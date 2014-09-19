package fontes.terra;

import fontes.ObtemNoticias;

public class ObtemNoticiasTerra extends ObtemNoticias{
	
	public ObtemNoticiasTerra(){
		super();
	}
	
	/**
	 * @param args[0] nome do arquivo com os enderecos
	 * dos arquivos RSS de interesse.
	 * args[1] nome do arquivo para ser utilizado em futura indexacao
	 * args[2] nome do arquivo com a relacao arquivoNoticia x urlNoticia
	 * args[3] diretorio de configuracao
	 * 
	 * Exemplo de utilização:
	 * 
	 * java fontes.terra.ObtemNoticiasTerra fontesRssTerra.txt nutchTerra.txt crawler/tabelaTerra.txt /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/resultadosTerra/
	 * 
	 */
	public static void main(String[] args) {
		try{
			new ObtemNoticiasTerra().obtemNoticias(args[0],args[1],args[2],args[3],new NoticiaTerra());
		}catch(Exception e){
			System.out.println("Error at ObtemNoticiasTerra.main: "+e);
		}
	}
}
