package com.bodeslab.architectureexamplekotlin.presentation.ui.breed

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bodeslab.architectureexamplekotlin.R
import com.bodeslab.architectureexamplekotlin.SampleApplication
import com.bodeslab.architectureexamplekotlin.database.entities.BreedEntity
import com.bodeslab.architectureexamplekotlin.di.component.DaggerBreedComponent
import com.bodeslab.architectureexamplekotlin.di.module.BreedModule
import com.bodeslab.architectureexamplekotlin.presentation.presenter.breed.BreedPresenterImpl
import com.bodeslab.architectureexamplekotlin.presentation.presenter.breed.BreedView
import com.bodeslab.architectureexamplekotlin.toolbox.AlertDialogUtils
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class BreedsActivity : AppCompatActivity(), BreedView {

    @Inject
    lateinit var mPresenter: BreedPresenterImpl

    private var mLastPage: Int? = 0
    private lateinit var mAdapter: BreedsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()
        recycler.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)
        mAdapter = BreedsAdapter(this)
        recycler.adapter = mAdapter

        mPresenter.getInitialBreeds()

    }

    private fun initComponent() {
        DaggerBreedComponent.builder()
                .applicationComponent((SampleApplication).daggerComponent)
                .breedModule(BreedModule(this))
                .build()
                .inject(this)
    }


    override fun showBreeds(breedsResponse: Int?, entities: List<BreedEntity>?) {
        mLastPage = breedsResponse
        mAdapter.addBreeds(entities!!.toMutableList())
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
        recycler.visibility = View.GONE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
        recycler.visibility = View.VISIBLE
    }

    override fun showMessage(message: String?) {
        AlertDialogUtils.dialog(this, message).show()
    }

    override fun showErrorMessage(message: String?) {
        AlertDialogUtils.dialog(this, message).show()
    }
}
