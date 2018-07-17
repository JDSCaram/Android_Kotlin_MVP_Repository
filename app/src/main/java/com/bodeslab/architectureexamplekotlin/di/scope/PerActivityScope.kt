package com.bodeslab.architectureexamplekotlin.di.scope

import kotlin.annotation.*
import javax.inject.Scope


/**
 * {Created by Jonatas Caram on 25/05/2018}.
 */

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivityScope