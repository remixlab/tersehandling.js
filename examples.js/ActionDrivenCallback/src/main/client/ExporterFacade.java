package main.client;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportConstructor;
import org.timepedia.exporter.client.ExportOverlay;
import org.timepedia.exporter.client.ExportPackage;

import com.google.gwt.core.client.JavaScriptObject;

import processing.core.PApplet;

public class ExporterFacade {

	
	@ExportPackage("")	
	@Export ("ActionDrivenCallback")

	public static abstract class ActionDrivenCallbackFacade implements ExportOverlay<ActionDrivenCallback> {

		@ExportConstructor
		public static ActionDrivenCallback constructor(JavaScriptObject ctx)
		{
			return new 	ActionDrivenCallback( new PApplet (ctx));			
		}
		
		public abstract void setup();
		public abstract void draw();
		public abstract void mouseMoved();
		public abstract void mouseDragged();
		public abstract void mouseClicked();
		

	}		
	
}
