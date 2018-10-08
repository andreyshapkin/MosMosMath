package com.mosmos.mosmos_math;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class DialogSoundLevel extends Dialog {
    public DialogSoundLevel(@NonNull Context context) {
        super(context);
    }

    private static final String TAG = "DialogSoundLevel";
    private SoundMakerInterface soundMakerInterface;

    CheckBox soundDialogMuteCheckBox;
    SeekBar soundDialogLevelSeekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_sound_level);

        soundMakerInterface = MathProblemVisualizer.getInstance().soundMaker;

        soundDialogMuteCheckBox = (CheckBox) findViewById(R.id.checkBoxMute);
        soundDialogLevelSeekBar = (SeekBar) findViewById(R.id.seekBarSoundLevel);
        soundDialogLevelSeekBar.setMax(10);

        updateWidgetStates();

        soundDialogMuteCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean muted = soundDialogMuteCheckBox.isChecked();
                Log.d(TAG, "onClick: checkBox state " + String.valueOf(muted));
                soundMakerInterface.setMute(muted);
                updateWidgetStates();
            }
        });
        soundDialogLevelSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int volume = soundDialogLevelSeekBar.getProgress();
                Log.d(TAG, "onStopTrackingTouch: progress=" + String.valueOf(volume));
                soundMakerInterface.setMute(false);
                soundMakerInterface.setVolume(volume);
                updateWidgetStates();
            }

        });

        Button button = (Button) findViewById(R.id.dialog_sound_volume_OK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: dialog sound okay");
                dismiss();
            }
        });
    }

    private void updateWidgetStates() {
        if (soundMakerInterface.getMute()) {
            soundDialogLevelSeekBar.setProgress(0);
            soundDialogMuteCheckBox.setChecked(true);
            soundDialogMuteCheckBox.setBackgroundColor(Color.RED);
        } else {
            soundDialogLevelSeekBar.setProgress(soundMakerInterface.getVolume());
            soundDialogMuteCheckBox.setChecked(false);
            soundDialogMuteCheckBox.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}