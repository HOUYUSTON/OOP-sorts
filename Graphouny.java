import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Graphouny extends Frame {//1327 �����
	public static Graphouny gr = new Graphouny();
	
	public Graphouny() {
		addKeyListener(new MyKeyAdapter(this));
		addMouseListener(new MyMouseAdapter(this));
		addWindowListener(new MyWindowAdapter());
	}
	
	public static void main(String args[]) {
		gr.setLayout(null);
		gr.setSize(1000,300);
		gr.setResizable(false);
		CheckboxGroup cbg=new CheckboxGroup(); 
		Checkbox cb1=new Checkbox ("Test", cbg, false); 
		Checkbox cb2=new Checkbox ("Study", cbg, false);
		MyButtonPanel mbt1 = new MyButtonPanel(1);
		MyButtonPanel mbt2 = new MyButtonPanel(2);
		mbt1.setBounds(gr.getWidth()/2-400, 100, 800, 50);
		mbt2.setBounds(gr.getWidth()/2-400, 100, 800, 50);
		gr.add(mbt1);
		gr.add(mbt2);
		mbt1.setVisible(false);
		mbt2.setVisible(false);
		cb1.addItemListener(new ItemListener() {
			public void itemStateChanged (ItemEvent ie)
		    {
				Checkbox cb=(Checkbox) ie.getSource();
					if (cb.getState ())
			        {
						mbt2.setVisible(false);
						mbt1.setVisible(true);
			        }
		    }
		});
		cb2.addItemListener(new ItemListener() {
			public void itemStateChanged (ItemEvent ie)
		    {
				mbt1.setVisible(false);
				mbt2.setVisible(true);
		    }
		});
		gr.add(cb1);
		gr.add(cb2);
		cb1.setBounds(gr.getWidth()/3, 50, 100, 20);
		cb2.setBounds((gr.getWidth()/3)*2, 50, 100, 20);
		gr.setLocationRelativeTo(null);
    	gr.setExtendedState(Frame.MAXIMIZED_BOTH);
		gr.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	}

}

class MyKeyAdapter extends KeyAdapter {
	Graphouny gr;
	
	public MyKeyAdapter(Graphouny gr) {
		this.gr = gr;
	}
}

class MyMouseAdapter extends MouseAdapter {
	Graphouny gr;
	public MyMouseAdapter(Graphouny gr) {
		this.gr = gr;
}
	public void mousePressed(MouseEvent me) {
		gr.repaint();
	}
}

class MyWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent we) {
	System.exit(0);
	}
}

class MyButtonPanel extends Panel { 
	
	public MyButtonPanel(int c) {
		setLayout(new FlowLayout());
		Button b1 = new Button("���������� �������");
		Button b2 = new Button("���������� ���������");
		Button b3 = new Button("���������� ���������");
		setSize(800,50);
		b1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				if(c==1) {
					gui t = new gui();
					t.setsort(new sort_by_choice());
					//gui.sort = new sort_by_choice();
					//t.reset(t);
			    	t.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent we) {
			                t.setVisible(false);
			             }
			    	});
			    	t.setLocationRelativeTo(null);
			    	t.setVisible(true);
			    }
			    if(c==2) {
			    	gui t = new gui();
			    	//t.reset(t);
			    	t.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent we) {
			                t.setVisible(false);
			             }
			    	});
			    	t.setLocationRelativeTo(null);
			    	t.setVisible(true);
			    }
			}
		});
		b2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				if(c==1) {
					gui t = new gui();
					t.setsort(new sort_by_insertion());
					t.reset();
			    	t.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent we) {
			                t.setVisible(false);
			             }
			    	});
			    	t.setLocationRelativeTo(null);
			    	t.setVisible(true);
			    }
			    if(c==2) {
			    	gui t = new gui();
			    	t.reset();
			    	t.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent we) {
			                t.setVisible(false);
			             }
			    	});
			    	t.setLocationRelativeTo(null);
			    	t.setVisible(true);
			    }
			}
		});
		b3.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				if(c==1) {
					gui t = new gui();
					t.setsort(new sort_by_bubble());
					t.reset();
			    	t.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent we) {
			                t.setVisible(false);
			             }
			    	});
			    	t.setLocationRelativeTo(null);
			    	t.setVisible(true);
			    }
			    if(c==2) {
			    	gui t = new gui();
			    	t.reset();
			    	t.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent we) {
			                t.setVisible(false);
			             }
			    	});
			    	t.setLocationRelativeTo(null);
			    	t.setVisible(true);
			    }
			}
		});
	    /*if(c==1) {
	    	b1.setBackground(Color.DARK_GRAY);
	    }
	    if(c==2) {
	    	b1.setBackground(Color.LIGHT_GRAY);
	    }*/
		add(b1); 
		add(b2);
		add(b3);
		}
	
	public void paint(Graphics g) { 
			super.paint(g); 
	} 
}