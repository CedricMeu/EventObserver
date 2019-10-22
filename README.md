# EventObserver
An implementation of the observer pattern combined with events

## Events
Events are the classes emited by Subjects. 
To make an event just create a class that implements `Event`.

```java
class NameChangedEvent implements Event {
  private String name;
  public NameChangedEvent(String name) { this.name = name; }
  public String getName() { return this.name; }
}
```

```java
class CityChangedEvent implements Event {
  private String city;
  public CityChangedEvent(String city) { this.city = city; }
  public String getCity() { return this.city; }
}
```

## Subjects
Subjects can emit events through the `emit` function. 
A subject can emit different events.

```java
class Person extends Subject {
  public String name;
  public String city;
  
  public Person(String name, String city) { 
    this.name = name;
    this.city = city;
  }
  
  public void setName(String name) { 
    this.name = name;
    emit(new NameChangedEvent(this.name));
  }
  
  public void setCity(String city) {
    this.city = city;
    emit(new CityChangedEvent(this.city));
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
  
  public void listener(CityChangedEvent e) {
    System.out.println("City changed: " + e.getCity());
  }
}
```

## Connecting Subjects and Observers

```java
static void main(String[] args) {
  // create the Subject
  Person person = new Person("Foo Bar", "New York");
  
  // create the Observer
  PersonLogger logger = new PersonLogger();
  
  // connect the Observer to the Subject
  person.addObserver(logger);
  
  // call a function in the Subject that emits an Event
  person.setName("John Doe");
  person.setCity("Brussels");
}
```
