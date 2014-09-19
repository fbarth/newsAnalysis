package rss;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;

/**
 * Leitor de noticias RSS
 * Classe responsavel pela abertura de arquivos e conversao em texto.
 * 
 * @author Fabricio J. Barth
 * @version April, 2006
 */
public class Arquivo {
	
	/**
	 * Grava o conteudo de uma String num arquivo 
	 * Apaga o arquivo antes de escrever
	 *
	 * @param entrada - String a ser gravada
	 *        nomeArq - nome do arquivo a gravar
	 */
	public static void grava (String entrada, String nomeArq) 
		throws IOException {
		if (entrada!=null) {
			File f = new File(nomeArq);
			f.delete();
			RandomAccessFile arq = new RandomAccessFile(nomeArq,"rw");
			arq.writeBytes(entrada);
			arq.close();
		}
	}
	
	/**
	 * Recupera o conteudo de um arquivo XML de um endereco RSS da web
	 * @param c - configuracao do usuario
	 * @return String do arquivo
	 */
	public static String getRssFile(String rssURL) throws Exception {
		String saida="";
		URL url = new URL(rssURL);
		URLConnection uc = url.openConnection();
		uc.connect();
		InputStream fonte = uc.getInputStream(); 
		InputStreamReader isr = new InputStreamReader(fonte);
		BufferedReader br = new BufferedReader(isr); 
		String lin = br.readLine();
		while (lin!=null) {
			saida+=lin+"\n";
			lin = br.readLine();
		}
		return saida; 
	}
	
	/**
	 * Abre um TXT e nao faz mais nada -> So coloca numa String
	 */
	public static String txt2String (String txtFile) throws IOException {
		String saida = "";
		String linha;
		RandomAccessFile file = new RandomAccessFile (txtFile,"r");
		linha = file.readLine();
		while (linha!=null) {
			saida+=linha+"\n";
			linha = file.readLine();
		}
		file.close();
		return saida;	
	}
	
	/**
	 * Transforma a String em letras minusculas, sem acentos e sem pontuacao
	 * Elimina numeros e palavras menores de tres caracteres
	 */
	public static String trataString(String texto){
	    String saida;
	    String regExp;
	    saida = texto.toLowerCase();
	    regExp = "[�����]";
	    saida = saida.replaceAll(regExp, "a");
	    regExp = "[����]";
	    saida = saida.replaceAll(regExp, "e");
	    regExp = "[����]";
	    saida = saida.replaceAll(regExp, "i");
	    regExp = "[�����]";
	    saida = saida.replaceAll(regExp, "o");
	    regExp = "[����]";
	    saida = saida.replaceAll(regExp, "u");
	    regExp = "[��]";
	    saida = saida.replaceAll(regExp, "c");
	    //regExp = "[^0-9a-zA-Z_\\-]";
	    regExp = "[^a-zA-Z_\\-]";
	    saida = saida.replaceAll(regExp, " ");
	    //regExp = "[ ]{2,}";
	    regExp = "[ ]";
	    saida = saida.replaceAll(regExp, "");
	    saida = saida.trim();
	    if (saida.length()<3) {
	        saida = "";
	    }
		return saida;
	}
}