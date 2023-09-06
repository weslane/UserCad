package com.mwsa.domain.user.models

import com.mwsa.domain.util.Entity
import java.util.Date


interface User : Entity {

    val nome: String
    val username: String
    val password: String
    val foto: String?
    val email: String
    val endereco: String
    val dataNascimento: Date
    val sexo: Int
    val cpfCnpj: String

}


data class UserDomain(
    val entity: Entity,
    override val nome: String,
    override val username: String,
    override val password: String,
    override val foto: String?,
    override val email: String,
    override val endereco: String,
    override val dataNascimento: Date,
    override val sexo: Int,
    override val cpfCnpj: String,
) : User, Entity by entity

fun buildUser(
    entity: Entity,
    nome: String,
    username: String,
    password: String,
    foto: String? = null,
    email: String,
    endereco: String,
    dataNascimento: Date,
    sexo: Int,
    cpfCnpj: String,
): User = UserDomain(
    entity, nome, username, password, foto, email, endereco, dataNascimento, sexo, cpfCnpj
)