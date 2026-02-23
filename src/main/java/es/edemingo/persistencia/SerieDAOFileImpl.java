package es.edemingo.persistencia;

import es.edemingo.modelo.Serie;

import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;
import java.util.List;

public class SerieDAOFileImpl implements ISeriesDAO{

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
        return null;
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
