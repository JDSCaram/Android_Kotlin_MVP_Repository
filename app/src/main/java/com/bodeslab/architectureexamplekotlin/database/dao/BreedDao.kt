package com.bodeslab.architectureexamplekotlin.database.dao

import android.arch.persistence.room.*
import com.bodeslab.architectureexamplekotlin.database.entities.BreedEntity
import io.reactivex.Flowable
import io.reactivex.Single


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */
@Dao
abstract class BreedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertBreeds(entities: MutableList<BreedEntity>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertBreed(entity: BreedEntity): Long

    @Update
    abstract fun updateBreed(entity: BreedEntity): Int

    @Update
    abstract fun updateBreeds(entity: List<BreedEntity>): Int

    @Delete
    abstract fun deleteBreed(vararg entities: BreedEntity)

    @Query("SELECT * FROM BreedEntity WHERE uid = :id")
    abstract fun selectUnique(id: Int): Single<BreedEntity>

    @Query("SELECT * FROM BreedEntity ")
    abstract fun selectAll(): List<BreedEntity>
}