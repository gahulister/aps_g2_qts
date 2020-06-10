package com.Glieban.aps;

public class Endereco {
    String nome;
    String cep;

    public Endereco() {
    }

    public Endereco(String cep, String nome) {
        this.nome = nome;
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
