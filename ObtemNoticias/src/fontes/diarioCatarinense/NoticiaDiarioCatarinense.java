package fontes.diarioCatarinense;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import fontes.Noticia;

public class NoticiaDiarioCatarinense extends Noticia{

	@Override
	public String encontraFinalTexto(BufferedReader br, String texto) {
		try{
			if(!texto.contains("<div class=\"extra\">")){
				texto = texto + br.readLine();
				texto = encontraFinalTexto(br,texto);
			}
			return(texto);
		}catch(Exception e){
			System.out.println("Error at NoticiaDiarioCatarinense.encontraFinalTexto: "+e);
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
                if(lin.contains("<p><strong>Atualizada em")){
                	texto = br.readLine();
                	texto = encontraFinalTexto(br,texto);
                	return texto;
                }
                lin = br.readLine();
            }
            return "";
        }catch (Exception e) {
        	System.out.println("Error at NoticiaDiarioCatarinense.encontraNoticia(..): "+e);
            return "";
        }
	}

}
