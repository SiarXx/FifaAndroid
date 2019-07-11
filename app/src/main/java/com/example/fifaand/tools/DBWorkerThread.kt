package com.example.fifaand.tools

import android.os.Handler
import android.os.HandlerThread

class DBWorkerThread(threadname: String): HandlerThread(threadname){
    private lateinit var mWorkerHandler: Handler

    override fun onLooperPrepared() {
        super.onLooperPrepared()
        mWorkerHandler = Handler(looper)
    }

    fun postTask(task: Runnable) {
        mWorkerHandler.post(task)
    }
}