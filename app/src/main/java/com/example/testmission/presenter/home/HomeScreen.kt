package com.example.testmission.presenter.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import com.example.testmission.ui.components.BookItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlin.math.log

class HomeScreen : AndroidScreen() {
    @SuppressLint("StateFlowValueCalledInComposition")
    @Composable
    override fun Content() {
        val vm: HomeScreenContract.ViewModel = getViewModel<HomeScreenViewModel>()
        HomeScreenContent(
            vm.uiState.collectAsState(),
            vm::onEventDispatcher
        )
    }
}

@Composable
fun HomeScreenContent(
    uiState: State<HomeScreenContract.UiState>,
    onEventDispatcher: (HomeScreenContract.Intent) -> Unit,
) {

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White,
            darkIcons = true
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (uiState.value.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color(0xFFff7686),
                strokeWidth = 2.dp,
                strokeCap = StrokeCap.Round
            )
        } else {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize(),
                    columns = GridCells.Adaptive(minSize =160.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item (span = {
                        GridItemSpan(
                            maxLineSpan
                        )
                    }){
                        Text(
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .fillMaxWidth(),
                            text = "Славянское фэнтези",
                            color = Color.Black,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    items(uiState.value.data) {
                        BookItem(
                            model = it,
                            onClick = {
                                onEventDispatcher.invoke(
                                    HomeScreenContract.Intent.Details(it)
                                )
                            })
                    }
                    item(span = {
                        GridItemSpan(
                            maxLineSpan
                        )
                    }) {
                        Spacer(modifier = Modifier.size(16.dp))
                    }

                }
            }


        }
    }

}