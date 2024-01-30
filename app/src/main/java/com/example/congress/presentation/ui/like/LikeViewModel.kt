package com.example.congress.presentation.ui.like

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.congress.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LikeViewModel @Inject constructor(
) : BaseViewModel() {

    private val _selectedCategory = MutableLiveData<String>()
    val selectedCategory: LiveData<String> = _selectedCategory

    fun setSelectedCategory(category: String) {
        _selectedCategory.value = category
    }
}