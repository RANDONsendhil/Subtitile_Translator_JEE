package classMetier;

public class MetierTextTranslated extends AbstractText {

	public String getTextTitle() {
		return textTitle;
	}

	public void setTextTitle(String textTitle) {
		this.textTitle = textTitle;
	}

	public String getText() {
		return text;
	}

	public void setText(String addLine) {
		this.text = addLine;
	}

	public String toString() {
	 
		return " "+text;
	}

}
