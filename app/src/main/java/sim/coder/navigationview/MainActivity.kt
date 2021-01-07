package sim.coder.navigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

lateinit var drawerLayout: DrawerLayout
lateinit var navigationView: NavigationView
lateinit var actionBarDrawerToggle : ActionBarDrawerToggle

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout=findViewById(R.id.drawer_layout)
        navigationView=findViewById(R.id.nav)

        val toolBar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolBar)

        actionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolBar,
            R.string.drawer_open,
            R.string.drawer_close

        ){
            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                setTitle(R.string.drawer_close)

            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                setTitle(R.string.drawer_open)

            }
        }
        actionBarDrawerToggle.isDrawerIndicatorEnabled=true
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navigationView.setNavigationItemSelectedListener (this)
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.book -> {
                getData("Book")
            }

            R.id.novel ->
                getData("Novels")
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun getData(data:String){
        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.frame_container)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, CategoryFragment.newInstance(data))
            .commit()}

}





