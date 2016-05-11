package com.blooot.criminalintent;


import android.support.v4.app.Fragment;

/**
 * Created by roger on 4/21/2016.
 */
public class CrimeListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}
