package com.example.ui.home

import com.example.common_compose.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(

) : BaseViewModel<HomeState, HomeAction>(HomeState()) {

    init {
        onEachAction { action ->
            when(action) {
                is HomeAction.Refresh -> {

                }
                else -> throw IllegalArgumentException("unknown action: $action")
            }
        }
    }
}