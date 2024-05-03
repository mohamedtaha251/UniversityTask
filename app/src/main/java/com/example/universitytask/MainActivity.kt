package com.example.universitytask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.universitytask.ui.theme.showShortToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mViewModel: UniversityListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel.getUniversities {
            showShortToast(it.size.toString())
        }

        //  startActivity(Intent(this, ListingActivity::class.java))


    }
}