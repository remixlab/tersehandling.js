/*******************************************************************************
 * TerseHandling (version 1.0.0)
 * Copyright (c) 2014 National University of Colombia, https://github.com/remixlab
 * @author Jean Pierre Charalambos, http://otrolado.info/
 *     
 * All rights reserved. Library that eases the creation of interactive
 * scenes, released under the terms of the GNU Public License v3.0
 * which is available at http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package unal.client;

import com.gwtent.reflection.client.Reflectable;

import remixlab.tersehandling.core.Agent;
import remixlab.tersehandling.core.TerseHandler;
import remixlab.tersehandling.event.DOF2Event;
import remixlab.tersehandling.js.JsMouseEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class MouseAgent.
 *
 * @author cesar
 */
@Reflectable
public class MouseAgent extends Agent {
	  
  	/** The event. */
  	DOF2Event event;
	  
	  /**
  	 * Instantiates a new mouse agent.
  	 */
  	public MouseAgent() {};
	  
	  /**
  	 * Instantiates a new mouse agent.
  	 *
  	 * @param scn the scn
  	 * @param n the n
  	 */
  	public MouseAgent(TerseHandler scn, String n) {
	    super(scn, n);
	  }

	  /**
  	 * Mouse event.
  	 *
  	 * @param e the e
  	 */
  	public void mouseEvent(JsMouseEvent e) {
	    event = new DOF2Event(e.getX(), e.getY());
	    
	    //log( e.getAction() +" X "+ Integer.toString( e.getX())+ " Y "+Integer.toString( e.getY() ));
	    
	    if ( e.getAction() == JsMouseEvent.MOVE )
	      updateGrabber(event);
	    if ( e.getAction() == JsMouseEvent.DRAG )
	      handle(event);
	  }
	  
	  
	 
	  
	  

	  
	}