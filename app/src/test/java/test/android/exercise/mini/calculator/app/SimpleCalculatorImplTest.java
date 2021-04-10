package test.android.exercise.mini.calculator.app;

import android.exercise.mini.calculator.app.SimpleCalculatorImpl;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class SimpleCalculatorImplTest {

  @Test
  public void when_noInputGiven_then_outputShouldBe0(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    assertEquals("0", calculatorUnderTest.output());
  }

  @Test
  public void when_inputIsPlus_then_outputShouldBe0Plus(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertPlus();
    assertEquals("0+", calculatorUnderTest.output());
  }


  @Test
  public void when_inputIsMinus_then_outputShouldBeCorrect(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertMinus();
    String expected = "0-"; // TODO: decide the expected output when having a single minus
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_callingInsertDigitWithIllegalNumber_then_exceptionShouldBeThrown(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    try {
      calculatorUnderTest.insertDigit(357);
      fail("should throw an exception and not reach this line");
    } catch (RuntimeException e) {
      // good :)
    }
  }


  @Test
  public void when_callingDeleteLast_then_lastOutputShouldBeDeleted(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(9);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertMinus(); // does nothing
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.deleteLast();
    String expected = "9+";
    assertEquals(expected, calculatorUnderTest.output());

    calculatorUnderTest.deleteLast();
    expected = "9";
    assertEquals(expected, calculatorUnderTest.output());

    calculatorUnderTest.deleteLast();
    expected = "0";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_callingClear_then_outputShouldBeCleared(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(9);
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.clear();
    String expected = "0";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_savingState_should_loadThatStateCorrectly(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    // give some input
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(7);

    // save current state
    Serializable savedState = calculatorUnderTest.saveState();
    assertNotNull(savedState);

    // call `clear` and make sure calculator cleared
    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());

    // load the saved state and make sure state was loaded correctly
    calculatorUnderTest.loadState(savedState);
    assertEquals("5+7", calculatorUnderTest.output());
  }

  @Test
  public void when_savingStateFromFirstCalculator_should_loadStateCorrectlyFromSecondCalculator(){
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();

    firstCalculator.insertDigit(9);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(8);
    firstCalculator.insertEquals();
    Serializable savedState = firstCalculator.saveState();

    secondCalculator.loadState(savedState);
    assertEquals("17", secondCalculator.output());
  }

  @Test
  public void complexUsage1()
  {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(9);
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertEquals();
    assertEquals("95", calculatorUnderTest.output());

    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertEquals();
    assertEquals("95", calculatorUnderTest.output());
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(5);
    assertEquals("95+5", calculatorUnderTest.output());
    calculatorUnderTest.insertEquals();
    assertEquals("100", calculatorUnderTest.output());
  }

  @Test
  public void complexUsage2()
  {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(0);
    assertEquals("0", calculatorUnderTest.output());
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(9);
    calculatorUnderTest.insertEquals();
    assertEquals("-1", calculatorUnderTest.output());

    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(8);
    assertEquals("-1-8", calculatorUnderTest.output());
    calculatorUnderTest.insertEquals();
    assertEquals("-9", calculatorUnderTest.output());
  }

  @Test
  public void complexUsage3()
  {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.deleteLast();
    assertEquals("5+8-1", calculatorUnderTest.output());
    calculatorUnderTest.insertEquals();
    assertEquals("12", calculatorUnderTest.output());
  }

  @Test
  public void complexUsage4()
  {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.deleteLast();
    assertEquals("5+8-1", calculatorUnderTest.output());
    calculatorUnderTest.insertEquals();
    assertEquals("12", calculatorUnderTest.output());
  }

  @Test
  public void complexUsage5()
  {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(1);
    assertEquals("1", calculatorUnderTest.output());
  }

  @Test
  public void complexUsage6()
  {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(9);
    calculatorUnderTest.insertDigit(9);
    calculatorUnderTest.insertDigit(9);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertDigit(2);
    calculatorUnderTest.insertEquals();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertDigit(3);
    assertEquals("-111-333", calculatorUnderTest.output());
  }

  @Test
  public void complexUsage7()
  {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.clear();
    calculatorUnderTest.insertDigit(1);
    assertEquals("1", calculatorUnderTest.output());
  }

  @Test
  public void complexUsage8()
  {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertMinus();
    assertEquals("1+", calculatorUnderTest.output());
  }

  @Test
  public void complexUsage9()
  {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertMinus();
    assertEquals("1+", calculatorUnderTest.output());
  }

  @Test
  public void complexUsage10()
  {
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.deleteLast();
    assertEquals("0", calculatorUnderTest.output());
  }
}