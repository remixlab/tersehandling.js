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

public class ExporterFacade {
	
	@ExportPackage("")	
	@Export ("MouseAgent")
	@ExportClosure ()
	public static abstract class MouseAgentFacade implements ExportOverlay<MouseAgent> {

		@ExportConstructor
		public static MouseAgent constructor(TerseHandler scn, String n)
		{
			return new MouseAgent( scn, n);					
		}

	}	
	
		
	
	

	
	
	
	@ExportPackage("")	
	@Export ("TerseHandler")
	@ExportClosure ()
	public static abstract class TerseHandlerFacade implements ExportOverlay<TerseHandler> {
		
		public abstract void handle();

	}		

	@ExportPackage("")	
	@Export ("GrabbableCircle")
	public static abstract class GrabbableCircleFacade implements ExportOverlay<GrabbableCircle> {

		@ExportConstructor
		public static GrabbableCircle constructor(Agent agent, JavaScriptObject ctx)
		{
			return new GrabbableCircle( agent,  ctx);					
		}
		
		public abstract boolean grabsAgent(Agent agent);
		public abstract void draw();
		public abstract void draw(int c) ;

	}		
	
	@ExportPackage("")	
	@Export ("JsEventHandler")
	public static abstract class JsEventHandlerFacade implements ExportOverlay<JsEventHandler> {
		
		@ExportConstructor
		public static JsEventHandler constructor(JavaScriptObject canvas, Object m, String methodName)
		{
			return new JsEventHandler(  canvas,  m , methodName) ;					
		}

	}		
	
	

}
