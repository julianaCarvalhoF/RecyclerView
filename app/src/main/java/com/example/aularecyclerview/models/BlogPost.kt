package com.example.aularecyclerview.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// MODELANDO NOSSOS ITEM A SER EXIBIDO NA RECYCLE VIEW

@Parcelize
data class BlogPost(
    var titulo: String,

    var body: String,

    var imagem: String,

    var userName: String
): Parcelable
