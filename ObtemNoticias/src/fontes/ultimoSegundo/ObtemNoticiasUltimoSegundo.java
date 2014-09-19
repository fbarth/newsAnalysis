package fontes.ultimoSegundo;

import fontes.ObtemNoticias;

public class ObtemNoticiasUltimoSegundo extends ObtemNoticias {

	public ObtemNoticiasUltimoSegundo(){
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
	 * java fontes.ultimoSegundo.ObtemNoticiasUltimoSegundo fontesRssUltimoSegundo.txt nutchUltimoSegundo.txt crawler/tabelaUltimoSegundo.txt /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/resultadosUltimoSegundo/
	 * 
	 */
	public static void main(String[] args) {
		try{
			new ObtemNoticiasUltimoSegundo().obtemNoticias(args[0],args[1],args[2],args[3],new NoticiaUltimoSegundo());
		}catch(Exception e){
			System.out.println("Error at ObtemNoticiasUltimoSegundo.main: "+e);
		}
	}
	
}
