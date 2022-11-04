package Game;

import Utilitaire.Utils;

public class Executeur {
	public static void main(String[] args) {
		
		Game g = new Game(Utils.nomJoueur1(), Utils.nomJoueur2());
		g.lancer();
	}
}
