package com.belajar.decodeencodelanjutan.ui.theme

sealed class Route (val route:String) {

    object Home:Route("home_activity")
    object Decrypy:Route("decrypt_activity")
    object Encrypt:Route("encrypt_activity")
}
