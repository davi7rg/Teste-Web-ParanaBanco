package com.test.web.paranabanco.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.web.paranabanco.methods.Methods;

/**
 * Unit test for simple App.
 */
public class ValidatorClass {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        return driver;
    }

    public static Methods methods() throws IOException {

        Methods metodos = new Methods();
        return metodos;
    }

    @Before
    public void beforeTests() {

        driver = new ChromeDriver();

        try {
            // driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/challenging_dom");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Falha na iniciação dos testes");
        }
    }

    @After
    public void afterTests() {

        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Falha na finalização dos testes");
        }
    }

    @Test
    public void teste1Exercicio() throws IOException {

        try {

            WebElement buttonBlue = driver.findElement(By.cssSelector("[class='button']"));
            methods().highlightElement(buttonBlue);
            buttonBlue.click();
            assertTrue(true);

            WebElement buttonRed = driver.findElement(By.cssSelector("[class='button alert']"));
            methods().highlightElement(buttonRed);
            buttonRed.click();
            assertTrue(true);

            WebElement buttonGreen = driver.findElement(By.cssSelector("[class='button success']"));
            methods().highlightElement(buttonGreen);
            buttonGreen.click();
            assertTrue(true);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Falha nos testes");
        }

    }

    @Test
    public void teste2Exercicio() throws IOException {

        try {

            // Dava para fazer em um unico findElement mas a ideia aqui e a demonstracao do
            // uso conforme o exercicio solicita
            // Encontra tabela pela tag que eh unica na pagia
            WebElement elementTable = driver.findElement(By.tagName("table"));

            // Obtem todos os elementos de link EDIT existentes na tabela
            // Clica em cada um deles na sequencia
            List<WebElement> elementsEdit = elementTable.findElements(By.cssSelector("tbody td a[href='#edit']"));
            for (WebElement elements : elementsEdit) {
                methods().highlightElement(elements);
                elements.click();
                assertTrue(true);
            }

            // Obtem todos os elementos de link DELETE existentes na tabela
            // Clica em cada um deles na sequencia
            List<WebElement> elementsDelete = elementTable.findElements(By.cssSelector("tbody td a[href='#delete']"));
            for (WebElement elements : elementsDelete) {
                methods().highlightElement(elements);
                elements.click();
                assertTrue(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Falha nos testes");
        }
    }

}
