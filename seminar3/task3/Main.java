package seminar3.task3;

class Counter implements AutoCloseable {
  private Integer count;

  Counter() {
    this.count = 0;
  }

  public Integer getCount() throws Exception {
    if (this.count == null) {
      throw new UnsupportedOperationException("Unimplemented method 'close'");
    }
    return count;
  }

  public void add() throws Exception {
    if (this.count == null) {
      throw new UnsupportedOperationException("Unimplemented method 'close'");
    }
    this.count++;
  }

  @Override
  public void close() throws Exception {
    if (this.count != null) {
      this.count = null;
    } else {
      throw new UnsupportedOperationException("Unimplemented method 'close'");
    }
  }

}

public class Main {
  public static void main(String[] args) {
    try (Counter count = new Counter();) {
      count.add();
      System.out.println(count.getCount());
      count.close();
      count.add();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}

// Задание №2
// Создайте класс Счетчик, у которого есть метод add(), увеличивающий
// значение внутреннейint переменнойна 1.Сделайте так, чтобы с объектом
// такого типа можно было работать в блоке try-with-resources. Нужно бросить
// исключение, еслиработа с объектом типа счетчикбылане в ресурсномtry
// и/или ресурс остался открыт.Подумайте какой тип исключения подойдет
// лучше всего.
