package main.client;

import processing.core.PApplet;
import processing.core.PVector;
import remixlab.tersehandling.core.AbstractGrabber;
import remixlab.tersehandling.core.Agent;
import remixlab.tersehandling.event.TerseEvent;
import remixlab.tersehandling.generic.event.GenericDOF2Event;
import remixlab.tersehandling.generic.profile.Duoable;

public class GrabbableCircle extends AbstractGrabber {
    int w = 600;
    int h = 600;
	private PApplet p;
	public GrabbableCircle() {}
	
    public float radiusX, radiusY;
    public PVector center;
    public int colour;
    public int contourColour;
    public int sWeight;

    public GrabbableCircle(Agent agent, PApplet p ) {
    	
    		this.p = p;
            agent.addInPool(this);
            setColor();
            setPosition();
            sWeight = 4;
            contourColour = p.color(0, 0, 0);
    }

    public GrabbableCircle(Agent agent, PVector c, float r) {
            agent.addInPool(this);
            radiusX = r;
            radiusY = r;
            center = c;
            setColor();
            sWeight = 4;
    }

    public void setColor() {
            setColor(p.color(p.random(0, 255), p.random(0, 255), p.random(0, 255)));
    }

    public void setColor(int myC) {
            colour = myC;
    }

    public void setPosition(float x, float y) {
            setPositionAndRadii(new PVector(x, y), radiusX, radiusY);
    }

    public void setPositionAndRadii(PVector p, float rx, float ry) {
            center = p;
            radiusX = rx;
            radiusY = ry;
    }

    public void setPosition() {
            float maxRadius = 50;
            float low = maxRadius;
            float highX = w - maxRadius;
            float highY = h - maxRadius;
            float r = p.random(20, maxRadius);
            setPositionAndRadii(
                            new PVector(p.random(low, highX), p.random(low, highY)), r, r);
    }

    public void draw() {
            draw(colour);
    }

    public void draw(int c) {
    	p.pushStyle();
    	p.stroke(contourColour);
    	p.strokeWeight(sWeight);
    	p.fill(c);
    	p.ellipse(center.x(), center.y(), 2 * radiusX, 2 * radiusY);
            p.popStyle();
    }

    @Override
    public boolean checkIfGrabsInput(TerseEvent event) {
            if (event instanceof GenericDOF2Event) {
                    float x = ((GenericDOF2Event<?>) event).getX();
                    float y = ((GenericDOF2Event<?>) event).getY();
                    return (PApplet.pow((x - center.x()), 2) / PApplet.pow(radiusX, 2)
                                    + PApplet.pow((y - center.y()), 2) / PApplet.pow(radiusY, 2) <= 1);
            }
            return false;
    }

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
                            setPosition(((GenericDOF2Event<?>) event).getX(),
                                            ((GenericDOF2Event<?>) event).getY());
                            break;
                    case CHANGE_SHAPE:
                            radiusX += ((GenericDOF2Event<?>) event).getDX();
                            radiusY += ((GenericDOF2Event<?>) event).getDY();
                            break;
                    }
            }
    }


}