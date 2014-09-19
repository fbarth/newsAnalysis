package rss;

/**
 * Leitor de noticias RSS
 * Classe que representa cada noticia
 * 
 * @author Fabricio J. Barth
 * @version April, 2006
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class News {

    private String title;
    private String description;
    private String link;
    private String language;
    @SuppressWarnings("unchecked")
	private HashMap palavras;
    private HashMap<String, Double> frequencias;
    private int maxFreq; // palavra que aparece mais vezes

    /**
     * Construtor
     */
    @SuppressWarnings("unchecked")
	public News (String title,String description,String link,String language) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.language = language;
        maxFreq = 0;
        palavras = new HashMap();
        frequencias = new HashMap<String, Double>();
    }


    /**
     * Calcula a frequencia de cada palavra e armazena no mapa frequencias
     * @return Set com todas as palavras da noticia
     */
    @SuppressWarnings("unchecked")
	public Set calcWordsFrequency() {
        Set wordSet = palavras.keySet();
        Iterator it = wordSet.iterator();
        while (it.hasNext()) {
            String chave = (String) it.next();
            double freq = (double) ((Integer) palavras.get(chave)).intValue()
                    / (double) maxFreq;
            frequencias.put(chave,new Double(freq));
        }
        return wordSet;
    }

    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return Returns the language.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @return Returns the link.
     */
    public String getLink() {
        return link;
    }

    /**
     * @return Returns the title.
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Retorna o WORD FREQ de uma palavra
     * Caso a palavra nao exista, retorna 0.0
     */
    public double getWordFreq(String palavra) {
        if (frequencias.containsKey(palavra)) {
            return ((Double)frequencias.get(palavra)).doubleValue();
        }
        else {
            return 0.0;
        }
    }

    /**
     * Representacao da noticia
     */
    @SuppressWarnings("unchecked")
	public String toString() {
        String saida = "Noticia -> " + title + " / " + language + "\n";
        Iterator it = frequencias.keySet().iterator();
        while (it.hasNext()) {
            String palavra = (String) it.next();
            saida += palavra + "\t" + frequencias.get(palavra) + "\n";
        }
        saida += "\nMax Freq: -> " + maxFreq + "\n";
        return saida;
    }
}
