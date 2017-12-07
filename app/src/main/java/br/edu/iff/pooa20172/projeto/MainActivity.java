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

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.frame_layout, new Fragment_home()).commit();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                if (item.getItemId() == R.id.inicioItem) {
                    transaction.replace(R.id.frame_layout, new Fragment_home()).commit();
                } else {
                    if (item.getItemId() == R.id.musicaItem) {
                        transaction.replace(R.id.frame_layout, new Fragment_musica()).commit();
                    } else {
                        if (item.getItemId() == R.id.videosItem) {
                            transaction.replace(R.id.frame_layout, new Fragment_video()).commit();
                        } else {
                            if (item.getItemId() == R.id.imagensItem) {
                                transaction.replace(R.id.frame_layout, new Fragment_imagem()).commit();
                            } else {
                                if (item.getItemId() == R.id.documentosItem) {
                                    transaction.replace(R.id.frame_layout, new Fragment_doc()).commit();
                                }
                            }
                        }
                    }
                }

                return true;
            }
        });
    }
}