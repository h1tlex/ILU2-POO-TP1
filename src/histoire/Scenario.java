package histoire;

import exceptions.VillageSansChefException;
import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class Scenario {

	public static void main(String[] args) {
		Village village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Druide druide = new Druide("Panoramix", 2, 5, 10);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois assurancetourix = new Gaulois("Assurancetourix", 2);
		Gaulois bonemine = new Gaulois("Bonemine", 7);
		
		Etal etal1 = new Etal();

		
		etal1.occuperEtal(obelix, "fleurs", 3);
		
		// Acheter Produit
		try {
			System.out.println(etal1.acheterProduit(1, asterix));
		} catch(NullPointerException N) {
			N.printStackTrace();
		} catch(IllegalArgumentException I) {
			I.printStackTrace();
		} catch(IllegalStateException S) {
			S.printStackTrace();
		}
		
		// Afficher Village
		try {
			System.out.println(village.afficherVillageois());
		} catch(VillageSansChefException C) {
			C.printStackTrace();
		}

//		village.ajouterHabitant(bonemine);
//		village.ajouterHabitant(assurancetourix);
//		village.ajouterHabitant(asterix);
//		village.ajouterHabitant(obelix);
//		village.ajouterHabitant(druide);
//		village.ajouterHabitant(abraracourcix);
//		village.afficherVillageois();

//		System.out.println(village.rechercherVendeursProduit("fleurs"));
//		System.out.println(village.installerVendeur(bonemine, "fleurs", 20));
//		System.out.println(village.rechercherVendeursProduit("fleurs"));
//		System.out
//				.println(village.installerVendeur(assurancetourix, "lyres", 5));
//		System.out.println(village.installerVendeur(obelix, "menhirs", 2));
//		System.out.println(village.installerVendeur(druide, "fleurs", 10));

//		System.out.println(village.rechercherVendeursProduit("fleurs"));
//		Etal etalFleur = village.rechercherEtal(bonemine);
//		System.out.println(etalFleur.acheterProduit(10, abraracourcix));
//		System.out.println(etalFleur.acheterProduit(15, obelix));
//		System.out.println(etalFleur.acheterProduit(15, assurancetourix));
//		System.out.println(village.partirVendeur(bonemine));
//		System.out.println(village.afficherMarche());
	}

}
