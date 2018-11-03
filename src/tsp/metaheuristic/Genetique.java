/*
 * 
 */
package tsp.metaheuristic; 	    			 	  	 	 	 	
 	    			 	  	 	 	 	
import tsp.Instance; 	    			 	  	 	 	 	
import tsp.Solution; 	    			 	  	 	 	 	
 	    			 	  	 	 	 	
// TODO: Auto-generated Javadoc
/**
 * The Class Genetique.
 */
public class Genetique extends AMetaheuristic { 	    			 	  	 	 	 	
	 	    			 	  	 	 	 	
	/**
	 * @author Marin Guermeur, Stacy Heitz
	 * 
	 * Instantiates a new genetique.
	 *
	 * @param instance the instance
	 * @param name the name
	 * @throws Exception the exception
	 */
	public Genetique(Instance instance, String name) throws Exception { 	    			 	  	 	 	 	
		super(instance, name); 	    			 	  	 	 	 	
	} 	    			 	  	 	 	 	
	 	    			 	  	 	 	 	
    			 	  	 	 	 	
	 	    			 	  	 	 	 	
	/** 	    			 	  	 	 	 		 * 
	 * Calcul de la distance totale d'une solution donnée. 	    			 	  	 	 	 	
	 * 	    			 	  	 	 	 	
	 * @param s une solution 	    			 	  	 	 	 	
	 * @return la longueur du chemin de la solution 	    			 	  	 	 	 	
	 * @throws Exception the exception 	    			 	  	 	 	 	
	 */ 	    			 	  	 	 	 	
	public long distancetotale(Solution s) throws Exception{ 	    			 	  	 	 	 	
		 	    			 	  	 	 	 	
		long distancetotale=0; 	    			 	  	 	 	 	
		for (int i=0; i<this.m_instance.getNbCities(); i++) { 	    			 	  	 	 	 	
			int a =s.getCity(i); 	    			 	  	 	 	 	
			int b =s.getCity(i+1); 	    			 	  	 	 	 	
			distancetotale=distancetotale+this.m_instance.getDistances(a, b); 	    			 	  	 	 	 	
		} 	    			 	  	 	 	 	
		return distancetotale; 	    			 	  	 	 	 	
		 	    			 	  	 	 	 	
	} 	    			 	  	 	 	 	
 	    			 	  	 	 	 	
	//code de genetique  	    			 	  	 	 	 	
	 	    			 	  	 	 	 	
	/* (non-Javadoc)
	 * @see tsp.metaheuristic.AMetaheuristic#solve(tsp.Solution)
	 */
	public Solution solve(Solution sol) throws Exception { 	    			 	  	 	 	 	
		 	    			 	  	 	 	 	
		//solution parent 1 correspond a celle trouvee grace au plus proche voisin 	    			 	  	 	 	 	
		Solution solppvparent1=sol; 	    			 	  	 	 	 	
		 	    			 	  	 	 	 	
		//solution parent 2 correspond a prendre les villes dans l'ordre 	    			 	  	 	 	 	
		Solution solordreparent2= new Solution(this.m_instance); 	    			 	  	 	 	 	
		 	    			 	  	 	 	 	
		for (int a=0;a<this.m_instance.getNbCities();a++) { 	    			 	  	 	 	 	
			solordreparent2.setCityPosition(a, a); 	    			 	  	 	 	 	
		} 	    			 	  	 	 	 	
		 	    			 	  	 	 	 	
		//on initialise une solution fils que l'on modifiera  	    			 	  	 	 	 	
		Solution fils = new Solution(this.m_instance); 	    			 	  	 	 	 	
		 	    			 	  	 	 	 	
		//nombre (arbitraire) de fois que l'on va faire la boucle : attention a la complexite en temps 	    			 	  	 	 	 	
		int nbdegeneration=10; 	    			 	  	 	 	 	
 	    			 	  	 	 	 	
		for (int i=0; i<nbdegeneration; i++) { 	    			 	  	 	 	 	
			 	    			 	  	 	 	 	
			//initialisation d'une coupure pour la selection des individus  	    			 	  	 	 	 	
			int coupure=(int)(this.m_instance.getNbCities()/2); 	    			 	  	 	 	 	
 	    			 	  	 	 	 	
			/* modification de la solution fils qui prends plus proche voisin comme solution  	    			 	  	 	 	 	
			 * jusqu'a l'indice coupure  	    			 	  	 	 	 	
			 */ 	    			 	  	 	 	 	
			for (int j=0; j<coupure; j++) { 	    			 	  	 	 	 	
				fils.setCityPosition(solppvparent1.getCity(j), j); 	    			 	  	 	 	 	
			} 	    			 	  	 	 	 	
			 	    			 	  	 	 	 	
			while(coupure<this.m_instance.getNbCities()) { 	    			 	  	 	 	 	
				 	    			 	  	 	 	 	
				for (int k=0;k<this.m_instance.getNbCities();k++) { 	    			 	  	 	 	 	
 	    			 	  	 	 	 	
					boolean z =false; 	    			 	  	 	 	 	
					 	    			 	  	 	 	 	
					for (int l=0; l<coupure; l++) { 	    			 	  	 	 	 	
						 	    			 	  	 	 	 	
						/* on verifie si la solution est deja presente avant la coupure, auquel cas  	    			 	  	 	 	 	
						 * on ne modifie pas  	    			 	  	 	 	 	
						 */ 	    			 	  	 	 	 	
						if (solordreparent2.getCity(k)==fils.getCity(l) ) 	    			 	  	 	 	 	
							z = true; 	    			 	  	 	 	 	
					} 	    			 	  	 	 	 	
					 	    			 	  	 	 	 	
					/* sinon on modifie la solution fils avec la solution parent 2 a l'indice coupure  	    			 	  	 	 	 	
					 * qui augmente ensuite afin de balayer toute les villes 	    			 	  	 	 	 	
					 */ 	    			 	  	 	 	 	
					if (z==false) { 	    			 	  	 	 	 	
						fils.setCityPosition(solordreparent2.getCity(k), coupure); 	    			 	  	 	 	 	
						coupure++; 	    			 	  	 	 	 	
					} 	    			 	  	 	 	 	
				} 	    			 	  	 	 	 	
			} 	    			 	  	 	 	 	
 	    			 	  	 	 	 	
			//initialisation des indices de mutation : choix du hasard  	    			 	  	 	 	 	
			int mut1=(int)(Math.random()*this.m_instance.getNbCities()); 	    			 	  	 	 	 	
			int mut2=(int)(Math.random()*this.m_instance.getNbCities()); 	    			 	  	 	 	 	
			 	    			 	  	 	 	 	
			int compteur = 0; 	    			 	  	 	 	 	
			 	    			 	  	 	 	 	
			//on verifie que les 2 indices ne soient pas les memes 	    			 	  	 	 	 	
			while (mut1==mut2) { 	    			 	  	 	 	 	
				mut2=(int)(Math.random()*this.m_instance.getNbCities()); 	    			 	  	 	 	 	
			} 	    			 	  	 	 	 	
			 	    			 	  	 	 	 	
			/* verification necessaire pour la boucle for qui suit car on doit avoir mut2>mut1*/ 	    			 	  	 	 	 	
			if(mut1>mut2) { 	    			 	  	 	 	 	
				int a = mut2; 	    			 	  	 	 	 	
				mut2 = mut1; 	    			 	  	 	 	 	
				mut1 = a; 	    			 	  	 	 	 	
			} 	    			 	  	 	 	 	
			 	    			 	  	 	 	 	
			//copie de la solution fils qui ne sera jamais modifiee afin de garder les memes indices 	    			 	  	 	 	 	
			Solution filsbase = fils.copy(); 	    			 	  	 	 	 	
			 	    			 	  	 	 	 	
			//on effectue les mutations entre les indices mut1 et mut2 	    			 	  	 	 	 	
			for (int n =mut1; n<mut2+1; n++) { 	    			 	  	 	 	 	
				fils.setCityPosition(filsbase.getCity(mut2-compteur), n); 	    			 	  	 	 	 	
				compteur ++; 	    			 	  	 	 	 	
			} 	    			 	  	 	 	 	
			 	    			 	  	 	 	 	
			//initialisation des distances en faisant appel a la fonction distancetotale ci dessus 	    			 	  	 	 	 	
			long distance1=distancetotale(fils); 	    			 	  	 	 	 	
			long distance2=distancetotale(solordreparent2); 	    			 	  	 	 	 	
			long distance3 = distancetotale(solppvparent1); 	    			 	  	 	 	 	
			 	    			 	  	 	 	 	
			//cas ou la pire solution est plus proche voisin : on la remplace par fils  	    			 	  	 	 	 	
			if (distance1<=distance2 && distance2<=distance3) { 	    			 	  	 	 	 	
				solppvparent1=fils; 	    			 	  	 	 	 	
			} 	    			 	  	 	 	 	
			 	    			 	  	 	 	 	
			//cas ou la pire solution est celle ordonnee : on la remplace par fils  	    			 	  	 	 	 	
			if (distance1<=distance2 && distance3<=distance2) { 	    			 	  	 	 	 	
				solordreparent2=fils; 	    			 	  	 	 	 	
			} 	    			 	  	 	 	 	
		} 	    			 	  	 	 	 	
 	    			 	  	 	 	 	
		/* apres avoir fait generation fois la boucle dessus on obtient 2 solutions parents 	    			 	  	 	 	 	
		 * on cherche maintenant a savoir laquelle des deux a la distance totale la plus petite 	    			 	  	 	 	 	
		 * afin de pouvoir la retourner et la tracer 	    			 	  	 	 	 	
		 */ 	    			 	  	 	 	 	
		long distancefils=distancetotale(solordreparent2); 	    			 	  	 	 	 	
		long distanceini=distancetotale(solppvparent1); 	    			 	  	 	 	 	
		 	    			 	  	 	 	 	
		if (distancefils<=distanceini) { 	    			 	  	 	 	 	
			return solordreparent2; 	    			 	  	 	 	 	
		} 	    			 	  	 	 	 	
		 	    			 	  	 	 	 	
		else { 	    			 	  	 	 	 	
			return solppvparent1; 	    			 	  	 	 	 	
		} 	    			 	  	 	 	 	
	} 	    			 	  	 	 	 	
 	    			 	  	 	 	 	
} 	    			 	  	 	 	 	
