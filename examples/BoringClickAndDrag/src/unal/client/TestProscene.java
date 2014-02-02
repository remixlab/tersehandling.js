package unal.client;


import org.timepedia.exporter.client.ExporterUtil;

import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TestProscene implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		
		//JsniFacade f = new JsniFacade();
		//f.publish();
		
		ExporterUtil.exportAll();
		onLoadImpl();		
		
	}
	
	
	  private native void onLoadImpl() /*-{
	    if ($wnd.gwtOnLoad && typeof $wnd.gwtOnLoad == 'function') $wnd.gwtOnLoad();
	  }-*/;	

}
