package com.loehder.aps;

import com.loehder.aps.CorreioService;
import com.loehder.aps.EnderecoDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CorreioServiceTest {

    @InjectMocks
    private CorreioService correioService;

    @Mock
    EnderecoDAO enderecoDAO;

    String poaCep;
    String assisBrasilCep;

    @Before
    public void setUp() throws Exception {
        poaCep = "9000000";
        assisBrasilCep = "8000000";
    }

    @Test
    public void buscaEnderecoPoa() {
        when(enderecoDAO.getByCep(poaCep)).thenReturn("Porto Alegre");
        String buscaCep = correioService.buscaEndereco(poaCep);
        String esperado = "Porto Alegre";
        Assert.assertEquals(esperado, buscaCep);
    }

    @Test
    public void buscaEnderecoAssisBrasil() {
        when(enderecoDAO.getByCep(assisBrasilCep)).thenReturn("Av. Assis Brasil");
        String buscaCep = correioService.buscaEndereco(assisBrasilCep);
        String esperado = "Av. Assis Brasil";
        Assert.assertEquals(esperado, buscaCep);
    }
}
