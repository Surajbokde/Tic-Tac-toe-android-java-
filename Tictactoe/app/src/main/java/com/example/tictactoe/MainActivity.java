package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] chance={2,2,2,2,2,2,2,2,2};
    int[][] win={{0,1,2},{3,4,5},{6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};
    int player=0;
    int flag =1;
    String infostatus;
    TextView status;
    public void reset(View view){
         for(int i=0;i<9;i++){
             chance[i]=2;}
         player=0;
         flag =1;

        ((ImageView)findViewById(R.id.img1)).setImageResource(0);
        ((ImageView)findViewById(R.id.img2)).setImageResource(0);
        ((ImageView)findViewById(R.id.img3)).setImageResource(0);
        ((ImageView)findViewById(R.id.img4)).setImageResource(0);
        ((ImageView)findViewById(R.id.img5)).setImageResource(0);
        ((ImageView)findViewById(R.id.img6)).setImageResource(0);
        ((ImageView)findViewById(R.id.img7)).setImageResource(0);
        ((ImageView)findViewById(R.id.img8)).setImageResource(0);
        ((ImageView)findViewById(R.id.img9)).setImageResource(0);
        TextView status=findViewById(R.id.status);
        status.setText( "Player 1::Tap To Play");
    }
    public void click(View view){
        if(flag==0){
            Toast.makeText(MainActivity.this,infostatus+"\nPress RESET to Play Again",Toast.LENGTH_LONG).show();
            //Toast.makeText(MainActivity.this,"Press RESET to Play Again",Toast.LENGTH_LONG).show();

        }
        int z=0;
        ImageView img=(ImageView) view;
        int tapimg =Integer.parseInt(img.getTag().toString());
        if(chance[tapimg]==2 && flag==1)
        {
            chance[tapimg]=player;
            img.setTranslationY(-1000f);
            if(player==0){
                img.setImageResource(R.drawable.tic);
                player=1;
                infostatus="Player 2::Tap To Play";
            }else{
                img.setImageResource(R.drawable.tac);
                player=0;
               infostatus="Player 1::Tap To Play";
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        for(int[] n:win){
            if(chance[n[0]]==chance[n[1]]&&chance[n[1]]==chance[n[2]]&&chance[n[1]]!=2){
                flag=0;
                if(player==0)
                     infostatus="Player 2::WIN";
                else
                    infostatus="Player 1::WIN";
            }
        }


       for( z=0;z<9;z++)
       {
           if(chance[z]==2)
               break;
       }
       if(z==9&&flag==1){
            infostatus="DRAW";
            flag=0;
            // reset(view);
        } status=findViewById(R.id.status);
        status.setText( infostatus);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
