package es.edemingo.persistencia;

import es.edemingo.modelo.Serie;
import java.util.List;

public interface ISeriesDAO {

    public Serie create(Serie serie);
    public Serie read(String titulo);
    public Serie update(Serie serie);
    public void delete(String titulo);
    public List<Serie> readAll();

}
