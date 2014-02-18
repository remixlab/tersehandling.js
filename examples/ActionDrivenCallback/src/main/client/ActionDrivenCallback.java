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

import processing.core.PApplet;
import remixlab.tersehandling.core.EventConstants;
import remixlab.tersehandling.core.TerseHandler;
import remixlab.tersehandling.generic.event.GenericClickEvent;
import remixlab.tersehandling.generic.event.GenericDOF2Event;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionDrivenCallback.
 */
public class ActionDrivenCallback {
	
	
	/** The p. */
	private PApplet p;
    
    /** The w. */
    int w = 600;
    
    /** The h. */
    int h = 600;
    
    /** The agent. */
    MouseAgent agent;
    
    /** The terse handler. */
    TerseHandler terseHandler;
    
    /** The circles. */
    GrabbableCircle[] circles;
   
    /** The prev event. */
    GenericDOF2Event<MotionAction> event, prevEvent;
    
    
    /**
     * Instantiates a new action driven callback.
     */
    public ActionDrivenCallback(){}
    
    /**
     * Instantiates a new action driven callback.
     *
     * @param p the p
     */
    public ActionDrivenCallback(PApplet p){
    	this.p = p;
    }
    
    /**
     * Setup.
     */
    public void setup() {
            p.size(w, h);
            terseHandler = new TerseHandler();
            agent = new MouseAgent(terseHandler, "my_mouse");
            //1st choice above
            //registerMethod("mouseEvent", agent);
            circles = new GrabbableCircle[50];
            for (int i = 0; i < circles.length; i++)
                    circles[i] = new GrabbableCircle(agent, p);
    }

    /**
     * Draw.
     */
    public void draw() {
    	p.background(255);
            for (int i = 0; i < circles.length; i++) {
                    if (circles[i].grabsAgent(agent))
                            circles[i].draw(p.color(255, 0, 0));
                    else
                            circles[i].draw();
            }
            terseHandler.handle();
    }
   
    //3rd choice from here

    /**
     * Mouse moved.
     */
    public void mouseMoved() {
            event = new GenericDOF2Event<MotionAction>(prevEvent, p.mouseX(), p.mouseY(), EventConstants.TH_NOMODIFIER_MASK, EventConstants.TH_NOBUTTON);
            agent.updateGrabber(event);
            prevEvent = event.get();        
    }
   

    /**
     * Mouse dragged.
     */
    public void mouseDragged() {
            event = new GenericDOF2Event<MotionAction>(prevEvent, p.mouseX(), p.mouseY(), EventConstants.TH_NOMODIFIER_MASK, EventConstants.TH_LEFT);
            agent.handle(event);
            prevEvent = event.get();        
    }
   

    /**
     * Mouse clicked.
     */
    public void mouseClicked() {
            agent.handle(new GenericClickEvent<ClickAction>(p.mouseX(), p.mouseY(), EventConstants.TH_NOMODIFIER_MASK, EventConstants.TH_RIGHT, 1));        
    }	
	
}
