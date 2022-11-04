package Utilitaire;

import java.util.Scanner;

public class Utils {
	
	public static String nomJoueur1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nom du joueur 1");
		return sc.nextLine();
	}
	
	public static String nomJoueur2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nom du joueur 2");
		return sc.nextLine();
	}
}
