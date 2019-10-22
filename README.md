# EventObserver
An implementation of the observer pattern combined with events

## Events
Events are the classes emited by Subjects. 
To make an event just crate a class that implements `Event`.

```java
class NameChangedEvent implements Event {
  private String name;
  public MessageEvent(String name) { this.name = name; }
  public String getName() { return this.name; }
}
```

## Subjects
Subjects can emit events through the `emit` function. 
A subject can emit different events.

```java
class Person extends Subject {
  public String name;
  
  public Person(String name) { this.name = name; }
  
  public void setName(String name) { 
    this.name = name;
    emit(new NameChangedEvent(this.name));
  }
}
```

## Observers
Observers can implement `listener` functions with 
different Events as argument types. Only the listener
that accepts the passed `Event` will then be called.

```java
class PersonLogger implements Observer {
  public void listener(NameChangedEvent e) {
    System.out.println("Name changed: " + e.getName());
  }
}
```

## Connecting Subjects and Observers

```java
static void main(String[] args) {
  // create the Subject
  Person person = new Person("Foo Bar");
  
  // create the Observer
  PersonLogger logger = new PersonLogger();
  
  // connect the Observer to the Subject
  person.addObserver(logger);
  
  // call a function in the Subject that emits an Event
  person.setName("John Doe");
}
```
