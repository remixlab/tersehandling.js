/**
 *                  TerseHandling (version 0.70.0)
 *           Copyright (c) 2013 by Jean Pierre Charalambos
 *                 @author Jean Pierre Charalambos
 *             https://github.com/nakednous/tersehandling
 *           
 * This library provides classes to ease the creation of interactive scenes.
 * 
 * This source file is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option)
 * any later version.
 * 
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 * more details.
 * 
 * A copy of the GNU General Public License is available on the World Wide Web
 * at <http://www.gnu.org/copyleft/gpl.html>. You can also obtain it by
 * writing to the Free Software Foundation, 51 Franklin Street, Suite 500
 * Boston, MA 02110-1335, USA.
 */

package remixlab.tersehandling.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import remixlab.tersehandling.event.TerseEvent;

public class TerseHandler {
	//D E V I C E S	  &   E V E N T S
	protected HashMap<String, Agent> agents;
	protected LinkedList<EventGrabberTuple> eventTupleQueue;
	
	public TerseHandler() {
		//agents
		agents = new HashMap<String, Agent>();
		//events
		eventTupleQueue = new LinkedList<EventGrabberTuple>();
	}
	
	// to be called at the end of the main drawing loop
	public void handle() {
		// 1. Agents
		for (Agent agent : agents.values())
			agent.handle(agent.feed());
		
		// 2. Low level events 
		while( !eventTupleQueue.isEmpty() )
			eventTupleQueue.remove().perform();
	}
	
	// call when grabber is null
	//public abstract void defaultPerformer(GenericEvent e);
	
	/**
	 * Returns an array of the camera profile objects that are currently
	 * registered at the Scene.
	 */
	public Agent [] agentsArray() {
		return agents.values().toArray(new Agent[0]);
	}
	
	public List<Agent> agents() {
		List<Agent> list = new ArrayList<Agent>();
		for (Agent agent : agents.values())
			list.add(agent);
				
		return list;
	}
	
	/**
	 * Adds an HIDevice to the scene.
	 * 
	 * @see #unregisterProfile(HIDevice)
	 * @see #removeAllDevices()
	 */
	public void registerAgent(Agent agent) {
		if(!isAgentRegistered(agent))
			agents.put(agent.name(), agent);
		else {
			System.out.println("Nothing done. An agent with the same name is already registered. Current agent names are:");
			for (Agent ag : agents.values())
				System.out.println(ag.name());
		}
	}
	
	public boolean isAgentRegistered(Agent agent) {
		return agents.containsKey(agent.name());
	}
	
	public boolean isAgentRegistered(String name) {
		return agents.containsKey(name);
	}
	
	public Agent getAgent(String name) {
		return agents.get(name);
	}
	
	/**
	 * Removes the device from the scene.
	 * 
	 * @see #registerProfile(HIDevice)
	 * @see #removeAllDevices()
	 */
	public Agent unregisterAgent(Agent device) {
		return agents.remove(device.name());
	}

	public Agent unregisterAgent(String name) {
		return agents.remove(name);
	}
	
	/**
	 * Removes all registered devices from the scene.
	 * 
	 * @see #registerProfile(HIDevice)
	 * @see #unregisterProfile(HIDevice)
	 */
	public void unregisterAllAgents() {
		agents.clear();
	}
	
	/**
	 * Adds an HIDevice to the scene.
	 * 
	 * @see #unregisterProfile(AbstractHIDevice)
	 * @see #removeAllDevices()
	 */
	/**
	public void enqueueEventTuple(EventGrabberTuple eventTuple) {
		if(!eventTupleQueue.contains(eventTuple))
			if( !eventTuple.event().isNull() )
				if( eventTuple instanceof Duoble ) {
					if (((Duoble<?>)eventTuple.event()).getAction() != null)
						eventTupleQueue.add(eventTuple);
				}
				else
					eventTupleQueue.add(eventTuple);
	}
	*/
	
	public LinkedList<EventGrabberTuple> eventTupleQueue() {
		return eventTupleQueue;
	}
	
	public void enqueueEventTuple(EventGrabberTuple eventTuple) {		
		if(!eventTupleQueue.contains(eventTuple))
			eventTuple.enqueue(eventTupleQueue);
	}
	
	/**
	 * Removes the device from the scene.
	 * 
	 * @see #registerProfile(AbstractHIDevice)
	 * @see #removeAllDevices()
	 */
	public void removeEventTuple(TerseEvent event) {
		eventTupleQueue.remove(event);
	}
	
	/**
	 * Removes all registered devices from the scene.
	 * 
	 * @see #registerProfile(AbstractHIDevice)
	 * @see #unregisterProfile(AbstractHIDevice)
	 */
	public void removeAllEventTuples() {
		eventTupleQueue.clear();
	}
	
	// 3. Device grabber handling
	
	public boolean isInAgentPool(Grabbable grabber, Agent agent) {
		if(agent == null) return false;
		return agent.isInPool(grabber);
	}
	
	public boolean addInAgentPool(Grabbable grabber, Agent agent) {
		if(agent == null) return false;
		return agent.addInPool(grabber);
	}
	
	public boolean removeFromAgentPool(Grabbable grabber, Agent agent) {
		if(agent == null) return false;
		return agent.removeFromPool(grabber);
	}
	
	public void clearAgentPool(Agent agent) {
		agent.clearPool();
	}
	
	//--- Global
	
	public void addInAllAgentPools(Grabbable grabber) {
		for (Agent agent : agents.values())
			if( !agent.isInPool(grabber) )
				agent.addInPool(grabber);
	}	
	
	public void removeFromAllAgentPools(Grabbable grabber) {
		for (Agent agent : agents.values())
			agent.removeFromPool(grabber);
	}

	public void clearAllAgentPools() {
		for (Agent agent : agents.values())
			agent.clearPool();
	}
	
	public List<Grabbable> globalGrabberList() {
		List<Grabbable> msGrabberPool = new ArrayList<Grabbable>();
		for (Agent device : agents.values())
			for (Grabbable grabber : device.pool())
				if(!msGrabberPool.contains(grabber))
					msGrabberPool.add(grabber);

		return msGrabberPool;
	}
}
