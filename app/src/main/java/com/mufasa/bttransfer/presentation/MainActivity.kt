package com.mufasa.bttransfer.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.mufasa.bttransfer.presentation.components.DeviceScreen
import com.mufasa.bttransfer.ui.theme.BluetoothChatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BluetoothChatTheme {
                val viewModel = hiltViewModel<BluetoothViewModel>()
                val state by viewModel.state.collectAsState()

                val enableBluetoothLauncher = registerForActivityResult(
                    ActivityResultContracts.StartActivityForResult()
                ) {
                    /* Not needed */
                }

                val permissionLauncher = registerForActivityResult(
                    ActivityResultContracts.RequestMultiplePermissions()
                ) { perms ->

                }

                Surface (
                    color = MaterialTheme.colors.background
                        ) {
                    DeviceScreen(
                        state = state,
                        onStartScan = viewModel::startScan,
                        onStopScan = viewModel::stopScan
                    )
                }
            }
        }
    }
}
