/**
* @author N.Jomaa
* Programme simulant le jeu du Marienbad en joueur contre joueur.
*/
class MarienbadJvsJ
{
	//Variable fin présent ici car utilisées dans les différentes méthodes
	int fin = 0; //Variable pour l'arrêt du jeu lorsqu'il n'y a plus d'allumettes.
	
	void principal()
	{
		//Partie initialisation des variables
		String nom1 = SimpleInput.getString("Saisir le nom du joueur qui jouera en premier : ");
		String nom2 = SimpleInput.getString("Saisir le nom du joueur qui jouera en second : ");
		
		//Partie initialisation des CONSTANTES
		
		
		//Programme principal
		
		//Définission de la taille et initialisation du tableau.
		int[] plateau = tableau(SimpleInput.getInt("Saisir le nombre de lignes du plateau : "));
		
		System.out.println("Jeu du Marienbad en joueur contre joueur, le gagnant est celui qui prend une ou des allumette(s) en dernier");
		System.out.println("Les joueur sont " + nom1 + " et " + nom2); //Affichage du nom du joueur.
		jeu(plateau, nom1, nom2);
		
		//Activation des méthodes de test, test = true.
		boolean test = true;
		if (test)
		{
			testTableau();
			testModifJeu();
		}
	}
	
	//Partie initialisation des méthodes
	/**
	* Méthode pour créer er remplir le tableau pour la création du plateau.
	* @param int taille ; variable pour définir la taille du tableau.
	* @return int[] plateau
	*/
	int[] tableau(int taille)
	{
		while (taille <= 0) {																			//Boucle pour vérifier que le valeur de taille est > 0
			taille = SimpleInput.getInt("Valeur incorrect, saisir le nombre de lignes du plateau : ");	//int[] plateau doit être placé après
		}
		
		int[] plateau = new int[taille];
		plateau[0] = 1; //Définission de la première case du tableau pour éviter les bug dans la boucle.
		for (int i = 1; i < plateau.length; i++) //Boucle pour remplir le tableau.
		{
			plateau[i] = plateau[i - 1] + 2; //+2 pour ajouter le nombre de barre à partir de la case précédente.
		}
		return plateau;
	}
	
	/**
	* Méthode pour afficher le plateau depuis le tableau.
	* @param int[] t
	* @param nom1
	* @param nom2
	*/
	void affichageJeu(int[] t)
	{
		int i = 0;
		//Boucle pour passer à la case suivant du tableau.
		while (i < t.length)
		{
			System.out.println();
			System.out.print(i + " : ");
			//Boucle pour afficher un nombre de barre en fonction du nombre contenu dans la case du tableau.
			for (int nbrBarre = 0; nbrBarre < t[i]; nbrBarre++) //Variable nbrBarre qui s'incrémente à chaque barre affiché
																//tant que la valeur de la case du tableau n'est pas dépassée.
			{
				System.out.print ("|  "); //Affichage des barres.
			}
			System.out.println();
			System.out.println();
			i = i + 1;
		}
	
	}
	
	/**
	* Méthode pour modifier le tableau.
	* @param int[] t
	*/
	void modifJeu(int[] t)
	{
		int ligne = SimpleInput.getInt("Choisir la ligne : "); //Variable pour choisir la ligne.
		int nbrAllumettes = SimpleInput.getInt("Choisir le nombre d allumette(s) a enlever : "); //Variable pour choisir le nombre d'allumettes.
		if (ligne < t.length && ligne >= 0 && nbrAllumettes <= t[ligne] && nbrAllumettes > 0)
		{
			t[ligne] = t[ligne] - nbrAllumettes; //Modification de la case du tableau.
			fin = fin - nbrAllumettes; //Supression des allumettes présentes dans le total.
		}
		else
		{
			System.out.println("Les valeurs choisies sont incorrectes.");
			modifJeu(t);
		}
	}
	
	/**
	* Méthode pour faire avancer le jeu.
	* @param int[] plateau
	* @param String nom1
	* @param String nom2
	*/
	void jeu(int[] plateau, String nom1, String nom2)
	{
		boolean nom = true; //Variable pour afficher le nom du joueur actuel.
		
		//Boucle pour ajouter le nombre totales d'allumettes dans la variable fin
		int i = 0;
		while (i < plateau.length)
		{
			fin = fin + plateau[i]; //Ajout des valeurs du tableau dans la variable.
			i = i + 1;
		}
		
		while (fin > 0)
		{
			affichageJeu(plateau);
			if (nom)
			{
				System.out.println("Au tour de " + nom1);
				nom = false; //Inversion de la variable pour afficher le nom2
			}
			else
			{
				System.out.println("Au tour de " + nom2);
				nom = true; //Inversion de la variable pour afficher le nom1
			}
			modifJeu(plateau);
		}
		if (nom)
		{
			System.out.println("Fin du jeu, le gagnant est " + nom2);
		}
		else
		{
			System.out.println("Fin du jeu, le gagnant est " + nom1);
		}
	}
	
	
	/**
	* Méthode pour tester la méthode tableau().
	*/
	void testTableau()
	{
		System.out.println ();
		System.out.println ("*** testTableau()");
		
		//Accolades car réutilisation des mêmes noms de variables pour les tests.
		{ //Test 1
		System.out.println ("*** testTableau() n 1");
		System.out.println ("Provoque une erreur de redemande la taille du tableau.");
		System.out.print("Affichage d'un tableau avec une taille de -6 : ");
		int[] t = tableau(-6);
		affichageJeu(t);
		}
		{ //Test 2
		System.out.println ("*** testTableau() n 2");
		System.out.println ("Provoque une erreur de redemande la taille du tableau.");
		System.out.print("Affichage d'un tableau avec une taille de 0 : ");
		int[] t = tableau(0);
		affichageJeu(t);
		}
		{ //Test 3
		System.out.println ("*** testTableau() n 3");
		System.out.println ("Fonctionne correctement.");
		System.out.print("Affichage d'un tableau avec une taille de 5 : ");
		int[] t = tableau(5);
		affichageJeu(t);
		}
	}
	
	/**
	* Méthode pour tester la méthode modifJeu().
	*/
	void testModifJeu()
	{
		System.out.println ();
		System.out.println ("*** testModifJeu()");
		
		//Accolades car réutilisation des mêmes noms de variables pour les tests.
		{ //Test 1
		System.out.println ("*** testModifJeu() n 1");
		System.out.println ("La ligne 1 du tableau doit perdre 3 allumettes");
		System.out.print("Affichage d'un tableau avec une taille de 4 : ");
		int[] t = tableau(4);
		affichageJeu(t);
		System.out.println("Saisir la valeur 1 pour la ligne.");
		System.out.println("Saisir la valeur 3 pour le nombre d'allumettes a enlever.");
		modifJeu(t);
		affichageJeu(t);
		}
		{ //Test 2
		System.out.println ("*** testModifJeu() n 2");
		System.out.println ("Les valeurs saisies doivent etre incorrecte et la methode redemande des nouvelles valeurs.");
		System.out.print("Affichage d'un tableau avec une taille de 4 : ");
		int[] t = tableau(4);
		affichageJeu(t);
		System.out.println("Saisir la valeur 0 pour la ligne.");
		System.out.println("Saisir la valeur 3 pour le nombre d'allumettes a enlever.");
		modifJeu(t);
		affichageJeu(t);
		}
		{ //Test 3
		System.out.println ("*** testModifJeu() n 3");
		System.out.println ("Les valeurs saisies doivent etre incorrecte et la methode redemande des nouvelles valeurs.");
		System.out.print("Affichage d'un tableau avec une taille de 4 : ");
		int[] t = tableau(4);
		affichageJeu(t);
		System.out.println("Saisir la valeur 1 pour la ligne.");
		System.out.println("Saisir la valeur 0 pour le nombre d'allumettes a enlever.");
		modifJeu(t);
		affichageJeu(t);
		}
	}
}
