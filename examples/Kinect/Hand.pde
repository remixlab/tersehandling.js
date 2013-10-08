/**
 * Tersehandling - https://github.com/remixlab/tersehandling
 * National University of Colombia - Remixlab
 * 
 * Hand Class, this class store a point with the position of the hand
 * */
public class Hand {
  PVector pos;
  color col;
  /****************************************************************************/
  /******************************* CONSTRUCTORS *******************************/
  /****************************************************************************/
  public Hand() {
    this(new PVector(0,0,0));
  }
  
  public Hand(float x, float y, float z) {
    this(new PVector(x,y,z),0);
  }
  
  public Hand(PVector p){
    this(p,0);
  }
  
  public Hand(color inColor){
    this(new PVector(0,0,0), inColor);
  }
  
  public Hand(PVector p, color inColor){
    pos=new PVector(p.x,p.y,p.z);
    col=inColor;
  }
  /****************************************************************************/
  /**************************** GETTERS AND SETTERS ***************************/
  /****************************************************************************/
  /**
   * Return the pos
   * @return PVector Current Hand position
   * */
  public PVector position(){
    return pos;
  }
  /**
   * Set the pos
   * @param PVector inPoint Position vector
   * */
  public void setPosition(PVector inPoint){
    pos=inPoint;
  }
  /****************************************************************************/
  /********************************** METHODS *********************************/
  /****************************************************************************/
  /**
   * Draw the hand pos
   * */
   public void draw(){
     fill(col);
     float maxZAllowed=1800;
     float minZAllowed=1000;
     float maxRadius=15;
     float minRadius=5;
     float rad=abs((maxRadius-((pos.z-minZAllowed)*((maxRadius-minRadius)/(maxZAllowed-minZAllowed)))));
     ellipse(pos.x, pos.y,rad,rad);
   }
}
