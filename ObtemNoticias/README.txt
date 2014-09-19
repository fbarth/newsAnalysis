** Rotina para criação de um novo filtro para uma nova fonte de dados
acessada através de RSS:

* Criar uma package dentro da package fontes com um nome significativo, 
por exemplo "g1" para o portal de notícias da globo, g1.globo.com.

* Criar uma classe para tratamento da Noticia, por exemplo NoticiaG1. 
Esta classe deve ser uma sub-classe da classe Noticia, por exemplo:

package fontes.g1;

import java.io.BufferedReader;
import fontes.Noticia;

public class NoticiaG1 extends Noticia{

	@Override
	public String encontraFinalTexto(BufferedReader br, String texto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encontraNoticia(String pagina) {
		// TODO Auto-generated method stub
		return null;
	}
}

* O comportamento dos métodos encontraFinalTexto e encontraNoticia deve ser
alterado para as necessidades específicas da nova fonte de dados. Utilize
como exemplo a classe NoticiaEstadao.

* Criar uma classe Principal, por exemplo ObtemNoticiasG1. Esta classe
deve ser sub-classe da classe fontes.ObtemNoticia e deve invocar o método 
obtemNoticias(...), passando como instância um objeto da classe NoticiaG1.
Exemplo:

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

* Crie um diretório para armazenar os resultados da busca, por exemplo, resultadosG1.

* Crie um arquivo que lista os endereços RSS de interesse, por exemplo, 
fontesRssG1.txt:

http://g1.globo.com/Rss2/0,,AS0-5597,00.xml
http://g1.globo.com/Rss2/0,,AS0-5598,00.xml
http://g1.globo.com/Rss2/0,,AS0-5603,00.xml
http://g1.globo.com/Rss2/0,,AS0-5602,00.xml 
