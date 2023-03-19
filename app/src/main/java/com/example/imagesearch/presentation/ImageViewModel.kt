package com.example.imagesearch.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesearch.common.ResourceStateManager
import com.example.imagesearch.domain.use_case.GetSearchImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(private val getSearchImageUseCase: GetSearchImageUseCase): ViewModel()  {
    private val _imageList = mutableStateOf(ImageState())
    val imageList: State<ImageState> get() = _imageList

    init{
        getSearchImage("Sun Flower")
    }
    fun getSearchImage(query: String){
        getSearchImageUseCase(query).onEach{
            when(it){
                is ResourceStateManager.Loading ->{
                    _imageList.value = ImageState(isLoading = true)
                }
                is ResourceStateManager.Success ->{
                    _imageList.value = ImageState(data = it.data)
                }
                is ResourceStateManager.Error -> {
                    _imageList.value = ImageState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}