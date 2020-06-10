package com.Glieban.aps;

public class CorreioService {

    EnderecoDAO enderecoDAO;

    public String buscaEndereco(String cep) {
       return enderecoDAO.getByCep(cep);
    }

}
