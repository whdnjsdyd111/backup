package ц╘ем17_JavaFX;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Question_Student {

	private SimpleStringProperty name;
	private SimpleIntegerProperty language;
	private SimpleIntegerProperty math;
	private SimpleIntegerProperty english;
	
	Question_Student(String name, int language, int math, int english){
		this.name = new SimpleStringProperty(name);
		this.language = new SimpleIntegerProperty(language);
		this.math = new SimpleIntegerProperty(math);
		this.english = new SimpleIntegerProperty(english);
	}
	
	public String getName() { return name.get(); }
	public void setName(SimpleStringProperty name) { this.name = name; }
	public int getLanguage() { return language.get(); }
	public void setLanguage(SimpleIntegerProperty language) { this.language = language; }
	public int getMath() { return math.get(); }
	public void setMath(SimpleIntegerProperty math) { this.math = math; }
	public int getEnglish() { return english.get(); }
	public void setEnglish(SimpleIntegerProperty english) { this.english = english; }

}
