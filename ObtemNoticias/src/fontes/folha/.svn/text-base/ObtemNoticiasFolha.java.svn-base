package fontes.folha;

import fontes.ObtemNoticias;

public class ObtemNoticiasFolha extends ObtemNoticias{

	public ObtemNoticiasFolha(){
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
	 * java fontes.folha.ObtemNoticiasFolha fontesRssFolha.txt nutchFolha.txt crawler/tabelaFolha.txt /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/resultadosFolha/
	 * 
	 */
	public static void main(String[] args) {
		try{
			new ObtemNoticiasFolha().obtemNoticias(args[0],args[1],args[2],args[3],new NoticiaFolha());
		}catch(Exception e){
			System.out.println("Error at ObtemNoticiasFolha.main: "+e);
		}
	}
}
