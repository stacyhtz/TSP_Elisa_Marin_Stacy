package tsp.metaheuristic;






	import tsp.Instance;
	import tsp.Solution;

	public class Opt2bis extends AMetaheuristic{

		public Opt2bis(Instance instance, String name) throws Exception {
			super(instance, name);
			// TODO Auto-generated constructor stub
		}

		
		public long distancetotale(Solution s) throws Exception{
			
			long distancetotale=0;
			for (int i=0; i<this.m_instance.getNbCities(); i++) {
				int a =s.getCity(i);
				int b =s.getCity(i+1);
				distancetotale=distancetotale+this.m_instance.getDistances(a, b);
			}
			
			return distancetotale;
		}
		
		

		@Override
		public Solution solve(Solution sol) throws Exception {
			/*Solution bouclebase=sol;
			System.err.println(distancetotale(bouclebase));
			Solution bouclemodifiee = bouclebase;
			Solution bouclebis = bouclebase;
			long distancetotaleref=distancetotale(bouclebase);	
			for(int posville_1 =0; posville_1<this.m_instance.getNbCities(); posville_1++) {
				
				for (int posville_2=0; posville_2<this.m_instance.getNbCities(); posville_2++) {			
					bouclemodifiee.setCityPosition(sol.getCity(posville_1), posville_2);
					bouclemodifiee.setCityPosition(sol.getCity(posville_2), posville_1);
					long distancetest=distancetotale(bouclemodifiee);
					if (distancetest<distancetotaleref) {
						distancetotaleref=distancetest;
						bouclebis = bouclemodifiee;
					
					}
				}
				bouclebase = bouclebis;
				bouclemodifiee = bouclebase;
			}
			return bouclebase;*/
	
			
			
			long distanceref = distancetotale(sol);
			
			int iterations = 10;
		
			while (iterations>0) {
			
			for (int posville1 = 1; posville1 < this.m_instance.getNbCities()-2;posville1 ++) {
				
				for(int posville2 = posville1+1; posville2< this.m_instance.getNbCities()-2;posville2++) {
					Solution solbis = sol.copy();
					
					int compteur = 0;
					
					for (int i = posville1; i<= posville2 ;i++) {
						
						solbis.setCityPosition(sol.getCity(posville2-compteur), i);
					
						compteur ++;
						
					
					}
					long distancemodifiee = distancetotale(solbis);
					
					if (distancemodifiee < distanceref) {
						iterations = 0;
						
						distanceref=distancemodifiee;
						sol = solbis.copy();
					
					}
					
				}
			}
			iterations --;
		
		
			
		}
			return sol;
		}

	}
