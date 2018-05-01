package com.abdalrahman.iamarabbutrich;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ImageView image1;
    ImageView image2;
    String name;
    Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name ="";
        c =this;
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image1.animate().alpha(1f).translationY(-800).setDuration(20);
        image2.animate().alpha(1f).translationY(800).setDuration(20);


        new CountDownTimer(10000, 4500) {
            @Override
            public void onTick(long millisUntilFinished) {
                Toast.makeText(c, "please wait a moment", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFinish() {
                image1.animate().alpha(1f).translationY(1500).setDuration(5000);
                image2.animate().alpha(1f).translationY(-1500).setDuration(12000);
            }
        }.start();
    }
    public void button(View v){

        final EditText editText = new EditText(this);
        final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setView(editText);
        alertDialog.setTitle("Receipt");
        alertDialog.setMessage("Please Entr your name to get the receipt");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "submit",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                        name = editText.getText().toString();
                        if (name.equals("")  ){
                            Toast.makeText(MainActivity.this, "INVAILED name , Please try again", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(c);
                            builder1.setTitle("receipt");
                            builder1.setMessage(" \"I am arab but rich\" community is proud that " + name + " is a member of our rich community");
                            builder1.setPositiveButton(
                                    "ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            name ="";
                                            alertDialog.cancel();
                                            dialog.cancel();
                                        }
                                    });
                            AlertDialog alert11 = builder1.create();
                            alert11.show();
                        }
                    }
                });
        alertDialog.show();


    }
}
