package com.example.simplerecyclerviewexample

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListItem (val text: String) : Parcelable