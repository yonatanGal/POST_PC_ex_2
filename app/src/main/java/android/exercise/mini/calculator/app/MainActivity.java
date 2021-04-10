package android.exercise.mini.calculator.app;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @VisibleForTesting
  public SimpleCalculator calculator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (calculator == null) {
      calculator = new SimpleCalculatorImpl();
    }

    View clearButton = findViewById(R.id.buttonClear);
    View minusButton = findViewById(R.id.buttonMinus);
    View plusButton = findViewById(R.id.buttonPlus);
    View equalsButton = findViewById(R.id.buttonEquals);
    View backspaceButton = findViewById(R.id.buttonBackSpace);
    View button0 = findViewById(R.id.button0);
    View button1 = findViewById(R.id.button1);
    View button2 = findViewById(R.id.button2);
    View button3 = findViewById(R.id.button3);
    View button4 = findViewById(R.id.button4);
    View button5 = findViewById(R.id.button5);
    View button6 = findViewById(R.id.button6);
    View button7 = findViewById(R.id.button7);
    View button8 = findViewById(R.id.button8);
    View button9 = findViewById(R.id.button9);

    TextView screen = findViewById(R.id.textViewCalculatorOutput);
    screen.setText(calculator.output());

    clearButton.setOnClickListener(v ->
      {calculator.clear();
      screen.setText(calculator.output());});

    minusButton.setOnClickListener(v ->
    {calculator.insertMinus();
      screen.setText(calculator.output());});

    plusButton.setOnClickListener(v ->
    {calculator.insertPlus();
      screen.setText(calculator.output());});

    equalsButton.setOnClickListener(v ->
    {calculator.insertEquals();
      screen.setText(calculator.output());});

    backspaceButton.setOnClickListener(v ->
    {calculator.deleteLast();
      screen.setText(calculator.output());});

    button0.setOnClickListener(v ->
    {calculator.insertDigit(0);
      screen.setText(calculator.output());});

    button1.setOnClickListener(v ->
    {calculator.insertDigit(1);
      screen.setText(calculator.output());});

    button2.setOnClickListener(v ->
    {calculator.insertDigit(2);
      screen.setText(calculator.output());});

    button3.setOnClickListener(v ->
    {calculator.insertDigit(3);
      screen.setText(calculator.output());});

    button4.setOnClickListener(v ->
    {calculator.insertDigit(4);
      screen.setText(calculator.output());});

    button5.setOnClickListener(v ->
    {calculator.insertDigit(5);
      screen.setText(calculator.output());});

    button6.setOnClickListener(v ->
    {calculator.insertDigit(6);
      screen.setText(calculator.output());});

    button7.setOnClickListener(v ->
    {calculator.insertDigit(7);
      screen.setText(calculator.output());});

    button8.setOnClickListener(v ->
    {calculator.insertDigit(8);
      screen.setText(calculator.output());});

    button9.setOnClickListener(v ->
    {calculator.insertDigit(9);
      screen.setText(calculator.output());});

  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putSerializable("curScreen", calculator.output());
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    calculator.loadState(savedInstanceState.getSerializable("curScreen"));
    TextView screen = findViewById(R.id.textViewCalculatorOutput);
    screen.setText(calculator.output());
  }
}