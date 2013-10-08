/**
 * Tersehandling - https://github.com/remixlab/tersehandling
 * National University of Colombia - Remixlab
 * @author Jean Pierre Charalambos
 * Class to manage the Kinect functions and the Kinect Agent with Tersehandling
 * Example by Miguel Alejandro Parra [maparrar(at)gmail(dot)com]
 * */
import remixlab.tersehandling.core.*;
import remixlab.tersehandling.generic.agent.*;
import remixlab.tersehandling.generic.event.*;
import remixlab.tersehandling.generic.profile.*;
import remixlab.tersehandling.event.*;

int w = 600;
int h = 600;

//Kinect kinect;
MouseAgent agent;
KINECTAgent kinectAgent;
TerseHandler terseHandler;
GrabbableCircle [] circles;

PVector kinectPos; // Positions
PVector kinectRot; // Rotations

void setup() {
  size(w, h);
  terseHandler = new TerseHandler();
  agent = new MouseAgent(terseHandler, "my_mouse");
  registerMethod("mouseEvent", agent);
  kinectAgent = new KINECTAgent(this,terseHandler, "Kinect");
  circles = new GrabbableCircle[50];
  for (int i = 0; i < circles.length; i++)
    circles[i] = new GrabbableCircle(agent);
  for (int i = 0; i < circles.length; i++)
    kinectAgent.addInPool(circles[i]);
}

void draw() {
  background(255);
  //Update the Kinect data
  kinectAgent.update();
  
  //Get the translation and rotation vectors from Kinect
  kinectPos=kinectAgent.positionVector();
  kinectRot=kinectAgent.rotationVector();
  
  for (int i = 0; i < circles.length; i++) {
    if ( circles[i].grabsAgent(agent) )
      circles[i].draw(color(255, 0, 0));
    else
      circles[i].draw();
  }
  terseHandler.handle();
  //DRaw the hands position
  kinectAgent.draw();
}

void keyPressed() {
  println("mouse: " + mouseX + " " + mouseY);
  println("kinect: " + kinectPos.x + " " + kinectPos.y + " " + kinectPos.z);
}

/****************************************************************************/
/******************************* KINECT EVENTS ******************************/
/****************************************************************************/
// SimpleOpenNI events
void onNewUser(SimpleOpenNI curContext, int userId){
  kinectAgent.onNewUser(curContext,userId);
}
