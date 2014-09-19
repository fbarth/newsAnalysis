package rss;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Leitor de noticias RSS
 * Classe que trata cada RSS
 * 
 * @author Fabricio J. Barth
 * @version April, 2006.
 */


public class RssHandler extends DefaultHandler {
	
	private ArrayList<News> news;
	private String elementName;
	private String currentElement;
	private String currentLanguage;
	private String currentLink;
	private String currentTitle;
	private String currentDescription;
	private boolean isItem;
	
	/**
	 * Construtor
	 */
	
	public RssHandler(){
		news = new ArrayList<News>();
		currentElement = "";
	}
	
	/**
	 * Verifica o inicio e tipo de elemento do XML
	 */
	
	public void startElement(String namespaceURI,String localName,String qName,
			Attributes attr ) throws SAXException {
		elementName = qName;
		if (elementName.equals("item")) {
			isItem = true;
		}
	}
	
	/**
	 * Verifica o final de um elemento XML
	 */
	
	public void endElement( String namespaceURI,String localName,String qName )
	throws SAXException {
		adiciona(currentElement);
		currentElement = "";
		if (qName.equals("item")) {
			isItem = false;
			news.add(new News(currentTitle,currentDescription,currentLink,
					currentLanguage));
		}
	}
	
	/**
	 * Armazena numa lista o conteudo de um elemento do XML
	 */
	
	public void characters(char buf[], int offset, int len) throws SAXException {
		currentElement += trataString(new String(buf,offset,len));
	}
	
	/**
	 * Adiciona uma String s a titles ou links de acordo com o tipo de elemento
	 */
	
	private void adiciona (String s) {
		if (isItem) {
			if(elementName.equals("title")) {
				currentTitle = s;
			}
			else if(elementName.equals("link")){
				currentLink = s;
			}
			else if(elementName.equals("description")) {
				currentDescription = s;
			}
		}
		else if(elementName.equals("language")) {
			currentLanguage = s;
		}
	}
	
	/**
	 * Retorna a quantidade de Noticias armazenadas
	 */
	
	public int getQuantReg() {
		return news.size();
	}
	
	/**
	 * Retorna a noticia de indice i
	 */
	
	public News getNoticia(int i) {
		return (News) news.get(i);
	}
	
	/**
	 * Trata as Strings -> remove todos white spaces (new line, carriage return,
	 * space, tab and form feed)
	 */
	
	private String trataString(String entrada) {
		String regExp ="[\\s]";
		return (entrada.replaceAll(regExp," ")).trim();
	}
}