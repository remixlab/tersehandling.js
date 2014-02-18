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


import org.timepedia.exporter.client.*;

import com.google.gwt.core.client.JavaScriptObject;

import processing.core.PApplet;


import remixlab.tersehandling.core.AbstractGrabber;
import remixlab.tersehandling.core.Agent;
import remixlab.tersehandling.core.TerseHandler;
import remixlab.tersehandling.event.DOF2Event;
import remixlab.tersehandling.event.TerseEvent;
import remixlab.tersehandling.js.JsEventHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class ExporterFacade.
 */
public class ExporterFacade {
	
	/**
	 * The Class MouseAgentFacade.
	 */
	@ExportPackage("")	
	@Export ("MouseAgent")
	@ExportClosure ()
	public static abstract class MouseAgentFacade implements ExportOverlay<MouseAgent> {

		/**
		 * Constructor.
		 *
		 * @param scn the scn
		 * @param n the n
		 * @return the mouse agent
		 */
		@ExportConstructor
		public static MouseAgent constructor(TerseHandler scn, String n)
		{
			return new MouseAgent( scn, n);					
		}

	}	
	
		
	
	

	
	
	
	/**
	 * The Class TerseHandlerFacade.
	 */
	@ExportPackage("")	
	@Export ("TerseHandler")
	@ExportClosure ()
	public static abstract class TerseHandlerFacade implements ExportOverlay<TerseHandler> {
		
		/**
		 * Handle.
		 */
		public abstract void handle();

	}		

	/**
	 * The Class GrabbableCircleFacade.
	 */
	@ExportPackage("")	
	@Export ("GrabbableCircle")
	public static abstract class GrabbableCircleFacade implements ExportOverlay<GrabbableCircle> {

		/**
		 * Constructor.
		 *
		 * @param agent the agent
		 * @param ctx the ctx
		 * @return the grabbable circle
		 */
		@ExportConstructor
		public static GrabbableCircle constructor(Agent agent, JavaScriptObject ctx)
		{
			return new GrabbableCircle( agent,  ctx);					
		}
		
		/**
		 * Grabs agent.
		 *
		 * @param agent the agent
		 * @return true, if successful
		 */
		public abstract boolean grabsAgent(Agent agent);
		
		/**
		 * Draw.
		 */
		public abstract void draw();
		
		/**
		 * Draw.
		 *
		 * @param c the c
		 */
		public abstract void draw(int c) ;

	}		
	
	/**
	 * The Class JsEventHandlerFacade.
	 */
	@ExportPackage("")	
	@Export ("JsEventHandler")
	public static abstract class JsEventHandlerFacade implements ExportOverlay<JsEventHandler> {
		
		/**
		 * Constructor.
		 *
		 * @param canvas the canvas
		 * @param m the m
		 * @param methodName the method name
		 * @return the js event handler
		 */
		@ExportConstructor
		public static JsEventHandler constructor(JavaScriptObject canvas, Object m, String methodName)
		{
			return new JsEventHandler(  canvas,  m , methodName) ;					
		}

	}		
	
	

}
