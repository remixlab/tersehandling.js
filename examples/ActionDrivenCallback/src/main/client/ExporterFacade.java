/*******************************************************************************
 * TerseHandling (version 1.0.0)
 * Copyright (c) 2014 National University of Colombia, https://github.com/remixlab
 * @author Jean Pierre Charalambos, http://otrolado.info/
 *     
 * All rights reserved. Library that eases the creation of interactive
 * scenes, released under the terms of the GNU Public License v3.0
 * which is available at http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package main.client;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.ExportConstructor;
import org.timepedia.exporter.client.ExportOverlay;
import org.timepedia.exporter.client.ExportPackage;

import com.google.gwt.core.client.JavaScriptObject;

import processing.core.PApplet;

// TODO: Auto-generated Javadoc
/**
 * The Class ExporterFacade.
 */
public class ExporterFacade {

	
	/**
	 * The Class ActionDrivenCallbackFacade.
	 */
	@ExportPackage("")	
	@Export ("ActionDrivenCallback")

	public static abstract class ActionDrivenCallbackFacade implements ExportOverlay<ActionDrivenCallback> {

		/**
		 * Constructor.
		 *
		 * @param ctx the processing js context
		 * @return the action driven callback
		 */
		@ExportConstructor
		public static ActionDrivenCallback constructor(JavaScriptObject ctx)
		{
			return new 	ActionDrivenCallback( new PApplet (ctx));			
		}
		
		/**
		 * Setup.
		 */
		public abstract void setup();
		
		/**
		 * Draw.
		 */
		public abstract void draw();
		
		/**
		 * Mouse moved.
		 */
		public abstract void mouseMoved();
		
		/**
		 * Mouse dragged.
		 */
		public abstract void mouseDragged();
		
		/**
		 * Mouse clicked.
		 */
		public abstract void mouseClicked();
		

	}		
	
}
