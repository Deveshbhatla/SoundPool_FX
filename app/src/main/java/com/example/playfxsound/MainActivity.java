package com.example.playfxsound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonOne,buttontwo,buttonthree,buttonfour;
    private SoundPool soundpool;
    int sound1,sound2,sound3,sound4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioAttributes audioattributes= new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                        .build();




        soundpool=new SoundPool.Builder()
                .setMaxStreams(4)
                .setAudioAttributes(audioattributes)
                .build();

        sound1=soundpool.load(this,R.raw.complete,1);
        sound2=soundpool.load(this,R.raw.correct,1);
        sound3=soundpool.load(this,R.raw.defeat_one,1);
        sound4=soundpool.load(this,R.raw.defeat_two,1);

        buttonOne=findViewById(R.id.buttonone);
        buttontwo=findViewById(R.id.buttontwo);
        buttonthree=findViewById(R.id.buttonthree);
        buttonfour=findViewById(R.id.buttonfour);


        buttonOne.setOnClickListener(this);
        buttontwo.setOnClickListener(this);
        buttonthree.setOnClickListener(this);
        buttonfour.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.buttonone:
                soundpool.play(sound1,1,0,0,0,1);
            break;

            case R.id.buttontwo:
                soundpool.play(sound2,1,0,0,0,1);

                break;

                case R.id.buttonthree:
                    soundpool.play(sound3,0,1,0,0,1);

                break;

                case R.id.buttonfour:
                    soundpool.play(sound4,0,1,0,0,1);

                break;


        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(soundpool!=null)
        {
            soundpool.release();
            soundpool=null;
        }
    }
}
