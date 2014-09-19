package fontes.g1;

import fontes.ObtemNoticias;

public class ObtemNoticiasG1 extends ObtemNoticias{

	public ObtemNoticiasG1(){
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
	 * java fontes.g1.ObtemNoticiasG1 fontesRssG1.txt nutchG1.txt crawler/tabelaG1.txt /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/resultadosG1/
	 * 
	 */
	public static void main(String[] args) {
		try{
			new ObtemNoticiasG1().obtemNoticias(args[0],args[1],args[2],args[3],new NoticiaG1());
		}catch(Exception e){
			System.out.println("Error at ObtemNoticiasG1.main: "+e);
		}
	}	
}