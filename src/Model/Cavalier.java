package Model;

import java.util.ArrayList;
import java.util.List;
//import java.util.*;

import echec.Couleur;
import echec.Mouvement;
import echec.Piece;
import echec.Position;

public class Cavalier extends Piece implements Mouvement {

	public Cavalier(int x, int y, Couleur c) {
		super(x, y, c);
	}

	@Override
	public List<Position> getMouvementPossible() {
		int x = getPosition().getX();
		int y = getPosition().getY();
		Position temp = new Position(x, y);
		List<Position> mouvementPossible = new ArrayList<Position>();

		for (int px = -2; px <= 2; px++) {
			for (int py = -2; py <= 2; py++) {

				if (Math.abs(px) + Math.abs(py) == 3) {
					temp.setPosition(x + px, y + py);
					if (temp.inBounds() && !this.bloqueAmi(temp)) {
						mouvementPossible.add(temp.clone());
					}
				}
			}
		}
		return mouvementPossible;
	}

	@Override
	public String toString() {
		return "[Cavalier " + super.getPosition().getX() + "," + super.getPosition().getY() + "]";
	}

}
