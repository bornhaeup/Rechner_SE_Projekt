import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
	Container c;
	TextField tfFa, tfFb;
	private Label lbOperation, lbGleich, lbErg;
	JButton btnPlus, btnMinus, btnMul, btnDiv, btnClear;
	private Character uebergabe= '+';
	public GUI (){
		class OperatorListener implements ActionListener {
			Character uebergabe;
			public OperatorListener(Character uebergabe){
				this.uebergabe=uebergabe;
			}
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//test
				System.out.println("test");
				if (e.getSource().equals(btnPlus)){
					lbErg.setText(""+(Double.parseDouble(tfFa.getText())+Double.parseDouble(tfFb.getText())));
					lbOperation.setText("");
				}
				else if (e.getSource().equals(btnMinus)){
					lbErg.setText(""+(Double.parseDouble(tfFa.getText())-Double.parseDouble(tfFb.getText())));		
				}
				else if (e.getSource().equals(btnMul)){
					lbErg.setText(""+(Double.parseDouble(tfFa.getText())*Double.parseDouble(tfFb.getText())));	
				}
				else if (e.getSource().equals(btnDiv)){
					lbErg.setText(""+(Double.parseDouble(tfFa.getText())/Double.parseDouble(tfFb.getText())));		
				}
				else if (e.getSource().equals(btnClear)){
					tfFa.setText("");tfFb.setText("");lbOperation.setText("+");lbErg.setText("");	
				}
				//lbErg.setText(""+btnPlus.getMnemonic());
				
			}			
		}
		OperatorListener oList = new OperatorListener (uebergabe);
		c = getContentPane();
		c.setLayout(new GridLayout(2,5));
		tfFa = new TextField ("987.654");
		c.add(tfFa);
		lbOperation = new Label("+");
		c.add(lbOperation);
		tfFb = new TextField ("124");
		c.add(tfFb);
		lbGleich = new Label ("=");
		c.add(lbGleich);
		lbErg = new Label ("Erg");
		c.add(lbErg);
		btnPlus = new JButton ("Addiere");
		btnMinus = new JButton ("Subtrahiere");
		btnMul = new JButton ("Multipliziere");
		btnDiv = new JButton ("Dividiere");
		btnClear = new JButton ("Loesche alles");
		c.add(btnPlus);
		c.add(btnMinus);
		c.add(btnMul);
		c.add(btnDiv);
		c.add(btnClear);
		btnPlus.setMnemonic('+');
		btnMinus.setMnemonic('-');
		btnMul.setMnemonic('*');
		btnDiv.setMnemonic('/');
		btnClear.setMnemonic('1');
		btnPlus.addActionListener(oList);
		btnMinus.addActionListener(oList);
		btnMul.addActionListener(oList);
		btnDiv.addActionListener(oList);
		btnClear.addActionListener(oList);
		
	}
	public static void main (String [] args){
		GUI gui = new GUI();
		gui.setSize(400,150);
		gui.setTitle("Rechner");
		gui.setVisible (true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
