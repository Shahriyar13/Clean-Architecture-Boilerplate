package com.example.template.di

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.template.App
import com.example.template.base.BaseActivity
import com.example.template.base.BaseFragment
import com.example.template.base.BaseViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {


    @Provides
    fun provideBaseActivity(activity: Activity): BaseActivity {
        check(activity is BaseActivity) { "Every Activity is expected to extend BaseActivity" }
        return activity
    }

    @Provides
    fun provideBaseFragment(fragment: Fragment): BaseFragment {
        check(fragment is BaseFragment) { "Every Fragment is expected to extend BaseFragment" }
        return fragment
    }

    @Provides
    fun provideBaseViewModel(viewModel: ViewModel): BaseViewModel {
        check(viewModel is BaseViewModel) { "Every ViewModel is expected to extend BaseViewModel" }
        return viewModel
    }


    @Provides
    @Singleton
    fun provideContext(application: App): Context =
        application.applicationContext
}