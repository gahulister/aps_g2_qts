package com.Glieban.aps;

public class EnderecoDAO {

    public String getByCep(String cep) {
        switch (cep) {
            case "9000000":
                return "Porto Alegre";
            case "8000000":
                return "Av. Assis Brasil";
            default:
                return "Nao encontrado";
        }
    }
}
