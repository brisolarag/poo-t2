package models.midia;

import models.Categoria;

public abstract class Midia {
    private int _codigo = 0;  


    private int codigo;
    private void setCodigo() {
        this.codigo = _codigo;
        _codigo++;
    }
    public int getCodigo() {
        return codigo;
    }

    private String titulo;
    public String getTitulo() {
        return titulo;
    }


    private int ano;
    public int getAno() {
        return ano;
    }

    private Categoria categoria;
    public Categoria getCategoria() {
        return categoria;
    }

    public Midia(String titulo, int ano, Categoria categoria) {
        this.setCodigo();
        this.titulo = titulo;
        this.ano = ano;
        this.categoria = categoria;
    }

    

    abstract double calculaLocacao();


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.codigo);
        builder.append(". [").append(this.getTitulo()).append("] ").append(this.getAno()).append(" - ").append(this.getCategoria());
        return builder.toString();
    }
}
