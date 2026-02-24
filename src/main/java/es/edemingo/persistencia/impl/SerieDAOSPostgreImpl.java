package es.edemingo.persistencia.impl;

import es.edemingo.modelo.Serie;
import es.edemingo.persistencia.interfaces.ISeriesDAO;

import java.sql.*;
import java.util.List;

public class SerieDAOSPostgreImpl implements ISeriesDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/SERIES_DB";
    private static final String user = "postgres";
    private static final String password = "test";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }

    @Override
    public Serie create(Serie serie) {
        String sql = "INSERT INTO serie (titulo, genero, numerotemporadas) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, serie.getTitulo());
            stmt.setString(2, serie.getGenero());
            stmt.setInt(3, serie.getNumeroTemporadas());

            stmt.executeUpdate();
            return serie;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Serie read(String titulo) {
        String sql = "SELECT * FROM serie WHERE titulo ilike ? ";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + titulo + "%");

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Serie(
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getInt("numeroTemporadas")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Serie update(Serie serie) {
        return null;
    }

    @Override
    public void delete(String titulo) {
        String sql = "DELETE FROM serie WHERE titulo = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas == 0) {
                System.out.println("No se encontró ninguna serie con el título: " + titulo);
            } else {
                System.out.println("Serie eliminada correctamente.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Serie> readAll() {
        return List.of();
    }
}
