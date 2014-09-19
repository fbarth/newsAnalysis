package fontes.globoOnline;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import fontes.Noticia;

public class NoticiaGloboOnline extends Noticia {

	@Override
	public String encontraFinalTexto(BufferedReader br, String texto) {
		try{
			if(!texto.contains("<!--  -->")){
				texto = texto + br.readLine();
				texto = encontraFinalTexto(br,texto);
			}
			return(texto);
		}catch(Exception e){
			System.out.println("Error at NoticiaGloboOnline.encontraFinalTexto: "+e);
			return "";
		}
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
                if(lin.contains("<!--inicio_materia-->")){
                	texto = br.readLine();
                	texto = encontraFinalTexto(br,texto);
                	return texto;
                }
                lin = br.readLine();
            }
            return "";
        }catch (Exception e) {
        	System.out.println("Error at NoticiaGloboOnline.encontraNoticia(..): "+e);
            return "";
        }
	}

}
