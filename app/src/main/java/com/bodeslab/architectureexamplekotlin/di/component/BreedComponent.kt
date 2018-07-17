package com.bodeslab.architectureexamplekotlin.di.component

import com.bodeslab.architectureexamplekotlin.di.module.BreedModule
import com.bodeslab.architectureexamplekotlin.di.scope.PerActivityScope
import com.bodeslab.architectureexamplekotlin.presentation.ui.breed.BreedsActivity
import dagger.Component


/**
 * {Created by Jonatas Caram on 25/05/2018}.
 */
@PerActivityScope
@Component(
        dependencies = [ApplicationComponent::class],
        modules = [BreedModule::class]
)
interface BreedComponent {
    fun inject(activity: BreedsActivity)
}