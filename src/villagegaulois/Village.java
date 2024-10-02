package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village.Marche;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private int nbEtals = 5; // nombre d'etal defini
	Marche marche = new Marche(nbEtals);


	public Village(String nom, int nbVillageoisMaximum, int nbEtals) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		Marche marche = new Marche(nbEtals);
	}

	
	// class intern (private static class)
		private static class Marche{
			
			private Etal[] etals;
			
			private Marche(int nbEtals) {
				etals = new Etal[nbEtals];
				for (int i = 0; i < nbEtals; i++) {
					etals[i] = new Etal();
				}
			}
			
			// Installer un vendeur gaulois à un etal
			private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
				etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
			}
			
			// Trouve un etal non occuper, sinon return -1
			private int trouverEtalLibre() {
				int i = 0;
				while (i<etals.length) {
					if (etals[i].isEtalOccupe() == false) {
						return i;
					}
					i++;
				}
				return -1;
			}
			
			// Retourne le tableau d'etals où on vend un produit
			private Etal[] trouverEtals(String produit) {
				int n = 0;
				Etal[] etalProduit = new Etal[etals.length];
				
				for(int i = 0; i < etals.length; i++) {
					if (etals[i].contientProduit(produit)) {
						etalProduit[n] = etals[i];
						n++;
					}
				}
				return etalProduit;
			}
			
			// Trouve l'etal d'un vendeur passer en parametre, sinon return null
			private Etal trouverVendeur(Gaulois gaulois) {
				for(int i = 0; i < etals.length; i++) {
					if (etals[i].isEtalOccupe()) {
						if (etals[i].getVendeur() == gaulois) {
							return etals[i];
						}
					}
				}
				return null;
			}
			
			// Affiche les etals occuper dans le marche, et le nombre d'etals libres 
			private String afficherMarche() {
				int nbLibre = 0;
				for(int i = 0; i < etals.length; i++) {
					if (etals[i].isEtalOccupe()) {
						etals[i].afficherEtal();
					}else {
						nbLibre++;
					}
					
				}
				return "Il reste" + nbLibre + "etals non utilises dans le marche.\n";
			}
			
		}	
	
	
	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String installerVendeur(Gaulois vendeur, String produit, int nbProduit) {
		StringBuilder chaine = new StringBuilder();
		chaine.append(vendeur + "cherche un endroit pour vendre" + nbProduit + produit +"\n");
		int place = marche.trouverEtalLibre(); 
		if(place == -1) {
			chaine.append("Pas d'etals disponible.\n");
		}else {
			marche.utiliserEtal(place, vendeur, produit, nbProduit);
			chaine.append("Le vendeur" + vendeur + "vend des" + produit + "à l'etal n°" + place);
		}
		
	}
	
	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	
	
}

