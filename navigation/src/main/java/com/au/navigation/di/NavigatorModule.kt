package com.au.navigation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class NavigatorModule {

    @Provides
    fun provideNavString() = "Hello world"
}