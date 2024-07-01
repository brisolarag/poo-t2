package models.midia;


import java.util.ArrayList;

import interfaces.Iterador;
import models.Categoria;

public class Midiateca implements Iterador {

    private Node head;
    @SuppressWarnings("unused")
    private Node tail;
    private int count;

    private class Node {
        private Midia element;
        private Node next;
        public Node(Midia element) {
            this.element = element;
            this.next = null;
        }
    }




    public Midiateca() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public void add(int index, Midia element) {
        if ((index < 0) || (index > count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node n = new Node(element);
        if (index == 0) {
            n.next = head;
            head = n;
        } else {
            Node ant = null;
            Node target = head;
            for (int pos = 0; pos < index; pos++) {
                ant = target;
                target = target.next;
            }
            ant.next = n;
            n.next = target;
        }
        count++;
    }
    public void cadastraMidia(Midia element) {
        this.add(this.size(), element);
    } 


    public Midia get(int index) { 
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node ptr = head;
        for (int pos = 0; pos < index; pos++)
            ptr = ptr.next;
        return ptr.element;
    }
    


    public Midia set(int index, Midia element) { 
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node ptr = head;
        for (int pos = 0; pos < index; pos++)
            ptr = ptr.next;
        Midia temp = ptr.element; 
        ptr.element = element;
        return temp; 
    }
    public int indexOf(Midia element) {
        Node ptr = head;
        for (int pos = 0; pos < count; pos++) {
            if (ptr.element == element)
                return pos;
            ptr = ptr.next;
        }
        return -1;
    }
    public boolean isEmpty() {
        return this.size() == 0;
    }
    public Midia removeByIndex(int index) {
        Node aux = head;
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = head;
            aux = head.next;
            for (int pos = 1; pos < index; pos++) {
                prev = aux;
                aux = aux.next;
            }
            prev.next = aux.next;
            if (index == count - 1)
                tail = prev;
        }
        count--;
        if (count == 0)
            tail = null;
        return aux.element;
    }
    public boolean remove(Midia element) {
        int pos = indexOf(element);
        if (pos == -1)
            return false;
        removeByIndex(pos);
        return true;
    }
    @Override
    public void reset() {
        head = null;
        tail = null;
        count = 0;
    }
    @Override
    public boolean hasNext() {
        return this.head.next != null;
    } 
    @Override
    public Midia next() {
        return this.head.next.element;
    }

    public int size() {
        return this.count;
    }


    public Midia consultaMidiaCodigo(int codigo) {
        for (int i = 0 ; i < this.size() ; i++ ) {
            Midia atual = this.get(i);
            if (atual.getCodigo() == codigo)
                return atual;
        }
        return null;
    }

    public ArrayList<Midia> getMidias() {
        ArrayList<Midia> midias = new ArrayList<Midia>();
        for (int i = 0 ; i < this.size() ; i++ ) {
            midias.add(this.get(i));
        }
        return midias;
    }
    
    public ArrayList<Midia> consultaMidiaCategoria (Categoria categoria) {
        ArrayList<Midia> midiasComCategoria = new ArrayList<Midia>();
        for (int i = 0 ; i < this.size() ; i ++ ) {
            Midia atual = this.get(i);
            if (atual.getCategoria() == categoria)
                midiasComCategoria.add(atual);
        }
        return midiasComCategoria;
    }

    public ArrayList<Video> consultaMidiaQualidade (int qualidade) {
        ArrayList<Video> midiasComCategoria = new ArrayList<Video>();
        for (int i = 0 ; i < this.size() ; i ++ ) {
            Midia atual = this.get(i);
            if (atual instanceof Video) {
                Video atualv = ((Video)atual);
                if (atualv.getQualidade() == qualidade)
                    midiasComCategoria.add(atualv);
            }

        }
        return midiasComCategoria;
    }
    public Musica consultaMusicaMaiorDuracao () {
        Musica maiorDuracao = null;

        for (int i = 0 ; i < this.size() ; i ++ ) {
            Midia atual = this.get(i);
            if (atual instanceof Musica) {
                Musica atualv = ((Musica)atual);
                if (maiorDuracao == null) {
                    maiorDuracao = atualv;
                } else {
                    if (atualv.getDuracao() > maiorDuracao.getDuracao())
                        maiorDuracao = atualv;
                }
            }

        }
        return maiorDuracao;
    }

    public double todasLocacoes () {
        double acumulador = 0;
        if (this.size() == 0)
            throw new NullPointerException("Nenhuma midia...");

        for (int i = 0 ; i < this.size() ; i++ ) {
            Midia atual = this.get(i);
            acumulador += atual.calculaLocacao();
        }
        return acumulador;
    }

    public double media() {
        return this.todasLocacoes() / this.size();
    }

    public Midia maisProximoMedia() {
        double media = this.media();
        Midia maisProximo = null;

        for (int i = 0 ; i < this.size() ; i ++ ) {
            Midia atual = this.get(i);
            if (maisProximo == null) maisProximo = atual;
            else {
                double dif_atual = atual.calculaLocacao() - media;
                if (dif_atual < 0) dif_atual = dif_atual * -1;
                if (dif_atual < maisProximo.calculaLocacao())
                    maisProximo = atual;
            }
        }
        return maisProximo;
    }

    public Midia maisRecente() {
        if (this.isEmpty()) {
            return null;
        }
    
        Midia maisRecente = this.get(0); 
    
        for (int i = 1 ; i < this.size() ; i ++ ) {
            Midia atual = this.get(i);
            if ((maisRecente.getDate().compareTo(atual.getDate())) < 0)
                maisRecente = atual;
        }
        
        return maisRecente;
    }





}
