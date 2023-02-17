package com.example.fragment.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragment.R
import com.example.fragment.databinding.ActivityFragmentClickBinding

class FragmentClickActivity : AppCompatActivity() {
    var doubleBackToExitPressedOnce = false

    private lateinit var binding: ActivityFragmentClickBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentClickBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarfragment.setTitle("This is First Fragment")
        setSupportActionBar(binding.toolbarfragment)
        click()
    }

    private fun click() {
        replacefragment(FragmentActivityFragone())
    }

    private fun replacefragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        ft.replace(R.id.framentActivity, fragment,"This is First Fragment")
        ft.commitAllowingStateLoss()
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
        }
        if (supportFragmentManager.backStackEntryCount != 0) {
          val title = supportFragmentManager.fragments[supportFragmentManager.backStackEntryCount - 1].tag

            Log.d("title-->", "$title")
            if (title!=null)
            {
                binding.toolbarfragment.title = title
            }
            super.onBackPressed()
        } else {
            doubleBackToExitPressedOnce = true
            Toast.makeText(
                this,
                resources.getString(R.string.Please_click_BACK_again_to_exit),
                Toast.LENGTH_SHORT
            ).show()
            Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
        }
    }
}
