package com.test.web.paranabanco.methods;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.test.web.paranabanco.test.ValidatorClass;

public class Methods {

    ValidatorClass validator = new ValidatorClass();

    /**
	 * Metodo que recebe a informacao do elemento visivel em tela bem como a marcacao do elemento com um moldura vermelhas
	 * 
	 * @param element - Elemento para interecao
	 * @throws IOException
	 */
	public void highlightElement(WebElement element) throws IOException {
		highlight(element, 1);
	}

    /**
	 * Metodo que seleciona o elemento desejado com uma moldura vermelhas
	 * 
	 * @param element - Elemento para interecao
	 * @throws IOException
	 */
    
	private void highlight(WebElement element, int waitSeconds) {
		String style = element.getAttribute("style");
		
		JavascriptExecutor js = (JavascriptExecutor) ValidatorClass.getDriver();
		js.executeScript("arguments[0].setAttribute('style','border:2px solid red;')", element);
		
		try {
			Thread.sleep(waitSeconds*500);
			js.executeScript("arguments[0].setAttribute('style','"+style+"')", element);
		} catch (Exception e) {
			js.executeScript("arguments[0].setAttribute('style','"+style+"')", element);
		}
	}    
}
