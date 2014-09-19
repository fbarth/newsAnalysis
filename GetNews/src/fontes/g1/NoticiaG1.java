package fontes.g1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import fontes.Noticia;

public class NoticiaG1 extends Noticia{

	@Override
	public String encontraFinalTexto(BufferedReader br, String texto) {
		try{
			if(!texto.contains("<!-- /MultiMateria -->")){
				texto = texto + br.readLine();
				texto = encontraFinalTexto(br,texto);
			}
			return texto;
		}catch(Exception e){
			System.out.println("Error at NoticiaG1.encontraFinalTexto: "+e);
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
            	if(lin.contains("<!-- MultiMateria -->")){
                	texto = br.readLine();
                	texto = encontraFinalTexto(br,texto);
                    /*
                     * As paginas do G1 estao escritas em UTF-8
                     */
                	byte t[] = texto.getBytes("ISO-8859-1");
                	return new String(t,0,t.length,"UTF-8");
                }
                lin = br.readLine();
            }
            return "";
        }catch (Exception e) {
        	System.out.println("Error at NoticiaG1.encontraNoticia(..): "+e);
            return "";
        }
	}
	
	public String filtro(String conteudo){
		return super.filtro(conteudo).replace("#160", " ");
	}

}
