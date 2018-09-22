import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;
public class computer extends Thread {
	public static String tocompute="";
	
	public void run(){
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    try {
	    	Calculator.lblNewLabel.setText(Double.toString( (double)engine.eval(tocompute)));
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    tocompute="";
	}

}
