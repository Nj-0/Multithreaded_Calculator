import java.awt.Color;

import javax.swing.SwingUtilities;

public class Highlighter extends Thread{
	public static volatile int button,currentbtn;

	public Highlighter(){
		button=1;
	}

	public void run (){		//function to highlight numbers
		while(true){
			
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run(){
						System.out.println(button);
						switch(button){
						case 1:
							Calculator.frame.getContentPane().getComponent(0).setEnabled(true);
							Calculator.frame.getContentPane().getComponent(9).setEnabled(false);
							button=2;
							currentbtn=1;
							break;
						default:
							Calculator.frame.getContentPane().getComponent(button-1).setEnabled(true);
							Calculator.frame.getContentPane().getComponent(button-2).setEnabled(false);
							currentbtn=button;
							button++;
							
							break;
						case 9:
							Calculator.frame.getContentPane().getComponent(8).setEnabled(true);
							Calculator.frame.getContentPane().getComponent(7).setEnabled(false);
							button=0;
							currentbtn=9;
							break;
						case 0:
							Calculator.frame.getContentPane().getComponent(9).setEnabled(true);
							Calculator.frame.getContentPane().getComponent(8).setEnabled(false);
							button=1;
							currentbtn=0;
							break;

						}
					}
				 	});
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException  interruptedException)
			{
				/*Interrupted exception will be thrown when a sleeping or  waiting
				 * thread is interrupted.
				 */
				System.out.println(  "First Thread is interrupted when it is  sleeping" +interruptedException);
			}		}
	}

	
}
