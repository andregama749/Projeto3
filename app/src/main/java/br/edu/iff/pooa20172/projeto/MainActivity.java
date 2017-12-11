package br.edu.iff.pooa20172.projeto;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener bnv
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {

                case R.id.inicioItem:
                    transaction.replace(R.id.frame_layout, new Fragment_home()).commit();
                    return true;

                case R.id.musicaItem:
                    transaction.replace(R.id.frame_layout, new Fragment_musica()).commit();
                    return true;

                case R.id.videosItem:
                    transaction.replace(R.id.frame_layout, new Fragment_video()).commit();
                    return true;

                case R.id.imagensItem:
                    transaction.replace(R.id.frame_layout, new Fragment_imagem()).commit();
                    return true;

                case R.id.documentosItem:
                    transaction.replace(R.id.frame_layout, new Fragment_doc()).commit();
                    return true;

            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(bnv);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, new Fragment_home()).commit();
    }
}