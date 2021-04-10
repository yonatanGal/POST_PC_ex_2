package android.exercise.mini.calculator.app;

import java.io.Serializable;

public class SimpleCalculatorImpl implements SimpleCalculator {
  private String curScreen = "";
  private final String plus = "+";
  private final String minus = "-";


  @Override
  public String output() {
    // todo: return output based on the current state
    if (this.curScreen.length() == 0)
    {
      return "0";
    }
    else
    {
      return this.curScreen;
    }

  }

  @Override
  public void insertDigit(int digit) {
    if (digit < 0 || digit > 9)
    {
      throw new RuntimeException();
    }
    if (output().equals("0") && digit == 0)
    {
      return;
    }
    if (this.curScreen.length() > 0 && digit == 0)
    {
      String lastDigit = this.curScreen.substring(this.curScreen.length() - 1);
      if (lastDigit.equals(this.plus) || lastDigit.equals(this.minus))
      {
        return;
      }
    }
    this.curScreen = this.curScreen + digit;
  }

  @Override
  public void insertPlus() {
    if (this.curScreen.length() == 0)
    {
      this.curScreen = "0+";
    }
    else
    {
      String lastDigit = this.curScreen.substring(this.curScreen.length() - 1);
      if (!lastDigit.equals(this.minus) && !lastDigit.equals(this.plus))
      {
        this.curScreen = this.curScreen + this.plus;
      }
    }
  }

  @Override
  public void insertMinus() {
    if (this.curScreen.length() == 0)
    {
      this.curScreen = "0-";
    }
    else
    {
      String lastDigit = this.curScreen.substring(this.curScreen.length() - 1);
      if (!lastDigit.equals(this.minus) && !lastDigit.equals(this.plus))
      {
        this.curScreen = this.curScreen + this.minus;
      }
    }
  }


  /**
   * a method to remove unnecessary operations from the end of the output or a minus from the
   * beginning
   */
  private void parseCurScreen(String lastDigit, char firstDigit)
  {
    if (lastDigit.equals(this.plus) || lastDigit.equals(this.minus))
    {
      this.curScreen = this.curScreen.substring(0, this.curScreen.length() - 1);
    }
    if (firstDigit == '-')
    {
      this.curScreen = this.curScreen.substring(1);
    }
  }

  /**
   * a method to calculate the result when calling insertEquals
   * @return the result as a String
   */
  private String calculateResult()
  {
    String lastDigit = this.curScreen.substring(this.curScreen.length() - 1);
    char firstDigit = this.curScreen.charAt(0);
    parseCurScreen(lastDigit, firstDigit);
    String[] resultList = this.curScreen.split("(?<=[-+])|(?=[-+])");
    int result = Integer.parseInt(resultList[0]);
    if (firstDigit == '-')
    {
      result = -result;
    }
    for (int i = 1; i < resultList.length; i += 2)
    {
      int num = Integer.parseInt(resultList[i + 1]);
      String operator = resultList[i];
      if (operator.equals(this.plus))
      {
        result += num;
      }
      else
      {
        result -= num;
      }
    }
    return String.valueOf(result);
  }

  @Override
  public void insertEquals() {
    if (this.curScreen.length() == 0)
    {
      this.curScreen = "0";
    }
    else
    {
      this.curScreen = calculateResult();
    }
  }


  @Override
  public void deleteLast() {
    if (this.curScreen.length() == 0)
    {
      return;
    }
    this.curScreen = this.curScreen.substring(0, this.curScreen.length() - 1);
  }

  @Override
  public void clear() {
    this.curScreen = "";
  }

  @Override
  public Serializable saveState() {
    CalculatorState state = new CalculatorState();
    state.settCurScreen(this.curScreen);
    return state;
  }

  @Override
  public void loadState(Serializable prevState) {
    if (!(prevState instanceof CalculatorState)) {
      return; // ignore
    }
    CalculatorState casted = (CalculatorState) prevState;
    this.curScreen = casted.getCurScreen();
  }

  private static class CalculatorState implements Serializable {
    private String curScreen = "";

    public void settCurScreen(String res)
    {
      this.curScreen = res;
    }

    public String getCurScreen()
    {
      return this.curScreen;
    }

  }
}
