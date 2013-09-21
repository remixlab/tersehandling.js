TerseHandling
=============

`TerseHandling` is a framework designed for _sketching_ generic input events, i.e., transforming input events into high-level user-defined actions,
mainly implemented using [[generic programming techniques|http://en.wikipedia.org/wiki/Generics_in_Java]].
It provides its own set of events which supports up to [[6-DOFs|http://en.wikipedia.org/wiki/Degrees_of_freedom_(mechanics)]],
together with a set of *agents* which parses them, i.e., identifies object *grabbers* and the *actions* they should perform,
allowing the developer to focus on implementing those actions. A developer workflow using `TerseHandling` would typically involve the following tasks:

  * Choose one among of the provided `TerseHandling` *Agents* (extending it if necessary) and attach to it an event listening mechanism.
  * Reduce (hardware or software) input events into their `TerseHandling` counterparts.
  * Choose a callback mechanism: direct actionless approach (non-generic programming), or high-level action-driven (which extensively uses generic programming). In the latter case:
    * Define *shortcuts* over `TerseHandling` events to trigger different actions using *Profiles*.
    * Implement the actions to be performed by object grabbers.
    
for details please refer to our [[wiki|https://github.com/remixlab/tersehandling/wiki]]

`TerseHandling` is a full-fledged, stand-alone library which will become the new event backend for the upcoming Proscene-2 series,
but can also backed up the event sub-system of any other third party *Java* or *Processing* library.
