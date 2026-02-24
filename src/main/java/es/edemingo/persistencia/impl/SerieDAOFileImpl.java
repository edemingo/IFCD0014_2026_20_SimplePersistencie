package es.edemingo.persistencia.impl;

import es.edemingo.modelo.Serie;
import es.edemingo.persistencia.interfaces.ISeriesDAO;

import java.io.*;
import java.util.List;

public class SerieDAOFileImpl implements ISeriesDAO {

    @Override
    public Serie create(Serie serie) {
        try (FileOutputStream fileOut = new FileOutputStream(serie.getTitulo()+".txt");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(serie);
            System.out.println("Objeto guardado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serie;
    }

    @Override
    public Serie read(String titulo) {
        Serie serie = null;
        try (FileInputStream fileIn = new FileInputStream(titulo + ".txt");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            serie = (Serie)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return serie;
    }

    @Override
    public Serie update(Serie serie) {
        return null;
    }

    @Override
    public void delete(String titulo) {

    }

    @Override
    public List<Serie> readAll() {
        return List.of();
    }
}
