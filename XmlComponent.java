package xmlCustoPack;

public class XmlComponent implements IXmlComponent{
	XmlObject xmlObj = null;
	Montador montador = new Montador();
	
	public XmlComponent(){};
	public XmlComponent(String xml, int mode){
		this.montarObj(xml, mode);
	}
	
	@Override
	/**
	 * int mode recebe 1 para montar o objeto a partir da string recebida ou 2
	 * para montar um objeto a partir de um arquivo xml recebida na string
	 */
	public boolean montarObj(String xml, int mode) {
		if(mode == 1){
			xml = montador.retiraComentarios(xml);
			xmlObj = montador.montar(xml);
		}
		//fazer a parte de montar a partir do arquivo
		return false;
	}

	@Override
	public String getObjToString() {
		String xml = "";
		if(xmlObj != null)
			xml = montaStr(xml, xmlObj);
		return xml;
	}

	@Override
	public void impObj() {
		// TODO Auto-generated method stub
		if(xmlObj != null)
			montador.impObj(xmlObj);
		else
			System.out.println("Objeto xml nulo");
	}
	private String montaStr(String xml, XmlObject xmlObjInner){
		//abre a tag
		xml += "<" + xmlObjInner.getNome();
		
		//coloca as propriedades
		for (int i = 0; i < xmlObjInner.getPropriedades().size(); i++) {
					xml +=  " " + xmlObjInner.getPropriedades().get(i)[0] + "=";
					xml += "\"" + xmlObjInner.getPropriedades().get(i)[1] + "\"";
		}
		
		//verifica se tem ? pra fechar a tag
		if(xmlObjInner.getNome().charAt(0) == '?')
			xml += "?";
		
		//fecha a tag de inicio
		xml += ">";
		
		//coloca o conteudo
		xml += xmlObjInner.getConteudo();
		
		//coloca os filhos
		if(xmlObjInner.temFilhos()){
			for (int i = 0; i < xmlObjInner.getFilhos().size(); i++) {
				xml = montaStr(xml, xmlObjInner.getFilhos().get(i));
			}
		}
		
		//coloca a tag de fechamento
		if(xmlObjInner.getNome().charAt(0) != '?')
			xml += "</" + xmlObjInner.getNome() +">";
		
		return xml;
	}

}
