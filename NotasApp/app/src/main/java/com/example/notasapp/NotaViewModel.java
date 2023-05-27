package com.example.notasapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NotaViewModel extends AndroidViewModel {

    private NotasRepositorio repositorio;
    private LiveData<List<Nota>> notas;

    public NotaViewModel(@NonNull Application application){

        super(application);


        repositorio = new NotasRepositorio(application);
        notas = repositorio.getAllNote();



    }


    public void insert(Nota nota){

        repositorio.insert(nota);
    }

    public void update(Nota nota){

        repositorio.update(nota);
    }

    public  void delete(Nota nota){
        repositorio.delete(nota);
    }

    public LiveData<List<Nota>> getAllNotas() {
        return notas;
    }
}
