package com.rightmove.codechallenge.ui.di

import android.app.Application
import com.rightmove.codechallenge.ui.RightMoveApplication
import com.rightmove.library_property.inject.PropertyLibraryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        PropertyLibraryModule::class]
)

interface AppComponent : AndroidInjector<RightMoveApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}