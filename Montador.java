package xmlCustoPack;

import java.util.ArrayList;

public class Montador {
	public String retiraComentarios(String str){
		String tmp_1, tmp_2;
		while(str.indexOf("<!--") > -1){
			tmp_1 = str.substring(str.indexOf("<!--"));
			tmp_2 = tmp_1.substring(0, tmp_1.indexOf("-->")+3);
			str = str.replace(tmp_2, "");
		}
		return str;
	}
	public XmlObject montar(String xml){
		XmlObject objRaiz = null;
		xml = retiraComentarios(xml);
		String aux;
		ArrayList<XmlObject> objsXml = new ArrayList<>();
		while(xml.length() > 0){
			xml = xml.trim();
			if(xml.charAt(0) == '<'){
				//é elemento
				aux = xml.substring(0, xml.indexOf(">")+1 );
				xml = xml.replace(aux, "");
				if(aux.indexOf("/") != 1){
					if(aux.charAt(aux.length()-2) != '/'){
						if(objsXml.size() == 0){
							Tag tag = new Tag(aux);
							objRaiz = new XmlObject(tag.getName());
							objRaiz.setPropriedades(tag.getPropriedades());
							objsXml.add(0, objRaiz);
						}else{
							Tag tag = new Tag(aux);
							XmlObject objFilho = new XmlObject(tag.getName());
							objFilho.setPropriedades(tag.getPropriedades());
							objsXml.get(0).addFilho(objFilho);
							objsXml.add(0, objFilho);
						}
					}else{
						if(objsXml.size() != 0){
							Tag tag = new Tag(aux);
							XmlObject objFilho = new XmlObject(tag.getName());
							objFilho.setPropriedades(tag.getPropriedades());
							objsXml.get(0).addFilho(objFilho);
						}
					}
				}else{
					//é de fechamento tem que desempilhar
					aux = aux.replace(">", "");
					aux = aux.replace("<", "");
					aux = aux.substring(1);
					aux = aux.replace(" ", "");
					if(objsXml.size() != 0){
						if(aux.equals(objsXml.get(0).getNome()))
							objsXml.remove(0);
					}
				}
			}else{
				//é conteudo
				aux = xml.substring(0, xml.indexOf("<") );
				xml = xml.replace(aux, "");
				if(objsXml.size() != 0)
					objsXml.get(0).setConteudo(aux);
			}
		}
		
		return objRaiz;
	}
	public void impObj(XmlObject obj){
		System.out.println("\n\n==========================INICIO==================================================\n\n");
		System.out.println("Nome: "+obj.getNome());
		System.out.println("Conteudo: "+obj.getConteudo());
		int counter = 1;
		for (int i = 0; i < obj.getPropriedades().size(); i++) {
			System.out.println("Propriedade"+counter+": \n"
					+ "Nome: "+obj.getPropriedades().get(i)[0]+"\n"
					+ "Valor: "+obj.getPropriedades().get(i)[1]+"\n\n"
					);
			counter++;
		}
		if(obj.temFilhos()){
			for (int i = 0; i < obj.getFilhos().size(); i++) {
				impObj(obj.getFilhos().get(i));
			}
		}
		System.out.println("\n==========================FIM==================================================\n\n");
	}
}

