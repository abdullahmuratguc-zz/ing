package com.muratguc.ingchallange.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muratguc.ingchallange.R
import com.muratguc.ingchallange.ui.home.RepoListFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RepoListFragment.newInstance())
                .commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Timber.e(supportFragmentManager.fragments.size.toString())
    }
}