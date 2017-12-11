import java.util.ArrayList;

public class sort_by_choice implements sort {

	public ArrayList<Integer> next_step(ArrayList<Integer> arr, int metka) {
		if(metka<arr.size()) {
			int min=metka;		
			for(int i=metka+1;i<arr.size();i++) {
				if(arr.get(i)<arr.get(min)) {
					min=i;
				}
			}
			int tmp=arr.get(min);
			arr.set(min,arr.get(metka));
			arr.set(metka,tmp);
			return arr;
		}
		else {
			return null;
		}
	}
}
