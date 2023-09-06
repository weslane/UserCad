package com.mwsa.infrastructure.data

import com.raizlabs.android.dbflow.annotation.Database
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.kotlinextensions.count
import com.raizlabs.android.dbflow.sql.language.SQLite
import com.raizlabs.android.dbflow.structure.BaseModel

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION, generatedClassSeparator = "_")
object AppDatabase {
    const val NAME: String = "UserCadDB"
    const val VERSION: Int = 1
}

interface LocalDataSource<T : BaseModel> {

    fun count(): Long

    fun getAll(): List<T>

    suspend fun save(model: T)

    suspend fun delete(model: T)

    suspend fun update(model: T)

}

class LocalDataSourceImpl<T>(private val javaClass: Class<T>) :
    LocalDataSource<T> where T : BaseModel, T : Entity {

    private val modelAdapter = FlowManager.getModelAdapter(javaClass)

    override fun count(): Long {
        return SQLite.select()
            .from(modelAdapter.modelClass)
            .count
    }

    override fun getAll(): List<T> {

        return SQLite.select()
            .from(modelAdapter.modelClass)
            .queryList()
    }

    override suspend fun save(model: T) {
        model.save()
    }

    override suspend fun delete(model: T) {
        model.delete()
    }

    override suspend fun update(model: T) {
        model.save()
    }

}
