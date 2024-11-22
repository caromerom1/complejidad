package calculator;

class Course {

  String name;
  int credits;
  double mark;

  public Course(String name, int credits, double mark) {
    this.name = name;
    this.credits = credits;
    this.mark = mark;
  }

  public int getCredits() {
    return this.credits;
  }

  public double courseMark() {
    return this.mark;
  }

  public String courseName() {
    return this.name;
  }
}
