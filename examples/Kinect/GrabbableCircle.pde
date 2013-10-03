public class GrabbableCircle extends AbstractGrabber {
  public float radiusX, radiusY;
  public PVector center;
  public int colour;
  public int contourColour;
  public int sWeight;

  public GrabbableCircle(Agent agent) {
    agent.addInPool(this);
    setColor();
    setPosition();
    sWeight = 4;
    contourColour = color(0, 0, 0);
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
    setColor(color(random(0, 255), random(0, 255), random(0, 255)));
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
    float r = random(20, maxRadius);
    setPositionAndRadii(new PVector(random(low, highX), random(low, highY)), r, r);
  }

  public void draw() {
    draw(colour);
  }

  public void draw(int c) {
    pushStyle();
    stroke(contourColour);
    strokeWeight(sWeight);
    fill(c);
    ellipse(center.x, center.y, 2*radiusX, 2*radiusY);
    popStyle();
  }

  @Override
    public boolean checkIfGrabsInput(TerseEvent event) {
    if (event instanceof GenericDOF2Event) {
      float x = ((GenericDOF2Event<?>)event).getX();
      float y = ((GenericDOF2Event<?>)event).getY();
      return(pow((x - center.x), 2)/pow(radiusX, 2) + pow((y - center.y), 2)/pow(radiusY, 2) <= 1);
    }      
    return false;
  }

  @Override
    public void performInteraction(TerseEvent event) {
    if (event instanceof Duoable) {
      switch ((GlobalAction) ((Duoable<?>)event).action().referenceAction()) {
        case CHANGE_COLOR:
          contourColour = color(random(100, 255), random(100, 255), random(100, 255));
          break;
        case CHANGE_STROKE_WEIGHT:
          if (event.isShiftDown()) {          
            if (sWeight > 1)
              sWeight--;
          }
          else      
            sWeight++;    
          break;
        case CHANGE_POSITION:
          setPosition( ((GenericDOF2Event<?>)event).getX(), ((GenericDOF2Event<?>)event).getY() );
          break;
        case CHANGE_SHAPE:
          radiusX += ((GenericDOF2Event<?>)event).getDX();
          radiusY += ((GenericDOF2Event<?>)event).getDY();
          break;
        case CHANGE_POS_SHAPE:
          radiusX = ((GenericDOF6Event<?>)event).getRX();
          radiusY = ((GenericDOF6Event<?>)event).getRY();
          //center.x = ((GenericDOF6Event<?>)event).getX();
          //center.y = ((GenericDOF6Event<?>)event).getY();     
          setPosition(((GenericDOF6Event<?>)event).getX(),((GenericDOF6Event<?>)event).getY());           
          break;
        }
    }
  }
}
