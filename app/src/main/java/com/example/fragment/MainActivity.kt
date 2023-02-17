package com.example.fragment
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment.AdapterClass.CustomAdapter
import com.example.fragment.Fragment.*
import com.example.fragment.Model.dyanamiclistModel
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigation()
        onclick()
        Recyview()
    }

    private fun Recyview() {
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<dyanamiclistModel>()

        data.add(dyanamiclistModel("NAME"))
        data.add(dyanamiclistModel("SETTING"))
        data.add(dyanamiclistModel("PRIVACY"))
        data.add(dyanamiclistModel("WEB VIEW"))

        val adapter = CustomAdapter(data) { Position->
            when(Position){
                0->{
                    Toast.makeText(this,R.string.account, Toast.LENGTH_SHORT).show()
                    replacefragment(NameOfAccountFragment())
                }
                1->{
                    Toast.makeText(this,R.string.setting, Toast.LENGTH_SHORT).show()
                    replacefragment(SettingFragment())
                }
                2->{
                    Toast.makeText(this,R.string.privacypolicy, Toast.LENGTH_SHORT).show()
                    replacefragment(PrivacyPolicyFragment())
                }
                3->{
                    replacefragment(WebViewFragment())
                    Toast.makeText(this,R.string.webview, Toast.LENGTH_SHORT).show()
                }
            }
            binding.drawer.closeDrawer(GravityCompat.START)
        }
            recyclerview.adapter = adapter
        }

    private fun navigation() {
        binding.toolbar.setTitle("MY FIRST FRAGMENT")
        binding.toolbar.setNavigationOnClickListener {
            binding.drawer.openDrawer(GravityCompat.START)
            return@setNavigationOnClickListener
        }
        binding.navigrationdrawer.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    replacefragment(SettingFragment())
                }
                R.id.nav_nameofaccount -> {
                    Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show()
                    replacefragment(NameOfAccountFragment())
                }

                R.id.nav_privacyPolicy -> {
                    Toast.makeText(this, "Privacy Policy", Toast.LENGTH_SHORT).show()
                    replacefragment(PrivacyPolicyFragment())
                }
                R.id.webview->{
                    Toast.makeText(this, "Web view", Toast.LENGTH_SHORT).show()
                    replacefragment(WebViewFragment())
                }
            }
            binding.drawer.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }*/

    private fun onclick() {
        binding.apply {
            btnfragmentone.setOnClickListener {
                replacefragment(FragmentOne())
            }
            btnfragmenttwo.setOnClickListener {
                replacefragment(FragmentTwo())
            }
            btnfragmentNewActivity.setOnClickListener {
                val intent = Intent(this@MainActivity, FragmentClickActivity::class.java);
                startActivity(intent);
            }
        }

    }

    private fun replacefragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.frameLayout, fragment)
        ft.commit()
    }

}
