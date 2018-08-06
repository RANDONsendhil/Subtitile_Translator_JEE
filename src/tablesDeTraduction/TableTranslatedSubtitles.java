package tablesDeTraduction;

import java.util.ArrayList;

public class TableTranslatedSubtitles {

	
	private String idText ="";


	private ArrayList<String> translatedSubtitles = null;
 
 

	public  TableTranslatedSubtitles(){}
	
 
	
	public void addTranslatedSubtitles(String   addLine) {
		translatedSubtitles = new ArrayList<String>();
		  
		 translatedSubtitles.add (addLine); 
		 
	}
	
	public String gettranslatedSubtitles(){
		 String str ="";
	
	 for(String a: translatedSubtitles){
		 str = str+a+"\n";}
	
	
		  	 return str;
	 }	 
	
	

public int gettranslatedSize(){
	return translatedSubtitles.size();
	
}





public void setTranslatedSubtitles(ArrayList<String> translatedSubtitles) {
	this.translatedSubtitles = translatedSubtitles;
}


public String getTextID(){
	return this.idText;
}

public void setTextId(String idText) {
	this.idText =  idText;
	
}





 
}




