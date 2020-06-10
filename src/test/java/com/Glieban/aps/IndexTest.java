package com.loehder.aps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class IndexTest {
    private static WebDriver driver =  null;

    private static final String indexURL = "C:\\Users\\loehder\\IdeaProjects\\qts-aps-selenium-mockito\\src\\main\\java\\com\\loehdmed\\aps\\index.html";
    private static final String webChromeDriver = "webdriver.chrome.driver";
    private static final String chromeDriver = "C:\\geckodriver-v0.26.0-win64\\chromedriver.exe";

    private String name;
    private String endereco;
    private String sexo;
    private String idade;

    private WebElement campoNome;
    private WebElement campoEndereco;
    private WebElement campoSexo;
    private WebElement campoIdade;
    private WebElement salvar;
    private WebElement getResultado;

    public IndexTest() { }

    @BeforeClass
    public static void setUp() {
        System.setProperty(webChromeDriver, chromeDriver);
        driver = new ChromeDriver();
        driver.get(indexURL);
        driver.getWindowHandle();
    }

    @Before
    public void init(){
        this.name = "nhanha";
        this.endereco = "Rua X";
        this.sexo = "m";
        this.idade = "33";

        this.campoNome = driver.findElement(By.id("nome"));
        this.campoEndereco = driver.findElement(By.id("endereco"));
        this.campoSexo = driver.findElement(By.id("sexo"));
        this.campoIdade = driver.findElement(By.id("idade"));
        this.salvar = driver.findElement(By.id("botao_somar"));
        this.getResultado = driver.findElement(By.id("resultado"));

    }

    @Test
    public void testaFormularioCadastroPessoaValido() {
        this.campoNome.sendKeys(this.name);
        this.campoEndereco.sendKeys(this.endereco);
        this.campoSexo.sendKeys(this.sexo);
        this.campoIdade.sendKeys(this.idade);
        this.salvar.click();
        Alert alert = driver.switchTo().alert();
        String esperado = "Cadastro realizado com sucesso";
        assertEquals(esperado, alert.getText());
        alert.accept();
    }

    @Test
    public void testaCampoNomeBranco() {
        this.campoNome.sendKeys("");
        this.campoEndereco.sendKeys(this.endereco);
        this.campoSexo.sendKeys(this.sexo);
        this.campoIdade.sendKeys(this.idade);
        this.salvar.click();
        String esperado = "Preencha o campo nome";
        Assert.assertEquals(esperado, this.getResultado.getAttribute("innerHTML"));
    }

    @Test
    public void testaCampoEnderecoBranco() {
        this.campoNome.sendKeys(this.name);
        this.campoEndereco.sendKeys("");
        this.campoSexo.sendKeys(this.sexo);
        this.campoIdade.sendKeys(this.idade);
        this.salvar.click();
        String esperado = "Preencha o campo endereco";
        Assert.assertEquals(esperado, this.getResultado.getAttribute("innerHTML"));
    }

    @Test
    public void testaCampoSexoBranco() {
        this.campoNome.sendKeys(this.name);
        this.campoEndereco.sendKeys(this.endereco);
        this.campoSexo.sendKeys("");
        this.campoIdade.sendKeys(this.idade);
        this.salvar.click();
        String esperado = "Selecione um valor para o campo sexo";
        Assert.assertEquals(esperado, this.getResultado.getAttribute("innerHTML"));
    }

    @Test
    public void testaCampoIdadeBranco() {
        this.campoNome.sendKeys(this.name);
        this.campoEndereco.sendKeys(this.endereco);
        this.campoSexo.sendKeys(this.sexo);
        this.campoIdade.sendKeys("");
        this.salvar.click();
        String esperado = "Preencha o campo idade, somente com numeros";
        Assert.assertEquals(esperado, this.getResultado.getAttribute("innerHTML"));
    }

    @Test
    public void testaCampoIdadeNaoNumero() {
        this.campoNome.sendKeys(this.name);
        this.campoEndereco.sendKeys(this.endereco);
        this.campoSexo.sendKeys(this.sexo);
        this.campoIdade.sendKeys("a");
        this.salvar.click();
        String esperado = "Preencha o campo idade, somente com numeros";
        Assert.assertEquals(esperado, this.getResultado.getAttribute("innerHTML"));
    }

    @Test
    public void testaCampoIdadeNumeroNegativo() {
        this.campoNome.sendKeys(this.name);
        this.campoEndereco.sendKeys(this.endereco);
        this.campoSexo.sendKeys(this.sexo);
        this.campoIdade.sendKeys("-1");
        this.salvar.click();
        String esperado = "Preencha o campo idade com valores acima de 0";
        Assert.assertEquals(esperado, this.getResultado.getAttribute("innerHTML"));
    }

    @Test
    public void tituloPagina() {
        String esperado = "Trabalho 2-1";
        assertEquals(esperado, driver.getTitle());
    }

}
