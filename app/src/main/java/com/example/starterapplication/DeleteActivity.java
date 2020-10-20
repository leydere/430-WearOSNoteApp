package com.example.starterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.wearable.view.DelayedConfirmationView;
import android.view.View;

public class DeleteActivity extends AppCompatActivity implements DelayedConfirmationView.DelayedConfirmationListener{

    DelayedConfirmationView delayedConfirmationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        delayedConfirmationView = (DelayedConfirmationView) findViewById(R.id.delayed_confirm);

        delayedConfirmationView.setListener(this);
        delayedConfirmationView.setTotalTimeMs(3000);

        delayedConfirmationView.start();
    }

    @Override
    public void onTimerFinished(View v) {
        Helper.displayConfirmation("Deleted",this);

        String id = getIntent().getStringExtra("id");

        Helper.removeNote(id, this);
        finish();
    }

    @Override
    public void onTimerSelected(View v) {
        Helper.displayConfirmation("Cancelled", this);
        delayedConfirmationView.reset();
        finish();
    }
}