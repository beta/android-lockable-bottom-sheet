package net.kyouko.lockablebottomsheetdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

}
