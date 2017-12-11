import java.util.ArrayList;

public class sort_by_bubble implements sort{

	public ArrayList<Integer> next_step(ArrayList<Integer> arr, int metka) {
		if(metka<arr.size()-1) {
			/*for (int j = 0; j < metka; j++) {
		        if (arr.get(j) > arr.get(j+1)) {
		            int tmp = arr.get(j);
		            arr.set(j, arr.get(j+1));
		            arr.set(j+1, tmp);
		        }
		    }*/
			int bub = arr.size()-1;
			for(int i=arr.size()-2;i>=metka;i--) {
				if(arr.get(bub)<arr.get(i)) {
					int tmp=arr.get(bub);
					arr.set(bub, arr.get(i));
					arr.set(i, tmp);
					bub=i;
				}
				else {
					bub=i;
				}
			}
			return arr;
		}
		else {
			return null;			
		}
	}

}
