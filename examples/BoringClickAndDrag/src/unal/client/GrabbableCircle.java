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

import com.google.gwt.core.client.JavaScriptObject;

import processing.core.PApplet;
import processing.core.PVector;
import remixlab.tersehandling.core.AbstractGrabber;
import remixlab.tersehandling.core.Agent;
import remixlab.tersehandling.event.DOF2Event;
import remixlab.tersehandling.event.TerseEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class GrabbableCircle.
 *
 * @author cesar
 */
public class GrabbableCircle extends AbstractGrabber {
	
	
	/** The w. */
	int w = 800;
	
	/** The h. */
	int h = 500;
	
	  /** The radius. */
  	public float radius;
	  
  	/** The center. */
  	public PVector center;
	  
  	/** The colour. */
  	public int colour;
	  
	  
	  /**
  	 * Instantiates a new grabbable circle.
  	 */
  	public GrabbableCircle() {}
	  
	  /** The p. */
  	private PApplet p;
	  
	  
	  /**
  	 * Instantiates a new grabbable circle.
  	 *
  	 * @param agent the agent
  	 * @param ctx the ctx
  	 */
  	public GrabbableCircle(Agent agent, JavaScriptObject ctx) {
		  	
		  	this.p = new PApplet(ctx);
		    agent.addInPool(this);
		    setColor();
		    setPositionAndRadius();
	 }
	  
	  /**
  	 * Instantiates a new grabbable circle.
  	 *
  	 * @param agent the agent
  	 */
  	public GrabbableCircle(Agent agent) {
		  
	    agent.addInPool(this);
	    setColor();
	    setPositionAndRadius();
	  }

	  /**
  	 * Instantiates a new grabbable circle.
  	 *
  	 * @param agent the agent
  	 * @param c the c
  	 * @param r the r
  	 */
  	public GrabbableCircle(Agent agent, PVector c, float r) {
	    agent.addInPool(this);
	    radius = r;
	    center = c;    
	    setColor();
	  }

	  /**
  	 * Sets the color.
  	 */
  	public void setColor() {
	    setColor(p.color(p.random(0, 255), p.random(0, 255), p.random(0, 255)));
	  }

	  /**
  	 * Sets the color.
  	 *
  	 * @param myC the new color
  	 */
  	public void setColor(int myC) {
	    colour = myC;
	  }

	  /**
  	 * Sets the position and radius.
  	 *
  	 * @param p the p
  	 * @param r the r
  	 */
  	public void setPositionAndRadius(PVector p, float r) {
	    center = p;
	    radius = r;
	  }

	  /**
  	 * Sets the position and radius.
  	 */
  	public void setPositionAndRadius() {
	    float maxRadius = 50;
	    float low = maxRadius;
	    float highX = w - maxRadius;
	    float highY = h - maxRadius;
	    setPositionAndRadius(new PVector(p.random(low, highX), p.random(low, highY)), p.random(20, maxRadius));
	  }

	  /**
  	 * Draw.
  	 */
  	public void draw() {
	    draw(colour);
	  }

	  /**
  	 * Draw.
  	 *
  	 * @param c the c
  	 */
  	public void draw(int c) {
		  p.pushStyle();
		  p.fill(c);
		  p.ellipse(center.x, center.y, 2*radius, 2*radius);
		  p.popStyle();
	  }

	  /* (non-Javadoc)
  	 * @see remixlab.tersehandling.core.Grabbable#checkIfGrabsInput(remixlab.tersehandling.event.TerseEvent)
  	 */
  	@Override
	  public boolean checkIfGrabsInput(TerseEvent event) {
	    if (event instanceof DOF2Event) {
	      float x = ((DOF2Event)event).x();
	      float y = ((DOF2Event)event).y();
	      
	     
	      return(PApplet.pow((x - center.x), 2) + PApplet.pow((y - center.y), 2) <= PApplet.pow(radius, 2));
	    }      
	    return false;
	  }

	  /* (non-Javadoc)
  	 * @see remixlab.tersehandling.core.Grabbable#performInteraction(remixlab.tersehandling.event.TerseEvent)
  	 */
  	@Override
	  public void performInteraction(TerseEvent event) {
	    setColor();
	    setPositionAndRadius();
	  }
	  

  	  
	  
	}