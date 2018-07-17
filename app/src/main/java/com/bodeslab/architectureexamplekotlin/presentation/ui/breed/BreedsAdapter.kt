package com.bodeslab.architectureexamplekotlin.presentation.ui.breed

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bodeslab.architectureexamplekotlin.R
import com.bodeslab.architectureexamplekotlin.database.entities.BreedEntity
import kotlinx.android.synthetic.main.item_breed.view.*

class BreedsAdapter() : RecyclerView.Adapter<BreedsAdapter.ViewHolder>() {

    lateinit var mContext: Context
    lateinit var mBreeds: MutableList<BreedEntity>

    constructor(context: Context) : this() {
        this.mContext = context
        this.mBreeds = mutableListOf<BreedEntity>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.item_breed, parent,
                false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mBreeds.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mBreeds[position])
    }

    fun addBreeds(breeds: MutableList<BreedEntity>) {
        mBreeds = breeds
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(entity: BreedEntity) {
            itemView.coat.text = entity.coat
            itemView.breed.text = entity.breed
            itemView.origin.text = entity.origin
            itemView.country.text = entity.country
            itemView.pattern.text = entity.pattern
        }
    }


}
