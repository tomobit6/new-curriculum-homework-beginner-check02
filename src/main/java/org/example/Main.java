package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    System.out.println("問題2");
    Student student1 = new Student("佐藤一郎", 50);
    Student student2 = new Student("鈴木次郎", 85);
    Student student3 = new Student("山田三郎", 35);
    Student student4 = new Student("佐々木四郎", 60);
    Student student5 = new Student("後藤花子", 74);

    List<Student> studentList = new ArrayList<>(
        List.of(student1, student2, student3, student4, student5));

    while (true) {
      Scanner scanner = new Scanner(System.in);
      try {
        System.out.println("-------------------------------");
        System.out.println("1.学生の追加");
        System.out.println("2.学生の削除");
        System.out.println("3.点数の更新");
        System.out.println("4.平均点を計算");
        System.out.println("5.全学年の情報を表示");
        System.out.println("6.終了");
        System.out.println("選択してください:");
        int number = scanner.nextInt();
        scanner.nextLine();  //改行消費　nextIntが改行文字を残すため。33行目は一度空で34行目で判定される。

        switch (number) {
          case (1):
            System.out.println("学生の名前を入力してください:");
            String addName = scanner.nextLine();
            if (!addName.isEmpty()) {
              System.out.println(addName + "の点数を入力してください:");
              int addScore = scanner.nextInt();
              scanner.nextLine();  // 改行を消費
              studentList.add(new Student(addName, addScore));
            }
            break;

          case (2):
            System.out.println("1.学生情報をすべて削除");
            System.out.println("2.学生を選んで削除");
            System.out.println("選択してください:");
            int removeNumber = scanner.nextInt();
            scanner.nextLine();
            if (removeNumber == 1) {
              studentList.clear();
            } else if (removeNumber == 2) {
              System.out.println("学生の番号を選択してください:");
              int studentNumber = scanner.nextInt();
              scanner.nextLine();
              studentList.remove(studentNumber - 1);
            } else {
              System.out.println("正しい数字を入力してください。");
            }
            break;

          case (3):
            System.out.println("学生の番号を選択してください:");
            int studentNumber = scanner.nextInt() - 1; //配列は0から
            scanner.nextLine();
            if (studentNumber < studentList.size()) {
              Student studentToUpdate = studentList.get(studentNumber);
              System.out.println(studentToUpdate.getName() + "の点数を入力してください:");
              int studentScore = scanner.nextInt();
              scanner.nextLine();
              studentToUpdate.setScore(studentScore);
            } else {
              System.out.println("正しい数字を入力してください。");
            }
            break;

          case (4):
            double average = studentList.stream()
                .mapToDouble(Student::getScore)
                .average()
                .orElse(0.0);
            System.out.println(average);
            break;

          case (5):
            for (Student student : studentList) {
              System.out.println(student);
            }
            break;

          case (6):
            System.out.println("プログラムを終了します。");
            scanner.close();
            return;

          default:
            System.out.println("正しい数字を入力してください。");
            break;
        }
      } catch (InputMismatchException e) {
        System.out.println("無効な入力です。正しい数字を入力してください。");
        scanner.nextLine();
      }
    }
  }
}


