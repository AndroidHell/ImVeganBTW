package com.androidhell.imveganbtw

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NavigationViewModel : ViewModel() {
    private val _selectedNavItem = MutableStateFlow<String?>(null)
    val selectedNavItem: StateFlow<String?> = _selectedNavItem

    fun setSelectedNavItem(navItem: String) {
        viewModelScope.launch {
            _selectedNavItem.emit(navItem)
        }
    }
}