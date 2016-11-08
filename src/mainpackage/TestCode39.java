package mainpackage;

import junit.framework.*;

public class TestCode39 extends TestCase {
	
	// La fonction va tester diff�rentes chaines pour voir lesquelles passent

	// On v�rifie les chaines simples avec uniquement des caract�res alpha num�riques
	public void testConformeAlphaNum() throws Exception {

		String chaine;

		// chaine normale avec que des minuscules
		chaine = "abcdefghijklmnopq";
		assertEquals(Code39.rendreConforme(chaine), "*ABCDEFGHIJKLMNOPQ*");
		
		// chaine vide
		assertNotSame(Code39.rendreConforme(""), "");
		
		// chaine avec espace
		chaine = "abc efg";
		assertEquals(Code39.rendreConforme(chaine), "*ABC EFG*");

		// chaine avec majuscules et minuscules
		chaine = "aBc";
		assertEquals(Code39.rendreConforme(chaine), "*ABC*");

		// chaine avec majuscules
		chaine = "ABC";
		assertEquals(Code39.rendreConforme(chaine), "*ABC*");

		// chaine avec majuscules, minuscules et num�riques
		chaine = "aBc123";
		assertEquals(Code39.rendreConforme(chaine), "*ABC123*");

		// chaine avec majuscules et num�riques
		chaine = "ABC123";
		assertEquals(Code39.rendreConforme(chaine), "*ABC123*");

		// chaine avec minuscules et num�riques
		chaine = "abc123";
		assertEquals(Code39.rendreConforme(chaine), "*ABC123*");

		// chaine avec num�riques
		chaine = "123";
		assertEquals(Code39.rendreConforme(chaine), "*123*");
	}

	// On v�rifie les chaines simples avec uniquement des caract�res sp�ciaux
	public void testConformeSpecialChars() throws Exception {

		String chaine;

		// chaine avec caract�res sp�ciaux +
		chaine = "abc+";
		assertEquals(Code39.rendreConforme(chaine), "*ABC+*");

		// chaine avec caract�res sp�ciaux -
		chaine = "abc-";
		assertEquals(Code39.rendreConforme(chaine), "*ABC-*");

		// chaine avec caract�res sp�ciaux /
		chaine = "a/bc";
		assertEquals(Code39.rendreConforme(chaine), "*A/BC*");

		// chaine avec caract�res sp�ciaux $
		chaine = "$abc";
		assertEquals(Code39.rendreConforme(chaine), "*$ABC*");

		// chaine avec caract�res sp�ciaux %
		chaine = "ab%c";
		assertEquals(Code39.rendreConforme(chaine), "*AB%C*");

		// chaine avec caract�res sp�ciaux .
		chaine = "a.b.c";
		assertEquals(Code39.rendreConforme(chaine), "*A.B.C*");

		// chaine avec caract�res sp�ciaux "espace"
		chaine = "abc ";
		assertEquals(Code39.rendreConforme(chaine), "*ABC *");

		// chaine avec plusieurs caract�res sp�ciaux 
		chaine = "a+b-c.d/e$f%g ";
		assertEquals(Code39.rendreConforme(chaine), "*A+B-C.D/E$F%G *");

		// chaine avec caract�res sp�ciaux interdits
		chaine = "ab)c�d'e";
		assertEquals(Code39.rendreConforme(chaine), "*ABCDE*");

		// chaine avec des * � l'int�rieur
		chaine = "AB*C*D1*23";
		assertEquals(Code39.rendreConforme(chaine), "*ABCD123*");
		// bug �trange avec ABCDE123 ???

		// chaine avec des * au d�but
		chaine = "*ABc";
		assertEquals(Code39.rendreConforme(chaine), "*ABC*");

		// chaine avec des * � la fin
		chaine = "ABc*";
		assertEquals(Code39.rendreConforme(chaine), "*ABC*");

		// chaine avec des * au d�but et � la fin
		chaine = "*ABc*";
		assertEquals(Code39.rendreConforme(chaine), "*ABC*");
	}

	// On passe aux tests avec la fonction Code39.rendreConforme2 qui rajoute le caract�re � la fin selon un modulo

	// On v�rifie les chaines simples avec uniquement des caract�res alpha num�riques
	public void testConforme2AlphaNum() throws Exception {

		String chaine;

		// chaine normale avec que des minuscules
		chaine = "abcdefghijklmnopq";
		assertEquals(Code39.rendreConforme2(chaine), "*ABCDEFGHIJKLMNOPQ5*");
		
		// chaine vide
		assertNotSame(Code39.rendreConforme2(""), "");
		
		// chaine avec espace
		chaine = "abc efg";
		assertEquals(Code39.rendreConforme2(chaine), "*ABC EFGU*");

		// chaine avec majuscules et minuscules
		chaine = "aBc";
		assertEquals(Code39.rendreConforme2(chaine), "*ABCX*");

		// chaine avec majuscules
		chaine = "ABC";
		assertEquals(Code39.rendreConforme2(chaine), "*ABCX*");

		// chaine avec majuscules, minuscules et num�riques
		chaine = "aBc123";
		assertEquals(Code39.rendreConforme2(chaine), "*ABC123$*");

		// chaine avec majuscules et num�riques
		chaine = "ABC123";
		assertEquals(Code39.rendreConforme2(chaine), "*ABC123$*");

		// chaine avec minuscules et num�riques
		chaine = "abc123";
		assertEquals(Code39.rendreConforme2(chaine), "*ABC123$*");

		// chaine avec num�riques
		chaine = "123";
		assertEquals(Code39.rendreConforme2(chaine), "*1236*");
	}

	// On v�rifie les chaines simples avec uniquement des caract�res sp�ciaux
	public void testConforme2SpecialChars() throws Exception {

		String chaine;

		// chaine avec caract�res sp�ciaux +
		chaine = "abc+";
		assertEquals(Code39.rendreConforme2(chaine), "*ABC+V*");

		// chaine avec caract�res sp�ciaux -
		chaine = "abc-";
		assertEquals(Code39.rendreConforme2(chaine), "*ABC-Q*");

		// chaine avec caract�res sp�ciaux /
		chaine = "a/bc";
		assertEquals(Code39.rendreConforme2(chaine), "*A/BCU*");

		// chaine avec caract�res sp�ciaux $
		chaine = "$abc";
		assertEquals(Code39.rendreConforme2(chaine), "*$ABCT*");

		// chaine avec caract�res sp�ciaux %
		chaine = "ab%c";
		assertEquals(Code39.rendreConforme2(chaine), "*AB%CW*");

		// chaine avec caract�res sp�ciaux .
		chaine = "a.b.c";
		assertEquals(Code39.rendreConforme2(chaine), "*A.B.CL*");

		// chaine avec caract�res sp�ciaux "espace"
		chaine = "abc ";
		assertEquals(Code39.rendreConforme2(chaine), "*ABC S*");

		// chaine avec plusieurs caract�res sp�ciaux 
		chaine = "a+b-c.d/e$f%g ";
		assertEquals(Code39.rendreConforme2(chaine), "*A+B-C.D/E$F%G K*");

		// chaine avec caract�res sp�ciaux interdits
		chaine = "ab)c�d'e";
		assertEquals(Code39.rendreConforme2(chaine), "*ABCDEH*");

		// chaine avec des * � l'int�rieur
		chaine = "AB*C*D1*23";
		assertEquals(Code39.rendreConforme2(chaine), "*ABCD1239*");

		// chaine avec des * au d�but
		chaine = "*ABc";
		assertEquals(Code39.rendreConforme2(chaine), "*ABCX*");

		// chaine avec des * � la fin
		chaine = "ABc*";
		assertEquals(Code39.rendreConforme2(chaine), "*ABCX*");

		// chaine avec des * au d�but et � la fin
		chaine = "*ABc*";
		assertEquals(Code39.rendreConforme2(chaine), "*ABCX*");
	}
}
