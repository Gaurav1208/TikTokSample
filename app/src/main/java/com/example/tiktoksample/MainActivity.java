package com.example.tiktoksample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {

    SpaceNavigationView navigationView;
    private HomeFragment homeFragment;
    private LoveFragment loveFragment;
    private HistoryFragment historyFragment;
    private AddFragment addFragment;
    private SettingFragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.space);
        homeFragment = new HomeFragment();
        loveFragment = new LoveFragment();
        historyFragment = new HistoryFragment();
        addFragment = new AddFragment();
        settingFragment = new SettingFragment();

        navigationView.initWithSaveInstanceState(savedInstanceState);
        navigationView.addSpaceItem(new SpaceItem("",R.drawable.ic_history_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("",R.drawable.ic_favorite_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("",R.drawable.ic_home_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("",R.drawable.ic_add_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("",R.drawable.ic_settings_black_24dp));

        navigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
               setFragment(homeFragment);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {

                switch (itemIndex){
                    case 0:
                        setFragment(historyFragment);
                        return;
                    case 1:
                        setFragment(loveFragment);
                        return;
                    case 2:
                        setFragment(homeFragment);
                        return;
                    case 3:
                        setFragment(addFragment);
                        return;
                    case 4:
                        setFragment(settingFragment);
                        return;
                            default:
                                setFragment(homeFragment);
                }

            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });

    }

    private void setFragment (Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.space,fragment);
        fragmentTransaction.commit();

    }
}
