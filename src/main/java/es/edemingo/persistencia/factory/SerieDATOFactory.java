package es.edemingo.persistencia.factory;

import es.edemingo.persistencia.impl.SerieDAOFileImpl;
import es.edemingo.persistencia.impl.SerieDAOSPostgreImpl;
import es.edemingo.persistencia.interfaces.ISeriesDAO;
import es.edemingo.persistencia.impl.SeriaDAOSQLiteImpl;
import es.edemingo.util.AppPropertiesReader;
import es.edemingo.util.PropertiesReader;

public class SerieDATOFactory {

    private static final String FILE_NAME = "config.prop";
    private static final String KEY = "PERSISTENCIE_TYPE";

    public static ISeriesDAO getSerieDAOImpl(){

        String daoType = AppPropertiesReader.readProperty(FILE_NAME, KEY);

        PersistenceType persistenceType = PersistenceType.valueOf(daoType);

        switch (persistenceType) {
            case PersistenceType.FILE:
                return new SerieDAOFileImpl();
            case PersistenceType.SQLITE:
                return new SeriaDAOSQLiteImpl();
            case PersistenceType.POSTGRE:
                return new SerieDAOSPostgreImpl();
            default:
                return new SeriaDAOSQLiteImpl();
        }
    }
}
