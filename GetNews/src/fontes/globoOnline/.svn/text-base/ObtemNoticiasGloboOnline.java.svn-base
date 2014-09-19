package fontes.globoOnline;

import fontes.ObtemNoticias;

public class ObtemNoticiasGloboOnline extends ObtemNoticias {

	public ObtemNoticiasGloboOnline(){
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
	 * java fontes.globoOnline.ObtemNoticiasGloboOnline fontesRssGloboOnline.txt nutchGloboOnline.txt crawler/tabelaGloboOnline.txt /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/resultadosGloboOnline/
	 * 
	 */
	public static void main(String[] args) {
		try{
			new ObtemNoticiasGloboOnline().obtemNoticias(args[0],args[1],args[2],args[3],new NoticiaGloboOnline());
		}catch(Exception e){
			System.out.println("Error at ObtemNoticiasGloboOnline.main: "+e);
		}
	}
	
}
