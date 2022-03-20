package com.auldy.moviecatalogue.utils

import android.os.Handler
import android.os.Looper
import androidx.annotation.VisibleForTesting
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * 12/05/2021
 * AULDY ANSYA RULLAH
 */
class AppExecutors @VisibleForTesting constructor(
    private val diskIO: Executor,
    private val mainThread: Executor
) {

    constructor() : this(
        Executors.newSingleThreadExecutor(),
        MainThreadExecutor()
    )

    fun diskIO(): Executor = diskIO

    fun mainThread(): Executor = mainThread

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}