package relatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RelatorioCriacaoNoticias {
	
	private ArrayList<Item> itens = new ArrayList<Item>();
	
	public RelatorioCriacaoNoticias(String nomeArquivoEntrada, String nomeArquivoSaida){
		ler(nomeArquivoEntrada);
		gravar(nomeArquivoSaida);
	}
	
	private void ler(String nomeArquivoEntrada){
		try {
			File arquivoEntrada = new File(nomeArquivoEntrada);
			RandomAccessFile rf = new RandomAccessFile(arquivoEntrada,"r");
			String linha = rf.readLine();
			while(linha!=null){
				System.out.println(linha);
				Item it = new Item();
				it.setDt_inicio(linha);
				rf.readLine();
				it.setDt_fim(rf.readLine());
				rf.readLine();
				it.setCount_estadao(new StringTokenizer(rf.readLine().trim()).nextToken());
				rf.readLine();
				it.setCount_folha(new StringTokenizer(rf.readLine().trim()).nextToken());
				rf.readLine();
				it.setCount_g1(new StringTokenizer(rf.readLine().trim()).nextToken());
				rf.readLine();
				it.setCount_globoOnline(new StringTokenizer(rf.readLine().trim()).nextToken());
				rf.readLine();
				it.setCount_terra(new StringTokenizer(rf.readLine().trim()).nextToken());
				rf.readLine();
				it.setCount_ultimoSegundo(new StringTokenizer(rf.readLine().trim()).nextToken());
				rf.readLine();
				rf.readLine();
				itens.add(it);
				linha = rf.readLine();
			}
			rf.close();
		} catch (FileNotFoundException ef) {
			ef.printStackTrace();
		} catch (IOException ei) {
			ei.printStackTrace();
		}
	}
	
	private void gravar(String nomeArquivoSaida){
		try {
			File arquivoSaida = new File(nomeArquivoSaida);
			RandomAccessFile rf = new RandomAccessFile(arquivoSaida,"rw");
			for(int i=0; i<itens.size(); i++){
				rf.writeBytes(itens.get(i).toString()+"\n");
			}
			rf.close();
		} catch (FileNotFoundException ef) {
			ef.printStackTrace();
		} catch (IOException ei) {
			ei.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RelatorioCriacaoNoticias("metaInformacoes.txt","formatoExcel_v2.txt");
	}
}

class Item {
	
	private String dt_inicio;
	private String dt_fim;
	private String count_estadao;
	private String count_folha;
	private String count_g1;
	private String count_globoOnline;
	private String count_terra;
	private String count_ultimoSegundo;
	
	public String getCount_estadao() {
		return count_estadao;
	}
	public void setCount_estadao(String count_estadao) {
		this.count_estadao = count_estadao;
	}
	public String getCount_folha() {
		return count_folha;
	}
	public void setCount_folha(String count_folha) {
		this.count_folha = count_folha;
	}
	public String getCount_g1() {
		return count_g1;
	}
	public void setCount_g1(String count_g1) {
		this.count_g1 = count_g1;
	}
	public String getCount_globoOnline() {
		return count_globoOnline;
	}
	public void setCount_globoOnline(String count_globoOnline) {
		this.count_globoOnline = count_globoOnline;
	}
	public String getCount_terra() {
		return count_terra;
	}
	public void setCount_terra(String count_terra) {
		this.count_terra = count_terra;
	}
	public String getCount_ultimoSegundo() {
		return count_ultimoSegundo;
	}
	public void setCount_ultimoSegundo(String count_ultimoSegundo) {
		this.count_ultimoSegundo = count_ultimoSegundo;
	}
	public String getDt_fim() {
		return dt_fim;
	}
	public void setDt_fim(String dt_fim) {
		this.dt_fim = dt_fim;
	}
	public String getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(String dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public String toString(){
		return 
			this.dt_inicio+";"+
			this.dt_fim+";"+
			this.count_estadao+";"+
			this.count_folha+";"+
			this.count_g1+";"+
			this.count_globoOnline+";"+
			this.count_terra+";"+
			this.count_ultimoSegundo;
	}
}
