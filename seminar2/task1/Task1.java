package seminar2.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
  public static void main(String[] args) {
    String path = "D:\\GBru\\Учеба\\Exception\\ExeptionsCode\\seminar2\\task1\\test.txt";
    List<String[]> list = readFile(path);
    checkMass(list);
    try {
      writeFile(list, path);
    } catch (Exception e) {

    }
  }

  public static void checkMass(List<String[]> arr) {
    for (String[] elem : arr) {
      if (elem[1].equals("?")) {
        elem[1] = String.valueOf(elem[0].length());
        // System.out.println(elem[0]);
      } else if (!isNumber(elem[1])) {
        System.out.println("Не число ");
      }

    }
  }

  public static boolean isNumber2(String str) {
    String string = "0123456789";
    for (char elem : str.toCharArray()) {
      if (!string.contains(String.valueOf(elem))) {
        return false;
      }
    }
    return true;

  }

  public static boolean isNumber(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static List<String[]> readFile(String path) {
    List<String[]> temp = new ArrayList<String[]>();
    try {
      String tempString = "";
      BufferedReader file = new BufferedReader(new FileReader(path));
      while ((tempString = file.readLine()) != null) {
        temp.add(tempString.split("="));
      }
      file.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return temp;
  }

  public static void writeFile(List<String[]> arr, String path) throws IOException {

    BufferedWriter writer = new BufferedWriter(new FileWriter(path));
    for (String[] strings : arr) {
      writer.write(strings[0] + "=" + strings[1] + "\n");
    }
    writer.close();

  }

}
