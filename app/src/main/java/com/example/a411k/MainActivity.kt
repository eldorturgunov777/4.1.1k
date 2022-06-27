package com.example.a411k

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.a411k.utils.Utils
import java.io.File
import java.io.FileOutputStream
import java.nio.charset.StandardCharsets

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cache = findViewById<Button>(R.id.cache)
        val files = findViewById<Button>(R.id.files)
        val delete = findViewById<Button>(R.id.delete)

        cache.setOnClickListener {
            saveInternalFile("CACHE")
        }
        files.setOnClickListener {
            saveInternalFiles("FILES")
        }
        delete.setOnClickListener {
            deleteInternalFile()
        }
    }

    private fun deleteInternalFile() {
        val fileName = "internal.txt"
        val cache = File(filesDir, fileName)
        val file = File(cacheDir, fileName)
        file.delete()
        cache.delete()
        Utils.fireToast(this, String.format("File %s has been deleted", fileName))
    }

    private fun saveInternalFiles(file: String) {
        val fileName = "internal.txt"
        try {
            val fileOutputStream: FileOutputStream = openFileOutput(fileName, MODE_PRIVATE)
            fileOutputStream.write(file.toByteArray(StandardCharsets.UTF_8))
            Utils.fireToast(this, String.format("Write to %s successful", fileName))
        } catch (e: Exception) {
            e.printStackTrace()
            Utils.fireToast(this, String.format("Write to file %s failed", fileName))
        }
    }

    private fun saveInternalFile(cache: String) {
        val fileName = "internal.txt"
        try {
            val fileOutputStream: FileOutputStream
            val file = File(cacheDir, fileName)
            fileOutputStream = FileOutputStream(file)
            fileOutputStream.write(cache.toByteArray(StandardCharsets.UTF_8))
            Utils.fireToast(this, String.format("Write to %s successful", fileName))
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Utils.fireToast(this, String.format("Write to file %s failed", fileName))
        }
    }
}