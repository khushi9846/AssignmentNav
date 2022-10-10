package com.example.assignmentnav;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.assignmentnav.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());


        drawerLayout = findViewById(R.id.layoutdrawer);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this
                , drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        replacefragemet(new HomeFragment());

        activityMainBinding.drawerview.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case (R.id.home2):
                                replacefragemet(new HomeFragment());
                                Toast.makeText(MainActivity.this, "New page launched", Toast.LENGTH_SHORT).show();

                                break;
                            case (R.id.profile2):
                                replacefragemet(new ProfileFragment());
                                Toast.makeText(MainActivity.this, "New page launched", Toast.LENGTH_SHORT).show();
                                break;
                            case (R.id.search2):
                                replacefragemet(new SearchFragment());
                                Toast.makeText(MainActivity.this, "New page launched", Toast.LENGTH_SHORT).show();

                                break;
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }

                });


        activityMainBinding.bottomview.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case (R.id.home):
                    replacefragemet(new HomeFragment());
                    Toast.makeText(MainActivity.this, "New page launched", Toast.LENGTH_SHORT).show();

                    break;
                case (R.id.profile):
                    replacefragemet(new ProfileFragment());
                    Toast.makeText(MainActivity.this, "New page launched", Toast.LENGTH_SHORT).show();
                    break;
                case (R.id.search):
                    replacefragemet(new SearchFragment());
                    Toast.makeText(MainActivity.this, "New page launched", Toast.LENGTH_SHORT).show();

                    break;
            }
            return true;
        });



    }

    @Override
    public void onBackPressed() {
      if(drawerLayout.isDrawerOpen(GravityCompat.START)){
          drawerLayout.closeDrawer(GravityCompat.START);
      }else {
          super.onBackPressed();


      }
    }


    private void replacefragemet(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

}