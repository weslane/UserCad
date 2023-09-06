package com.mwsa.infrastructure.user.mapper

import com.mwsa.domain.user.models.User
import com.mwsa.domain.user.models.buildUser
import com.mwsa.domain.util.buildEntity
import com.mwsa.domain.util.getDate
import com.mwsa.domain.util.getTimestamp
import com.mwsa.infrastructure.user.model.UserApiDto
import com.mwsa.infrastructure.user.model.UserEntity

fun UserEntity.toDomain(): User =
   buildUser(
       entity = buildEntity(this.id),
       nome = this.nome,
       username = this.username,
       password = this.password,
       email = this.email,
       dataNascimento = getDate(this.dataNascimento),
       endereco = this.endereco,
       sexo = this.sexo,
       cpfCnpj = this.cpfCnpj,
       foto = this.foto,

   )

fun User.toUserEntity(): UserEntity =
    UserEntity(
        id = this.id,
        nome = this.nome,
        username = this.username,
        password = this.password,
        foto = this.foto,
        email = this.email,
        endereco = this.endereco,
        sexo = this.sexo,
        cpfCnpj = this.cpfCnpj,
        dataNascimento = getTimestamp(this.dataNascimento)
    )

fun UserApiDto.toEntity(): UserEntity =
    UserEntity(
        nome = this.nome,
        username = this.username,
        password = this.password,
        foto = this.foto,
        email = this.email,
        endereco = this.endereco,
        sexo = this.sexo,
        cpfCnpj = this.cpfCnpj,
        dataNascimento = this.dataNascimento
    )
