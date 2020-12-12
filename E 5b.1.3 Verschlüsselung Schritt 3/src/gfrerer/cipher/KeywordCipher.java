package gfrerer.cipher;

public class KeywordCipher extends MonoAlphabeticCipher{
	private String keyword;
	
	public KeywordCipher(String keyword) {
		super();
		this.keyword = keyword;
	}
	
	public void setKeyword(String keyword) { 
		switch(keyword) {
		case "original":	super.setSecretAlphabet("abcdefghijklmnopqrstuvwxyzäöüß");
							break;
		case "keyboard":	super.setSecretAlphabet("qwertzuiopüasdfghjklöäyxcvbnmß");
							break;
		case "verschoben":	super.setSecretAlphabet("ßabcdefghijklmnopqrstuvwxyzäöü");
							break;
		case "verkehrt":	super.setSecretAlphabet("ßüöäzyxwvutsrqponmlkjihgfedcba");
							break;
		}
	}
}