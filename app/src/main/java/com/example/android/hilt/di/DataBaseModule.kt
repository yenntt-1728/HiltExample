package com.example.android.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.android.hilt.data.AppDatabase
import com.example.android.hilt.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * @class DataBaseModule
 * Created by SUN-ASTERISK\nguyen.thi.tu.yen on 15,October,2020
 */
@InstallIn(ApplicationComponent :: class)
@Module
object DataBaseModule {

    @Provides
    @Singleton
    fun provideAppDataBase(@ApplicationContext appContext: Context) : AppDatabase {
        return Room.databaseBuilder(
            appContext, AppDatabase ::class.java , "logging.db"
        ).build()
    }

    @Provides
    fun provideLogDao(dataBase : AppDatabase) : LogDao {
        return dataBase.logDao()
    }

}