package tablesDeTraduction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TablesdeOriginalSubtitles {
	

	private ArrayList<String> originalSubtitles=null;
	
public TablesdeOriginalSubtitles(){}
	public TablesdeOriginalSubtitles(String fileName) {
		
		originalSubtitles = new ArrayList<String>();
		BufferedReader br;
		System.out.println(originalSubtitles);
		
		try { 
			br = new BufferedReader(new FileReader(fileName));
			String line="";
			line = line+"*";
		 
			while ((line = br.readLine()) != null) {
		
			  		  if( (!checkInteger(line))&&(!checkArrow( line))&&(!checkSpace(line))){
							  originalSubtitles.add(line);
						  }
						      
			}	 
			 
			br.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getSubtitles() {
		
		
		return originalSubtitles;
	}
	
	 
	public boolean checkArrow(String line){
		
		 int findArrow =0;
 for(int i = 0; i<line.length(); i++){
			 
			 if(line.charAt(i) =='>'){
				 findArrow = findArrow+i;
				 int secondline = findArrow-1;
				 int firstline =findArrow-2;
				 if((line.charAt(firstline)=='-')&&(line.charAt(secondline)=='-')){
					 return true;
				 }
				 }
			 }
		 
		return false;	
	}
	
	public boolean checkInteger(String line){
		
		String pharsInt = "";
		 
		 try{ 
			 for(int i =0; i<line.length(); i++){
			 pharsInt =pharsInt+line.charAt(i);	}
			 
			Integer.parseInt(pharsInt);
			 
			 
			 
			 return true;
		 }catch(NumberFormatException e ){
			 return false;
			}
			 
		 }
	

	public boolean checkSpace(String line){
		
		  
			 if(line.length()==0){
				 
				 return true;
			 }else{
				 
		 }return false;
	}
	  

	
public int getoriginalTextSize(){
	return originalSubtitles.size();
}
}

 
 