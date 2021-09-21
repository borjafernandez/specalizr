<p align="center">
  <img width="100rem" src="./api/src/main/resources/logo.svg" />
</p>

# Specalizr

An implementation and platform agnostic, human-readable visual test scenario definition [DSL](./api).

![Full-build CI](https://github.com/borjafernandez/specalizr/actions/workflows/full-build.yaml/badge.svg)

## Project Goal :

Enable visual scenario ATDD in Java. Allow software producers and integrators to deliver E2E / front-end tests with
wireframes.

Streamline collaboration between all project stakeholders.

Example for a google unit conversion use case :

<p align="center">
  <img src="./selenium/src/main/resources/google-test.png" />
</p>

``` java
        final var leftField = field(leftOf(item(with(text("=")))), below(selector(with(text("Length")))));
        final var rightField = field(rightOf(leftField));
        final var actions = first(click(item(with(text("I agree")))))
                .then(write("unit converter").into(field(above(button(with(text("Google Search")))))))
                .then(press(ENTER))
                .then(select("Mile").from(selector(with(text("Meter")))))
                .then(select("kilometre").from(selector(with(text("Centimeter")))))
                .then(clear(leftField))
                .then(write("50").into(leftField))
                .andLastly(validate(that(rightField), containsText("80.4672")));

        play(actions, with(seleniumPlayer));
```

## Concepts

### Action

A command to be performed on a given element (i.e. press, select, write, clear, ...)

### ActionChain

A list of chained actions representing a test scenario

### Element

Represents a visual component (i.e. button, select, checkbox, link, text ...)

### Query

Describes how to find an element (i.e. with(text("Length")) ... rightOf(item(with(text(...)))))

### Player

A component that takes an Action chain and plays it against any given platform (web, mobile, desktop ...)

## How to

### Define a scenario

Start with the "first" keyword. It will instantiate an ActionChain and will act as a scenario builder.

You can then chain actions aka ActionDefinition by using "then" keyword.

``` java

      first(click(item(with(text("I agree")))))
        .then(write("unit converter").into(field(above(button(with(text("Google Search")))))))
        .then(press(ENTER))
        ...
        ...
        .andLastly(validate(that(rightField), containsText("80.4672")));

```


### Execute a scenario

Once you have defined a scenario, you can play it using an ActionDefinitionPlayerRegistry. This registry is responsible for providing players for ActionDefinition instances.

``` java
        play(actions, with(seleniumPlayer));
```

### Extend the framework

#### New command

In order to create a new command you need to implement ActionDefinition interface 

Check api for examples

``` java
public class WriteActionDefinition<T extends Writable> implements ActionDefinition 
```


#### New element

In order to create a new element you need to extend ElementBase class

Check api for examples

``` java
public class Button extends ElementBase implements Clickable 
```


#### New query component
In order to create a new query component you need to extend ElementQueryComponent class

Check api for examples

``` java
public class TextQueryComponent extends ElementQueryComponent {
```


## Implementations

There is currently a [Selenium](./selenium) implementation available. 


