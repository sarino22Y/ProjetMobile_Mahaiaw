package com.sarino.rojo.m1p9.itu.mahaiaw.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.sarino.rojo.m1p9.itu.mahaiaw.customclasses.Constant
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class DatabaseHelper(internal var context: Context) : SQLiteOpenHelper(context, Constant.DATABASE_NAME, null, Constant.DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    @Throws(IOException::class)
    fun createDataBase() {
        val databaseExist = checkDataBase()
        if (databaseExist) {
        } else {
            this.writableDatabase
            copyDataBase()
        }
    }

    private fun checkDataBase(): Boolean {
        val databaseFile = File(Constant.DB_PATH + Constant.DATABASE_NAME)
        return databaseFile.exists()
    }

    @Throws(IOException::class)
    private fun copyDataBase() {
        val myInput = context.assets.open("databases/" + Constant.DATABASE_NAME)
        val outFileName = Constant.DB_PATH + Constant.DATABASE_NAME
        val myOutput = FileOutputStream(outFileName)
        val buffer = ByteArray(1024)
        while (myInput.read(buffer) > 0) {
            myOutput.write(buffer)
        }
        myOutput.flush()
        myOutput.close()
        myInput.close()
    }

}
