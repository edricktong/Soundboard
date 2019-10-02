package com.example.soundboard;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;

public class SoundBoardActivity extends AppCompatActivity implements View.OnClickListener{

    public SoundPool soundPool;
    public Button buttonA;
    public Button buttonB;
    public Button buttonBb;
    public Button buttonC;
    public Button buttonCS;
    public Button buttonD;
    public Button buttonDS;
    public Button buttonE;
    public Button buttonF;
    public Button buttonFS;
    public Button buttonG;
    public Button buttonGS;
    public boolean areSoundsLoaded;
    public int aNote;
    public int bNote;
    public int bbNote;
    public int cNote;
    public int csNote;
    public int dNote;
    public int dsNote;
    public int eNote;
    public int fNote;
    public int fsNote;
    public int gNote;
    public int gsNote;
    public Button buttonSong1;
    public Button buttonSong2;
    public Button buttonSong3;
    public Map<Integer, Integer> noteMap;
    private int[] sounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);
        wireWidgets();
        initializeSoundPools();
        setListeners();
    }

    private void wireWidgets() {
        buttonA = findViewById(R.id.soundA_soundboard_button);
        buttonBb = findViewById(R.id.soundBb_soundboard_button);
        buttonB = findViewById(R.id.soundB_soundboard_button);
        buttonC = findViewById(R.id.soundC_soundboard_button);
        buttonCS = findViewById(R.id.soundCS_soundboard_button);
        buttonD = findViewById(R.id.soundD_soundboard_button);
        buttonDS = findViewById(R.id.soundDS_soundboard_button);
        buttonE = findViewById(R.id.soundE_soundboard_button);
        buttonF = findViewById(R.id.soundF_soundboard_button);
        buttonFS = findViewById(R.id.soundFS_soundboard_button);
        buttonG = findViewById(R.id.soundG_soundboard_button);
        buttonGS = findViewById(R.id.soundGS_soundboard_button_soundboard_button);
        buttonSong1 = findViewById(R.id.soundBoard_song1_button);
        buttonSong2 = findViewById(R.id.soundBoard_song2_button);
        buttonSong3 = findViewById(R.id.soundBoard_song3_button);
    }

    private void initializeSoundPools() {
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(30, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                areSoundsLoaded = true;
            }
        });
        aNote = soundPool.load(this, R.raw.scalea, 1);
        bNote = soundPool.load(this, R.raw.scaleb, 1);
        bbNote = soundPool.load(this, R.raw.scalebb, 1);
        cNote = soundPool.load(this, R.raw.scalec, 1);
        csNote = soundPool.load(this, R.raw.scalecs, 1);
        dNote = soundPool.load(this, R.raw.scaled, 1);
        eNote = soundPool.load(this, R.raw.scalee, 1);
        fNote = soundPool.load(this, R.raw.scalef, 1);
        fsNote = soundPool.load(this, R.raw.scalefs, 1);
        gNote = soundPool.load(this, R.raw.scaleg, 1);
        gsNote = soundPool.load(this, R.raw.scalegs, 1);



        noteMap = new HashMap<>();
        noteMap.put(buttonA.getId(), aNote);
        noteMap.put(buttonB.getId(), bNote);
        noteMap.put(buttonC.getId(), cNote);
        noteMap.put(buttonBb.getId(), bbNote);
        noteMap.put(buttonCS.getId(), csNote);
        noteMap.put(buttonD.getId(), dNote);
        noteMap.put(buttonDS.getId(), dsNote);
        noteMap.put(buttonE.getId(), eNote);
        noteMap.put(buttonF.getId(), fNote);
        noteMap.put(buttonFS.getId(), fsNote);
        noteMap.put(buttonG.getId(), gNote);
        noteMap.put(buttonGS.getId(), gsNote);
    }


    private void setListeners() {

        KeyBoardListener keyBoardListener = new KeyBoardListener();
        buttonA.setOnClickListener(keyBoardListener);
        buttonB.setOnClickListener(keyBoardListener);
        buttonC.setOnClickListener(keyBoardListener);
        buttonBb.setOnClickListener(keyBoardListener);
        buttonCS.setOnClickListener(keyBoardListener);
        buttonD.setOnClickListener(keyBoardListener);
        buttonDS.setOnClickListener(keyBoardListener);
        buttonE.setOnClickListener(keyBoardListener);
        buttonF.setOnClickListener(keyBoardListener);
        buttonFS.setOnClickListener(keyBoardListener);
        buttonG.setOnClickListener(keyBoardListener);
        buttonGS.setOnClickListener(keyBoardListener);

        buttonSong1.setOnClickListener(this);
        buttonSong2.setOnClickListener(this);
        buttonSong3.setOnClickListener(this);
    }


    private void delay(int millisDelay){
        try {
            Thread.sleep(millisDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.soundBoard_song1_button : {
                Toast.makeText(this, "Song #1", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.soundBoard_song2_button : {
                Toast.makeText(this, "Song #2", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.soundBoard_song3_button : {
                Toast.makeText(this, "Song #3", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
    private class KeyBoardListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            int someId = noteMap.get(view.getId());
            if(someId != 0) {
                soundPool.play(someId, 1, 1, 1, 0, 1);
            }
        }
    }
}
