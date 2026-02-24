package es.edemingo.persistencia.factory;

import es.edemingo.persistencia.interfaces.ISeriesDAO;
import es.edemingo.persistencia.impl.SeriaDAOSQLiteImpl;

public class SerieDATOFactory {

    public static ISeriesDAO getSerieDAOImpl(){
        return new SeriaDAOSQLiteImpl();
    }

}
