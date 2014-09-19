package fontes;

import java.io.BufferedReader;

public abstract class Noticia{

	/**
	 * Todo texto relevante para indexacao comeca
	 * com alguma TAG relevante e termina com outra TAG relevante.
	 * 
	 * Este metodo encontra o inicio da noticia
	 * 
	 * @param pagina O endereco da noticia que deve ser tratada.
	 */
	public abstract String encontraNoticia(String pagina);

	/**
	 * Todo texto relevante para indexacao comeca
	 * com alguma TAG relevatne e termina com outra TAG relevante.
	 * 
	 * Este metodo encontra o final da noticia
	 * 
	 * @param br BufferedReader
	 * @param texto texto encontrado
	 * @return texto adaptado
	 */
	public abstract String encontraFinalTexto(BufferedReader br, String texto);

	
	/**
	 * Elimina todas as tags do conteúdo da notícia
	 * 
	 * Este filtro é executa em outras situações dentro do projeto
	 * BuscaInteligente, no entanto vale repeti-lo aqui.
	 * 
	 * @param conteudo
	 * @return conteudo sem tags HTML
	 */
	public String filtro(String conteudo){
		return removeStyle(
				removeScript(
						shiftPunctSigns(
								removeMultiSpaces(
										removeMarkup(
												htmlToAccTxt(
														conteudo))))));
	}

	/**
     * Substitui os caracteres acentuados em HTML pelos equivalentes
     * em TXT. A lista de caracteres a serem substituidos pode ser
     * estendida 'a vontade.
     * 
     * @param  input   String HTML
     * @return         String TXT
     */
	private String htmlToAccTxt(String input) {
		String[] from = {"&aacute;", "&agrave;", "&acirc;", "&atilde;",
				"&eacute;", "&ecirc;", "&iacute;", "&oacute;", "&ocirc;",
				"&otilde;", "&uacute;", "&ccedil;", "&ordm;", "&ordf;",
				"&quot;", "&nbsp;", "&laquo;", "&raquo;"};
		String[] to = {"á", "à", "â", "ã", "é", "ê", "í", "ó", "ô", "õ",
				"ú", "ç", "o.", "a.", "\"", " ", "\"", "\""};
		for(int i = 0; i < to.length; i++) {
			input = input.replaceAll(from[i],to[i]);
		}
		return input;
	}
	
	/**
     * Remove o markup entre <...>.
     * 
     * @param  input   String original
     * @return         String sem markup
     */
	private String removeMarkup(String input) {
		// Adaptado de http://www.javaworld.com/javaworld/jw-07-2001/
		// jw-0713-regex.html?page=3
		input = input.replaceAll("<[^>]*>"," ");
		return input;
	}
	
	/**
     * Substitui multiplos *espacos* por um so'.
     * 
     * @param  input   String original
     * @return         String sem multiplos *espacos*
     */
	private String removeMultiSpaces(String input) {
		String noMultiSpaces = new String();
		String[] temp = input.split("\\s+");
		for (int i = 0; i < temp.length; i++) {
			noMultiSpaces += temp[i] + " ";
		}
		return noMultiSpaces.trim();
	}
	
	/**
     * Insere um espaco em branco entre palavras e sinais de
     * pontuacao com o objetivo de melhorar o reconhecimento
     * de entidades nomeadas.
     * 
     * @param  input   String original
     * @return         String modificada
     */
	private String shiftPunctSigns(String input) {
		String[] before = { "\\. ", ", ", "; ", ": ", "! ", "\\)"   ,"\\("   ,"\""   ,"\\["  ,"\\]"};
		String[]  after = {" \\. "," , "," ; "," : "," ! ", " \\) " ," \\( " ," \" " ," \\[ "," \\] "};
		for(int i = 0; i < before.length; i++) {
			input = input.replaceAll(before[i],after[i]);
		}
		return input;
	}
	
	/**
     * Remove o conteudo de <script... </script>.
     * 
     * @param  input   String original
     * @return         String sem scripts
     */
	private String removeScript(String input) {
		/*
		 * From http://www.fusionauthority.com/Techniques/
		 * 3908-How-to-Strip-Tags-in-Three-Easy-Lessons.htm:
		 * (1) <script.*?>: the .*? section tells the regular expression that
		 * we're looking for anything at all (.), as much as necessary (*),
		 * but no more than we need to find the first > (?). So, this finds
		 * any tag which begins with <script and ends with an a >. Next,
		 * we need to represent a closing script tag (2) </script> and
		 * (3) what's in between: .*?. Therefore, the <script> block can be
		 * represented by properly concatenating these three things.
		 */
		input = input.replaceAll("<script.*?>.*?</script*>"," ");
		return input;
	}

	/**
     * Remove o conteudo de <style... </style>.
     * 
     * @param  input   String original
     * @return         String sem definicao de estilos
     */
	private String removeStyle(String input) {
		input = input.replaceAll("<style.*?>.*?</style*>"," ");
		return input;
	}

}