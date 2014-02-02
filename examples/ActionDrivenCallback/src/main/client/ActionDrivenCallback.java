package main.client;

import processing.core.PApplet;
import remixlab.tersehandling.core.EventConstants;
import remixlab.tersehandling.core.TerseHandler;
import remixlab.tersehandling.generic.event.GenericClickEvent;
import remixlab.tersehandling.generic.event.GenericDOF2Event;

public class ActionDrivenCallback {
	
	
	private PApplet p;
    int w = 600;
    int h = 600;
    MouseAgent agent;
    TerseHandler terseHandler;
    GrabbableCircle[] circles;
   
    GenericDOF2Event<MotionAction> event, prevEvent;
    
    
    public ActionDrivenCallback(){}
    public ActionDrivenCallback(PApplet p){
    	this.p = p;
    }
    
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

    public void mouseMoved() {
            event = new GenericDOF2Event<MotionAction>(prevEvent, p.mouseX(), p.mouseY(), EventConstants.TH_NOMODIFIER_MASK, EventConstants.TH_NOBUTTON);
            agent.updateGrabber(event);
            prevEvent = event.get();        
    }
   

    public void mouseDragged() {
            event = new GenericDOF2Event<MotionAction>(prevEvent, p.mouseX(), p.mouseY(), EventConstants.TH_NOMODIFIER_MASK, EventConstants.TH_LEFT);
            agent.handle(event);
            prevEvent = event.get();        
    }
   

    public void mouseClicked() {
            agent.handle(new GenericClickEvent<ClickAction>(p.mouseX(), p.mouseY(), EventConstants.TH_NOMODIFIER_MASK, EventConstants.TH_RIGHT, 1));        
    }	
	
}
