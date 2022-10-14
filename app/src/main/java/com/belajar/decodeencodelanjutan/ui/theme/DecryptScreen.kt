package com.belajar.decodeencodelanjutan.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DecryptScreenPreview(
    navController: NavController
) {
    DecryptScreen(encode = "Kauiksas", navController = navController )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable fun DecryptScreen(
    encode:String?,
    navController: NavController,
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val decode = encode?.let { viewModel.decodeStringA(encode) }
    
    Column(modifier = Modifier
        .wrapContentWidth(Alignment.CenterHorizontally)
        .wrapContentHeight(CenterVertically),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        
        Text(text = "Hasil decrypt: $decode")
        
        Spacer(modifier = Modifier.height(12.dp))
 
        Button(onClick = {navController.navigate(Route.Home.route)}) {
            
        }
    }
}