package models.midia;

import models.Categoria;

public class Video extends Midia {
    private int qualidade;
    public int getQualidade() {
        return qualidade;
    }

    public Video (String titulo, int ano, Categoria categoria, int qualidade) {
        super(titulo, ano, categoria);
        this.qualidade = qualidade;
    } 


    public double calculaLocacao() {
        if (this.getAno() < 2024) {
            if (this.getAno() < 2000)
                return 10.00;
            return 15.00;
        }
        return 20.00;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(", ").append(this.getQualidade()).append(", R$").append(this.calculaLocacao());
        return builder.toString();
    }
}
