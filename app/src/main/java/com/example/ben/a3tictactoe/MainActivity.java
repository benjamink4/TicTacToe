package com.example.ben.a3tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Button> buttons;

    String user;
    String comp;
    int spaces;

    CheckBox xc;
    CheckBox oc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spaces = 0;


        buttons = new ArrayList<>();
        buttons.add((Button) findViewById(R.id.button));
        buttons.add((Button) findViewById(R.id.button2));
        buttons.add((Button) findViewById(R.id.button3));
        buttons.add((Button) findViewById(R.id.button4));
        buttons.add((Button) findViewById(R.id.button5));
        buttons.add((Button) findViewById(R.id.button6));
        buttons.add((Button) findViewById(R.id.button7));
        buttons.add((Button) findViewById(R.id.button8));
        buttons.add((Button) findViewById(R.id.button9));


        xc = (CheckBox) findViewById(R.id.x);

        oc = (CheckBox) findViewById(R.id.o);

        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(xc.isChecked() && oc.isChecked()){
                    Toast.makeText(MainActivity.this, "Please only Select one option", Toast.LENGTH_SHORT).show();
                }

                else if (xc.isChecked() == true) {
                    user = "x";
                    comp = "o";

                }

                else if (oc.isChecked()) {
                    user = "o";
                    comp = "x";
                }


            }
        });



        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                if (is_occupied((Button) findViewById(R.id.button))) {
                    Toast.makeText(MainActivity.this, "This space is occupied", Toast.LENGTH_SHORT).show();

                } else {
                    anyclicked(buttons.get(0));


                }

            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                if (is_occupied((Button) findViewById(R.id.button2))) {
                    Toast.makeText(MainActivity.this, "This space is occupied", Toast.LENGTH_SHORT).show();

                } else {
                    anyclicked(buttons.get(1));


                }

            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                if (is_occupied((Button) findViewById(R.id.button3))) {
                    Toast.makeText(MainActivity.this, "This space is occupied", Toast.LENGTH_SHORT).show();

                } else {
                    anyclicked(buttons.get(2));

                }

            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                if (is_occupied((Button) findViewById(R.id.button4))) {
                    Toast.makeText(MainActivity.this, "This space is occupied", Toast.LENGTH_SHORT).show();

                } else {
                    anyclicked(buttons.get(3));


                }

            }
        });

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                if (is_occupied((Button) findViewById(R.id.button5))) {
                    Toast.makeText(MainActivity.this, "This space is occupied", Toast.LENGTH_SHORT).show();

                } else {
                    anyclicked(buttons.get(4));

                }

            }
        });

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                if (is_occupied((Button) findViewById(R.id.button6))) {
                    Toast.makeText(MainActivity.this, "This space is occupied", Toast.LENGTH_SHORT).show();

                } else {
                    anyclicked(buttons.get(5));
                }

            }
        });


        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                if (is_occupied((Button) findViewById(R.id.button7))) {
                    Toast.makeText(MainActivity.this, "This space is occupied", Toast.LENGTH_SHORT).show();

                } else {
                    anyclicked(buttons.get(6));


                }

            }
        });
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                if (is_occupied((Button) findViewById(R.id.button8))) {
                    Toast.makeText(MainActivity.this, "This space is occupied", Toast.LENGTH_SHORT).show();

                } else {
                    anyclicked(buttons.get(7));

                }

            }
        });


        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                if (is_occupied((Button) findViewById(R.id.button9))) {
                    Toast.makeText(MainActivity.this, "This space is occupied", Toast.LENGTH_SHORT).show();

                } else {
                    anyclicked(buttons.get(8));

                }

            }
        });

        findViewById(R.id.Clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 9; i++) {
                    buttons.get(i).setText(" ");
                    buttons.get(i).setEnabled(true);
                }
                xc.setChecked(false);
                oc.setChecked(false);
                user="";
                comp="";
                spaces=0;

            }
        });
    }


    public boolean is_occupied(Button b) {
        if (b.getText() == "x" || b.getText() == "o") {
            return true;
        }
        return false;

    }


    public void computer() {
        if (anywin() == false && spaces < 9) {

            int random = new Random().nextInt(9);


            while (is_occupied(buttons.get(random))) {
                random = new Random().nextInt(9);

            }
            Button q = buttons.get(random);
            q.setText(comp);
            spaces++;
            anywin();

        }
    }

    public boolean wina(String x) {

        if (buttons.get(0).getText().toString().equals(x) && buttons.get(1).getText().toString().equals(x) && buttons.get(2).getText().toString().equals(x)) {
            return true;
        }
        if (buttons.get(3).getText().toString().equals(x) && buttons.get(4).getText().toString().equals(x) && buttons.get(5).getText().toString().equals(x)) {
            return true;
        }
        if (buttons.get(6).getText().toString().equals(x) && buttons.get(7).getText().toString().equals(x) && buttons.get(8).getText().toString().equals(x)) {
            return true;
        }
        return false;


    }

    public boolean down(String x) {

        if (buttons.get(0).getText().toString().equals(x) && buttons.get(3).getText().toString().equals(x) && buttons.get(6).getText().toString().equals(x)) {
            return true;
        }
        if (buttons.get(1).getText().toString().equals(x) && buttons.get(4).getText().toString().equals(x) && buttons.get(7).getText().toString().equals(x)) {
            return true;
        }
        if (buttons.get(2).getText().toString().equals(x) && buttons.get(5).getText().toString().equals(x) && buttons.get(8).getText().toString().equals(x)) {
            return true;
        }

        return false;

    }

    public boolean diagonol(String x) {
        if (buttons.get(0).getText().toString().equals(x) && buttons.get(4).getText().toString().equals(x) && buttons.get(8).getText().toString().equals(x)) {

            return true;
        }

        if (buttons.get(2).getText().toString().equals(x) && buttons.get(4).getText().toString().equals(x) && buttons.get(6).getText().toString().equals(x)) {
            return true;
        }

        return false;
    }


    public void win() {
        if (wina("x") || diagonol("x") || down("x")) {
            Toast.makeText(this, "X wins", Toast.LENGTH_SHORT).show();


        }
        if (wina("o") || diagonol("o") || down("o")) {
            Toast.makeText(this, "o wins", Toast.LENGTH_SHORT).show();

        }


    }

    public boolean anywin(){
        if (wina("x") || diagonol("x") || down("x") || wina("o") || diagonol("o") || down("o")) {
            disable();
            win();
           return true;


        }else if(spaces==9){
            Toast.makeText(this, "Tie", Toast.LENGTH_SHORT).show();
            disable();

        }


        return false;




    }

    public void disable(){
       for(Button b:buttons){
           b.setEnabled(false);
       }
    }

    public void anyclicked(Button b){
        b.setText(user);
        spaces++;
        anywin();
        computer();


    }



}





