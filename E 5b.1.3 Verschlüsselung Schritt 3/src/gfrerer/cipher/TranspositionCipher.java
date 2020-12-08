package gfrerer.cipher;

import java.util.Arrays;

public class TranspositionCipher implements Cipher {
	private int transpositionLevel;
	
	public TranspositionCipher(int transpositionLevel) {
		setTranspositionLevel(transpositionLevel);
	}
	
	public void setTranspositionLevel(int transpositionLevel) { 
		if(transpositionLevel>0 && transpositionLevel<5) {
			this.transpositionLevel = transpositionLevel;
		}else {
			System.out.println("Nur ein Wert zwischen 1-4 möglich!");
		}
	}
	@Override
	public String encrypt(String text) {
		try {
			int reihen = this.transpositionLevel;
			char[] a0 = new char[0];
			char[] a1 = new char[0];
			char[] a2 = new char[0];
			char[] a3 = new char[0];
			String endtext = "";
			
			for(int i=0; i < text.length(); i++) {
				switch(i%reihen) {
				case 0: a0 = Arrays.copyOf(a0, a0.length+1);
						a0[a0.length-1] = text.charAt(i);
						break;
				case 1: a1 = Arrays.copyOf(a1, a1.length+1);
						a1[a1.length-1] = text.charAt(i);
						break;
				case 2: a2 = Arrays.copyOf(a2, a2.length+1);
						a2[a2.length-1] = text.charAt(i);
						break;
				case 3: a3 = Arrays.copyOf(a3, a3.length+1);
						a3[a3.length-1] = text.charAt(i);
						break;
				default: System.out.println("Leider ein Fehler Anja :( Aber du packst das noch!");
				}
			}
			for(int i=0; i < a0.length; i++) {
				endtext = endtext + a0[i];
			}
			for(int i=0; i < a1.length; i++) {
				endtext = endtext + a1[i];
			}
			for(int i=0; i < a2.length; i++) {
				endtext = endtext + a2[i];
			}
			for(int i=0; i < a3.length; i++) {
				endtext = endtext + a3[i];
			}
			return endtext;
		}catch(Exception e) {
			System.out.println("Kann kein encrypt durchführen, Wert nicht im angegebenen Bereich!");
			return "";
		}
	}

	@Override
	public String decrypt(String text) {
		try {
			int reihen = this.transpositionLevel;
			char[] a0 = new char[0];
			char[] a1 = new char[0];
			char[] a2 = new char[0];
			char[] a3 = new char[0];
			String endtext = "";
			for(int i=0; i < text.length(); i++) {
				switch(i%reihen) {
				case 0: a0 = Arrays.copyOf(a0, a0.length+1);
						a0[a0.length-1] = text.charAt(i);
						break;
				case 1: a1 = Arrays.copyOf(a1, a1.length+1);
						a1[a1.length-1] = text.charAt(i);
						break;
				case 2: a2 = Arrays.copyOf(a2, a2.length+1);
						a2[a2.length-1] = text.charAt(i);
						break;
				case 3: a3 = Arrays.copyOf(a3, a3.length+1);
						a3[a3.length-1] = text.charAt(i);
						break;
				default: System.out.println("Leider ein Fehler Anja :( Aber du packst das noch!");
				}
			}
			for(int i=0; i < a0.length; i++) {
				endtext = endtext + a0[i];
			}
			for(int i=0; i < a1.length; i++) {
				endtext = endtext + a1[i];
			}
			for(int i=0; i < a2.length; i++) {
				endtext = endtext + a2[i];
			}
			for(int i=0; i < a3.length; i++) {
				endtext = endtext + a3[i];
			}
			return endtext;
		}catch(Exception e) {
			System.out.println("Kann kein decrpyt durchführen, Wert nicht im angegebenen Bereich!");
			return "";
		}
	}
}
