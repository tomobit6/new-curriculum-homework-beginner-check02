package org.example;

public class Student {

  String name;
  int score;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;

  }

  public void setName(String name) {
    this.name = name;
  }

  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return "名前:" + name + ",点数:" + score;
  }
}
