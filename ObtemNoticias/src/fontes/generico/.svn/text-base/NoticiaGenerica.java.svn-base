package fontes.generico;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import fontes.Noticia;

/**
 * Nao trata o conteudo da pagina para extrair apenas
 * o conteudo da noticia
 * 
 * Apenas pega todo o conteudo da pagina
 * 
 * @author Fabricio J. Barth (fbarth@atech.br)
 * @version Jan, 2009
 *
 */

public class NoticiaGenerica extends Noticia{

	/**
	 * Nao eh usado neste caso
	 */
	@Override
	public String encontraFinalTexto(BufferedReader br, String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encontraNoticia(String pagina) {
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
                texto = texto + lin;
                lin = br.readLine();
            }
            return texto;
        }catch (Exception e) {
        	System.out.println("Error at NoticiaGenerica.encontraNoticia(..): "+e);
            return "";
        }
	}

}
