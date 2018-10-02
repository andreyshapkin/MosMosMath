package com.example.agshapki.mosmos;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogAbout extends Dialog implements View.OnClickListener {
    public DialogAbout(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_about);

        TextView textView = (TextView) findViewById(R.id.dialogAboutText);
        textView.setText("All rights to this application belong to Shapkin's family and " +
                "their cat MosMos who generously donated her time for posing for the picture!\n" +
                "Please use this app free of charge and spread the word about MosMos cat's greatfulness.\n" +
                "Don't forget you can leave your constructive feedback on the Google Play market " +
                "or via email: andrey.shapkin@gmail.com");

        textView.setOnClickListener(this);
        ((ImageView) findViewById(R.id.dialogAboutImageView)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
