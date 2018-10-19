package tsp.metaheuristic;



	import tsp.Instance;
	import tsp.Solution;

	public class Opt2 extends AMetaheuristic{

		public Opt2(Instance instance, String name) throws Exception {
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
			Solution bouclebase=sol;
			long distancetotaleref=distancetotale(bouclebase);
			
			for(int posville_1 =0; posville_1<this.m_instance.getNbCities(); posville_1++) {
				for (int posville_2=posville_1; posville_2<this.m_instance.getNbCities(); posville_2++) {
					Solution bouclemodifiee=bouclebase;
					bouclemodifiee.setCityPosition(sol.getCity(posville_1), posville_2);
					bouclemodifiee.setCityPosition(sol.getCity(posville_2), posville_1);
					long distancetest=distancetotale(bouclemodifiee);
					
					if (distancetest<distancetotaleref) {
						distancetotaleref=distancetest;
						bouclebase=bouclemodifiee;
					}
					
					
				}
						}
			
			return bouclebase;
			
			
		
		}
		

	}

