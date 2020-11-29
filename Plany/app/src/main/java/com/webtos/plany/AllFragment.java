package com.webtos.plany;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.webtos.plany.Fragment.Home;
import com.webtos.plany.Fragment.Information;
import com.webtos.plany.Fragment.Note;
import com.webtos.plany.Fragment.Task;

public class AllFragment extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_fragment);

        bottomNavigationView =  findViewById(R.id.bottom_nav);

        Information information = new Information();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame , information).commit();

        try {

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment change = null;

                    switch (item.getItemId())
                    {

                        case R.id.nav_info:

                            change = new Information();
                            break;

                        case R.id.nav_note:

                            change = new Note();
                            break;



                        case R.id.nav_task:

                            change = new Task();
                            break;

                        case R.id.nave_home:

                            change = new Home();
                            break;

                        default:
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame , change).commit();



                    return true;
                }
            });

        }catch (NullPointerException e)
        {

        }
    }
}