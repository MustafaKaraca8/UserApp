package com.mustafa.userapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.mustafa.userapp.app.presentation.user_list.UserListEvent
import com.mustafa.userapp.app.presentation.user_list.UserListViewModel
import com.mustafa.userapp.core.presentation.ObserveAsEvent
import com.mustafa.userapp.core.presentation.toString
import com.mustafa.userapp.ui.theme.UserAppTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserAppTheme {
                val viewModel = koinViewModel<UserListViewModel>()
                val state by viewModel.userState.collectAsStateWithLifecycle()
                val context = LocalContext.current

                ObserveAsEvent(
                    events = viewModel.events,
                ) { userListEvent ->
                    when (userListEvent) {
                        is UserListEvent.Error -> {
                            Toast.makeText(
                                context,
                                userListEvent.error.toString(context),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }



                if(state.isLoading) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }else {
                    GoogleMap(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        state.users.forEach { user ->
                            val position = LatLng(user.lat, user.lng)
                            Marker(
                                state = MarkerState(position = position),
                                title = user.firstName,
                                snippet = user.lastName
                            )
                        }
                    }
                }

            }
        }
    }
}



