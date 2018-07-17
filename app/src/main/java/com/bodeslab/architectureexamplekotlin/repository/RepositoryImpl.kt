package com.bodeslab.architectureexamplekotlin.repository

import com.bodeslab.architectureexamplekotlin.repository.data.LocalData
import com.bodeslab.architectureexamplekotlin.repository.data.RemoteData
import javax.inject.Inject


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */

class RepositoryImpl : Repository {


    var mLocalData: LocalData?
    var mRemoteData: RemoteData?

    @Inject
    constructor(localData: LocalData, remoteData: RemoteData){
        this.mLocalData = localData
        this.mRemoteData = remoteData
    }

    override fun local(): LocalData? {
        return mLocalData
    }

    override fun remote(): RemoteData? {
        return mRemoteData
    }
}