package com.belajar.decodeencodelanjutan.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {

    var userInput by mutableStateOf("")

    fun updateUserInput(update:String) {
        userInput = update
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun encodeString(message:String):String {

        return Base64.getEncoder().encodeToString(message.toByteArray())

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun decodeStringA(encode:String):String {
        val decode = Base64.getDecoder().decode(encode)
        return String(decode)
    }

}