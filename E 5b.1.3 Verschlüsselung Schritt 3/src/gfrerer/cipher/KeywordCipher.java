package gfrerer.cipher;

public class KeywordCipher extends MonoAlphabeticCipher {
	private String keyword;
	
	public KeywordCipher(String keyword) {
		this.keyword = keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
