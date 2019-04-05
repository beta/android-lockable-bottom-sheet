package net.kyouko.lockablebottomsheetdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Button summonButton = (Button) findViewById(R.id.button_summon);
        summonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DemoBottomSheetDialogFragment demoDialogFragment = new DemoBottomSheetDialogFragment();
                demoDialogFragment.show(getSupportFragmentManager(), "DIALOG_DEMO");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Toast.makeText(this, "Hello from activity", Toast.LENGTH_SHORT).show();
        }
        return super.onTouchEvent(event);
    }
}
