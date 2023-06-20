package com.mufasa.bttransfer.data.chat

import android.annotation.SuppressLint
import com.mufasa.bttransfer.domain.chat.BluetoothDeviceDomain

@SuppressLint("MissingPermission")
fun android.bluetooth.BluetoothDevice.toBluetoothDeviceDomain(): BluetoothDeviceDomain {
    return BluetoothDeviceDomain(
        name = name,
        address = address
    )
}
