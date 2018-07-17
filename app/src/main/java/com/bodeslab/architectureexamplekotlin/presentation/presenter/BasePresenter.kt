package com.bodeslab.architectureexamplekotlin.presentation.presenter


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
interface BasePresenter<in T : BaseView<*>> {
//    fun setView(view: T)
    fun onDestroy()
    fun isViewAttached(): Boolean
}