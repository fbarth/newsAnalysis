package rss;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ObtemNoticiasParaMemoria {
	
	private RssHandler rsh;
	private File f;
	private RandomAccessFile rf;
	
	public ObtemNoticiasParaMemoria(String urlsRSS){
		try{
			rsh = new RssHandler();
			f = new File(urlsRSS);
		}catch(Exception e){
			System.out.println("Erro em TrataRSS: "+e);
		}
	}
	
	public ArrayList<String> start(){
		ArrayList<String> retorno = new ArrayList<String>();
		try{
			rf = new RandomAccessFile(f,"rw");
			String linha;
			int inicio = 0;
			while((linha = rf.readLine())!=null){
				System.out.println(linha);
				carregaNoticias(linha);
				System.out.println(rsh.getQuantReg());
				for(int i=inicio; i<rsh.getQuantReg(); i++){
					retorno.add(((News)rsh.getNoticia(i)).getLink());
				}
				inicio = rsh.getQuantReg();
			}
			rf.close();
			return retorno;
		}catch(Exception e){
			System.out.println("Erro em TrataRSS.start(): "+e);
			return null;
		}
	}
	
	public ArrayList<News> getNews(){
		ArrayList<News> retorno = new ArrayList<News>();
		try{
			rf = new RandomAccessFile(f,"rw");
			String linha;
			int inicio = 0;
			while((linha = rf.readLine())!=null){
				System.out.println(linha);
				carregaNoticias(linha);
				System.out.println(rsh.getQuantReg());
				for(int i=inicio; i<rsh.getQuantReg(); i++){
					retorno.add(((News)rsh.getNoticia(i)));
				}
				inicio = rsh.getQuantReg();
			}
			rf.close();
			return retorno;
		}catch(Exception e){
			System.out.println("Erro em TrataRSS.getNews(): "+e);
			return null;
		}
	}
	
	
	/**
	 * Inicializa a carga das noticias
	 */
	public void carregaNoticias(String file) {
		SAXParserFactory factory;
		SAXParser saxParser = null;
		try {
			factory = SAXParserFactory.newInstance();
			saxParser = factory.newSAXParser();
			saxParser.parse(file, rsh);
		} catch (Exception e) { 
			System.out.println("Erro em carragaNoticias: "+e);
		}
	}	
}
