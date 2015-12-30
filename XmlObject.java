package xmlCustoPack;

import java.util.ArrayList;

public class XmlObject {
	private String nome = "";
	private ArrayList<XmlObject> filhos = new ArrayList<XmlObject>();
	private ArrayList<String[]> propriedades = new ArrayList<String[]>();
	private String conteudo = "";
	
	public boolean temFilhos() {
		boolean tem;
		if(this.filhos.size() < 1)
			tem = false;
		else
			tem = true;
		return tem;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setPropriedades(ArrayList<String[]> propriedades) {
		this.propriedades = propriedades;
	}

	public XmlObject(String nome){
		this.nome = nome;
	}
	
	public ArrayList<String[]> getPropriedades() {
		return propriedades;
	}
	public void addPropriedade(String nome, String valor){
		String str[] = {nome, valor};
		this.propriedades.add(str);
	}
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public ArrayList<XmlObject> getFilhos() {
		return filhos;
	}
	public void addFilho(XmlObject filho){
		this.filhos.add(filho);
	}
}
