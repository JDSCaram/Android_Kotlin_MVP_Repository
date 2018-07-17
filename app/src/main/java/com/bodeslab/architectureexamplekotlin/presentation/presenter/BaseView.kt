package com.bodeslab.architectureexamplekotlin.presentation.presenter


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
interface BaseView<T> {
    fun showProgress()

    fun hideProgress()

    fun showMessage(message: String?)

    fun showErrorMessage(message: String?)
}