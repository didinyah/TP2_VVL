package mainpackage;

import junit.framework.*;

public class TestCode39 extends TestCase {
	
	// La fonction va tester différentes chaines pour voir lesquelles passent

	// On vérifie les chaines simples avec uniquement des caractères alpha numériques
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

		// chaine avec majuscules, minuscules et numériques
		chaine = "aBc123";
		assertEquals(Code39.rendreConforme(chaine), "*ABC123*");

		// chaine avec majuscules et numériques
		chaine = "ABC123";
		assertEquals(Code39.rendreConforme(chaine), "*ABC123*");

		// chaine avec minuscules et numériques
		chaine = "abc123";
		assertEquals(Code39.rendreConforme(chaine), "*ABC123*");

		// chaine avec numériques
		chaine = "123";
		assertEquals(Code39.rendreConforme(chaine), "*123*");
	}

	// On vérifie les chaines simples avec uniquement des caractères spéciaux
	public void testConformeSpecialChars() throws Exception {

		String chaine;

		// chaine avec caractères spéciaux +
		chaine = "abc+";
		assertEquals(Code39.rendreConforme(chaine), "*ABC+*");

		// chaine avec caractères spéciaux -
		chaine = "abc-";
		assertEquals(Code39.rendreConforme(chaine), "*ABC-*");

		// chaine avec caractères spéciaux /
		chaine = "a/bc";
		assertEquals(Code39.rendreConforme(chaine), "*A/BC*");

		// chaine avec caractères spéciaux $
		chaine = "$abc";
		assertEquals(Code39.rendreConforme(chaine), "*$ABC*");

		// chaine avec caractères spéciaux %
		chaine = "ab%c";
		assertEquals(Code39.rendreConforme(chaine), "*AB%C*");

		// chaine avec caractères spéciaux .
		chaine = "a.b.c";
		assertEquals(Code39.rendreConforme(chaine), "*A.B.C*");

		// chaine avec caractères spéciaux "espace"
		chaine = "abc ";
		assertEquals(Code39.rendreConforme(chaine), "*ABC *");

		// chaine avec plusieurs caractères spéciaux 
		chaine = "a+b-c.d/e$f%g ";
		assertEquals(Code39.rendreConforme(chaine), "*A+B-C.D/E$F%G *");

		// chaine avec caractères spéciaux interdits
		chaine = "ab)cùd'e";
		assertEquals(Code39.rendreConforme(chaine), "*ABCDE*");

		// chaine avec des * à l'intérieur
		chaine = "AB*C*D1*23";
		assertEquals(Code39.rendreConforme(chaine), "*ABCD123*");
		// bug étrange avec ABCDE123 ???

		// chaine avec des * au début
		chaine = "*ABc";
		assertEquals(Code39.rendreConforme(chaine), "*ABC*");

		// chaine avec des * à la fin
		chaine = "ABc*";
		assertEquals(Code39.rendreConforme(chaine), "*ABC*");

		// chaine avec des * au début et à la fin
		chaine = "*ABc*";
		assertEquals(Code39.rendreConforme(chaine), "*ABC*");
	}

	// On passe aux tests avec la fonction Code39.rendreConforme2 qui rajoute le caractère à la fin selon un modulo

	// On vérifie les chaines simples avec uniquement des caractères alpha numériques
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

		// chaine avec majuscules, minuscules et numériques
		chaine = "aBc123";
		assertEquals(Code39.rendreConforme2(chaine), "*ABC123$*");

		// chaine avec majuscules et numériques
		chaine = "ABC123";
		assertEquals(Code39.rendreConforme2(chaine), "*ABC123$*");

		// chaine avec minuscules et numériques
		chaine = "abc123";
		assertEquals(Code39.rendreConforme2(chaine), "*ABC123$*");

		// chaine avec numériques
		chaine = "123";
		assertEquals(Code39.rendreConforme2(chaine), "*1236*");
	}

	// On vérifie les chaines simples avec uniquement des caractères spéciaux
	public void testConforme2SpecialChars() throws Exception {

		String chaine;

		// chaine avec caractères spéciaux +
		chaine = "abc+";
		assertEquals(Code39.rendreConforme2(chaine), "*ABC+V*");

		// chaine avec caractères spéciaux -
		chaine = "abc-";
		assertEquals(Code39.rendreConforme2(chaine), "*ABC-Q*");

		// chaine avec caractères spéciaux /
		chaine = "a/bc";
		assertEquals(Code39.rendreConforme2(chaine), "*A/BCU*");

		// chaine avec caractères spéciaux $
		chaine = "$abc";
		assertEquals(Code39.rendreConforme2(chaine), "*$ABCT*");

		// chaine avec caractères spéciaux %
		chaine = "ab%c";
		assertEquals(Code39.rendreConforme2(chaine), "*AB%CW*");

		// chaine avec caractères spéciaux .
		chaine = "a.b.c";
		assertEquals(Code39.rendreConforme2(chaine), "*A.B.CL*");

		// chaine avec caractères spéciaux "espace"
		chaine = "abc ";
		assertEquals(Code39.rendreConforme2(chaine), "*ABC S*");

		// chaine avec plusieurs caractères spéciaux 
		chaine = "a+b-c.d/e$f%g ";
		assertEquals(Code39.rendreConforme2(chaine), "*A+B-C.D/E$F%G K*");

		// chaine avec caractères spéciaux interdits
		chaine = "ab)cùd'e";
		assertEquals(Code39.rendreConforme2(chaine), "*ABCDEH*");

		// chaine avec des * à l'intérieur
		chaine = "AB*C*D1*23";
		assertEquals(Code39.rendreConforme2(chaine), "*ABCD1239*");

		// chaine avec des * au début
		chaine = "*ABc";
		assertEquals(Code39.rendreConforme2(chaine), "*ABCX*");

		// chaine avec des * à la fin
		chaine = "ABc*";
		assertEquals(Code39.rendreConforme2(chaine), "*ABCX*");

		// chaine avec des * au début et à la fin
		chaine = "*ABc*";
		assertEquals(Code39.rendreConforme2(chaine), "*ABCX*");
	}
}
