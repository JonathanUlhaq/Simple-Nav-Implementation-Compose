package com.belajar.decodeencodelanjutan.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun EncryptScreenPreview() {
    EncryptScreen()
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EncryptScreen() {
    EncryptLayout(text = "UvuvweveOss", navController = NavController(LocalContext.current) )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EncryptLayout(
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    text:String?,
    navController: NavController
) {
    val encode = text?.let { viewModel.encodeString(it) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(CenterHorizontally),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hasil Encrypt: $encode")

        Spacer(modifier = Modifier.size(15.dp))

        Button(onClick = { navController.navigate(Route.Decrypy.route + "/${encode}") }) {
            Text(text = "Decrypt Message")
        }
    }
}