/*******************************************************************************
 * TerseHandling (version 1.0.0)
 * Copyright (c) 2014 National University of Colombia, https://github.com/remixlab
 * @author Cesar Colorado, https://sites.google.com/site/cacolorador/
 *     
 * All rights reserved. Library that eases the creation of interactive
 * scenes, released under the terms of the GNU Public License v3.0
 * which is available at http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package remixlab.tersehandling.js;



import com.google.gwt.core.client.JavaScriptObject;
import com.gwtent.reflection.client.ClassType;
import com.gwtent.reflection.client.TypeOracle;


/**
 * The Class JsEventHandler.
 */
public class JsEventHandler {
	
	

	
	/** The is mouse pressed. */
	private static boolean isMousePressed = false;	
	
	
	/**
	 * Empty constructor required for GWT Exporter
	 */
	public JsEventHandler()
	{}
	
	
	/**
	 * Instantiates a new js event handler.
	 *
	 * @param canvas the canvas
	 * @param m the anonymous agent to call the event with reflection
	 * @param methodName the method name to call the event with reflection
	 */
	public JsEventHandler(JavaScriptObject canvas, Object m, String methodName)
	{	
		addMouseAgent( canvas,m,  methodName);
	}		
	
	
	/**
	 * Adds the event to the  mouse agent.
	 *
	 * @param canvas the canvas
	 * @param m the anonymous agent to call the event with reflection
	 * @param methodName the method name to call the event with reflection
	 */
	public native void addMouseAgent(JavaScriptObject canvas, Object m, String methodName)/*-{
		
		
		var eventHandler = function(event) {
						
			var type = event.type;
			

			//set if mouse is pressed 
			if (type === "mousedown"  )										
				@remixlab.tersehandling.js.JsEventHandler::isMousePressed = true;
								  																								
			else if (type === "mouseup" )			
				@remixlab.tersehandling.js.JsEventHandler::isMousePressed = false;
						
			var isMousePressed  = @remixlab.tersehandling.js.JsEventHandler::isMousePressed;

			// new JsMouseEvent with the native event
			var JsMouseEvent = 
			@remixlab.tersehandling.js.JsMouseEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Z)
			(event,canvas, isMousePressed);			
			
			
			//pass to the agent the JsMouseEvent to run
			@remixlab.tersehandling.js.JsEventHandler::ExecuteEvent(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)
			(m,methodName, JsMouseEvent);
			
	
			

																    
		}
		
		
		//listeners
		canvas.addEventListener('mousemove',eventHandler,false);		
		canvas.addEventListener('click',eventHandler,false);	
		canvas.addEventListener('ondblclick',eventHandler,false);				
		canvas.addEventListener('mousedown',eventHandler,false);				
		canvas.addEventListener('mouseup',eventHandler,false);				
		canvas.addEventListener('mouseout',eventHandler,false);	
	
	}-*/;	
	
	/**
	 * calls the method by reflection.
	 *
	 * @param agt the anonymous agent to call the event with reflection
	 * @param methodName the method name
	 * @param param the JsMouseEvent
	 */
	public static  void ExecuteEvent(Object agt, String methodName , Object param)
	{
				
		    ClassType<? extends Object> classType = TypeOracle.Instance.getClassType(agt.getClass());		    
		    classType.invoke(agt,methodName, param);		    			
	}
	
	

}
