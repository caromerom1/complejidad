package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Calculator {

  private record GradeThreshold(double threshold, String message) {
  }

  private static final List<GradeThreshold> GRADES = List.of(
      new GradeThreshold(4.5, "Aprobado, excelente"),
      new GradeThreshold(4.0, "Aprobado, bueno"),
      new GradeThreshold(3.5, "Aprobado, satisfactorio"),
      new GradeThreshold(3.0, "Aprobado, suficiente"));

  public String getAverage(ArrayList<Course> courses) {
    int sum = 0;
    int credits = 0;

    for (Course course : courses) {
      sum += course.courseMark() * course.getCredits();
      credits += course.getCredits();
    }

    double average = sum / credits;

    if (average == 1.5) {
      return "No aprobado, nota minima";
    }

    for (GradeThreshold grade : GRADES) {
      if (average >= grade.threshold) {
        return grade.message;
      }
    }

    return "No aprobado, insuficiente";
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
