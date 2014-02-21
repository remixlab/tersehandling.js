/**
 * 
 */
package processing.core;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayBoolean;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * @author cesar
 *
 */
public class JsUtils {

	
	  public static final PMatrix3D JavaScriptArray2Matrix3D(JavaScriptObject array){	  	
		  	return JsUtils.JavaScriptArray2Matrix3D(array,true);
		  }
		
		public native static final PMatrix3D JavaScriptArray2Matrix3D(JavaScriptObject array, boolean rowMajor)/*-{
			
			

			
			if(rowMajor){
			  
			  var o = array;
				return @processing.core.PMatrix3D::new(FFFFFFFFFFFFFFFF)
						(o.elements[0], o.elements[1], o.elements[2],    o.elements[3],
	           o.elements[4], o.elements[5], o.elements[6],    o.elements[7],
	           o.elements[8], o.elements[9], o.elements[10],   o.elements[11],
	           o.elements[12], o.elements[13], o.elements[14], o.elements[15]);		
			
			}else
			{	
			     var matrix3D = @processing.core.PMatrix3D::new();					
				   matrix3D.@processing.core.PMatrix3D::m00 = array[0]; 
				   matrix3D.@processing.core.PMatrix3D::m01 = array[4]; 
				   matrix3D.@processing.core.PMatrix3D::m02 = array[8]; 
				   matrix3D.@processing.core.PMatrix3D::m03 = array[12]; 
				   matrix3D.@processing.core.PMatrix3D::m10 = array[1]; 
				   matrix3D.@processing.core.PMatrix3D::m11 = array[5]; 
				   matrix3D.@processing.core.PMatrix3D::m12 = array[9]; 
				   matrix3D.@processing.core.PMatrix3D::m13 = array[13]; 
				   matrix3D.@processing.core.PMatrix3D::m20 = array[2]; 
				   matrix3D.@processing.core.PMatrix3D::m21 = array[6]; 
				   matrix3D.@processing.core.PMatrix3D::m22 = array[10]; 
				   matrix3D.@processing.core.PMatrix3D::m23 = array[14]; 
				   matrix3D.@processing.core.PMatrix3D::m30 = array[3]; 
				   matrix3D.@processing.core.PMatrix3D::m31 = array[7]; 
				   matrix3D.@processing.core.PMatrix3D::m32 = array[11]; 
				   matrix3D.@processing.core.PMatrix3D::m33 = array[15];			   			   
				   return matrix3D;		 
			}
			
								
		}-*/;
		
		
	  public static final JavaScriptObject  Matrix3D2JavaScriptArray(PMatrix3D matrix3D){  	
	  	return JsUtils.Matrix3D2JavaScriptArray(matrix3D,true);
	  }
		
		public native static final JavaScriptObject  Matrix3D2JavaScriptArray(PMatrix3D matrix3D, boolean rowMajor)/*-{
		
			var array = new Array();
			
			if(rowMajor){
			//array row major
			   array[0] = matrix3D.@processing.core.PMatrix3D::m00; 
			   array[1] = matrix3D.@processing.core.PMatrix3D::m01; 
			   array[2] = matrix3D.@processing.core.PMatrix3D::m02; 
			   array[3] = matrix3D.@processing.core.PMatrix3D::m03; 
			   array[4] = matrix3D.@processing.core.PMatrix3D::m10; 
			   array[5] = matrix3D.@processing.core.PMatrix3D::m11; 
			   array[5] = matrix3D.@processing.core.PMatrix3D::m12; 
			   array[7] = matrix3D.@processing.core.PMatrix3D::m13; 
			   array[8] = matrix3D.@processing.core.PMatrix3D::m20; 
			   array[9] = matrix3D.@processing.core.PMatrix3D::m21; 
			   array[10] = matrix3D.@processing.core.PMatrix3D::m22; 
			   array[11] = matrix3D.@processing.core.PMatrix3D::m23; 
			   array[12] = matrix3D.@processing.core.PMatrix3D::m30; 
			   array[13] = matrix3D.@processing.core.PMatrix3D::m31; 
			   array[14] = matrix3D.@processing.core.PMatrix3D::m32; 
			   array[15] = matrix3D.@processing.core.PMatrix3D::m33;		

			}else
			{
			//array col major
			   array[0] = matrix3D.@processing.core.PMatrix3D::m00; 
			   array[4] = matrix3D.@processing.core.PMatrix3D::m01; 
			   array[8] = matrix3D.@processing.core.PMatrix3D::m02; 
			   array[12] = matrix3D.@processing.core.PMatrix3D::m03; 
			   array[1] = matrix3D.@processing.core.PMatrix3D::m10; 
			   array[5] = matrix3D.@processing.core.PMatrix3D::m11; 
			   array[9] = matrix3D.@processing.core.PMatrix3D::m12; 
			   array[13] = matrix3D.@processing.core.PMatrix3D::m13; 
			   array[2] = matrix3D.@processing.core.PMatrix3D::m20; 
			   array[6] = matrix3D.@processing.core.PMatrix3D::m21; 
			   array[10] = matrix3D.@processing.core.PMatrix3D::m22; 
			   array[14] = matrix3D.@processing.core.PMatrix3D::m23; 
			   array[3] = matrix3D.@processing.core.PMatrix3D::m30; 
			   array[7] = matrix3D.@processing.core.PMatrix3D::m31; 
			   array[11] = matrix3D.@processing.core.PMatrix3D::m32; 
			   array[15] = matrix3D.@processing.core.PMatrix3D::m33;		
			}
			
			return array;
			
		}-*/;	
		
		public static JsArrayNumber toJavaScriptArray(double[] srcArray) {
		  if (GWT.isScript()) {
		    return arrayAsJsArrayForProdMode(srcArray);
		  }
		  JsArrayNumber result = JavaScriptObject.createArray().cast();
		  for (int i = 0; i < srcArray.length; i++) {
		    result.set(i, srcArray[i]);
		  }
		  return result;
		}	
		
		public static JsArrayNumber toJavaScriptArray(float[] srcArray) {
		  if (GWT.isScript()) {
		    return arrayAsJsArrayForProdMode(srcArray);
		  }
		  JsArrayNumber result = JavaScriptObject.createArray().cast();
		  for (int i = 0; i < srcArray.length; i++) {
		    result.set(i, srcArray[i]);
		  }
		  return result;
		}
		
		public static JsArrayNumber toJavaScriptArray(short[] srcArray) {
		  if (GWT.isScript()) {
		    return arrayAsJsArrayForProdMode(srcArray);
		  }
		  JsArrayNumber result = JavaScriptObject.createArray().cast();
		  for (int i = 0; i < srcArray.length; i++) {
		    result.set(i, srcArray[i]);
		  }
		  return result;
		}  
		
		private static native JsArrayBoolean arrayAsJsArrayForProdMode(boolean[] array) /*-{
		return array;
		}-*/;
		
		
		private static native JsArrayInteger arrayAsJsArrayForProdMode(byte[] array) /*-{
		    return array;
		}-*/;
		
		
		private static native JsArrayNumber arrayAsJsArrayForProdMode(short[] array) /*-{
		    return array;
		}-*/;
		
		
		private static native JsArrayNumber arrayAsJsArrayForProdMode(double[] array) /*-{
		    return array;
		}-*/;
		
		
		private static native JsArrayNumber arrayAsJsArrayForProdMode(float[] array) /*-{
		    return array;
		}-*/;		
	
	
}
