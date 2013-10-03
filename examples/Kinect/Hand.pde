/**
 * Tersehandling - https://github.com/remixlab/tersehandling
 * National University of Colombia - Remixlab
 * 
 * Hand Class, this class store a point with the position of the hand
 * */
public class Hand{
  PVector point;
  color col;
  /****************************************************************************/
  /******************************* CONSTRUCTORS *******************************/
  /****************************************************************************/
  public Hand(){
    point=new PVector(0,0,0);
  }
  public Hand(color inColor){
    point=new PVector(0,0,0);
    col=inColor;
  }
  /****************************************************************************/
  /**************************** GETTERS AND SETTERS ***************************/
  /****************************************************************************/
  /**
   * Return the point
   * @return PVector Current Hand position
   * */
  public PVector getPoint(){
    return point;
  }
  /**
   * Set the point
   * @param PVector inPoint Position vector
   * */
  public void setPoint(PVector inPoint){
    point=inPoint;
  }
  /****************************************************************************/
  /********************************** METHODS *********************************/
  /****************************************************************************/
  /**
   * Draw the hand point
   * */
   public void draw(){
     fill(col);
     float maxZAllowed=1800;
     float minZAllowed=1000;
     float maxRadius=15;
     float minRadius=5;
     float rad=abs((maxRadius-((point.z-minZAllowed)*((maxRadius-minRadius)/(maxZAllowed-minZAllowed)))));
     ellipse(point.x, point.y,rad,rad);
   }
}
