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

import remixlab.tersehandling.core.EventConstants;
import remixlab.util.Copyable;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * The Class JsEvent.
 * Encapsulates a native javascript event, 
 * is the javascript version of the class 
 * remixlab.tersehandling.event.TerseEvent
 */
public abstract class JsEvent implements EventConstants, Copyable {
	
	/** The canvas. */
	protected  JavaScriptObject canvas;
	
	/** The event. */
	protected JavaScriptObject event;

	/** The action. */
	private int action;

	/** The modifiers. */
	protected int modifiers;

	/**
	 * Instantiates a new js event.
	 *
	 * @param event the event
	 */
	public JsEvent(JavaScriptObject event) {
		this.event = event;

	}

	/**
	 * Process action.
	 */
	protected abstract void processAction();

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public int getAction() {

		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action the new action
	 */
	protected void setAction(int action) {
		this.action = action;

	}

	/**
	 * Gets the modifiers.
	 *
	 * @return the modifiers
	 */
	public int getModifiers() {
		return modifiers;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public native String getType() 
	/*-{
		
		var event = this.@remixlab.tersehandling.js.JsEvent::event;

		return event.type;
									
	}-*/;

	/**
	 * Gets the button.
	 *
	 * @return the button
	 */
	public native short getButton()
	/*-{
									
		var retValue;
		
		var e = this.@remixlab.tersehandling.js.JsEvent::event;
		
		switch (e.which) {
		case 1:
		retValue = 37;
		break;
		case 2:
		retValue = 3;
		break;
		case 3:
		retValue = 39;
		break
		}
		
		return retValue;
	
	}-*/;

	/**
	 * Checks if is control down.
	 *
	 * @return true, if is control down
	 */
	public native boolean isControlDown()
	/*-{
											
	var event = this.@remixlab.tersehandling.js.JsEvent::event;
	return event.ctrlKey;
	
	}-*/;

	/**
	 * Checks if is shift down.
	 *
	 * @return true, if is shift down
	 */
	public native boolean isShiftDown() 
	/*-{
	
	var event = this.@remixlab.tersehandling.js.JsEvent::event;

	return event.shiftKey;
	
	}-*/;

	/**
	 * Checks if is alt down.
	 *
	 * @return true, if is alt down
	 */
	public native boolean isAltDown() /*-{
										
	var event = this.@remixlab.tersehandling.js.JsEvent::event;
	return event.altKey;
	
	}-*/;

	/**
	 * Checks if is meta down.
	 *
	 * @return true, if is meta down
	 */
	public native boolean isMetaDown() /*-{
										
	var event = this.@remixlab.tersehandling.js.JsEvent::event;
	return event.metaKey;
	
	}-*/;
}
