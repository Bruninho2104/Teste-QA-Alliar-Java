package metodos;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import factory.Driver;

public class Metodos extends Driver {

	public void abrirNavegador(String navegador, String site) {
		if (navegador.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(navegador.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.get(site);
		driver.manage().window().maximize();
	}

	public void fecharNavegador() {
		driver.close();
	}

	public void tirarPrint(String nomePrint) throws IOException {
		TakesScreenshot print = (TakesScreenshot) driver;
		File printFile = print.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Evidencias/" + nomePrint + ".png");
		FileUtils.copyFile(printFile, destFile);
	}

	public void escrever(By el, String texto) {
		driver.findElement(el).sendKeys(texto);
	}

	public void clicar(By el) {
		driver.findElement(el).click();
	}
}
