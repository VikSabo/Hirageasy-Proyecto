package com.example.administrador.nuevomenu;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnEstiloLibre = (Button) findViewById(R.id.estiloLibreBtn);
        btnEstiloLibre.setOnClickListener(this);

        Button btnCompetitivo = (Button) findViewById(R.id.competitivoBtn);
        btnCompetitivo.setOnClickListener(this);

        Button frasesBtn = (Button) findViewById(R.id.frasesBtn);
        frasesBtn.setOnClickListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final int cancion = (int)(Math.random() * 2);
        if (cancion == 0) {
            AudioPlay.playAudio(this, R.raw.song);
        } else {
            AudioPlay.playAudio(this, R.raw.song2);
        }
    }

    public void onClick(View v) {
        number = getIntent().getExtras().getInt("valor");
        switch (v.getId()) {
            case  R.id.estiloLibreBtn: {
                Intent i = new Intent(this, JuegoActivity.class );
                i.putExtra("valor",number);
                startActivity(i);
                break;
            }
            case  R.id.competitivoBtn: {
                Intent i = new Intent(this, LetrasActvity.class );
                startActivity(i);
                break;
            }
            case  R.id.frasesBtn: {
                Intent i = new Intent(this, Frases.class );
                startActivity(i);
                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AudioPlay.stopAudio();
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_instructions) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_about) {
            Intent i = new Intent(this, AcercaDe.class );
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
