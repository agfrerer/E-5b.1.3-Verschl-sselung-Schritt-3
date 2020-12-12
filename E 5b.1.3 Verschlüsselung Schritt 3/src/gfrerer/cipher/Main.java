package gfrerer.cipher;

public class Main {
	public static void main(String[] args) {
		/**SubstitutionCipher sc = new SubstitutionCipher("qwertzuiopüasdfghjklöäyxcvbnmß");
		try {
			sc.encrypt("Anja Gfrerer");
			sc.decrypt("Qdpq Uzjtjtj");
		}catch(Exception e) {
			System.out.println("Etwas ist in Ihrem Alphabet schiefgegangen!");
		}
		ShiftCipher shc = new ShiftCipher();
		shc.setShiftValue(10);
		System.out.println(shc.getSecretAlphabet()); **/

		//new Controller();
		TranspositionCipher tpC = new TranspositionCipher(3); //Wert zwischen 1-4 möglich! 
		tpC.setTranspositionLevel(3);
		System.out.println(tpC.encrypt("Informatik"));
		//System.out.println(tpC.decrypt("Ioaknrtfmi"));
		new Controller();
	}
}
