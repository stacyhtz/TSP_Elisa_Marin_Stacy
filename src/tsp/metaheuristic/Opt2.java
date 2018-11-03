/*
 * 
 */
package tsp.metaheuristic;

import tsp.Instance;
import tsp.Solution;

// TODO: Auto-generated Javadoc
/**
 * The Class Opt2.
 */
public class Opt2 extends AMetaheuristic{

	/**
	 * @author Elisa Gressier-Monard, Marin Guermeur
	 * 
	 * Instantiates a new opt 2.
	 *
	 * @param instance the instance
	 * @param name the name
	 * @throws Exception the exception
	 */
	public Opt2(Instance instance, String name) throws Exception {
		super(instance, name);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Calcul de la distance totale d'une solution donnée.
	 *
	 * @param s une solution
	 * @return la longueur du chemin de la solution
	 * @throws Exception the exception
	 */
	public long distancetotale(Solution s) throws Exception{
		long distancetotale=0;
		for (int i = 0; i < this.m_instance.getNbCities(); i++) {
			int a = s.getCity(i);
			int b = s.getCity(i+1);
			distancetotale = distancetotale + this.m_instance.getDistances(a,b);
		}

		return distancetotale;
	}



	/* (non-Javadoc)
	 * @see tsp.metaheuristic.AMetaheuristic#solve(tsp.Solution)
	 */
	@Override
	public Solution solve(Solution sol) throws Exception {
		
		//on définit le nombre d'itérations de l'algorithme
		int iterations = 100;

		while (iterations > 0) {
			
			//initialisation de la distance de référence		
			long distanceref = distancetotale(sol);

			//on parcourt l'ensemble des doublets de villes pour procéder à l'inversion de ces deux villes
			//et au retournement de toutes les villes entre les deux
			for (int posville1 = 1; posville1 < this.m_instance.getNbCities(); posville1 ++) {
				for(int posville2 = posville1+1; posville2 < this.m_instance.getNbCities(); posville2++) {

					Solution solbis = sol.copy();
					int compteur = 0;
					
					//on procède à l'échange des deux villes et au retournement des villes au milieu
					for (int i = posville1; i < posville2 + 1 ;i++) {
						solbis.setCityPosition(sol.getCity(posville2-compteur), i);
						compteur ++;
					}

					long distancemodifiee = distancetotale(solbis);

					//si la distance après modification est inférieure à la distance de référence
					//elle devient la distance de référence et le chemin en question devient notre solution
					if (distancemodifiee < distanceref) {
						iterations = 100;
						distanceref = distancemodifiee;
						sol = solbis.copy();
					}

				}
			}
			iterations --;
		}
		return sol;
	}

}
