package br.edu.infnet.bootalunoapp.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IntegrationUISeleniumIT {

	@Before
	public void init() {		
		System.setProperty("webdriver.gecko.driver", "D:\\Desenvolvimento\\Programas\\integracao-continua\\geckodriver.exe");		
	}
	
	@Test
	public void deveCadastrarAluno() {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8585/app-bootaluno");
	
		driver.findElement(By.linkText("Cadastrar novo aluno")).click();
		
		driver.findElement(By.id("nome")).sendKeys("Pontes Marinho");
		driver.findElement(By.id("email")).sendKeys("paulomarinho@email.com");
		
		driver.findElement(By.cssSelector(".btn-primary")).click();
		
		assertTrue(driver.getPageSource().contains("paulomarinho@email.com"));
		
	}
	

	//@Test
	public void deveExcluirAluno() {			
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8585/app-bootaluno");
		
		//driver.findElement(By.xpath("//a[@href='/app-bootaluno/delete/3' and button[contains(text(), 'Excluir')]]").partialLinkText("Excluir")).click();
		String strPath = "//tr/td/a[@href='/app-bootaluno/delete/1']/button[@type='button' and contains(text(), 'Excluir')]";
		strPath = "/html/body/div/table/tbody/tr[1]/td[4]/a[2]/button";
		
		driver.findElement(ByXPath.xpath(strPath)).click();
		
		//assertNotEquals(false, driver.getPageSource().contains("1"));
		
	}
	
}
