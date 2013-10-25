Robotium-Sandwich
=================

Create beatifully abstract UI automation tests for Android apps


Introduction
------------

Building large and scalable test suites using Robotium can be a challenging task. Without a carefuly designed abstraction 
library, one can quickly end up with tests that are impossible to maintain, difficult to expand and full of a boiler-plate 
code. 
Robotium-Sandwich is a library that sits on top of Android instrumentation and Robotium that addresses this problem.
Robotium-Sandwich makes it super easy to create page object like definitions for different screens of your app and to write
abstract tests free of boiler-plate.


Concept
-------

Robotium-Sandwich test suite is broken into two parts: screen definition classes and tests themselves. Every screen class
maps to different screen of your app and contains definitions of widgets in that screen. This approach (similar to
a page object pattern) allows you to write tests that treat different screens as objects and their widgets as object 
properties. What's unique about Sandwich is that you don't have to find and retrieve a specific widget every time
your test code needs to interact with it. 
A quick examples will make it all much clearer, consider a following screen:

<TBD>

A complete Sandwich definition for this screen is as simple as the following skeleton class:

```java
public class StuffScreen extends AScreen {

	public StuffScreen() {
		super(StuffActivity.class);
	}
	
	@AIndex(0)
	public ARadioButton radio1;
	
	@AIndex(1)
	public ARadioButton radio2;
	
	@AId(com.appthwack.sampleapp.R.id.sample_edittext)
	public AEditText sample_edittext;
	
	@AText("Do more stuff")
	public AButton do_more_stuff;
	
	@AId(com.appthwack.sampleapp.R.id.my_spinner)
	public ASpinner my_spinner;

}
```

With the screen definition in place you can quickly write an abstract script that might look like this:

```java
	public void testStuff(){
	

		StuffScreen stuffScreen = new StuffScreen();
		stuffScreen.my_spinner.selectItemAt(1);
		stuffScreen.radio2.click();
		stuffScreen.sample_edittext.enterText("Some stuff")
		stuffScreen.do_more_stuff.click();

	}
```

Robotium-Sandwich does the rest of the work behind the scenes. It will find and retrieve a widget associated with a given
widget field (i.e. stuffScreen.do_more_stuff will map to a view of Button type with "Do more stuff" text) and it will
perform a requested action on that widget (using a familar Robotium implementation in most cases).


Screen classes
--------------

Robotium-Sandwich screen classes are very easy to define. Simply derive your class from AScreen, pass a target activity
class to a default constructor and define any number of widgets as public fields. Every widget field has to be of a type that derives from AView and is typically annotated with one more @A* identifiers. If no identifier is provided, Sandwich will associate a field with a first occurence of widget of a given type (@(AIndex(0) is a default identifier).


Widgets and identifiers
-----------------------

The library comes with a number of predefined widget types that map to different Android view classes. A complete list can be found at <TBD>. The developer can also create his/her own Sandwich widgets by deriving from AView (or any of its
derivaties) and implementing a relevant functionality using raw instrumentation or Robotium (more information in Misceallnous section).
Sandwich also comes with a wide range of widgets identifiers used to associate a widget field with an actual instance of an
Android view:
* **@AId** - uses anid to find a view. The least verbose and preffered if application source code is available. Can be combined
with @AClass and/or @AIndex.
* **@AIdName** - uses a view id name string and resolves it into an actual resource id, useful when working without the application source code. Can be combined with @AClass and/or @AIndex.
* **@AText** - find a view by text. Can be be combined with @AClass.
* **@AClass** - narrows down a target view type. Can be used alone or in combinations with other identifiers. If @AClass is not present, Sandwich will default to an Android view class associated with a field type.
* **@AIndex** - narrows down a search if multiple matches are present. Can be used alone or in combination with AId, AIdName and/or AClass


WebView support
---------------

Sandwich supports automating WebView elements as well. Just use AWebElement as your widget field type and use one of the following 
identifiers:
* **@AName** - finds an element by its name.
* **@CssSelector** - finds an element by a valid CSS selector string.


Instrumentation and Robotium access
-----------------------------------

You can access both Solo and instrumentation objects via *SoloFactory.getSolo* and *SoloFactory.getInstrumentation* class methods. This can be helpful when taking screenshots in your test (*SoloFactory.getSolo.takeScreenshot()*) as well as when creating you own Sandwich widget types by deriving from AView class.


Logging and settings
--------------------

By default, Robotium-Sandwich will log its internal operations to a device/emulator logcat under 'Sandwich' tag. You can append your own 'Sandwich' log messages by calling class methods on SandwichLog helper class.
Selected settings of the framework are exposed via SandwichSettings library:
* **setDebugLoggingEnabled** - disables/enables internal debug logs. True by default.
* **setAutomaticAssertsEnabled** - disables/enables automatic asserts for certain conditions including view not found, view found but of a wrong type, activity not curent etc. Trye by default.
* **setAutomaticWaitEnabled** - disables/enables automatic wait for views and activities. When set to false, Robotium-Sandwich will not assert if a desired view or activity is present. True by default.
* **setWaitTime** - sets a timeout (in milliseconds) used when waiting for a desired view or activity. 5000ms by default.











