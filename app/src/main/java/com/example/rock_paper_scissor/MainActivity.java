package com.example.rock_paper_scissor;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView rock;
    ImageView paper;
    ImageView scissor;
    TextView winRatio;
    TextView result;
    TextView status;
    int lossCounter=0;
    int winCounter=0;
    Random r  = new Random();



    public void MakeMove(View view) {
        int a = r.nextInt(3);
        ImageView inputKey = (ImageView) view;
        int currentCounter = Integer.parseInt(inputKey.getTag().toString());
        if (currentCounter==a) {
            status.setText("Its a draw");
            result.setText("Keep on trying");
        }

        else if (currentCounter==0) {
            if(a==1) {
                winCounter +=1;
                winRatio.setText(winCounter+":"+lossCounter);
                status.setText("You won");
                result.setText("Rock beats Scissor");
            }
            if (a==2) {
                lossCounter +=1;
                winRatio.setText(winCounter+":"+lossCounter);
                status.setText("You lost");
                result.setText("Rock loses to Paper");
            }
        }
        else if (currentCounter==1) {
            if (a==0) {
                lossCounter +=1;
                winRatio.setText(winCounter+":"+lossCounter);
                status.setText("You lost");
                result.setText("Scissor loses to Rock");
            }
            if (a==1) {
                winCounter +=1;
                winRatio.setText(winCounter+":"+lossCounter);
                status.setText("You won");
                result.setText("Scissor beats Paper");
            }
        }
        else {
            if (a==0){
                winCounter +=1;
                winRatio.setText(winCounter+":"+lossCounter);
                status.setText("You won");
                result.setText("Paper beats Rock");
            }
            if (a==1) {
                lossCounter +=1;
                winRatio.setText(winCounter+":"+lossCounter);
                status.setText("You lost");
                result.setText("Paper loses to Scissor");
            }
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rock = (ImageView) findViewById(R.id.rock);
        paper = (ImageView) findViewById(R.id.paper);
        scissor = (ImageView) findViewById(R.id.scissor);
        winRatio = (TextView) findViewById(R.id.winRatio);
        result = (TextView)findViewById(R.id.result);
        status = (TextView) findViewById(R.id.status);
        winRatio.setText("0:0");
        status.setText("Give it a go");
        result.setText("Can you defeat the computer?!");
    }
}