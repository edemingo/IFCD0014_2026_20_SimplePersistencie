package es.edemingo.modelo;

import java.io.Serializable;

public class Serie implements Serializable {

    private String titulo;
    private String genero;
    private int numeroTemporadas;

    public Serie(String titulo, String genero, int numeroTemporadas) {
        this.titulo = titulo;
        this.genero = genero;
        this.numeroTemporadas = numeroTemporadas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", numeroTemporadas=" + numeroTemporadas +
                '}';
    }
}


