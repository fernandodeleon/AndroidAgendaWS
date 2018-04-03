package com.edwindeleon.org.androidagenda.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.edwindeleon.org.androidagenda.R;
import com.edwindeleon.org.androidagenda.adapters.PageAdapter;
import com.edwindeleon.org.androidagenda.beans.Contacto;
import com.edwindeleon.org.androidagenda.adapters.ContactoAdaptador;
import com.edwindeleon.org.androidagenda.fragments.PerfilFragment;
import com.edwindeleon.org.androidagenda.recyclerviews.RecyclerViewFragment;

import java.util.ArrayList;

public class Contactos extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contactos);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_detalle_usuario);
    }


}
