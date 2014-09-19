package fontes.estadao;

import fontes.ObtemNoticias;

/**
 * Classe responsavel por tratar todas as noticias vindas da
 * fonte Estadao.
 * 
 * @author Fabricio J. Barth
 * @version Agosto, 2006
 *
 * Refactoring
 * @version Julho, 2007
 *
 */
public class ObtemNoticiasEstadao extends ObtemNoticias {
	
	public ObtemNoticiasEstadao(){
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
	 * java fontes.estadao.ObtemNoticiasEstadao fontesRssEstadao.txt nutchEstadao.txt crawler/tabelaEstadao.txt /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/resultadosEstadao/
	 * 
	 */
	public static void main(String[] args) {
		try{
			new ObtemNoticiasEstadao().obtemNoticias(args[0],args[1],args[2],args[3],new NoticiaEstadao());
		}catch(Exception e){
			System.out.println("Error at ObtemNoticiasEstadao.main: "+e);
		}
	}

}
