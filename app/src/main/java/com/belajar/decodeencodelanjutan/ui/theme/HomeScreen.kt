package com.belajar.decodeencodelanjutan.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}

@Composable
fun HomeScreen(
    viewModel: MainViewModel = viewModel(),
    navController: NavController 
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, top = 20.dp)
            .wrapContentWidth(Alignment.CenterHorizontally),
        horizontalAlignment = Alignment.CenterHorizontally
            ) {
        MessageText(text = viewModel.userInput, 
            onTextChange = {viewModel.updateUserInput(it)},
            navController = navController )
    }
}

@Composable
fun MessageText(text:String, onTextChange:(String) -> Unit, navController:NavController) {
    
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            label = { Text(text = "Tulis pesan disini") },
        )

    Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navController.navigate(Route.Encrypt.route + "/${text}") },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)) {
            Text(text = "Encode")
        }
        
    }
    
}