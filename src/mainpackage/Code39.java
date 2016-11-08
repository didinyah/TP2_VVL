package mainpackage;

import java.util.Scanner;

public class Code39 {
	public static String rendreConforme(String chaine) {

		int longueurChaine = chaine.length();
		
		// ON SUPPRIME LES CARACTERES INTERDITS et ON MET TOUT EN UPPER

		String chaineNettoyee = "";
		int j=0;
		for(int i=0; i<longueurChaine; i++) {
			chaine = chaine.toUpperCase();
			
			if((chaine.charAt(i)>='A' && chaine.charAt(i) <= 'Z')
				|| (chaine.charAt(i) >= '0' && chaine.charAt(i) <= '9') 	
				|| chaine.charAt(i) == '+'
				|| chaine.charAt(i) == '-' 
				|| chaine.charAt(i) == '.' 
				|| chaine.charAt(i) == '/' 
				|| chaine.charAt(i) == '$' 
				|| chaine.charAt(i) == '%' 
				|| chaine.charAt(i) == ' ')
			{
				chaineNettoyee += chaine.charAt(i);
			}
		}

		// ON AJOUTE LES ETOILES

		// On récupère la longueur de la chaine rentrée
		
	    String code39 = "*" + chaineNettoyee + "*";

		return code39.toString();
	}
	
	// Cette fonction va ajouter un caractère à la fin de la chaine dépendant du nombre de caractères modulo 43
	public static char ajouterModulo43(String chaine) {

		int longueurChaine = chaine.length();

		String dict = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";

		int i;
		int sum=0;
		for(i=0; i<longueurChaine; i++) {
			int index = dict.indexOf(chaine.charAt(i));
			sum+=index;
		}
		char charAAdd = dict.charAt(sum % 43);

		return charAAdd;
	}
	
	public static String rendreConforme2(String chaine) {

		int longueurChaine = chaine.length();
		
		// ON SUPPRIME LES CARACTERES INTERDITS et ON MET TOUT EN UPPER

		String chaineNettoyee = "";
		int j=0;
		for(int i=0; i<longueurChaine; i++) {
			chaine = chaine.toUpperCase();
			
			if((chaine.charAt(i)>='A' && chaine.charAt(i) <= 'Z')
				|| (chaine.charAt(i) >= '0' && chaine.charAt(i) <= '9') 	
				|| chaine.charAt(i) == '+'
				|| chaine.charAt(i) == '-' 
				|| chaine.charAt(i) == '.' 
				|| chaine.charAt(i) == '/' 
				|| chaine.charAt(i) == '$' 
				|| chaine.charAt(i) == '%' 
				|| chaine.charAt(i) == ' ')
			{
				chaineNettoyee += chaine.charAt(i);
			}
		}

		// ON AJOUTE LES ETOILES

		// On récupère la longueur de la chaine rentrée
		
	    String code39 = "*" + chaineNettoyee + ajouterModulo43(chaineNettoyee) + "*";

		return code39.toString();
	}
	
	public static void main(String args[]) {
		// Pour l'entrée à la main d'un mot
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un mot :");
		String str = sc.nextLine();
		System.out.println("Vous avez saisi : " + str);
		System.out.println("Chaine conforme : " + rendreConforme(str));
		System.out.println("Chaine conforme : " + rendreConforme2(str));
	}
}
