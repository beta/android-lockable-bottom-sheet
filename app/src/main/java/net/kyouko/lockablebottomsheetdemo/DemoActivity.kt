package net.kyouko.lockablebottomsheetdemo

import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        val summonButton = findViewById<Button>(R.id.button_summon)
        summonButton.setOnClickListener {
            val demoDialogFragment = DemoBottomSheetDialogFragment()
            demoDialogFragment.show(supportFragmentManager, "DIALOG_DEMO")
        }

        button_summon_popUP.setOnClickListener {
            val actionModeCallback = object : ActionMode.Callback2() {
                override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                    mode!!.finish()
                    return true
                }

                override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                    mode?.menuInflater?.inflate(R.menu.menu_test, menu)
                    return true
                }

                override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                    return true
                }

                override fun onDestroyActionMode(mode: ActionMode?) {
                }
            }
            it.startActionMode(actionModeCallback, ActionMode.TYPE_FLOATING)
        }


    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            Toast.makeText(this, "Hello from activity", Toast.LENGTH_SHORT).show()
        }
        return super.onTouchEvent(event)
    }
}
