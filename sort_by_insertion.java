import java.util.ArrayList;

public class sort_by_insertion implements sort{

	public ArrayList<Integer> next_step(ArrayList<Integer> arr, int metka) {
		if(metka<arr.size()-1) {
			if (arr.get(metka) > arr.get(metka+1)) {
		           int tmp = arr.get(metka+1);
		           arr.set(metka+1, arr.get(metka));		            
		           int j = metka;
		           while (j >0&&tmp<arr.get(j-1)) {
		        	   arr.set(j, arr.get(j-1));       
		               j--;
		           }
		           arr.set(j, tmp);  
		        }
			return arr;
		}
		else {
			return null;			
		}
	}

}
