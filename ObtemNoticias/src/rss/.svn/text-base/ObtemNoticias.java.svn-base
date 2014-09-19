package rss;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Classe principal que trata os arquivos RSS 
 * capturando as URLs das noticias
 * 
 * @author Fabricio J. Barth (fbarth@atech.br)
 * @version April, 2005
 *
 */

public class ObtemNoticias {

	private RssHandler rsh;
	
	public ObtemNoticias(String urlsRSS, String outputWget, String outputNutch){
		try{
			rsh = new RssHandler();
			File f = new File(urlsRSS);
			RandomAccessFile rf = new RandomAccessFile(f,"rw");
			File fOut = new File(outputWget);
			RandomAccessFile rfOut = new RandomAccessFile(fOut,"rw");
			File fOutNutch = new File(outputNutch);
			RandomAccessFile rfOutNutch = new RandomAccessFile(fOutNutch,"rw");
			rfOut.writeBytes("#!/bin/bash \n");
			String linha;
			while((linha = rf.readLine())!=null){
				System.out.println(linha);
				carregaNoticias(linha);
				System.out.println(rsh.getQuantReg());
				for(int i=0; i<rsh.getQuantReg(); i++){
					rfOut.writeBytes("wget -P output/ "+((News)rsh.getNoticia(i)).getLink()+"\n");
					rfOutNutch.writeBytes(((News)rsh.getNoticia(i)).getLink()+"\n");
				}
			}
			rf.close();
			rfOut.close();
			rfOutNutch.close();
		}catch(Exception e){
			System.out.println("Erro em TrataRSS: "+e);
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
			System.out.println("Erro em carregaNoticias: "+e);
		}
	}
	
	public static void main(String[] args) {
		try{
			new ObtemNoticias(args[0],args[1],args[2]);
		}catch(java.lang.ArrayIndexOutOfBoundsException e){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			new ObtemNoticias("fontesRss.txt","wgetNewsFromRSS-"+sdf.format(new Date())+".sh","nutchNewsFromRSS-"+sdf.format(new Date())+".txt");
		}		
	}

}
