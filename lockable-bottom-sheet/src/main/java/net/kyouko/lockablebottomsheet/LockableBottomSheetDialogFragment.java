package net.kyouko.lockablebottomsheet;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;

/**
 * {@link BottomSheetDialogFragment} with a simple hack to make it able to be noncancelable, or
 * "locked".
 *
 * @author beta
 */
public class LockableBottomSheetDialogFragment extends BottomSheetDialogFragment {

    /**
     * Sets whether the dialog is cancelable.
     * If {@code cancelable} is set to {@code false}, the dialog cannot be canceled neither by
     * clicking out of the dialog, nor by swiping down on the dialog. Otherwise, it could be
     * canceled just like a normal {@link BottomSheetDialog}.
     *
     * @param cancelable Whether the dialog is cancelable.
     */
    @Override
    public void setCancelable(boolean cancelable) {
        super.setCancelable(cancelable);

        BottomSheetDialog dialog = (BottomSheetDialog) getDialog();
        dialog.setCanceledOnTouchOutside(cancelable);

        View bottomSheetView = dialog.getWindow().getDecorView().findViewById(R.id.design_bottom_sheet);
        BottomSheetBehavior.from(bottomSheetView).setHideable(cancelable);
    }

}
