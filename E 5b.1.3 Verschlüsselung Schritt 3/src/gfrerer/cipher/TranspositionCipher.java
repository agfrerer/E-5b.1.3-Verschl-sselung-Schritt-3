package gfrerer.cipher;

public class TranspositionCipher implements Cipher {
	private int transpositionLevel;
	
	public TranspositionCipher(int transpositionLevel) {
		this.transpositionLevel = transpositionLevel;
	}
	
	public void setTranspositionLevel(int transpositionLevel) { 
		if(transpositionLevel>0) {
			this.transpositionLevel = transpositionLevel;
		}
	}
	@Override
	public String encrypt(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
