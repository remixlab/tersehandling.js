/**
 * 
 */
package unal.client;

import com.google.gwt.core.client.JavaScriptObject;

import processing.core.PApplet;
import remixlab.tersehandling.core.AbstractGrabber;
import remixlab.tersehandling.core.Agent;
import remixlab.tersehandling.core.DLVector;
import remixlab.tersehandling.event.DOF2Event;
import remixlab.tersehandling.event.TerseEvent;

/**
 * @author cesar
 *
 */
public class GrabbableCircle extends AbstractGrabber {
	
	
	int w = 800;
	int h = 500;
	
	  public float radius;
	  public DLVector center;
	  public int colour;
	  
	  
	  public GrabbableCircle() {}
	  
	  private PApplet p;
	  
	  
	  public GrabbableCircle(Agent agent, JavaScriptObject ctx) {
		  	
		  	this.p = new PApplet(ctx);
		    agent.addInPool(this);
		    setColor();
		    setPositionAndRadius();
	 }
	  
	  public GrabbableCircle(Agent agent) {
		  
	    agent.addInPool(this);
	    setColor();
	    setPositionAndRadius();
	  }

	  public GrabbableCircle(Agent agent, DLVector c, float r) {
	    agent.addInPool(this);
	    radius = r;
	    center = c;    
	    setColor();
	  }

	  public void setColor() {
	    setColor(p.color(p.random(0, 255), p.random(0, 255), p.random(0, 255)));
	  }

	  public void setColor(int myC) {
	    colour = myC;
	  }

	  public void setPositionAndRadius(DLVector p, float r) {
	    center = p;
	    radius = r;
	  }

	  public void setPositionAndRadius() {
	    float maxRadius = 50;
	    float low = maxRadius;
	    float highX = w - maxRadius;
	    float highY = h - maxRadius;
	    setPositionAndRadius(new DLVector(p.random(low, highX), p.random(low, highY)), p.random(20, maxRadius));
	  }

	  public void draw() {
	    draw(colour);
	  }

	  public void draw(int c) {
		  p.pushStyle();
		  p.fill(c);
		  p.ellipse(center.x(), center.y(), 2*radius, 2*radius);
		  p.popStyle();
	  }

	  @Override
	  public boolean checkIfGrabsInput(TerseEvent event) {
	    if (event instanceof DOF2Event) {
	      float x = ((DOF2Event)event).getX();
	      float y = ((DOF2Event)event).getY();
	      
	     
	      return(PApplet.pow((x - center.x()), 2) + PApplet.pow((y - center.y()), 2) <= PApplet.pow(radius, 2));
	    }      
	    return false;
	  }

	  @Override
	  public void performInteraction(TerseEvent event) {
	    setColor();
	    setPositionAndRadius();
	  }
	  

  	  
	  
	}