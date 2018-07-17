package com.bodeslab.architectureexamplekotlin.di.module

import com.bodeslab.architectureexamplekotlin.di.scope.PerActivityScope
import com.bodeslab.architectureexamplekotlin.presentation.presenter.breed.BreedView
import dagger.Module
import dagger.Provides


/**
 * {Created by Jonatas Caram on 25/05/2018}.
 */
@Module
class BreedModule(breedView: BreedView) {
    var view: BreedView = breedView

    @Provides
    @PerActivityScope
    fun provideBreedView(): BreedView {
        return view
    }
}