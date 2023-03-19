package com.example.imagesearch.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun MainScreen(viewModel: ImageViewModel = hiltViewModel()){

    val result = viewModel.imageList.value

    var query by remember {mutableStateOf("")}

    if(result.isLoading){
        Box(
            modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }

    if(result.error.isNotBlank()){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = result.error)
        }
    }

    Box(modifier = Modifier.fillMaxSize()){
        Column{
            TextField(
                singleLine = true,
                maxLines = 1,
                value = query,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                onValueChange = {
                    query = it
                    viewModel.getSearchImage(query = query)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                },
                placeholder = {
                    Text(text = "Search Here")
                }
            )
            result.data?.let{
                LazyColumn{
                    items(it){
                        AsyncImage(
                            model = it.imageUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(280.dp)
                                .padding(vertical = 4.dp)
                        )
                    }
                }
            }

        }

    }

}