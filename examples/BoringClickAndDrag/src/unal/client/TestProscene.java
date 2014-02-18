/*******************************************************************************
 * TerseHandling (version 1.0.0)
 * Copyright (c) 2014 National University of Colombia, https://github.com/remixlab
 * @author Jean Pierre Charalambos, http://otrolado.info/
 *     
 * All rights reserved. Library that eases the creation of interactive
 * scenes, released under the terms of the GNU Public License v3.0
 * which is available at http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/

package unal.client;


import org.timepedia.exporter.client.ExporterUtil;

import com.google.gwt.core.client.EntryPoint;

// TODO: Auto-generated Javadoc
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TestProscene implements EntryPoint {

	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		
		//JsniFacade f = new JsniFacade();
		//f.publish();
		
		ExporterUtil.exportAll();
		onLoadImpl();		
		
	}
	
	
	  /**
  	 * On load impl.
  	 */
  	private native void onLoadImpl() /*-{
	    if ($wnd.gwtOnLoad && typeof $wnd.gwtOnLoad == 'function') $wnd.gwtOnLoad();
	  }-*/;	

}
