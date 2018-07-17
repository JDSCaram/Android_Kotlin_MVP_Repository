package com.bodeslab.architectureexamplekotlin.presentation.presenter.breed

import com.bodeslab.architectureexamplekotlin.database.entities.BreedEntity
import com.bodeslab.architectureexamplekotlin.presentation.presenter.BaseView


/**
 * {Created by Jonatas Caram on 25/05/2018.
 * jcaram@luxfacta.com
 * For Luxfacta Soluções de TI.
 * {@see more in https://www.luxfacta.com}.
 */
interface BreedView : BaseView<Any?> {
    fun showBreeds(breedsResponse: Int?, entities: List<BreedEntity>?)
}