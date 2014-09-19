package fontes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.StringTokenizer;

public abstract class ObtemNoticias {

	protected ArrayList<String> enderecosURL;
	protected ArrayList<NoticiaGravada> noticias;
	protected String diretorio;

	protected HashSet<String> noticiasJaGravadas;
	
	public ObtemNoticias(){
		super();
	}
	
	/**
	 * Le a partir do RSS as noticias que devem ser capturadas.
	 * Para cada noticia eh criado um arquivo e uma entrada na tabela de noticias
	 * 
	 * @param rss nome do arquivo RSS com as noticias que devem ser indexadas
	 * @param nomeArqSaida nome do arquivo com os dados para futura indexacao
	 * @param nomeArqTabela nome do arquivo que irah conter a relacao arquivoNoticia x urlNoticia
	 * @param diretorio nome do diretorio onde serao armazenados os arquivos com as noticias
	 * @param ne objeto que identifica o tipo de noticia que deverah ser tratada
	 */
	protected void obtemNoticias(String rss, String nomeArqSaida, String nomeArqTabela, String diretorio, Noticia ne){
		this.diretorio = diretorio;
		noticias = new ArrayList<NoticiaGravada>();
		this.noticiasJaGravadas = obtemNoticiasJahGravadas(nomeArqTabela);
		enderecosURL = new rss.ObtemNoticiasParaMemoria(rss).start();
		for(int i=0; i<enderecosURL.size(); i++){
			String end = enderecosURL.get(i);
			System.out.println(end);
			if(!this.noticiasJaGravadas.contains(end)){
				String conteudo = ne.encontraNoticia(end);
				conteudo = ne.filtro(conteudo);
				//noticias.add(new NoticiaGravada(end,conteudo,"n"+i));
				noticias.add(new NoticiaGravada(end,conteudo,"n_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm_ssss_SSS").format(new Date())));
			}
		}
		
		/*
		 * Grava em arquivo o conteudo das noticias
		 */
		gravaEmArquivo(noticias,nomeArqSaida,nomeArqTabela);
	}

	/**
	 * Grava as noticias capturadas a partir do RSS
	 * 
	 * @param news ArrayList com as noticias gravadas em disco
	 * @param arquivoSaida nome do arquivo com os dados para futura indexacao
	 * @param nomeArqTabela nome do arquivo que irah conter a relacao arquivoNoticia x urlNoticia
	 */
	protected void gravaEmArquivo(ArrayList<NoticiaGravada> news, String arquivoSaida, String nomeArqTabela) {
		try{
			File fSaida = new File(arquivoSaida);
			File fTabela = new File(nomeArqTabela);
			RandomAccessFile rfSaida = new RandomAccessFile(fSaida,"rw");
			RandomAccessFile rfTabela = new RandomAccessFile(fTabela,"rw");
			rfSaida.seek(rfSaida.length());
			rfTabela.seek(rfTabela.length());
			for(int i=0; i<news.size(); i++){
				String nomeArquivo = news.get(i).getEnderecoArquivo();
				File f = new File(this.diretorio+"/"+nomeArquivo+".txt");
				RandomAccessFile rf = new RandomAccessFile(f,"rw");
				rf.writeBytes(news.get(i).getConteudo());
				rfSaida.writeBytes("file://"+this.diretorio+"/"+nomeArquivo+".txt\n");
				rfTabela.writeBytes("file://"+this.diretorio+"/"+nomeArquivo+".txt"+"#"+news.get(i).getEnderecoURL()+"\n");
				rf.close();
			}
			rfSaida.close();
			rfTabela.close();
		}catch(Exception e){
			System.out.println("Error ObtemNoticias.gravaEmArquivo: "+e);
		}
	}
	
	/**
	 * Recupera todas as noticias jah gravadas em inseridas na tabela de noticias.
	 * 
	 * @param nomeArqTabela nome do arquivo que armazena as noticias gravadas
	 * @return conjunto com os enderecos das noticias gravadas
	 */
	protected HashSet<String> obtemNoticiasJahGravadas(String nomeArqTabela){
		try {
			HashSet<String> retorno = new HashSet<String>();
			File fTabela = new File(nomeArqTabela);
			RandomAccessFile rfTabela = new RandomAccessFile(fTabela,"rw");
			String linha = rfTabela.readLine();
			while(linha!=null){
				StringTokenizer st = new StringTokenizer(linha,"#");
				st.nextToken();
				retorno.add(st.nextToken());
				linha = rfTabela.readLine();
			}
			return retorno;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException ioe){
			ioe.printStackTrace();
			return null;
		}
	}
}