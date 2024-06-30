package models.midia;

import models.Categoria;

public class Musica extends Midia {
    private double duracao;

    public double getDuracao() {
        return duracao;
    }


    public Musica(String titulo, int ano, Categoria categoria, double duracao) {
        super(titulo, ano, categoria);
        this.duracao = duracao;
    }

    private int transformaEmMinutos (double duracao) {
        return (int) duracao / 60;
    }

    private int pegaSegundos (double duracao) {
        int minutos = (int) duracao / 60;
        return (int) duracao - (minutos * 60);
    }


    public double calculaLocacao() {
        switch (this.getCategoria()) {
            case Categoria.ACA:
                return transformaEmMinutos(this.getDuracao()) * 0.90;
            case Categoria.DRA:
                return transformaEmMinutos(this.getDuracao()) * 0.70;
            case Categoria.FIC:
                return transformaEmMinutos(this.getDuracao()) * 0.50;
            case Categoria.ROM:
                return transformaEmMinutos(this.getDuracao()) * 0.30;
            default:
                return 0.00;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(", ").append(transformaEmMinutos(this.getDuracao())).append(":").append(pegaSegundos(this.getDuracao()));
        return builder.toString();
    }

}
