package com.example.a411k.utils

import android.content.Context
import android.widget.Toast


/**
 * Created by Eldor Turgunov on 27.06.2022.
 * 4.1.1k
 * eldorturgunov777@gmail.com
 */
object Utils {
    fun fireToast(context: Context?, text: String?) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}