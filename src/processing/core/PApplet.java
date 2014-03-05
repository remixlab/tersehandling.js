/**
 * 
 */
package processing.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author cesar
 *
 */
public class PApplet extends ProcessingJS {
	
	
	
	
	
	public  PApplet (){}
	public  PApplet (JavaScriptObject ctx)
	{
		super(ctx);
		g = new PGraphics3D(ctx);
	}
	




	public PGraphics g;





//	public void registerMethod(String string, Object scene) {
//		// TODO Auto-generated method stub
//		
//	}






	

	
	
						
						
}
