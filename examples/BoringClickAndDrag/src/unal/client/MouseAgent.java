/**
 * 
 */
package unal.client;

import com.gwtent.reflection.client.Reflectable;

import remixlab.tersehandling.core.Agent;
import remixlab.tersehandling.core.TerseHandler;
import remixlab.tersehandling.event.DOF2Event;
import remixlab.tersehandling.js.JsMouseEvent;

/**
 * @author cesar
 *
 */
@Reflectable
public class MouseAgent extends Agent {
	  DOF2Event event;
	  
	  public MouseAgent() {};
	  
	  public MouseAgent(TerseHandler scn, String n) {
	    super(scn, n);
	  }

	  public void mouseEvent(JsMouseEvent e) {
	    event = new DOF2Event(e.getX(), e.getY());
	    
	    //log( e.getAction() +" X "+ Integer.toString( e.getX())+ " Y "+Integer.toString( e.getY() ));
	    
	    if ( e.getAction() == JsMouseEvent.MOVE )
	      updateGrabber(event);
	    if ( e.getAction() == JsMouseEvent.DRAG )
	      handle(event);
	  }
	  
	  
	 
	  
	  

	  
	}