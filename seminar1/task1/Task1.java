package seminar1.task1;
// Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение. Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:

// если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
// если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
// если вместо массива пришел null, метод вернет -3
// придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
// Напишите метод, в котором реализуйте взаимодействие с пользователем. То есть, этот метод запросит искомое число у пользователя, вызовет первый, обработает возвращенное значение и покажет читаемый результат пользователю. Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.

public class Task1 {
  public static void main(String[] args) {
    Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
    Integer[] arr1 = new Integer[0];
    // System.out.println(getSize(arr, 0));
    // System.out.println(getSize(arr1, 0));
    System.out.println(errorMessage(FindElement(arr, 12)) + "\n");
    System.out.println(errorMessage(FindElement(arr1, 12)) + "\n");

  }

  public static String errorMessage(int errorMessage) {
    String msg = "Индекс первого вхождения = " + errorMessage;
    if (errorMessage == -1) {
      msg = "Длинна массива меншье заданного минимума ";
    } else if (errorMessage == -2) {
      msg = "Искомый элемент не найден";
    } else if (errorMessage == -3) {
      msg = "Массив пустой ";
    }
    return msg;
  }

  public static Integer FindElement(Integer[] arr, Integer element) {
    if (arr == null) {
      return -3;
    }
    if (getSize(arr, 1) < 0) {
      return getSize(arr, 1);
    }
    Integer index = -2;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == element) {
        index = i;
        break;
      }
    }
    return index;
  }

  public static int getSize(Integer[] arr, int min) {
    if (arr.length < min) {
      return -1;
    }
    return arr.length;
  }
}
