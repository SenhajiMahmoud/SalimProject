package test.exemple.autowired;


import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	@Autowired
	private SpellChecker spellCheck;

	
	public TextEditor() {
			System.out.println(">>>>>>>>TexxtEditor");
	}
	
//	public void setSpellChecker(SpellChecker spellChecker) {
//		System.out.println("setSpellChecker()");
//		this.spellChecker = spellChecker;
//	}

	public SpellChecker getSpellChecker() {
		return spellCheck;
	}

	public void spellCheck() {
		spellCheck.checkSpelling();
	}
}
