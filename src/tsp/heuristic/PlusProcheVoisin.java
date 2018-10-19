package tsp.heuristic;

import java.util.ArrayList;

import tsp.Instance;
import tsp.Solution;

public class PlusProcheVoisin extends AHeuristic {

	public PlusProcheVoisin(Instance instance, String name) throws Exception {
		super(instance, name);
	}

	@Override
	public void solve() throws Exception {
		ArrayList<Integer> listevillenonsolution = new ArrayList<>();
		Solution sol = new Solution(this.m_instance);
		for (int a=1; a<this.m_instance.getNbCities(); a++) {
			listevillenonsolution.add(a);
		}
		int compteur=0;
		while (listevillenonsolution.size() >0)	{
			int p = Villeplusproche(this.m_solution.getCity(compteur),listevillenonsolution);
			listevillenonsolution.remove(new Integer( p));
			compteur++;
			this.m_solution.setCityPosition(p, compteur);
					}	
		this.m_solution.setCityPosition(0, compteur+1);
		
	}


	public int Villeplusproche(int villeconcernee, ArrayList<Integer> listevillenonsolution) throws Exception {
		
		long distancemin=this.m_instance.getDistances(villeconcernee, listevillenonsolution.get(0));
		int villeplusproche=listevillenonsolution.get(0);
		
		for (int a : listevillenonsolution) {
			long distance = this.m_instance.getDistances(villeconcernee, a);
			if (distance != 0 && distancemin>distance) {
				distancemin=distance;
				villeplusproche=(a);
			}
		}
		
		return villeplusproche;
		
	}
}
