package net.kyouko.lockablebottomsheetdemo;

import android.app.Dialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import net.kyouko.lockablebottomsheet.LockableBottomSheetDialogFragment;

/**
 * A derived {@link LockableBottomSheetDialogFragment} used for demo.
 *
 * @author beta
 */
public class DemoBottomSheetDialogFragment extends LockableBottomSheetDialogFragment {

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        View contentView = View.inflate(getContext(), R.layout.dialog_demo, null);
        dialog.setContentView(contentView);

        CheckBox locker = dialog.findViewById(R.id.checkbox_locker);
        locker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                setCancelable(!checked);
            }
        });
    }

}
