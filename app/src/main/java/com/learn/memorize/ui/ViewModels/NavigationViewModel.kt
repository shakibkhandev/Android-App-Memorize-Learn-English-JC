package com.learn.memorize.ui.ViewModels

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NavigationViewModel : ViewModel() {
    private val _selectedBottomIndex = mutableStateOf(0)
    val selectedBottomIndex: State<Int> = _selectedBottomIndex



    // Set selected bottom index
    fun setSelectedBottomIndex(index: Int) {
        _selectedBottomIndex.value = index
    }
}
