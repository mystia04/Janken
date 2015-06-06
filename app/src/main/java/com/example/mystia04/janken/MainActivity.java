package com.example.mystia04.janken;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends Activity {

    ImageView cpu;
    ImageView player;
    TextView result;
    TextView winNumber;
    TextView loseNumber;
    Random r = new Random();
    int win,lose,wins,loses = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cpu = (ImageView)findViewById(R.id.cpu);
        player = (ImageView)findViewById(R.id.player);
        result = (TextView)findViewById(R.id.result);
        winNumber = (TextView)findViewById(R.id.winNumber);
        loseNumber = (TextView)findViewById(R.id.loseNumber);

    }

    public void goo(View v){
        player.setImageResource(R.drawable.goo);

        int random = r.nextInt(3);

        if (random == 0){
            cpu.setImageResource(R.drawable.goo);
            result.setText("引き分けです");
        }else if (random == 1){
            cpu.setImageResource(R.drawable.choki);
            result.setText("あなたの勝ちです");
            wins = winCounter();

        }else if(random == 2){
            cpu.setImageResource(R.drawable.paa);
            result.setText("あなたの負けです");
            loses = loseCounter();

        }else {
            result.setText("error : 乱数生成範囲が違います");
        }
        counter(wins,loses);
    }

    public void choki(View v){
        player.setImageResource(R.drawable.choki);

        int random = r.nextInt(3);

        if (random == 0){
            cpu.setImageResource(R.drawable.goo);
            result.setText("あなたの負けです");
            loses = loseCounter();
        }else if (random == 1){
            cpu.setImageResource(R.drawable.choki);
            result.setText("引き分けです");
        }else if(random == 2){
            cpu.setImageResource(R.drawable.paa);
            result.setText("あなたの勝ちです");
            wins = winCounter();

        }else{
            result.setText("error : 乱数生成範囲が違います");
        }
        counter(wins,loses);
    }

    public void paa(View v){
        player.setImageResource(R.drawable.paa);

        int random = r.nextInt(3);

        if (random == 0){
            cpu.setImageResource(R.drawable.goo);
            result.setText("あなたの勝ちです");
            wins = winCounter();
        }else if (random == 1){
            cpu.setImageResource(R.drawable.choki);
            result.setText("あなたの負けです");
            loses = loseCounter();
        }else if(random == 2){
            cpu.setImageResource(R.drawable.paa);
            result.setText("引き分けです");

        }else{
            result.setText("error : 乱数生成範囲が違います");
        }
        counter(wins,loses);
    }

    public int winCounter(){
        win++;
        return win;
    }

    public int loseCounter(){
        lose++;
        return lose;
    }

    public void counter(int wins,int loses){
        winNumber.setText(String.valueOf(wins));
        loseNumber.setText(String.valueOf(loses));
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
}
