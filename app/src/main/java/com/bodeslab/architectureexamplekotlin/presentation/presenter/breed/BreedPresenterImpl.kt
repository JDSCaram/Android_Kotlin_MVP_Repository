package com.bodeslab.architectureexamplekotlin.presentation.presenter.breed

import android.util.Log
import com.bodeslab.architectureexamplekotlin.database.entities.BreedEntity
import com.bodeslab.architectureexamplekotlin.network.api.breed.BreedsAPI
import com.bodeslab.architectureexamplekotlin.network.api.breed.BreedsResponse
import com.bodeslab.architectureexamplekotlin.repository.Repository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * {Created by Jonatas Caram on 25/05/2018}.
 */
class BreedPresenterImpl : BreedPresenter {

    private var mView: BreedView? = null
    var mRepository: Repository
    var mCompositeDisposable: CompositeDisposable

    @Inject
    constructor(view: BreedView, repository: Repository) {
        this.mView = view
        this.mRepository = repository
        this.mCompositeDisposable = CompositeDisposable()
    }


    override fun onDestroy() {
        this.mView = null
        this.mCompositeDisposable.clear()
    }

    override fun isViewAttached(): Boolean = mView != null


    override fun getInitialBreeds() {
        if (!isViewAttached()) return
        mView?.showProgress()

        mRepository.remote()?.getRetrofit()?.create(BreedsAPI::class.java)?.getBreeds()
                ?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ response: BreedsResponse ->
                    saveBreeds(response)
                }, { e ->
                    sendErrorToView(e)
                    Log.e(BreedPresenterImpl::class.java.simpleName, e.message, e)
                })

    }

    private fun saveBreeds(response: BreedsResponse) {
        val entities: MutableList<BreedEntity>? = BreedEntity.fromModelsToEntities(response.data)
        if (entities!!.isNotEmpty()) {
            Observable.fromCallable {
                mRepository.local()?.getDatabase()?.breedDao()?.insertBreeds(entities)
            }.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ longs: List<Long>? ->
                        if (longs?.isNotEmpty()!!)
                            selectFromBase(response)
                        else {
                            Log.i(BreedPresenterImpl::class.java.simpleName, "Nenhum item persistido")
                        }
                    }, { error ->
                        Log.e(BreedPresenterImpl::class.java.simpleName, error.message, error)
                    })
        } else {
            mView?.showErrorMessage("Empty Response")
        }
    }

    private fun selectFromBase(response: BreedsResponse) {
        Observable.fromCallable {
            mRepository.local()?.getDatabase()?.breedDao()?.selectAll()
        }.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ entities: List<BreedEntity>? ->
                    sendToView(response, entities)
                })
    }

    private fun sendErrorToView(e: Throwable?) {
        if (!isViewAttached()) return
        mView?.hideProgress()
        mView?.showErrorMessage(e?.message)
    }

    private fun sendToView(response: BreedsResponse, entities: List<BreedEntity>?) {
        if (!isViewAttached()) return
        mView?.hideProgress()
        mView?.showBreeds(response.lastPage, entities)
    }

    override fun getBreedsPerPage(page: String) {

    }


}