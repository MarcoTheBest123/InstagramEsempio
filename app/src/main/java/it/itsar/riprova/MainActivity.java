package it.itsar.riprova;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.tabView);

        navigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.homeIconId:
                    fragmentConfig(HomeFragment.class);
                    break;
                case R.id.messageIconId:
                    fragmentConfig(MessageFragment.class);
                    break;
                case R.id.profileIconId:
                    fragmentConfig(ProfileFragment.class);
                    break;
            }
            return true;
        });
    }

    private void fragmentConfig(Class fragmentClass){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragmentClass, null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();
    }
}