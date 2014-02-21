TerseHandling.js
================

# Description

`TerseHandling` is a framework designed for _sketching_ generic input events, i.e., transforming input events into high-level user-defined actions,
mainly implemented using [generic programming techniques](http://en.wikipedia.org/wiki/Generics_in_Java).
It provides its own set of events which supports up to [6-DOFs]( http://en.wikipedia.org/wiki/Degrees_of_freedom_(mechanics) ),
together with a set of *agents* which parses them, i.e., identifies object *grabbers* and the *actions* they should perform,
allowing the developer to focus on implementing those actions. A developer workflow using `TerseHandling` would typically involve the following tasks:

  * Choose one among of the provided `TerseHandling` *Agents* (extending it if necessary) and attach to it an event listening mechanism.
  * Reduce (hardware or software) input events into their `TerseHandling` counterparts.
  * Choose a callback mechanism: direct actionless approach (non-generic programming), or high-level action-driven (which extensively uses generic programming). In the latter case:
    * Define *shortcuts* over `TerseHandling` events to trigger different actions using *Profiles*.
    * Implement the actions to be performed by object grabbers.
    
for details please refer to our [wiki](https://github.com/remixlab/tersehandling/wiki)

`TerseHandling` is a full-fledged, stand-alone library which will become the new event backend for the upcoming Proscene-2 series,
but can also backed up the event sub-system of any other third party *Java* or *Processing* library.

# Usage

# Hacking

## Initial setup (you don't need this!)

First (and only) time setup. This is just for documentation purposes. Please visit the next sections.

```sh
git clone https://github.com/remixlab/tersehandling.js.git
cd tersehandling.js
git remote add -f tersehandling https://github.com/remixlab/tersehandling_tree.git
git subtree add --prefix src/remixlab/tersehandling tersehandling master --squash
git remote add -f util https://github.com/remixlab/util_tree.git
git subtree add --prefix src/remixlab/util util master --squash
git remote add -f processing.js https://github.com/remixlab/processing.js_tree.git
git subtree add --prefix src/processing processing.js master --squash
```

## Read-only access setup

Use it as any other basic github repo, i.e.,:

```sh
# clone it:
git clone https://github.com/remixlab/tersehandling.js.git
cd tersehandling.js
# pull changes in:
# for pull requests simply refer to: https://help.github.com/articles/using-pull-requests
```

## Read-write access setup

Clone the repo and add the remotes (here we refer to them as ["subtrees"](http://blogs.atlassian.com/2013/05/alternatives-to-git-submodule-git-subtree/)):

```sh
git clone https://github.com/remixlab/tersehandling.js.git
cd tersehandling.js
git remote add -f tersehandling https://github.com/remixlab/tersehandling_tree.git
git remote add -f util https://github.com/remixlab/util_tree.git
git remote add -f processing.js https://github.com/remixlab/processing.js_tree.git
```

Update from time to time:

```sh
#fetching command:
git fetch <remote> master
git subtree pull --prefix src/remixlab/<remote> <remote> master --squash
```

To contribute back to upstream:

```sh
git push
```

To contribute to a particular remixlab subtree (i.e., tersehandling, or util)

```sh
git subtree push --prefix=src/remixlab/<remote> <remote> master
```

To contribute to the processsing.js subtree

```sh
git subtree push --prefix=src/processing processing.js master
```

##  Compiling and export to Javascript  ##

**GWT**

You must have [Google Web Toolkit](http://www.gwtproject.org/) , either GWT SDK or Eclipse GWT plugin. You must be sure that the project is using GWT, select 
project properties -> Google -> Web Toolkit -> Use Google Web Toolkit, in Eclipse.

You must resolve the external jar library references, configuring the Libraries tab in the Java build path option on your Eclipse IDE.

Choosing  the external jar entry, you must select it on the local folder  
   

> tersehandling.js/lib
    
**GWT XML**

All code to export must be in a Gwt Module, a module consists of the java packages and classes, and a gwt xml where are appointed the java packages to export.
The default xml is :

> tersehandling.js\src\remixlab\tersehandling\tersehandling.gwt.xml

For example the entry in the xml

    <source path="core"/>

refers to the java package

> tersehandling.js\src\remixlab\tersehandling\core

The xml must be located one folder up of the java packages.
The xml module can refer to others gwt modules, more info on [here](http://www.gwtproject.org/doc/latest/DevGuideOrganizingProjects.html#DevGuideModuleXml)

**Exporting**

Selecting the project by right-clicking and choosing Google > GWT Compile.


##  Run, modify and create examples  ##


You can see running the examples running the html file in the war folder, to modify and create the examples 
you must have [ProcessingStub](https://github.com/remixlab/ProcessingStub) and  resolve references, (external jars).
 

**BoringClickAndDrag - js developer example**

you can go to the file
> tersehandling.js\examples\BoringClickAndDrag\war\Boring.html

And run or modify the processing js sketch example witout export to js, the sketch objects like agent, terseHandler and circles were export to js. 

If youy want create new sketch objects, you cant create it  on the package

> tersehandling.js\examples\BoringClickAndDrag\src\unal\client

later on the class

> tersehandling.js\examples\BoringClickAndDrag\src\unal\client\ExporterFacade.java

You must add the class and methods for export.
You can see how do on [here](https://code.google.com/p/gwt-exporter/)
The class must have a empty params  contrusctor.


Later you must export the project to javascript and you can use the objects in Boring.html. 

**ActionDrivenCallback - complete java developer example**
you can go to the file
> tersehandling.js\examples\ActionDrivenCallback\war\ActionDrivenCallback.html

And run the example,  there is a wrapper of the sketch called ActionDrivenCallback, 
 if you want modify the sketch or create new objects, you must do it in java and export to js.


On the file

> tersehandling.js\examples\ActionDrivenCallback\src\main\client\ActionDrivenCallback.java

you can modify the sketch, if you create a new method, you must add it to the abstract class ActionDrivenCallbackFacade  in the file

> tersehandling.js\examples\ActionDrivenCallback\src\main\client\ExporterFacade.java

if you create new objects  for the sketch, it is not necessary to add the ExporterFacade.java, because the only thing that need to run is the ActionDrivenCallbackFacade

# Acknowledgements

Cesar Colorado for the js port.

# Author, core developer and maintainer

[Jean Pierre Charalambos](http://disi.unal.edu.co/profesores/pierre/), [National University of Colombia](http://www.unal.edu.co)
