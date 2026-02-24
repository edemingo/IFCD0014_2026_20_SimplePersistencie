package es.edemingo.util;

import es.edemingo.persistencia.ISeriesDAO;
import es.edemingo.persistencia.SeriaDAOSQLiteImpl;
import es.edemingo.persistencia.SerieDAOFileImpl;

public class SerieDATOFactory {

    public static ISeriesDAO getSerieDAOImpl(){
        return new SeriaDAOSQLiteImpl();
    }

}
