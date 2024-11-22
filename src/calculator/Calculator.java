package calculator;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Calculator {

  public String getAverage(ArrayList<Course> courses) {
    int sum = 0;
    int credits = 0;

    for (Course course : courses) {
      sum += course.courseMark() * course.getCredits();
      credits += course.getCredits();
    }

    System.out.println("Suma: " + sum);
    System.out.println("Creditos: " + credits);

    double average = sum / credits;

    System.out.println("Promedio: " + average);

    if (average == 1.5) {
      return "No aprobado, nota minima";
    }

    if (average < 3) {
      return "No aprobado, insuficiente";
    }

    if (average < 3.5) {
      return "Aprobado, suficiente";
    }

    if (average < 4) {
      return "Aprobado, satisfactorio";
    }

    if (average < 4.5) {
      return "Aprobado, bueno";
    }

    return "Aprobado, excelente";
  }

  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    Course math = new Course("Matematicas", 3, 5.0);
    Course physics = new Course("Fisica", 3, 4.5);
    Course chem = new Course("Quimica", 2, 3.0);
    Course programming = new Course("Programacion", 3, 5.0);

    ArrayList<Course> courses = new ArrayList<Course>();

    Random rand = new Random();

    final Map<Integer, Course> PREDEFINED_COURSES = Map.of(
        1, math,
        2, physics,
        3, chem,
        4, programming);

    for (int i = 0; i < rand.nextInt(10); i++) {
      Course course = PREDEFINED_COURSES.getOrDefault(
          i,
          new Course("CBU", 2, rand.nextDouble(5.0)));
      courses.add(course);
    }

    System.out.println(calculator.getAverage(courses));
  }
}
