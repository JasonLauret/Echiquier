package Model;

//import java.util.*;
import java.util.ArrayList;
import java.util.List;

import echec.Couleur;
import echec.Mouvement;
import echec.Piece;
import echec.Position;

public class Pion extends Piece implements Mouvement {

	private boolean _1erTour;

	public Pion(int x, int y, Couleur c) {
		super(x, y, c);
		_1erTour = true;
	}

	@Override
	public boolean bouger(Position pos) {
		boolean temp = super.bouger(pos);
		if (temp)
			_1erTour = false;
		return temp;

	}

	@Override
	public List<Position> getMouvementPossible() {
		int x = getPosition().getX();
		int y = getPosition().getY();
		List<Position> mouvementPossible = new ArrayList<Position>();

		mouvementPossible.addAll(aCote());

		if (this.getCouleur().equals(Couleur.WHITE)) {
			Position temp1 = new Position(x, y + 1);
			if (temp1.inBounds() && !this.bloqueAmi(temp1) && !this.bloqueEnnemi(temp1))
				mouvementPossible.add(temp1.clone());

			Position temp2 = new Position(x, y + 2);
			if (_1erTour && !this.bloqueAmi(temp2) && !this.bloqueEnnemi(temp1))
				mouvementPossible.add(temp2.clone());
		}

		if (this.getCouleur().equals(Couleur.BLACK)) {
			Position temp1 = new Position(x, y - 1);
			if (temp1.inBounds() && !this.bloqueAmi(temp1) && !this.bloqueEnnemi(temp1))
				mouvementPossible.add(temp1.clone());
			else if (this.bloqueAmi(temp1))
				return mouvementPossible;

			Position temp2 = new Position(x, y - 2);
			if (_1erTour && !this.bloqueAmi(temp2) && !this.bloqueEnnemi(temp1))
				mouvementPossible.add(temp2.clone());

		}

		return mouvementPossible;
	}

	private List<Position> aCote() {
		List<Position> mouvementPossible = new ArrayList<Position>();

		if (this.getCouleur().equals(Couleur.WHITE)) {
			for (Piece other : Piece.getBlackPiece()) {
				if (getPosition().getY() - other.getPosition().getY() == -1) {
					if (Math.abs(getPosition().getX() - other.getPosition().getX()) == 1) {
						int x = other.getPosition().getX();
						int y = other.getPosition().getY();
						Position temp1 = new Position(x, y);
						mouvementPossible.add(temp1);

					}

				}
			}
		}

		if (this.getCouleur().equals(Couleur.BLACK)) {
			for (Piece other : Piece.getWhitePiece()) {
				if (getPosition().getY() - other.getPosition().getY() == 1) {
					if (Math.abs(getPosition().getX() - other.getPosition().getX()) == 1) {
						int x = other.getPosition().getX();
						int y = other.getPosition().getY();
						Position temp1 = new Position(x, y);
						mouvementPossible.add(temp1.clone());

					}
				}
			}
		}
		return mouvementPossible;
	}

	@Override
	public String toString() {
		return "[Pion " + super.getPosition().getX() + "," + super.getPosition().getY() + "]";
	}

}
