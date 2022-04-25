package wk2;

/*
 * Daniel Mogil
 * 01/25/2022
 * Assignment 2. Get You a Cat
 *
 * Prints 6 verses from Bought Me a Cat
 */

public class Song {

  static String verseStart(String animal) {
    return String.format(
      "Bought me a %s and the %<s pleased me,\nI fed my %<s under yonder tree.",
      animal
    );
  }

  static String animalSounds(String animal) {
    StringBuilder sb = new StringBuilder();
    switch (animal.toLowerCase()) {
      case "pig":
        sb.append("Pig goes oink, oink,\n");
      case "sheep":
        sb.append("Sheep goes baa, baa,\n");
      case "goose":
        sb.append("Goose goes hissy, hissy,\n");
      case "duck":
        sb.append("Duck goes quack, quack,\n");
      case "hen":
        sb.append("Hen goes chimmy-chuck, chimmy-chuck,\n");
      case "cat":
        sb.append("Cat goes fiddle-i-fee.");
    }
    return sb.toString();
  }

  static void printVerse(String animal) {
    System.out.println(verseStart(animal));
    System.out.print(animalSounds(animal));
  }

  static void verse1() {
    printVerse("cat");
    System.out.print("\n\n");
  }

  static void verse2() {
    printVerse("hen");
    System.out.print("\n\n");
  }

  static void verse3() {
    printVerse("duck");
    System.out.print("\n\n");
  }

  static void verse4() {
    printVerse("goose");
    System.out.print("\n\n");
  }

  static void verse5() {
    printVerse("sheep");
    System.out.print("\n\n");
  }

  static void verse6() {
    printVerse("pig");
  }

  public static void main(String[] args) {
    verse1();
    verse2();
    verse3();
    verse4();
    verse5();
    verse6();
  }
}
