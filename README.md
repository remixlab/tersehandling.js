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

To contribute to a particular subtree (i.e., tersehandling, or util)

```sh
git subtree push --prefix=src/remixlab/<remote> <remote> master
```

# Acknowledgements

Cesar Colorado for the js port.

# Author, core developer and maintainer

[Jean Pierre Charalambos](http://disi.unal.edu.co/profesores/pierre/), [National University of Colombia](http://www.unal.edu.co)
