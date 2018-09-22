import java.awt.Color;

import javax.swing.SwingUtilities;

public class Operator extends Thread{
	public static volatile int operation,currentop,switcher;

	public Operator(){
		operation=1;
		switcher=0;
		
	}

	public void run (){
		while(true){	// function to highlight operators
			
			
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run(){
							System.out.println(operation);
							
							switch(operation){
							case 1:
								Calculator.frame.getContentPane().getComponent(10).setEnabled(true);
								Calculator.frame.getContentPane().getComponent(15).setEnabled(false);
								operation=2;
								currentop=1;
								break;
							case 6:
								Calculator.frame.getContentPane().getComponent(15).setEnabled(true);
								Calculator.frame.getContentPane().getComponent(14).setEnabled(false);
								operation=1;
								currentop=6;
								break;
							default:
								Calculator.frame.getContentPane().getComponent(operation+9).setEnabled(true);
								Calculator.frame.getContentPane().getComponent(operation+8).setEnabled(false);
								currentop=operation;
								operation++;
								

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
