package fontes;

/**
 * Classe responsavel por armazenar informacoes
 * sobre as noticias capturadas e gravadas na base
 * para indexacao
 * 
 * @author Fabricio J. Barth
 * @version Agosto, 2006
 *
 * Refactoring da classe
 * @version Julho, 2007
 *
 */
public class NoticiaGravada {
	
	private String enderecoURL;
	
	private String conteudo;
	
	private String enderecoArquivo;

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getEnderecoArquivo() {
		return enderecoArquivo;
	}

	public void setEnderecoArquivo(String enderecoArquivo) {
		this.enderecoArquivo = enderecoArquivo;
	}

	public String getEnderecoURL() {
		return enderecoURL;
	}

	public void setEnderecoURL(String enderecoURL) {
		this.enderecoURL = enderecoURL;
	}

	public NoticiaGravada(String enderecoURL, String conteudo, String enderecoArquivo) {
		super();
		this.enderecoURL = enderecoURL;
		this.conteudo = conteudo;
		this.enderecoArquivo = enderecoArquivo;
	}	
	
	/**
	 * Imprime o conteudo do objeto
	 * @return conteudo
	 */
	public String print(){
		return this.enderecoURL+"\n"+
			this.conteudo+"\n"+
			this.enderecoArquivo+"\n";
	}
}
