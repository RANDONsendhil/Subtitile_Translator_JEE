package classMetier;

public class MetierTextOriginal extends AbstractText {

	public MetierTextOriginal(){}
	private String textTitle;
	private String text;
	 
 
	public String getTextTitle() {
		return textTitle;
	}

	public void setTextTitle(String textTitle) {
		this.textTitle = textTitle;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String toString() {
	 
		return " "+text;
	}

}
