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
import processing.core.PVector;
import remixlab.tersehandling.core.AbstractGrabber;
import remixlab.tersehandling.core.Agent;
import remixlab.tersehandling.event.TerseEvent;
import remixlab.tersehandling.generic.event.GenericDOF2Event;
import remixlab.tersehandling.generic.profile.Duoable;

// TODO: Auto-generated Javadoc
/**
 * The Class GrabbableCircle.
 */
public class GrabbableCircle extends AbstractGrabber {
    
    /** The w. */
    int w = 600;
    
    /** The h. */
    int h = 600;
	
	/** The p. */
	private PApplet p;
	
	/**
	 * Instantiates a new grabbable circle.
	 */
	public GrabbableCircle() {}
	
    /** The radius y. */
    public float radiusX, radiusY;
    
    /** The center. */
    public PVector center;
    
    /** The colour. */
    public int colour;
    
    /** The contour colour. */
    public int contourColour;
    
    /** The s weight. */
    public int sWeight;

    /**
     * Instantiates a new grabbable circle.
     *
     * @param agent the agent
     * @param p the p
     */
    public GrabbableCircle(Agent agent, PApplet p ) {
    	
    		this.p = p;
            agent.addInPool(this);
            setColor();
            setPosition();
            sWeight = 4;
            contourColour = p.color(0, 0, 0);
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
            radiusX = r;
            radiusY = r;
            center = c;
            setColor();
            sWeight = 4;
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
     * Sets the position.
     *
     * @param x the x
     * @param y the y
     */
    public void setPosition(float x, float y) {
            setPositionAndRadii(new PVector(x, y), radiusX, radiusY);
    }

    /**
     * Sets the position and radii.
     *
     * @param p the p
     * @param rx the rx
     * @param ry the ry
     */
    public void setPositionAndRadii(PVector p, float rx, float ry) {
            center = p;
            radiusX = rx;
            radiusY = ry;
    }

    /**
     * Sets the position.
     */
    public void setPosition() {
            float maxRadius = 50;
            float low = maxRadius;
            float highX = w - maxRadius;
            float highY = h - maxRadius;
            float r = p.random(20, maxRadius);
            setPositionAndRadii(
                            new PVector(p.random(low, highX), p.random(low, highY)), r, r);
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
    	p.stroke(contourColour);
    	p.strokeWeight(sWeight);
    	p.fill(c);
    	p.ellipse(center.x, center.y, 2 * radiusX, 2 * radiusY);
            p.popStyle();
    }

    /* (non-Javadoc)
     * @see remixlab.tersehandling.core.Grabbable#checkIfGrabsInput(remixlab.tersehandling.event.TerseEvent)
     */
    @Override
    public boolean checkIfGrabsInput(TerseEvent event) {
            if (event instanceof GenericDOF2Event) {
                    float x = ((GenericDOF2Event<?>) event).x();
                    float y = ((GenericDOF2Event<?>) event).y();
                    return (PApplet.pow((x - center.x), 2) / PApplet.pow(radiusX, 2)
                                    + PApplet.pow((y - center.y), 2) / PApplet.pow(radiusY, 2) <= 1);
            }
            return false;
    }

    /* (non-Javadoc)
     * @see remixlab.tersehandling.core.Grabbable#performInteraction(remixlab.tersehandling.event.TerseEvent)
     */
    @Override
    public void performInteraction(TerseEvent event) {
    	
    	
    	
            if (event instanceof Duoable) {
            	

                    switch ((GlobalAction) ((Duoable<?>) event).action()
                                    .referenceAction()) {
                    case CHANGE_COLOR:
                            contourColour = p.color(p.random(100, 255), p.random(100, 255),
                            		p.random(100, 255));
                            break;
                    case CHANGE_STROKE_WEIGHT:
                    	
                    	
                    	
                            if (event.isShiftDown()) {
                                    if (sWeight > 1)
                                            sWeight--;
                            } else
                                    sWeight++;
                            break;
                    case CHANGE_POSITION:
                            setPosition(((GenericDOF2Event<?>) event).x(),
                                            ((GenericDOF2Event<?>) event).y());
                            break;
                    case CHANGE_SHAPE:
                            radiusX += ((GenericDOF2Event<?>) event).dx();
                            radiusY += ((GenericDOF2Event<?>) event).dy();
                            break;
                    }
            }
    }

	
	/**
	 * Console.
	 *
	 * @param msg the msg
	 */
	public native void console( Object  msg ) /*-{
	
	console.log(msg);
	
	}-*/;	
    
    
}