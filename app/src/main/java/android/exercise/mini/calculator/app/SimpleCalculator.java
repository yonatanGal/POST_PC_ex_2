package android.exercise.mini.calculator.app;

import java.io.Serializable;

public interface SimpleCalculator {
  String output();
  void insertDigit(int digit);
  void insertPlus();
  void insertMinus();
  void insertEquals();
  void deleteLast();
  void clear();
  Serializable saveState();
  void loadState(Serializable prevState);
}
