/*
 * 
 */
package tsp.heuristic; 	    			 	  	 	 	 	 	 		 		 		  	 			 	
	 			 	 	 		 		 		  	 			 	 	    			 	  	 	 	 	
	import java.util.ArrayList; 	    			 	  	 	 	 	 	 		 		 		  	 			 	
	 	    			 	  	 	 	 	 	 		 		 		  	 			 	
	import tsp.Instance; 	    			 	  	 	 	 	 	 		 		 		  	 			 	
	import tsp.Solution; 	    			 	  	 	 	 	 	 		 		 		  	 			 	
	 	    			 	  	 	 	 	 	 		 		 		  	 			 	
	// TODO: Auto-generated Javadoc
/**
	 * The Class PlusProcheVoisin.
	 */
	public class PlusProcheVoisin extends AHeuristic { 	    			 	  	 	 	 	 	 		 		 		  	 			 	
	 	    			 	  	 	 	 	 	 		 		 		  	 			 	
		/**
		 * @author Stacy Heitz, Elisa Gressier-Monard
		 * 
		 * Instantiates a new plus proche voisin.
		 *
		 * @param instance the instance
		 * @param name the name
		 * @throws Exception the exception
		 */
		public PlusProcheVoisin(Instance instance, String name) throws Exception { 	    			 	  	 	 	 	 	 		 		 		  	 			 	
			super(instance, name); 	    			 	  	 	 	 	 	 		 		 		  	 			 	
		} 	    			 	  	 	 	 	 	 		 		 		  	 			 	
	 	    			 	  	 	 	 	 	 		 		 		  	 			 	
		 	    			 	  	 	 	 	 	 		 		 		  	 			 	
		/* (non-Javadoc)
		 * @see tsp.heuristic.AHeuristic#solve()
		 */
		public void solve() throws Exception { 	 
			// Creation de la liste des villes non solution	 	  	 	
			ArrayList<Integer> listevillenonsolution = new ArrayList<>(); 	    	 	 	 		 		 		  	 			 	 	    			 	  	 	 	 	
			Solution sol = new Solution(this.m_instance); 	   
			
			// Initialisation de la liste des villes non solution
			for (int a=1; a<this.m_instance.getNbCities(); a++) { 	    	 		 	  	 	 	 	 	 		 		 		  	 			 	 	    			 	  	 	 	 	
				listevillenonsolution.add(a); 	    			 	  	 	 	 	 	 		 		 		  	 			 	
			} 	    			 	  	 	 	 	 	 		 		 		  	 			 	
			int compteur=0; 	  
			
			// tant que toutes les villes ne sont pas visitées		 
			while (listevillenonsolution.size() >0)	{ 
				//recherche de la ville la plus proche en distance :   			 	  	 	 	 	 	 		 		 		  	 	
				int p = Villeplusproche(this.m_solution.getCity(compteur),listevillenonsolution); 			 	 	
				
				 //Suppression la ville p de la liste des villes non solution
				listevillenonsolution.remove(new Integer( p)); 	  
				
				compteur++; 	    			 	 
				
				// Ajout de la ville la plus proche à la solution
				this.m_solution.setCityPosition(p, compteur); 	    			 	  	 	 	 	 	 		 		 		  	 			 	 	    			 	  	 	 	 	
						}	 
			
			// Ajout de la ville de départ à la fin de la solution pour fermer la boucle	 	  	 	 	 	 	 		
			this.m_solution.setCityPosition(0, compteur+1); 	    		 		 		  	 			 	 	    			 	  	 	 	 	
			 	    			 	  	 	 	 	 	 		 		 		  	 			 	
		} 	 		 		 		  	 			 	 	    			 	  	 	 	 	
		 	 		 		 		  	 			 	 	    			 	  	 	 	 	
		 	 		 		 		  	 			 	 	    			 	  	 	 	 	
		/*	 		 		 		  	 			 	 	    			 	  	 	 	 	
		 */  	 		 		 		  	 			 	 	    			 	  	 	 	 	
	 	    			 	  	 	 	 	 	 		 		 		  	 			 	
	 	    			 	  	 	 	 	 	 		 		 		  	 			 	
		/**
		 * @author Stacy Heitz, Elisa Gressier-Monard
		 * 
		 * Ville la plus proche :  programme permettant de trouver la ville la plus proche 	 		 		 		  	 			 	 	    			 	  	 	 	 	
		 * prenant en argument, la ville de référence à partir de laquelle est cherchée la ville la plus proche 	 		 		 		  	 			 	 	    			 	  	 	 	 	
		 * et une liste de ville  	 		 		 		  	 			 	 	    			 	  	 	 	 	
		 * retourn le numéro de la ville la plus proche. 
		 *
		 * @param villeconcernee la ville concernée
		 * @param listevillenonsolution la liste des villes n'étant pas encore dans la solution
		 * @return the le numéro de la ville la plus proche de la ville concernée
		 * @throws Exception the exception
		 */
		public int Villeplusproche(int villeconcernee, ArrayList<Integer> listevillenonsolution) throws Exception { 	    			 	  	 	 	 	 	 		 		 		  	 			 	
			 	    			 	  	 	 	 	 	 		 		 		  	 			 	
			long distancemin=this.m_instance.getDistances(villeconcernee, listevillenonsolution.get(0)); 	    		//initialisation de la distance_min par la distance avec la ville de référence (ici 0)	 	  	 	 	 	 	 		 		 		  	 			 	 	    			 	  	 	 	 	
			int villeplusproche=listevillenonsolution.get(0); 	 //initialisation de la ville de référence (ici 0)   			 	  	 	 	 	 	 		 		 		  	 			 	 	    			 	  	 	 	 	
			 	    			 	  	 	 	 	 	 		 		 		  	 			 	
			for (int a : listevillenonsolution) { 	    	//Parcourt de la liste des villes		 	  	 	 	 	 	 		 		 		  	 			 	 	    			 	  	 	 	 	
				long distance = this.m_instance.getDistances(villeconcernee, a); 	    			 	  	 	 	 	 	 		 		 		  	 			 	
				if (distance != 0 && distancemin>distance) { 	    	//Test permettant de voir si une nouvelle distance minimale est trouvée		 	  	 	 	 	 	 		 		 		  	 			 	 	    			 	  	 	 	 	
					distancemin=distance; 	    		//Mise à jour des données de référence	 	  	 	 	 	 	 		 		 		  	 			 	 	    			 	  	 	 	 	
					villeplusproche=(a); 	    			 	  	 	 	 	 	 		 		 		  	 			 	
				} 	    			 	  	 	 	 	 	 		 		 		  	 			 	
			} 	    			 	  	 	 	 	 	 		 		 		  	 			 	
			 	    			 	  	 	 	 	 	 		 		 		  	 			 	
			return villeplusproche; 	    			 	  	 	 	 	 	 		 		 		  	 			 	
			 	    			 	  	 	 	 	 	 		 		 		  	 			 	
		} 	    			 	  	 	 	 	 	 		 		 		  	 			 	
	} 	    			 	  	 	 	 	
