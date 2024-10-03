package histoire;

import personnages.Gaulois;
import villagegaulois.Etal;

public class ScenarioCasDegrade {
	public static void main(String[] args) {
		Etal etal = new Etal();
		Gaulois tester = new Gaulois("tester",25);
		Gaulois tester2 = new Gaulois("tester2",25);

		etal.occuperEtal(tester2, "fleurs", 3);
		try {
			System.out.println(etal.acheterProduit(1, tester));
		} catch(NullPointerException N) {
			N.printStackTrace();
		} catch(IllegalArgumentException I) {
			I.printStackTrace();
		} catch(IllegalStateException S) {
			S.printStackTrace();
		}
		System.out.println("Fin du test");
	}
}
