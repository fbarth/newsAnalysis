package fontes.generico;

import fontes.ObtemNoticias;

public class ObtemNoticiasGenericas extends ObtemNoticias{

	public ObtemNoticiasGenericas(){
		super();
	}
	
	/**
	 * @param args[0] nome do arquivo com os enderecos
	 * dos arquivos RSS de interesse.
	 * args[1] nome do arquivo para ser utilizado em futura indexacao
	 * args[2] nome do arquivo com a relacao arquivoNoticia x urlNoticia
	 * args[3] diretorio de configuracao
	 * 
	 * Exemplo de utilizao:
	 * 
	 * java fontes.folha.ObtemNoticiasGenericas fontesRssGenericas.txt nutchGenericas.txt crawler/tabelaGenericas.txt /home/fbarth/eclipse/workspace/BuscaInteligente-ObtemNoticias/resultadosGenericas/
	 * 
	 * fontesRssGenericas.txt deve possuir referencias para:
	 * 
	 *  = Correio do Brasil
	 *  = Diario Catarinense
	 *  = JB Online
	 *  = Jornal Tribuna Catarinense
	 *  = O Dia
	 * 
	 */
	public static void main(String[] args) {
		try{
			new ObtemNoticiasGenericas().obtemNoticias(args[0],args[1],args[2],args[3],new NoticiaGenerica());
		}catch(Exception e){
			System.out.println("Error at ObtemNoticiasGenericas.main: "+e);
		}
	}
	
}
