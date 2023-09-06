package com.mwsa.infrastructure.user.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserApiDto(

    @SerialName("nome")
    val nome: String,
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String,
    @SerialName("foto")
    val foto: String?,
    @SerialName("email")
    val email: String,
    @SerialName("endereco")
    val endereco: String,
    @SerialName("dataNascimento")
    val dataNascimento: Long,
    @SerialName("sexo")
    val sexo: Int,
    @SerialName("cpfCnpj")
    val cpfCnpj: String,
)
