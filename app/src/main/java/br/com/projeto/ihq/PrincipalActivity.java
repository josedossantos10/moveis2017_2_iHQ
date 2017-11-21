package br.com.projeto.ihq;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.ihq.adapters.CardHqsAdapter;
import br.com.projeto.ihq.model.Album;
import br.com.projeto.ihq.model.HQ;


public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView itensCard;
    private RecyclerView recyclerView;

    private FloatingActionMenu menuFloat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menuFloat = (FloatingActionMenu) findViewById(R.id.menu_item_float);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        carregarComponentes();

        inflarItens();

    }

    private void carregarComponentes() {
            //this.itensCard = (ListView) findViewById(R.id.listview_item_principal);
            this.recyclerView = (RecyclerView) findViewById(R.id.recyclerview_principal);

    }


    private void inflarItens() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(manager);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());

        List<Album> albuns = new ArrayList<>();
        List<HQ> hqs = new ArrayList<>();

        Album b = new Album();
        b.setTitulo("TESTE1");


        HQ hq1 = new HQ(1, "flash1", "asdfasdasdasd");
        hqs.add(hq1);
        HQ hq2 = new HQ(2, "flash2", "asdfasdasdasd");
        hqs.add(hq2);
        HQ hq3 = new HQ(3, "flash3", "asdfasdasdasd");
        hqs.add(hq3);


        b.setHqs(hqs);
        albuns.add(b);

        b = new Album();
        b.setTitulo("TESTE2");
        b.setHqs(hqs);
        albuns.add(b);


        b = new Album();
        b.setTitulo("TESTE3");
        b.setHqs(hqs);
        albuns.add(b);


        recyclerView.setAdapter(new CardHqsAdapter(this, albuns));


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void novoAlbum(View view) {
    }

    public void novaHq(View view) {
    }
}
