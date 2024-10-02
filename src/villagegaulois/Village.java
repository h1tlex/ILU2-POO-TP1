package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private int nbEtals = 5;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		Marche marche = new Marche(nbEtals);
	}

	
	// class intern
		private static class Marche{
			
			private Etal[] etals;
			
			public Marche(int nbEtals) {
				etals = new Etal[nbEtals];
				for (int i = 0; i < nbEtals; i++) {
					etals[i] = new Etal();
				}
			}
			
			public void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
				etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
			}
			
			public int trouverEtalLibre() {
				int i = 0;
				while (i<etals.length) {
					if (etals[i].isEtalOccupe() == false) {
						return i;
					}
					i++;
				}
				return -1;
			}
			
			public Etal[] trouverEtals(String produit) {
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
			
			public Etal trouverVendeur(Gaulois gaulois) {
				for(int i = 0; i < etals.length; i++) {
					if (etals[i].isEtalOccupe()) {
						if (etals[i].getVendeur() == gaulois) {
							return etals[i];
						}
					}
				}
				return null;
			}
			
			public String afficherMarche() {
				int nbLibre = 0;
				for(int i = 0; i < etals.length; i++) {
					if (etals[i].isEtalOccupe()) {
						etals[i].afficherEtal();
					}else {
						nbLibre++;
					}
					
				}
				return "Il reste" + nbLibre + "2 �tals non utilis�s dans le march�.\n";
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

