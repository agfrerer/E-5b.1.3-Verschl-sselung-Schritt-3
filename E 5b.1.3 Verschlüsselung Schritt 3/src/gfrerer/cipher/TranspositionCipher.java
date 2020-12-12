package gfrerer.cipher;

import java.util.Arrays;

public class TranspositionCipher implements Cipher {
	private int transpositionLevel;
	private char[] a0, a1, a2, a3;
 
	public TranspositionCipher(int transpositionLevel) {
		setTranspositionLevel(transpositionLevel);
	}

	public void setTranspositionLevel(int transpositionLevel) { 
		if(transpositionLevel>0 && transpositionLevel<5) {
			this.transpositionLevel = transpositionLevel;
		}else {
			System.out.println("Wert nicht im Bereich 1-4!");
		}
	}
	@Override
	public String encrypt(String text) {
		try {
			int reihen = this.transpositionLevel;
			String endtext = "";
			this.a0 = new char[0];
			this.a1 = new char[0];
			this.a2 = new char[0];
			this.a3 = new char[0];
			
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
			System.out.println("Anscheinend stimmt Ihr Wert nicht. Kein encrypt möglich!");
			return "";
		}
	}

	@Override
	public String decrypt(String text) { //decrypt funktioniert leider nicht :/ Wollte es trotzdem abgeben, habe wirklich stundenlang nachgedacht
		String endtext = "";
		int reihen = this.transpositionLevel;
		try {
			String zeile0 = arrayInString(this.a0);
			String zeile1 = arrayInString(this.a1);
			String zeile2 = arrayInString(this.a2);
			String zeile3 = arrayInString(this.a3);

			char[] h0 = new char[0];
			char[] h1 = new char[0];
			char[] h2 = new char[0];
			char[] h3 = new char[0];

			for(int i=0; i < 4; i++) {
				int laenge = 0;
				switch(i) {
				case 0: laenge = zeile0.length(); break;
				case 1: laenge = zeile1.length(); break;
				case 2: laenge = zeile2.length(); break;
				case 3: laenge = zeile3.length(); break;
				}

				for(int j=0; j < laenge; j++) {
					if(j%reihen==0) {
						h0 = Arrays.copyOf(h0, h0.length+1);
						h0[h0.length-1] = text.charAt(j);
					}else if(j%reihen==1) {
						h1 = Arrays.copyOf(h1, h1.length+1);
						h1[h1.length-1] = text.charAt(j);
					}else if(j%reihen==2) {
						h2 = Arrays.copyOf(h2, h2.length+1);
						h2[h2.length-1] = text.charAt(j);
					}else if(j%reihen==3) {
						h3 = Arrays.copyOf(h3, h3.length+1);
						h3[h3.length-1] = text.charAt(j);
					}
				}
			}
			for(int j=0; j < h0.length; j++) {
				endtext = endtext + h0[j];
			}
			for(int j=0; j < h1.length; j++) {
				endtext = endtext + h1[j];
			}
			for(int j=0; j < h2.length; j++) {
				endtext = endtext + h2[j];
			}
			for(int j=0; j < h3.length; j++) {
				endtext = endtext + h3[j];
			}
			return endtext;
		} catch(Exception e) {
			System.out.println("Anscheinend stimmt Ihr Wert nicht. Kein decrypt möglich!");
			return "";
		}
	}

	public String arrayInString(char[] array) {
		String rueckgabe = "";
		for(int i=0; i < array.length; i++) {
			rueckgabe = rueckgabe + array[i];
		}
		return rueckgabe;
	}
}
