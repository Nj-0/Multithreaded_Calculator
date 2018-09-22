import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.text.Highlighter.Highlight;

public class Calculator {

	public static JFrame frame;
	public static JLabel lblNewLabel = new JLabel("");
	
	//public static JButton btn1,btn2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 700, 400);
		System.out.println("pressed");
		
		frame.setFocusable(true);
	 
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(35, 130, 55, 50);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setBounds(90, 130, 55, 50);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(146, 130, 55, 50);
		frame.getContentPane().add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(35, 180, 55, 50);
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(90, 180, 55, 50);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setBounds(146, 180, 55, 50);
		frame.getContentPane().add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(35, 231, 55, 50);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(90, 231, 55, 50);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(146, 231, 55, 50);
		frame.getContentPane().add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(90, 281, 55, 50);
		frame.getContentPane().add(btn0);
		
		JButton btnplus = new JButton("+");
		btnplus.setBounds(252, 131, 55, 50);
		frame.getContentPane().add(btnplus);
		
		JButton btnminus = new JButton("-");
		btnminus.setBounds(308, 130, 55, 50);
		frame.getContentPane().add(btnminus);
		
		JButton btnmul = new JButton("*");
		btnmul.setBounds(252, 180, 55, 50);
		frame.getContentPane().add(btnmul);
		
		JButton btndiv = new JButton("/");
		btndiv.setBounds(308, 180, 55, 50);
		frame.getContentPane().add(btndiv);
		
		JButton btnenter = new JButton("=");
		btnenter.setBounds(252, 231, 55, 50);
		frame.getContentPane().add(btnenter);
		
		JButton btnclr = new JButton("C");
		btnclr.setBounds(308, 231, 55, 50);
		frame.getContentPane().add(btnclr);
		
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 22));
		lblNewLabel.setBounds(35, 25, 328, 73);
		frame.getContentPane().add(lblNewLabel);
		for (Component x : frame.getContentPane().getComponents()){
			x.setEnabled(false);
			x.setFocusable(false);
		}
		lblNewLabel.setEnabled(true);
		Highlighter h = new Highlighter();
		Operator o=new Operator();
        h.start();
        o.start();
        frame.addKeyListener(new KeyListener(){
            @Override
               public void keyPressed(KeyEvent e) {
                   if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    	   computer.tocompute= computer.tocompute.concat(Integer.toString(Highlighter.currentbtn));
                    	   lblNewLabel.setText(computer.tocompute);
                    	   Operator.switcher=1;
                    	   
                       }
                       else if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    	   if (Operator.switcher==1)
                    	   switch(Operator.currentop){
                    	   case 1:
                    		   computer.tocompute= computer.tocompute.concat("+");
                    		   lblNewLabel.setText(computer.tocompute);
                    		   break;
                    	   case 2:
                    		   computer.tocompute= computer.tocompute.concat("-");
                    		   lblNewLabel.setText(computer.tocompute);
                    		   break;
                    	   case 3:
                    		   computer.tocompute= computer.tocompute.concat("*");
                    		   lblNewLabel.setText(computer.tocompute);
                    		   break;
                    	   case 4:
                    		   computer.tocompute= computer.tocompute.concat("/");
                    		   lblNewLabel.setText(computer.tocompute);
                    		   break;
                    	   case 6:
                    		   computer.tocompute= "";
                    		   lblNewLabel.setText(computer.tocompute);
                    		   break;
                    	   case 5:
                    		   computer comp= new computer();
                    		   comp.start();
                    		   break;
                    	   }
                    	   Operator.switcher=0;
                       }
                   
                       
                   
               }

               @Override
               public void keyTyped(KeyEvent e) {
                  //To change body of generated methods, choose Tools | Templates.
               }

               @Override
               public void keyReleased(KeyEvent e) {
               }
       });
	}
}
