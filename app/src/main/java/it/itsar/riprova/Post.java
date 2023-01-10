package it.itsar.riprova;

import java.io.Serializable;

public class Post implements Serializable {
    String nome;
    int immagine;

    public Post(String nome, int immagine) {
        this.nome = nome;
        this.immagine = immagine;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImmagine() {
        return immagine;
    }

    public void setImmagine(int immagine) {
        this.immagine = immagine;
    }
}
