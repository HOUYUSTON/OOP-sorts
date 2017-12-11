import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class gui extends Frame implements ActionListener {

	public ArrayList<Integer> oldmas = new ArrayList<Integer>();
	public ArrayList<Integer> newmas = new ArrayList<Integer>();
	public ArrPanel arrp;
	public ArrPanel arrold;
	public Label newarr= new Label("актуальный массив");
	public Label oldarr= new Label("массив на прошлом шаге");
	public boolean test_mode=false;
	public sort sort;
	public int metka=0;
	
	public gui() {
		setLayout(null);
		setTitle("Обучастер");
		setSize(1600,780);
		//newmas = new ArrayList<Integer>();
    	Random r = new Random();
    	int c=0;
    	while (newmas.size()<5) {
    	    int i = r.nextInt(10+10)-10;
    	    if (!newmas.contains(i)) {
    	    	newmas.add(i);
    	        c++;
    	    }
    	}
    	arrp = new ArrPanel(newmas,oldmas);    	
		arrp.setBounds(getWidth()/2-150, 400, 300, 50);
		add(arrp);
		newarr.setBounds(30,arrp.getY()+arrp.getHeight()/2-20,Strwidth(this,newarr.getText())+5,20);
		add(newarr);
    	Button b = new Button("Следующий шаг");
    	b.setBounds(getWidth()/2-Strwidth(this,b.getLabel())/2,getHeight()-300,Strwidth(this,b.getLabel())+5,20);
    	b.addActionListener(this);
    	add(b);
    	Button reset = new Button("Начать сначала");
    	reset.setBounds(getWidth()/2-Strwidth(this,b.getLabel())/2,getHeight()-200,Strwidth(this,b.getLabel())+5,20);
    	reset.addActionListener(this);
    	add(reset);
    	setResizable(false);
    	setVisible(true);
	}
	
	public int Strwidth(gui g, String s) {
		Font font = new Font("Arial", 0, 12);
		FontMetrics fontMetrics = g.getFontMetrics(font);
		int w = fontMetrics.stringWidth(s);
		return w;
	}

	public void actionPerformed(ActionEvent ae) {
		String s; 
		switch (s = ((Button) ae.getSource()).getLabel()) {
			case "Следующий шаг": {
				/*while(metka!=newmas.size()-1) {
					newmas=sort.next_step(newmas, metka);
					for(int i=0;i<newmas.size();i++) {
						System.out.print(newmas.get(i)+" ");					
					}
					System.out.println();
					metka++;
				}*/
	    		if(metka<newmas.size()-1) {
	    			oldmas = new ArrayList<Integer>(newmas);
		    		newmas=sort.next_step(newmas, metka);
					metka++;
					if(arrold!=null) {
						remove(arrold);
					}					
					arrold = new ArrPanel(oldmas);
					arrold.setBounds(getWidth()/2-150, 300, 300, 50);
					add(arrold);
					if(oldarr.getHeight()==0) {
						oldarr.setBounds(30,arrold.getY()+arrold.getHeight()/2-20,Strwidth(this,oldarr.getText())+5,20);
						add(oldarr);
					}
					remove(arrp);
					arrp = new ArrPanel(newmas,oldmas);
					arrp.setBounds(getWidth()/2-150, 400, 300, 50);
					add(arrp);
					setSize(getWidth()-1,getHeight()-1);
					setSize(getWidth()-1,getHeight()+1);
	    		}
				repaint();
				break;
			}
			case "Начать сначала": {
				reset();
				break;
			}
		}
	}
	
	public void reset() {
		metka=0;
		newmas.clear();
		oldmas.clear();
		remove(arrp);
		if(arrold!=null) {
			remove(arrold);
		}
		Random r = new Random();
    	int c=0;
    	while (newmas.size()<5) {
    	    int i = r.nextInt(10+10)-10;
    	    if (!newmas.contains(i)) {
    	    	newmas.add(i);
    	        c++;
    	    }
    	}
    	arrp = new ArrPanel(newmas,oldmas);
		arrp.setBounds(getWidth()/2-150, 400, 300, 50);
		add(arrp);
		newarr.setBounds(30,arrp.getY()+arrp.getHeight()/2-20,Strwidth(this,newarr.getText())+5,20);
		add(newarr);
		setSize(getWidth()-1,getHeight()-1);
		setSize(getWidth()-1,getHeight()+1);
	}
	
	public sort getsort() {
		return sort;
	}
	
	public void setsort(sort s) {
		sort=s;
	}
	
	public boolean gettest_mode() {
		return test_mode;
	}
	
	public void settest_mode(boolean b) {
		test_mode=b;
	}
	
	public void paint(Graphics g) { 
		super.paint(g); 
	}
}
