package xmlCustoPack;

import java.util.ArrayList;

public class Tag {
	private String name;
	ArrayList<String[]> propriedades = new ArrayList<String[]>();
	public Tag(String tag){
		tag = tag.replace("<", "");
		tag = tag.replace("  ", " ");
		tag = tag.replace("   ", " ");
		tag = tag.replace("    ", " ");
		tag = tag.replace(">", "");
		if(tag.charAt(tag.length()-1) == '/')
			tag = tag.substring(0, tag.length()-1);
		String arr[] = tag.split(" ");
		this.name = arr[0];
		if(arr.length > 1){
			String tmp_1, tmp_2;
			for (int i = 1; i < arr.length; i++) {
				//System.out.println(arr[i]);
				if(arr[i].indexOf("=") > -1){
					tmp_1 = arr[i].substring(0, arr[i].indexOf("="));
					tmp_2 = arr[i].substring(arr[i].indexOf("\"")+1, arr[i].lastIndexOf("\""));
					String str[] = {tmp_1, tmp_2};
					propriedades.add(str);
				}
			}
		}
	}
	public ArrayList<String[]> getPropriedades() {
		return propriedades;
	}
	public String getName() {
		return name;
	}

	
}

