package com.mufasa.bttransfer.domain.chat

import java.io.IOException

class TransferFailedException: IOException("Reading Incoming data failed")