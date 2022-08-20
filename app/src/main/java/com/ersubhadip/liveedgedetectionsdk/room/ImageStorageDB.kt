package com.ersubhadip.liveedgedetectionsdk.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ImageStorageEntity::class], version = 1, exportSchema = false)
abstract class ImageStorageDB : RoomDatabase() {
    abstract fun imagesDao(): ImageStorage

    companion object {

        @Volatile
        private var INSTANCE: ImageStorageDB? = null

        fun getDatabase(context: Context): ImageStorageDB? {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ImageStorageDB::class.java, "image_db"
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

//    companion object {
//        @Volatile
//        private var INSTANCE: ImageStorageDB? = null
//
//        @OptIn(InternalCoroutinesApi::class)
//        fun getDatabase(context: Context): ImageStorageDB {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    ImageStorageDB::class.java,
//                    "image_db"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//
//        }
//
//    }
}