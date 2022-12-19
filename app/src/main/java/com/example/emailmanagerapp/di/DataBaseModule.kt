package com.example.emailmanagerapp.di

import android.content.Context
import android.os.Debug
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.database.EmailDatabase
import com.example.data.database.EmailRoomDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataBaseModule {

    @Binds
    abstract fun bindOmpDatabase(db: EmailRoomDatabase): EmailDatabase

    @Binds
    abstract fun bindRoomDatabase(db: EmailRoomDatabase): RoomDatabase

    companion object {
        @Provides
        @Singleton
        fun provideDatabase(
            @ApplicationContext context: Context
        ): EmailRoomDatabase {
            val builder = Room.databaseBuilder(context, EmailRoomDatabase::class.java, "ompdb.db")
                .fallbackToDestructiveMigration()
            if (Debug.isDebuggerConnected()) {
                builder.allowMainThreadQueries()
            }
            return builder.build()
        }

        @Provides
        fun provideMessageDao(db: EmailRoomDatabase) = db.messageDao()
    }
}