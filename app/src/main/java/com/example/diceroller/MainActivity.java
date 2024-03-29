package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Intent;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on_button_click(View view){

        randomNumGenerator(6);
        showRandNum();

        //for result message
        TextView showResultMessage = this.findViewById(R.id.ResultMessage);

        EditText mEdit = findViewById(R.id.enternumberhere);
        //Editable guessedText = mEdit.getText();



        Editable guessedText;

        //to check if input is empty
        if (!mEdit.getText().toString().equals("")) {


            try {

                guessedText = mEdit.getText();

                //for scoring
                TextView showScoreText = this.findViewById(R.id.ScoreText);

                //for total score
                totaltries +=1;

                //parsing to int
                int guessme = Integer.parseInt(guessedText.toString());

                ConstraintError(guessme);

                CompareGuess(guessme, number);


            } catch (Exception ex) {
                Toast.makeText(MainActivity.this, "Error " + ex.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        }




    }
    public void on_button2_click(View view){

        Main2Activity ma2 = new Main2Activity();
        ma2.QuestionDB();

        Intent intent = new Intent ( MainActivity.this, Main2Activity.class);
        startActivity(intent);


    }


    //initialising variables
    private int score;
    private int totaltries;
    private int number;
    static int arlistSize = 6;

    //Editable guessedText;
    //EditText mEdit = findViewById(R.id.enternumberhere);
    private TextView showResultMessage;
    private TextView showconstraintError;

    public int randomNumGenerator(int randMax){

        Random r = new Random();
        number = r.nextInt(randMax)+1;


        return number;
    }
    public void showRandNum(){
        TextView tv = this.findViewById(R.id.numbertextView);
        tv.setText(Integer.toString(number));
    }


    public void CompareGuess(int guessme, int number){


        //for result message
        showResultMessage = this.findViewById(R.id.ResultMessage);


        //if entered number is valid
        if (guessme == number){

            //changes result message
            showResultMessage.setText("Congratulations you guessed the right number");

            //increments score by 5
            score += 1;

            Scoring(score, totaltries);
        }
        else{
            //changes result message
            showResultMessage.setText("You did not guess the right number");

            Scoring(score, totaltries);

        }
    }

    public void ConstraintError(int guessme){

        //for error messsage
        showconstraintError =  this.findViewById(R.id.constraintError);

        showconstraintError.setText("Please enter a valid number between 1-6");

        //when entered number is not between 1-6
        if (guessme < 1 || guessme > 6 ){
            showconstraintError.setText("Please enter a valid number between 1-6");
        }
        else{
            showconstraintError.setText("");
        }

    }

    public void Scoring(int score, int totaltries){
        //for scoring
        TextView showScoreText = this.findViewById(R.id.ScoreText);

        showScoreText.setText(score + " / " + totaltries);
    }

    //called when user enters a new icebreaker
    public void increasearlistSize(){
        arlistSize += 1;
    }

}
