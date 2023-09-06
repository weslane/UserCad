package com.mwsa.ui.user.models

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import com.mwsa.domain.user.models.User
import com.mwsa.ui.util.decodeImage
import java.util.Date


data class UserUiModel(
    val id: String,
    val nome: String,
    val username: String,
    val password: String,
    val foto: Bitmap?,
    val email: String,
    val endereco: String,
    val dataNascimento: Date,
    val sexo: Int,
    val cpfCnpj: String,
) {
    val hasFoto: Boolean = foto == null
}

fun User.toUiModel(): UserUiModel =
    UserUiModel(
        id,
        nome,
        username,
        password,
        foto?.let { decodeImage(it) } ,
        email,
        endereco,
        dataNascimento,
        sexo,
        cpfCnpj,
    )
