package com.example.notasapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {NotasDB.class}, version = 1)
public abstract class NotasDB extends RoomDatabase {

    public static NotasDB instance;

    public abstract NotasDao notasDao();

    public abstract NotasDB notasDB();

    public static synchronized NotasDB getInstance(Context context) {

        if (instance == null){

            instance = Room.databaseBuilder(context.getApplicationContext(), NotasDB.class, "notas_db")
                    .fallbackToDestructiveMigration().addCallback(roomCallBack).build();
        }


        return instance;
    }

    private static RoomDatabase.Callback roomCallBack = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            NotasDao notasDao =instance.notasDao();

            ExecutorService executorService = Executors.newSingleThreadExecutor();

            executorService.execute(new Runnable() {
                @Override
                public void run() {


                    notasDao.insert(new Nota("Titulo1", "Descripcion1"));
                    notasDao.insert(new Nota("Titulo2", "Descripcion2"));
                    notasDao.insert(new Nota("Titulo3", "Descripcion3"));
                    notasDao.insert(new Nota("Titulo4", "Descripcion4"));
                    notasDao.insert(new Nota("Titulo5", "Descripcion5"));


                }
            });


        }
    };


}
