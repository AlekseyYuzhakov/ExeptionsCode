package seminar3.task4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class DividedByZero extends ArithmeticException {
  DividedByZero() {
    super("Деление на ноль запрещено");
  }
}

class IndexOutOfBoundries extends ArrayIndexOutOfBoundsException {
  IndexOutOfBoundries() {
    super("Выход за пределы массива ");
  }

  IndexOutOfBoundries(int arg) {
    super("Выход за пределы массива при обращенни к аргументу с индексом " + arg);
  }
}

class FilenotFound extends FileNotFoundException {
  FilenotFound() {
    super("Файл не найден ");
  }

  FilenotFound(String path) {
    super("Файл не найден по пути " + path);
  }
}

public class Main {
  public static void main(String[] args) throws FilenotFound {
    int a = 5;
    int b = 0;
    try {
      int c = div(a, b);

    } catch (DividedByZero e) {
      System.out.println(e.getMessage());
    }
    int[] array = new int[2];
    try {
      if (indexcheck(array.length, 3)) {
        array[3] = 5;
      }
    } catch (IndexOutOfBoundries e) {
      System.out.println(e.getMessage());
    }
    String path = "123";
    try (FileReader in = new FileReader(path)) {
      in.close();

    } catch (FileNotFoundException e) {
      throw new FilenotFound(path);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static int div(int a, int b) {
    if (b == 0) {
      throw new DividedByZero();
    }
    return a / b;
  }

  public static boolean indexcheck(int arraySize, int index) {
    if (index >= arraySize) {
      throw new IndexOutOfBoundries(index);
    }
    return true;
  }
}

// Задание №3
// 1. Создайтеклассисключения, который будет выбрасываться при делениина
// 0. Исключениедолжно отображать понятноедля пользователя сообщение
// об ошибке.
// 2. Создайте классисключений, которое будет возникать при обращении к
// пустому элементув массиве ссылочного типа. Исключение должно
// отображать понятное для пользователя сообщениеоб ошибке
// 3. Создайте классисключения, которое будет возникать при попытке открыть
// несуществующий файл. Исключение должно отображать понятное для
// пользователя сообщение об ошибке.
