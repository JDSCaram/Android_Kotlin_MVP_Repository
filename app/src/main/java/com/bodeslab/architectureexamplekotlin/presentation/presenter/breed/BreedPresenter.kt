package com.bodeslab.architectureexamplekotlin.presentation.presenter.breed

import com.bodeslab.architectureexamplekotlin.presentation.presenter.BasePresenter


/**
 * {Created by Jonatas Caram on 25/05/2018.
 * jcaram@luxfacta.com
 * For Luxfacta Soluções de TI.
 * {@see more in https://www.luxfacta.com}.
 */
interface BreedPresenter : BasePresenter<BreedView> {
    fun getInitialBreeds()
    fun getBreedsPerPage(page: String)
}