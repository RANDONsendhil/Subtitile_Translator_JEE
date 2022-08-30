package classMetier;
/*MASTER*/
public abstract class AbstractText {
		
String textTitle;
String text;


 


public String getTextTitle() {
	return textTitle;
}

 

public String getText() {
	return text;
}


public void setText(String text) {
	this.text = text;
}
	
public  abstract String toString();
	 
}
