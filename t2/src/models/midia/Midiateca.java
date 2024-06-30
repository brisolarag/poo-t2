package models.midia;

import java.util.ArrayList;

import models.Categoria;

public class Midiateca {
    private ArrayList<Midia> todasMidias;

    public Midiateca() {
        this.todasMidias = new ArrayList<Midia>();
    }

    public ArrayList<Midia> getMidias() {
        return this.todasMidias;
    }

    public boolean cadastraMidia(Midia midia) {
        boolean error = false;
        try {
            todasMidias.add(midia);
        } catch (Exception e) {
            error = true;
        }
        return error;
    }

    public Midia consultaMidiaCodigo (int codigo) {
        for (Midia m : todasMidias) {
            if (m.getCodigo() == codigo)
                return m;
        }
        return null;
    }

    public ArrayList<Midia> consultaPorCategoria (Categoria c) {
        ArrayList<Midia> categoriasIguais = new ArrayList<Midia>();
        for (Midia midia : todasMidias) {
            if (midia.getCategoria() == c)
                categoriasIguais.add(midia);
        }
        return categoriasIguais;
    }

    public boolean removeMidia(int codigo) {
        Midia toRemove = null;        
        for (Midia midia : todasMidias) {
            if (midia.getCodigo() == codigo)
                toRemove = midia;
        }
        return toRemove != null;
    }
}
