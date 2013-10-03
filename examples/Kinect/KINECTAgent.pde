/**
 * Tersehandling - https://github.com/remixlab/tersehandling
 * National University of Colombia - Remixlab
 * @author Jean Pierre Charalambos
 * Class to manage the Kinect functions and the Kinect Agent with Tersehandling
 * Example by Miguel Alejandro Parra [maparrar(at)gmail(dot)com]
 * */
import SimpleOpenNI.*;
public class KINECTAgent extends GenericMotionAgent<GenericMotionProfile<SpaceAction>, GenericClickProfile<ClickAction>> implements EventConstants {
  GenericDOF6Event<SpaceAction> currEvent, prevEvent;
  SimpleOpenNI  context;    //Context for the Kinect handler
  Hand left,right;          // Hands position
  PVector posit;            // The vector with position values calculated with hands positions
  PVector rotat;            // The vector with rotation values calculated with hands positions
  PVector starting;         // Start position, set when two hands are detected
  
  /****************************************************************************/
  /******************************* CONSTRUCTORS *******************************/
  /****************************************************************************/
  /**
   * Kinect object constructor
   * @param PApplet p PApplet object
   * */
  public KINECTAgent(PApplet p,TerseHandler h, String n) {
    super(new GenericMotionProfile<SpaceAction>(), new GenericClickProfile<ClickAction>(), h, n);
    //default bindings
    profile().setBinding(SpaceAction.CHANGE_POS_SHAPE);
    disableTracking();
    //setSensitivities(1, 1, 0.00001, 0.0001, 0.0001, 0.02);
    
    //Kinect init
    context = new SimpleOpenNI(p);
     if (context.isInit() == false){
       println("ERROR PARSING KINECT: Check if the camera is connected.");
     }else{
       // disable mirror
       context.setMirror(true);
       
       // enable depthMap generation 
       context.enableDepth();
         
       // enable skeleton generation for all joints
       context.enableUser();
       
       // Initialize the hands vectors
       left = new Hand(color(255, 0, 0));
       right = new Hand(color(0, 255, 0));
       right.setPoint(new PVector(50,0,0));
       //Initialize the movement vectors
       posit=rotat=new PVector(0,0,0);
       
       //Update for the first time the hands to define the starting vector
       update();
       starting=new PVector(0,0,0);
       starting.x=((right.getPoint().x+left.getPoint().x)/2);
       starting.y=((right.getPoint().y+left.getPoint().y)/2);
       starting.z=((right.getPoint().z+left.getPoint().z)/2);
     }
  }
  
  @Override
  public GenericDOF6Event<SpaceAction> feed() {
    currEvent = new GenericDOF6Event<SpaceAction>(prevEvent, kinectPos.x, kinectPos.y, kinectPos.z, 
                                                             kinectRot.x, kinectRot.y, kinectRot.z, 0, 0);
    prevEvent = currEvent.get();                                                          
    return currEvent;             
  }
  
  /****************************************************************************/
  /**************************** GETTERS AND SETTERS ***************************/
  /****************************************************************************/
  
  /****************************************************************************/
  /********************************** METHODS *********************************/
  /****************************************************************************/
  /**
   * Update the Kinect context and the hand positions
   * */
   public void update(){
     //update the cam
     context.update();
     //Update the hands position
     updateHands();
   }
  /**
   * Update Draw the hands position in the screen
   * */
  public void draw(){
    //Draw the depth image
    //image(context.userImage(),0,0);
    left.draw();
    right.draw();
    
    // Draw the position vector
    fill(color(255,140,0));
    ellipse(posit.x,posit.y,10,10);
  }
  
  /**
   * Return the vector of position calculated using the position of hands
   * @param PVector Position vector
   * */
  public PVector positionVector(){
    posit=new PVector(0,0,0);
    if(isActiveUser()){
      posit.x=((left.getPoint().x+right.getPoint().x)/2);
      posit.y=((left.getPoint().y+right.getPoint().y)/2);
      posit.z=1300-((left.getPoint().z+right.getPoint().z)/2);
    }
    return posit;
  }
  /**
   * Return the vector of rotations calculated using the position of hands
   * @param PVector Rotation vector
   * */
  public PVector rotationVector(){
    rotat=new PVector(0,0,0);
    if(isActiveUser()){
      //TODO: Define a gesture to x-rotation rotation.x=(left.getPoint().x-right.getPoint().x);
      //rotat.x=0;
      //rotat.y=-(left.getPoint().z-right.getPoint().z);
      rotat.x=abs(right.getPoint().x-left.getPoint().x);
      rotat.y=abs(right.getPoint().y-left.getPoint().y);
      rotat.z=(left.getPoint().y-right.getPoint().y);
    }
    return rotat;
  }
  /**
   * Update the hands position with the screen values (projective coordinates)
   * */
  private void updateHands(){
    if(isActiveUser()){
      int[] userList = context.getUsers();
      if(context.isTrackingSkeleton(userList[0])){
        PVector leftPoint=new PVector();
        PVector rightPoint=new PVector();
        context.getJointPositionSkeleton(userList[0],SimpleOpenNI.SKEL_LEFT_HAND,leftPoint);
        context.getJointPositionSkeleton(userList[0],SimpleOpenNI.SKEL_RIGHT_HAND,rightPoint);
        left.setPoint(getScreen(leftPoint));
        right.setPoint(getScreen(rightPoint));
      }
    }
  }
  /**
   * Return the point with World coordinates in screen (projective) coordinates
   * @param PVector point Point to convert
   * @return PVector point converted to projective coordinated
   * */
  private PVector getScreen(PVector point) {
    PVector screenPos = new PVector();
    context.convertRealWorldToProjective(point, screenPos);
    return screenPos;
  }
  /**
   * Check if there is an active user in the openni context.
   * This example only works with the first registered user.
   * @return boolean True if is an active user, false otherwise
   * */
  private boolean isActiveUser() {
    boolean active=false;
    if (context.isInit() == true) {
      int[] userList = context.getUsers();
      if (userList.length==1) {
        active=true;
      }
    }
    return active;
  }
  // SimpleOpenNI events
  public void onNewUser(SimpleOpenNI curContext, int userId){
    println("New user detected: " + userId);
    curContext.startTrackingSkeleton(userId);
  }
}
