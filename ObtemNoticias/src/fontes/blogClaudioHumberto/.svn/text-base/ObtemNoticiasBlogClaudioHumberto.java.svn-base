package fontes.blogClaudioHumberto;

import fontes.ObtemNoticias;

public class ObtemNoticiasBlogClaudioHumberto extends ObtemNoticias {

	public ObtemNoticiasBlogClaudioHumberto(){
		super();
	}
	
	/**
	 * @param args[0] nome do arquivo com os enderecos dos arquivos RSS de interesse.
	 * args[1] nome do arquivo para ser utilizado em futura indexacao
	 * args[2] nome do arquivo com a relacao arquivoNoticia x urlNoticia
	 * args[3] diretorio de configuracao
	 * 
	 * Exemplo de utilizacao:
	 * 
	 * java fontes.blogClaudioHumberto.ObtemNoticiasBlogClaudioHumberto fontesRssClaudioHumberto.txt nutchClaudioHumberto.txt 
	 * crawler/tabelaClaudioHumberto.txt $DIR/resultadosClaudioHumberto/
	 * 
	 */
	public static void main(String[] args) {
		try{
			new ObtemNoticiasBlogClaudioHumberto().obtemApenasConteudoRSS(args[0],args[1],args[2],args[3]);
		}catch(Exception e){
			System.out.println("Error at ObtemNoticiasBlogClaudioHumberto.main: "+e);
		}
	}

}
