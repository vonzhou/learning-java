package thinkinginjava.generics;
import java.util.List;
import java.util.Map;

import thinkinginjava.typeinfo.pets.Person;
import thinkinginjava.typeinfo.pets.Pet;
import thinkinginjava.util.New;

public class ExplicitTypeSpecification {
  static void f(Map<Person, List<Pet>> petPeople) {}
  public static void main(String[] args) {
    f(New.<Person, List<Pet>>map());
  }
} ///:~
