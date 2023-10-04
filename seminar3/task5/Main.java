package seminar3.task5;

class MyArraySizeException extends RuntimeException {

  MyArraySizeException() {
    super("Массив не 4х4 ");
  }
  MyArraySizeException(int a, int b) {
    super("Массив не 4х4 " + a + "x" + b);
  }
}

class MyArrayDataException extends NumberFormatException {
  MyArrayDataException(int indexI, int indexJ) {
    super("Не удалось преобразовать в число значение массива с индексами: " + indexI + ", " + indexJ);
  }
}

public class Main {
  public static void main(String[] args) {
    String[][] firstArray = { { "1", "2", "3" }, { "1", "2", "3" }, { "1", "2", "3" }, { "1", "2", "3" } };
    String[][] secondArray = { { "1", "2", "3", "a" }, { "1", "2", "3", "4" }, { "1", "2", "3", "4" },
        { "1", "2", "3", "4" } };
    String[][] thirdArray = { { "1", "2", "3", "4" }, { "1", "2", "3", "4" }, { "1", "2", "3", "4" },
        { "1", "2", "3", "4" } };
    try {
      // int a = matrixSum(firstArray);
      // int b = matrixSum(secondArray);
      int c = matrixSum(thirdArray);
      System.out.println(c);
    } catch (MyArraySizeException | MyArrayDataException e) {
      System.out.println(e.getMessage());
    }
  }

  public static Integer matrixSum(String[][] array) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      if (array.length != 4 || array[i].length != 4) {
        throw new MyArraySizeException(array.length, array[i].length);
      }
      for (int j = 0; j < array.length; j++) {
        try {
          sum += Integer.parseInt(array[i][j]);
        } catch (NumberFormatException e) {
          throw new MyArrayDataException(i, j);
        }
      }
    }
    return sum;
  }

}

// Задание №4
// 1. Напишите метод,на вход которогоподаётся двумерный строковый массив
// размером 4х4. При подаче массива другого размера необходимо бросить
// исключение MyArraySizeException.
// 2. Далееметод должен пройтись по всем элементам массива,преобразоватьв
// int и просуммировать. Если в каком-то элементе массива преобразование
// не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException с детализацией, в
// какой именно ячейкележат неверныеданные.
// 3. В методе main() вызвать полученный метод, обработать возможные
// исключения MyArraySizeException и MyArrayDataException и вывести
// результатрасчета (сумму элементов,при условиичто подали на вход
// корректныймассив).
