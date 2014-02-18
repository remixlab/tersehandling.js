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

import remixlab.tersehandling.core.EventConstants;
import remixlab.tersehandling.core.TerseHandler;
import remixlab.tersehandling.generic.agent.GenericMotionAgent;
import remixlab.tersehandling.generic.event.GenericDOF2Event;
import remixlab.tersehandling.generic.profile.GenericClickProfile;
import remixlab.tersehandling.generic.profile.GenericMotionProfile;

// TODO: Auto-generated Javadoc
/**
 * The Class MouseAgent.
 */
public class MouseAgent
extends
GenericMotionAgent<GenericMotionProfile<MotionAction>, GenericClickProfile<ClickAction>>
implements EventConstants {
	
	/** The prev event. */
	GenericDOF2Event<MotionAction> event, prevEvent;

	/**
	 * Instantiates a new mouse agent.
	 *
	 * @param scn the scn
	 * @param n the n
	 */
	public MouseAgent(TerseHandler scn, String n) {
		super(new GenericMotionProfile<MotionAction>(),
				new GenericClickProfile<ClickAction>(), scn, n);
		// default bindings
		clickProfile().setClickBinding(TH_LEFT, 1, ClickAction.CHANGE_COLOR);
		clickProfile().setClickBinding(TH_META, TH_RIGHT, 1, ClickAction.CHANGE_STROKE_WEIGHT);
		clickProfile().setClickBinding((TH_META | TH_SHIFT), TH_RIGHT, 1, ClickAction.CHANGE_STROKE_WEIGHT);
		profile().setBinding(TH_LEFT, MotionAction.CHANGE_POSITION);
		profile().setBinding(TH_CENTER, MotionAction.CHANGE_SHAPE);
		profile().setBinding(TH_META, TH_RIGHT, MotionAction.CHANGE_SHAPE);
	}

/**
// 1st Choice: as it's done in the tutorial. Requires reflection
public void mouseEvent(processing.event.MouseEvent e) {
if (e.getAction() == processing.event.MouseEvent.MOVE) {
        event = new GenericDOF2Event<MotionAction>(prevEvent, e.getX(), e.getY(), e.getModifiers(), e.getButton());
        updateGrabber(event);
        prevEvent = event.get();
}
if (e.getAction() == processing.event.MouseEvent.DRAG) {
        event = new GenericDOF2Event<MotionAction>(prevEvent, e.getX(), e.getY(), e.getModifiers(), e.getButton());
        handle(event);
        prevEvent = event.get();
}
if (e.getAction() == processing.event.MouseEvent.CLICK) {
        handle(new GenericClickEvent<ClickAction>(e.getX(), e.getY(), e.getModifiers(), e.getButton(), e.getCount()));
}
}
// */

/**
// 2nd Choice: not that simple
@Override
public GenericDOF2Event<MotionAction> feed() {
return new GenericDOF2Event<MotionAction>(mouseX, mouseY, TH_NOMODIFIER_MASK, TH_NOBUTTON);
}
// */

}
