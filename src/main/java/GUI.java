package main.java;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame{
	private static final long serialVersionUID = 2L;
	Container c;
	JTextField op1, op2;
	JLabel op, gleich, erg;
	JButton add, sub, mul, div, del;
	
	public GUI(){
		c = getContentPane();
		c.setLayout(new GridLayout(2,5,2,2));
		//tes
		//Komponenten erstellen und einrichten
		op1 = new JTextField(123);
		op2 = new JTextField(456);
		op = new JLabel();
		gleich = new JLabel("=");
		erg = new JLabel();
		erg.setOpaque(true); //sonst wird der Hintergrund nicht sichtbar
		erg.setBackground(Color.WHITE);
		add = new JButton("Addiere");
		sub = new JButton("Subtrahiere");
		mul = new JButton("Multipliziere");
		div = new JButton("Dividiere");
		del = new JButton("Loesche alles");
		
		//ActionListener hinzufügen
		OperatorListener olAdd = new OperatorListener('+');
		OperatorListener olSub = new OperatorListener('-');
		OperatorListener olMul = new OperatorListener('*');
		OperatorListener olDiv = new OperatorListener('/');
		OperatorListener olDel = new OperatorListener('l');
		add.addActionListener(olAdd);
		sub.addActionListener(olSub);
		mul.addActionListener(olMul);
		div.addActionListener(olDiv);
		del.addActionListener(olDel);
				
		//Text horizontal zentrieren -> public static final int CENTER = 0
		op.setHorizontalAlignment(0);
		gleich.setHorizontalAlignment(0);
		
		//Komponenten ins Grid-Layout einfügen
		c.add(op1);
		c.add(op);
		c.add(op2);
		c.add(gleich);
		c.add(erg);
		c.add(add);
		c.add(sub);
		c.add(mul);
		c.add(div);
		c.add(del);
	}
	
	public static void main(String[] args){
		//System.out.println("");
		GUI f = new GUI();
		f.setTitle("Rechner");
		f.setSize(600,150);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public double addition (double a, double b){		
		return a+b;
	}
	
	class OperatorListener implements ActionListener{
		char z;
		
		public OperatorListener(char z){
			this.z = z;
		}
		public void actionPerformed(ActionEvent arg0) {
			//System.out.println(arg0.getActionCommand());
			
			if(z == 'l'){
				op1.setText("");
				op.setText("");
				op2.setText("");
				erg.setText("");
			} else{
				try{
					double x = Double.parseDouble(op1.getText());
					double y = Double.parseDouble(op2.getText());
					op.setText(String.valueOf(z));
					//char operand = arg0.getActionCommand().charAt(0);
					//test
					switch(z){
					case '+':
						erg.setText(String.valueOf(x+y));
						break;
					case '-':
						erg.setText(String.valueOf(x-y));
						break;
					case '*':
						erg.setText(String.valueOf(x*y));
						break;
					case '/':
						if(y == 0.0){
							throw new RuntimeException("Error (div 0)");
						}
						erg.setText(String.valueOf(x/y));
						break;
					}
				}
				catch(NumberFormatException nfe){
					erg.setText("Error (nfe)");
				}
				catch(RuntimeException re){
					erg.setText(re.getMessage());
				}
			}
		}
	}
}
