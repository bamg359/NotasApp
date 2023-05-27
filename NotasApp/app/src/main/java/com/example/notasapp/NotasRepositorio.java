package com.example.notasapp;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotasRepositorio {

    private NotasDao notasDao;
    private LiveData<List<Nota>> nota;

    ExecutorService executors = Executors.newSingleThreadExecutor();

    public NotasRepositorio (Application application){

        NotasDB database = NotasDB.getInstance(application);
        notasDao = database.notasDao();
        nota = notasDao.getAllNote();
    }


    public void insert(Nota nota){
         executors.execute(new Runnable() {
             @Override
             public void run() {
                 notasDao.insert(nota);
             }
         });

        }


    public void update(Nota nota){

        executors.execute(new Runnable() {
            @Override
            public void run() {
                notasDao.update(nota);
            }
        });
    }


    public void delete(Nota nota){

        executors.execute(new Runnable() {
            @Override
            public void run() {
                notasDao.delete(nota);
            }
        });

    }


    public LiveData<List<Nota>> getAllNote(){

        return nota;
    }



}
