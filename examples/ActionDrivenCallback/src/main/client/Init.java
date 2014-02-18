/*******************************************************************************
 * TerseHandling (version 1.0.0)
 * Copyright (c) 2014 National University of Colombia, https://github.com/remixlab
 * @author Jean Pierre Charalambos, http://otrolado.info/
 *     
 * All rights reserved. Library that eases the creation of interactive
 * scenes, released under the terms of the GNU Public License v3.0
 * which is available at http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package main.client;

import org.timepedia.exporter.client.ExporterUtil;


import com.google.gwt.core.client.EntryPoint;


// TODO: Auto-generated Javadoc
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Init implements EntryPoint {

	  /**
	   * The entry point method, called automatically by loading a module that
	   * declares an implementing class as an entry point.
	   */
	@Override
	public void onModuleLoad() {

		
		ExporterUtil.exportAll();
		onLoadImpl();		
		
	}
	
	
	 /**
  	 * On load impl in html.
  	 */
  	private native void onLoadImpl() /*-{
	    if ($wnd.gwtOnLoad && typeof $wnd.gwtOnLoad == 'function') $wnd.gwtOnLoad();
	  }-*/;	

}