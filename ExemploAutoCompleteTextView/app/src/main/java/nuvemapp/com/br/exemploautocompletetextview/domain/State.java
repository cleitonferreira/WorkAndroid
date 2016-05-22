package nuvemapp.com.br.exemploautocompletetextview.domain;

import java.util.HashMap;

import nuvemapp.com.br.exemploautocompletetextview.R;


public class State {
	private String name;
	private int imgResource;
	public static HashMap<String, Integer> imgMap = new HashMap<String, Integer>();
	static {
        imgMap.put("Acre (AC)", R.drawable.acre);
        imgMap.put("Alagoas (AL)", R.drawable.alagoas);
        imgMap.put("Amapá (AP)", R.drawable.amapa);
        imgMap.put("Amazonas (AM)", R.drawable.amazonas);
        imgMap.put("Bahia (BA)", R.drawable.bahia);
        imgMap.put("Ceará (CE)", R.drawable.ceara);
        imgMap.put("Distrito Federal (DF)", R.drawable.distrito_federal);
        imgMap.put("Espírito Santo (ES)", R.drawable.espirito_santo);
        imgMap.put("Goiás (GO)", R.drawable.goias);
        imgMap.put("Maranhão (MA)", R.drawable.maranhao);
        imgMap.put("Mato Grosso (MT)", R.drawable.mato_grosso);
        imgMap.put("Mato Grosso do Sul (MS)", R.drawable.mato_grosso_do_sul);
        imgMap.put("Minas Gerais (MG)", R.drawable.minas_gerais);
        imgMap.put("Pará (PA)", R.drawable.para);
        imgMap.put("Paraíba (PB)", R.drawable.paraiba);
        imgMap.put("Paraná (PR)", R.drawable.parana);
        imgMap.put("Pernambuco (PE)", R.drawable.pernambuco);
        imgMap.put("Piauí (PI)", R.drawable.piaui);
        imgMap.put("Rio de Janeiro (RJ)", R.drawable.rio_de_janeiro);
        imgMap.put("Rio Grande do Norte (RN)", R.drawable.rio_grande_do_norte);
        imgMap.put("Rio Grande do Sul (RS)", R.drawable.rio_grande_do_sul);
        imgMap.put("Rondônia (RO)", R.drawable.rondonia);
        imgMap.put("Roraima (RR)", R.drawable.roraima);
        imgMap.put("Santa Catarina (SC)", R.drawable.santa_catarina);
        imgMap.put("São Paulo (SP)", R.drawable.sao_paulo);
        imgMap.put("Sergipe (SE)", R.drawable.sergipe);
        imgMap.put("Tocantins (TO)", R.drawable.tocantins);
        imgMap.put("Ontario (ON)", R.drawable.ontario);
        imgMap.put("Quebec (QC)", R.drawable.quebec);
        imgMap.put("Nova Scotia (NS)", R.drawable.nova_scotia);
        imgMap.put("New Brunswick (NB)", R.drawable.new_brunswick);
        imgMap.put("Manitoba (MB)", R.drawable.manitoba);
        imgMap.put("British Columbia (BC)", R.drawable.british_columbia);
        imgMap.put("Prince Edward Island (PE)", R.drawable.prince_edward_island);
        imgMap.put("Saskatchewan (SK)", R.drawable.saskatchewan);
        imgMap.put("Alberta (AB)", R.drawable.alberta);
        imgMap.put("Newfoundland and Labrador (NL)", R.drawable.newfoundland_and_labrador);
    }
	
	
	
	public State(){}
	public State(String name, int imgResource){
		this.name = name;
		this.imgResource = imgResource;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getImgResource() {
		return imgResource;
	}
	public void setImgResource(int imgResource) {
		this.imgResource = imgResource;
	}
	
	
	public String toString() {
		return(this.getName());
	}
}
