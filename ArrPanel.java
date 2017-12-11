import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ArrPanel extends Panel{
	
	public ArrayList<Integer> mas ;

	ArrPanel(ArrayList<Integer> arr,ArrayList<Integer> old){
		for(int i=0;i<arr.size();i++) {
			Button b = new Button(Integer.toString(arr.get(i)));
			if(old.size()>i) {
				if(old.get(i)!=arr.get(i)) {
					b.setBackground(Color.magenta);
				}
			}
			b.setEnabled(false);
			add(b);			
		}
	}
	
	ArrPanel(ArrayList<Integer> arr){
		for(int i=0;i<arr.size();i++) {
			Button b = new Button(Integer.toString(arr.get(i)));
			b.setEnabled(false);
			add(b);		
		}
	}
	
	public void paint(Graphics g) { 
		super.paint(g); 
	} 
}
