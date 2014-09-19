package fontes.estadao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import fontes.Noticia;

/**
 * Classe principal responsavel pelo tratamento
 * do conteudo das noticias de fontes especificas.
 * 
 * Neste caso a fonte tratada eh o Estadao
 * 
 * Para a construcao de um novo filtro ver o arquivo
 * README deste projeto.
 * 
 * @author Fabricio J. Barth (fbarth@atech.br)
 * @version Julho, 2007
 *
 */

public class NoticiaEstadao extends Noticia {

	/* (non-Javadoc)
	 * @see fontes.Noticia#encontraNoticia(java.lang.String)
	 */
	public String encontraNoticia(String pagina){
		String texto="";
		try {
            URL url = new URL(pagina);
            URLConnection uc = url.openConnection();
            uc.connect();
            InputStream fonte = uc.getInputStream();
            InputStreamReader isr = new InputStreamReader(fonte);
            BufferedReader br = new BufferedReader(isr);
            String lin = br.readLine();
            while (lin!=null) {
                //if(lin.equalsIgnoreCase("<div id=\"Noticia\">")){ [forma antiga]
            	if(lin.equalsIgnoreCase("<div id=\"corpoNoticia\">")){
                	texto = br.readLine();
                	texto = encontraFinalTexto(br,texto);
                	return texto;
                }
                lin = br.readLine();
            }
            return "";
        }catch (Exception e) {
        	System.out.println("Error at NoticiaEstadao.encontraNoticia(..): "+e);
            return "";
        }
	}
	
	/* (non-Javadoc)
	 * @see fontes.Noticia#encontraFinalTexto(java.io.BufferedReader, java.lang.String)
	 */
	public String encontraFinalTexto(BufferedReader br, String texto){
		try{
			/*
			 * algumas vezes, logo em seguida ao </div>
			 * aparece um texto que não é relevante e interfere
			 * nos algoritmos de mineracao de texto
			 */
			if(!texto.contains("</div>")){ //[forma antiga]
			//if(!texto.contains("<br><p class=\"texto\">")){
				texto = texto + br.readLine();
				texto = encontraFinalTexto(br,texto);
			}
			//return(menosDiv(texto));
			return(texto);
		}catch(Exception e){
			System.out.println("Error at NoticiaEstadao.encontraFinalTexto: "+e);
			return "";
		}
	}
	
	//private String menosDiv(String texto){
	//	StringTokenizer st = new StringTokenizer(texto,"</div>");
	//	return st.nextToken();
	//}
}
