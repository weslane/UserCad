package com.mwsa.ui.util

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.util.Base64
import com.mwsa.ui.R
import java.io.ByteArrayOutputStream

fun decodeImage(encodedString: String): Bitmap {

    val imageBytes = Base64.decode(encodedString, Base64.DEFAULT)

    return BitmapFactory.decodeByteArray(imageBytes, 0, 194)

}

fun encodeImage(bitmap: Bitmap): String {
    val baos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.PNG, 90, baos)
    val b = baos.toByteArray()
    return Base64.encodeToString(b, Base64.DEFAULT)
}
