/**
 * 
 */
package processing.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Administrador
 *
 */
public class ProcessingJS implements PConstants{
	
	public  ProcessingJS (){}
	public  ProcessingJS (JavaScriptObject ctx)
	{
		init(ctx);
		//g = this;
	}
	
	private native void init(JavaScriptObject object)/*-{
	
		//this.@processing.core.Processing::height = object.height;
		//this.@processing.core.Processing::width  = object.width;
		this.@processing.core.ProcessingJS::gl = object;
		
	}-*/;
	
	private JavaScriptObject gl;



	
	
	
	  /**
	   * PI is a mathematical constant with the value 3.14159265358979323846.
	   * It is the ratio of the circumference of a circle to its diameter.
	   * It is useful in combination with the trigonometric functions <b>sin()</b> and <b>cos()</b>.
	   * 
	   * @webref constants
	   * @see processing.core.PConstants#HALF_PI
	   * @see processing.core.PConstants#TWO_PI
	   * @see processing.core.PConstants#QUARTER_PI
	   * 
	   */
	  public static final float PI = (float) Math.PI;
	  static final float DEG_TO_RAD = PI/180.0f;	  
	  static final float RAD_TO_DEG = 180.0f/PI;


	  public static final int OPENGL = 2;
	  public static final int P3D = 2;


	public static final int POINTS = 2;
	
/** height of this applet's associated PGraphics
 * @webref environment
 * */	
	//public   float height;
	
/** width of this applet's associated PGraphics
 * @webref environment
 */	
	//public   float width;



//private JavaScriptObject canvas;
	

	

			public native final JavaScriptObject getCanvas() /*-{
				
					var gl = this.@processing.core.ProcessingJS::gl;			
					return gl.externals.canvas;
				}-*/;

			
			
			public native int width() /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			return gl.width;	
			
		}-*/;	
		
		public native int height() /*-{
			var gl = this.@processing.core.ProcessingJS::gl;	
			return gl.height;
		}-*/;
		
		
		public PMatrix3D projmodelview() {
			throw new UnsupportedOperationException("projmodelview.");
		}
		
		
		public PMatrix3D modelview() {
			return getModelViewMatrix();
			
		}
		
		public PMatrix3D projection() {
			return getProjectionMatrix();
			
		}		
			
		private  final native PMatrix3D getProjectionMatrix()/*-{
		
			var gl = this.@processing.core.ProcessingJS::gl;
			//alert(gl);
			console.debug(gl);	
			//console.log(gl);	
			var pM = gl.getProjectionMatrix();
			
			console.debug(gl);	
			
			return @processing.core.JsUtils::JavaScriptArray2Matrix3D(Lcom/google/gwt/core/client/JavaScriptObject;)(pM);
					
					
		}-*/;
		
		
		
	private  final native PMatrix3D getModelViewMatrix()/*-{
	
		var gl = this.@processing.core.ProcessingJS::gl;
				
		var pM = gl.getModelViewMatrix();
		
		return @processing.core.JsUtils::JavaScriptArray2Matrix3D(Lcom/google/gwt/core/client/JavaScriptObject;)(pM);
				
				
	}-*/;
			
		
		
	  
			public  final native void perspective(float theFoV, float theAspect, float theNearClip,
					float theFarClip)/*-{
						
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.perspective(theFoV,  theAspect, theNearClip,theFarClip);	
						
						
									
			}-*/;
			public  final native void camera(float theCameraX, float theCameraY, float theCameraZ,
					float theTargetX, float theTargetY, float theTargetZ, float theUpX,
					float theUpY, float theUpZ)/*-{
					
					
						var gl = this.@processing.core.ProcessingJS::gl;
						
						gl.camera(theCameraX, theCameraY, theCameraZ,
						theTargetX, theTargetY, theTargetZ, theUpX,
						theUpY, theUpZ);
			}-*/;
	
	  static public final float sin(float angle) {
		    return (float)Math.sin(angle);
		  }
	
		  static public final float cos(float angle) {
		    return (float)Math.cos(angle);
		  }
	
		  static public final float tan(float angle) {
		    return (float)Math.tan(angle);
		  }
	
		  static public final float sqrt(float a) {
			    return (float)Math.sqrt(a);
		  }
		  		  
	  static public final float atan2(float a, float b) {
		    return (float)Math.atan2(a, b);
		  }
	  static public final float degrees(float radians) {
		    return radians * RAD_TO_DEG;
		  }
	  static public final float constrain(float amt, float low, float high) {
		    return (amt < low) ? low : ((amt > high) ? high : amt);
		  }

	  
		public static final native void log(Object message)/*-{
		
		console.log(message);

		}-*/;
		
		
		  public native final float random(float high) /*-{
			
				var gl = this.@processing.core.ProcessingJS::gl;			
				return gl.random( high);
			}-*/;		

		  public native final float random(float low, float high)/*-{
			
				var gl = this.@processing.core.ProcessingJS::gl;			
				return gl.random( low,  high);
			}-*/;	
		
		  static public final float pow(float n, float e) {
			    return (float)Math.pow(n, e);
			  }
		  
		  public native final int color(float v1, float v2, float v3)/*-{
						
				var gl = this.@processing.core.ProcessingJS::gl;			
				return gl.color( v1,  v2,  v3);
			}-*/;		
		  	  
		  
		  
		  public native void pushStyle()/*-{
						
				var gl = this.@processing.core.ProcessingJS::gl;				
				gl.pushStyle();
			}-*/;		
		  
		  
		  
		  public native void popStyle() /*-{
						
				var gl = this.@processing.core.ProcessingJS::gl;				
				gl.popStyle();
			}-*/;		
		  
		  
		  public native void fill(int rgb) /*-{
						
				var gl = this.@processing.core.ProcessingJS::gl;			
				gl.fill( rgb);
			}-*/;		
		  
		  public native void ellipse(float a, float b, float c, float d) /*-{
						
				var gl = this.@processing.core.ProcessingJS::gl;				
				gl.ellipse( a,  b,  c,  d);
			}-*/;

		public native void stroke(int  rgb) /*-{
		
			var gl = this.@processing.core.ProcessingJS::gl;				
			gl.stroke( rgb);
		}-*/;

		public native void strokeWeight(float weight) /*-{
		
			var gl = this.@processing.core.ProcessingJS::gl;				
			gl.strokeWeight( weight);
		}-*/;

		public native void size(int w, int h) /*-{
		
					var gl = this.@processing.core.ProcessingJS::gl;				
			gl.size( w , h);
		
		}-*/;
		
		
		
		public native void size(int w, int h, int mode) /*-{
		
				var gl = this.@processing.core.ProcessingJS::gl;				
		gl.size( w , h,mode);
		
		}-*/;		

		public native void background(int rgb) /*-{
					var gl = this.@processing.core.ProcessingJS::gl;				
			gl.background( rgb);			
			
		}-*/;
		
		public native int mouseX() /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			return gl.mouseX;	
			
		}-*/;	
		
		public native int mouseY() /*-{
			var gl = this.@processing.core.ProcessingJS::gl;	
			return gl.mouseY;
		}-*/;

		public native void stroke(float v1, float v2, float v3)/*-{
			var gl = this.@processing.core.ProcessingJS::gl;	
			gl.stroke(  v1,  v2,  v3);
		}-*/;

		public native void vertex(float x, float y) /*-{
			var gl = this.@processing.core.ProcessingJS::gl;	
			gl.vertex(  x,  y);
		}-*/;

		public native void smooth() /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			 gl.smooth();	
		
		}-*/;

		public native void pushMatrix() /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			gl. pushMatrix();	
		
		}-*/;

		public native void translate(float f, float g) /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			gl. translate( f,  g);	
		
		}-*/;

		public native void beginShape(int points2) /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			gl.beginShape( points2);	
		
		}-*/;

		public native void endShape() /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			gl.endShape();	
		
		}-*/;

		public native void popMatrix() /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			gl.popMatrix();	
		
		}-*/;

		public native char key() /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			return gl.key;	
		
		}-*/;	
		
		public native void translate(float x, float y, float z) /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			gl.translate( x,  y,  z) ;	
		
		}-*/;	
		
		  
		  
			public native int frameCount() /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			return gl.frameCount;	
		
		}-*/;	
			
			public native  void rotateX(float angle) /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			gl.rotateX( angle) ;	
		
		}-*/;	
			
			public native void rotateY(float angle) /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			gl.rotateY( angle);	
		
		}-*/;

			public native void vertex(float x, float y, float z)   /*-{
			var gl = this.@processing.core.ProcessingJS::gl;
			gl.vertex( x,  y,  z);	
		
		}-*/;
			
			static public final int max(int a, int b) {
			    return (a > b) ? a : b;
			  }

			  static public final float max(float a, float b) {
			    return (a > b) ? a : b;
			  }
			  
			  static public final int max(int a, int b, int c) {
				    return (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
				  }


				  static public final float max(float a, float b, float c) {
				    return (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
				  }
				public native static void println(String string) /*-{

				console.log(string);
				}-*/;
				
				
				public  native void line(float x1, float y1, float x2, float y2)/*-{
				var gl = this.@processing.core.ProcessingJS::gl;
				gl.line( x1,  y1,  x2,  y2);	
			
			}-*/;

				  public  native void line(float x1, float y1, float z1,
				                   float x2, float y2, float z2) /*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					gl.line( x1,  y1,  z1,
				                    x2,  y2,  z2);	
				
				}-*/;
				  
				  
				  public  native void noFill() /*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					gl.noFill();	
				
				}-*/;	
				  
				  public  native void beginShape() /*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					gl.beginShape();	
				
				}-*/;
				  
				  public native  void endShape(int mode) /*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					gl.endShape( mode);	
				
				}-*/;

					public  native void noStroke() /*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					gl.noStroke();	
				
				}-*/;
				  
				  

					static public final float radians(float degrees) {
					    return degrees * DEG_TO_RAD;
					  }
					
					
					public  native void rotate(float angle, float x, float y, float z) /*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					gl.rotate( angle,  x,  y,  z);	
				
				}-*/;
					
					public  native void normal(float nx, float ny, float nz)/*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					gl.normal( nx,  ny,  nz);	
				
				}-*/;				
					
					 public  native void frameRate(float fps) /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.frameRate( fps);	
					
					}-*/;
					 
					 
					 public  native void resetMatrix() /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.resetMatrix();	
					
					}-*/;

					 
					 public    PMatrix getMatrix() {
						return getModelViewMatrix();	
					
					}

					 
					 public  native void printMatrix() /*-{
					 	console.log("printMatrix: no implementado");
					 	
						//var gl = this.@processing.core.Processing::gl;
						//gl.vertex( x,  y,  z);	
					
					}-*/;
					 
					 public  native void applyMatrix(PMatrix source) /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.applyMatrix( source);	
					
					}-*/;
					 
					 public  native void applyMatrix(float n00, float n01, float n02, float n03,
	                          float n10, float n11, float n12, float n13,
	                          float n20, float n21, float n22, float n23,
	                          float n30, float n31, float n32, float n33) /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.applyMatrix( n00,  n01,  n02,  n03,
	                           n10,  n11,  n12,  n13,
	                           n20,  n21,  n22,  n23,
	                           n30,  n31,  n32,  n33) ;	
					
					}-*/;
					 
					 public  native void rotate(float angle) /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.rotate( angle);	
					
					}-*/;
					 
					 public  native void rotateZ(float angle)/*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.rotateZ( angle);	
					
					}-*/;
					 
					 
					  public  native void scale(float x) /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.scale( x);	
					
					}-*/;
					  public  native void scale(float x, float y) /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.scale( x,  y);	
					
					}-*/;
					 
					  public  native void scale(float x, float y, float z) /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.scale( x,  y,  z);	
					
					}-*/;

					 

					  public  native void hint(int which) /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.hint( which);	
					
					}-*/;
					  
					  
						public  native void fill(int i, int j, int k)/*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.fill( i,  j,  k);	
					
					}-*/;
						public  native Object createFont(String string, int i) /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.createFont( string,  i);	
					
					}-*/;
	
						
						public  native void text(String info, int i, int j, int k, int l) /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.text( info,  i,  j,  k,  l);	
					
					}-*/;

						
						public  native void printProjection() /*-{
						console.log("printProjection: no implementado");
					
					}-*/;
						
						
						

						
						
						public  native void pushProjection() /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.pushProjection();	
					
					}-*/;

						public  native void popProjection() /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.popProjection();	
					
					}-*/;

						public  native void resetProjection() /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.resetProjection();	
					
					}-*/;



						public  native void applyProjection(PMatrix3D pMatrix)/*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.applyProjection( pMatrix);	
					
					}-*/;


						public  native void setProjection(PMatrix3D pMatrix) /*-{
						var obj = @processing.core.JsUtils::Matrix3D2JavaScriptArray(Lprocessing/core/PMatrix3D;)(pMatrix);
							
						var gl = this.@processing.core.ProcessingJS::gl;
						
						var pM = gl.getProjectionMatrix();
						
						pM.set( obj[0], obj[1], obj[2], obj[3], 
								obj[4], obj[5], obj[6], obj[7], 
								obj[8], obj[9], obj[10], obj[11],
								obj[12], obj[13], obj[14], obj[15]);
					
					}-*/;


						public  native void setMatrix(PMatrix3D pMatrix) /*-{
						
						var obj = @processing.core.JsUtils::Matrix3D2JavaScriptArray(Lprocessing/core/PMatrix3D;)(pMatrix);	
						
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.resetMatrix();
						
						gl.applyMatrix( obj[0], obj[1], obj[2], obj[3], 
										obj[4], obj[5], obj[6], obj[7], 
										obj[8], obj[9], obj[10], obj[11],
										obj[12], obj[13], obj[14], obj[15]);
														
					}-*/;
						
						public  native void box(float width, float height, float depth) /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.box( width,  height,  depth);	
					
					}-*/;			
						
						public  native void lights() /*-{
							var gl = this.@processing.core.ProcessingJS::gl;
							gl.lights( );	
							
						}-*/;
						public native void box(int i) /*-{
							var gl = this.@processing.core.ProcessingJS::gl;
							gl.box( i);	
						}-*/;
						
						
						public native void colorMode(int rgb, int i) /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						gl.colorMode(rgb, i);	
					}-*/;
						
						
					public native int strokeColor() /*-{
						var gl = this.@processing.core.ProcessingJS::gl;
						return gl.getCurrentStrokeColor();	
					}-*/;
					
					public native float  brightness(int strokeColor) /*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					 return gl.brightness(strokeColor);	
				}-*/;

					public native float hue(int strokeColor)/*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					 return gl.hue(strokeColor);	
				}-*/;

					public native float saturation(int strokeColor) /*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					 return gl.saturation(strokeColor);	
				}-*/;

					public native float strokeWeight() /*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					return gl.getStrokeWeight();	
				}-*/;

					public native int color(float f, float g, int i, float alfa) /*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					return gl.color( f,  g,  i,  alfa);	
				}-*/;
					
					public native  float fillColor() /*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					return gl.getCurrentFillColor();	
					}-*/;
					
					public native float alpha(float fillColor) /*-{
					var gl = this.@processing.core.ProcessingJS::gl;
					return gl.alpha(fillColor);	
					}-*/;


}