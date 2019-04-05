package net.kyouko.lockablebottomsheet;

import android.graphics.Matrix;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.TypedValue;
import android.view.MotionEvent;
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
        if (!cancelable) {
            final View touchOutsideView = getDialog().getWindow().getDecorView().findViewById(android.support.design.R.id.touch_outside);
            touchOutsideView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int actionBarHeight = 0;
                    int[] array = {0, 0};
                    v.getLocationOnScreen(array);
                    // Calculate ActionBar height
                    TypedValue tv = new TypedValue();
                    actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
                    Matrix matrix = new Matrix();
                    matrix.setTranslate(0, actionBarHeight + array[1]);
                    event.transform(matrix);
                    getActivity().dispatchTouchEvent(event);
                    return true;
                }
            });

        } else {
            final View touchOutsideView = getDialog().getWindow().getDecorView().findViewById(android.support.design.R.id.touch_outside);
            touchOutsideView.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return false;
                }
            });
        }
    }
}
