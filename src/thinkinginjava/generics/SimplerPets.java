
package thinkinginjava.generics;

import java.util.List;
import java.util.Map;

import thinkinginjava.typeinfo.pets.Person;
import thinkinginjava.typeinfo.pets.Pet;
import thinkinginjava.util.New;

public class SimplerPets {
  public static void main(String[] args) {
    Map<Person, List<? extends Pet>> petPeople = New.map();
    // Rest of the code is the same...
  }
} ///:~
