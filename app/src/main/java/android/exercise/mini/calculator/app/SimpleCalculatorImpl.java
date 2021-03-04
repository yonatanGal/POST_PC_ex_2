package android.exercise.mini.calculator.app;

import java.io.Serializable;

public class SimpleCalculatorImpl implements SimpleCalculator {

  // todo: add fields as needed

  @Override
  public String output() {
    // todo: return output based on the current state
    return "implement me please";
  }

  @Override
  public void insertDigit(int digit) {
    // todo: insert a digit
  }

  @Override
  public void insertPlus() {
    // todo: insert a plus
  }

  @Override
  public void insertMinus() {
    // todo: insert a minus
  }

  @Override
  public void insertEquals() {
    // todo: calculate the equation
  }

  @Override
  public void deleteLast() {
    // todo: if the last user action was to add a digit, + or -, delete it
  }

  @Override
  public void clear() {
    // todo: clear everything
  }

  @Override
  public Serializable saveState() {
    CalculatorState state = new CalculatorState();
    // todo: insert all data to the state, so in the future we can load from this state
    return state;
  }

  @Override
  public void loadState(Serializable prevState) {
    if (!(prevState instanceof CalculatorState)) {
      return; // ignore
    }
    CalculatorState casted = (CalculatorState) prevState;
    // todo: use the CalculatorState to load
  }

  private static class CalculatorState implements Serializable {
    /*
    TODO: add fields to this class that will store the calculator state
    all fields must only be from the types:
    - primitives (e.g. int, boolean, etc)
    - String
    - ArrayList<> where the type is a primitive or a String
    - HashMap<> where the types are primitives or a String
     */
  }
}
