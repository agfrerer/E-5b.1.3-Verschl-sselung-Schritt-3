package gfrerer.cipher;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class Controller implements ActionListener {
	private MonoAlphabeticCipher maC;
	private ShiftCipher shiftC;
	private SubstitutionCipher substC;
	private TranspositionCipher tpC;
	private PanelKlasse panel;
	private FrameKlasse frame;

	public Controller() {
		this.maC = new MonoAlphabeticCipher();
		this.shiftC = new ShiftCipher();
		this.substC = new SubstitutionCipher("qwertzuiopüasdfghjklöäyxcvbnmß");
		this.tpC = new TranspositionCipher(0);
		
		this.panel = new PanelKlasse(this);
		this.frame = new FrameKlasse(panel);
	}

	public void actionPerformed(ActionEvent e)  {

		String eingabe = panel.getEingabe();
		String selected = panel.selected();
		String ausgabe = "";

		if(e.getActionCommand().contentEquals("Verschlüsseln")){ 

			if(selected.equals("Cäsar")) {
				int value = eingabeZahl("Ver");
				this.shiftC.setShiftValue(value);
				ausgabe = this.shiftC.encrypt(eingabe);
				panel.setPanel(ausgabe);

			}else if(selected.equals("Secret")) {
				String secret = eingabeABC();
				this.maC.setSecretAlphabet(secret);
				ausgabe = this.maC.encrypt(eingabe);
				panel.setPanel(ausgabe);
			}else if(selected.equals("Position")) {
				int level = 0;
				try {
					level = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie ein Transpositionslevel zwischen 1-4 ein!"));
					tpC.setTranspositionLevel(level);
					ausgabe = this.tpC.encrypt(eingabe);
					panel.setPanel(ausgabe);
				}catch(Exception a) {
					System.out.println("Wert nicht numerisch!");
				}
			}
			
		}else if(e.getActionCommand().contentEquals("Entschlüsseln")){

			if(selected.equals("Cäsar")) {
				int value = eingabeZahl("Ent");
				int neu = -(value);
				this.shiftC.setShiftValue(neu);
				ausgabe = this.shiftC.encrypt(eingabe);
				panel.setPanel(ausgabe);
				
			}else if(selected.equals("Secret")) {
				String secret = eingabeABC();
				this.maC.setSecretAlphabet(secret);
				ausgabe = this.maC.decrypt(eingabe);
				panel.setPanel(ausgabe);
			}
		}
	}
	
	public int eingabeZahl(String text) {
		boolean zahl = false;
		int wert = 0;
		while(zahl==false) {
			String eingabe = JOptionPane.showInputDialog("Geben Sie einen " + text + "schlüsselungswert ein!");
			if (eingabe == null) {
				System.exit(0);
			} else if (eingabe.equals("")) {
				eingabe = "0";
			}
			try {
				wert = Integer.parseInt(eingabe);
				zahl = true;
			}catch(NumberFormatException e) {
				zahl = false;
			}
		}
		return wert;
	}
	
	public String eingabeABC() {
		String eingabe = JOptionPane.showInputDialog("Geben Sie ein Geheimalphabet ein!");
		if (eingabe == null) {
			System.exit(0);
		}
		this.substC.setSecretAlphabet(eingabe);
		return eingabe;
	}
}
