package com.mwsa.infrastructure.user.model

import com.mwsa.infrastructure.data.AppDatabase
import com.mwsa.infrastructure.data.Entity
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.annotation.Unique
import com.raizlabs.android.dbflow.structure.BaseModel

@Table(name=UserEntity.NAME, database = AppDatabase::class, allFields = true)
open class UserEntity (

    @PrimaryKey(autoincrement = true)
    @Column
    override var id: String = "",

    @Column
    var nome: String = "",

    @Column
    @Unique(unique = true)
    var username: String = "",

    @Column
    var password: String = "",

    @Column
    var foto: String? = null,

    @Column
    @Unique(unique = true)
    var email: String = "",

    @Column
    var endereco: String = "",

    @Column
    var dataNascimento: Long = 0L,

    @Column
    var sexo: Int = 0,

    @Column
    var cpfCnpj: String = "",

) : BaseModel(), Entity {

    companion object {
        const val NAME = "User"
    }
}
