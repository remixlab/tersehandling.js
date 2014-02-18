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

import remixlab.tersehandling.generic.profile.*;

// TODO: Auto-generated Javadoc
/**
 * The Enum ClickAction.
 */
public enum ClickAction implements Actionable<GlobalAction> {
  
  /** The change color. */
  CHANGE_COLOR(GlobalAction.CHANGE_COLOR),
  
  /** The change stroke weight. */
  CHANGE_STROKE_WEIGHT(GlobalAction.CHANGE_STROKE_WEIGHT);

  /* (non-Javadoc)
   * @see remixlab.tersehandling.generic.profile.Actionable#referenceAction()
   */
  @Override
  public GlobalAction referenceAction() {
    return act;
  }

  /* (non-Javadoc)
   * @see remixlab.tersehandling.generic.profile.Actionable#description()
   */
  @Override
  public String description() {
    return "A simple click action";
  }

  /* (non-Javadoc)
   * @see remixlab.tersehandling.generic.profile.Actionable#dofs()
   */
  @Override
  public int dofs() {
    return 0;
  }

  /** The act. */
  GlobalAction act;

  /**
   * Instantiates a new click action.
   *
   * @param a the a
   */
  ClickAction(GlobalAction a) {
    act = a;
  }
}
