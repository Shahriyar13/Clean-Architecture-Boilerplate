package com.example.template.data.common

import android.os.Looper
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.PrintStream

class NetworkUtils {

    companion object {
        fun isOnline(host: String = "8.8.8.8", timeOut: Int = 120): Boolean {
            if (isMainThread())
                throw RuntimeException(" Must not be called on The MainThread")
            return try {
                val p1 = Runtime.getRuntime().exec("ping -t $timeOut -c 1 $host")
                val returnVal = p1.waitFor()
                Log.d("@@@@@", "return val $returnVal")
                logResponse(p1)
                /**
                 * change (returnVal == true) because this is'nt work for emulators
                 */
                returnVal == 0
            } catch (e: Exception) {
                e.printStackTrace()
                false
            }
        }

        private fun logResponse(p1: Process?) {
            if (p1 == null) return
            var line: String?
            val error = BufferedReader(InputStreamReader(p1.errorStream))
            while (error.readLine().also { line = it } != null) {
                println(line)
            }
            error.close()

            val input = BufferedReader(InputStreamReader(p1.inputStream))
            while (input.readLine().also { line = it } != null) {
                println(line)
            }
            input.close()

            val outputStream: OutputStream? = p1.outputStream
            val printStream = PrintStream(outputStream)
            printStream.println()
            printStream.flush()
            printStream.close()
        }

        private fun isMainThread(): Boolean {
            return Looper.getMainLooper().thread === Thread.currentThread()
        }

    }
}