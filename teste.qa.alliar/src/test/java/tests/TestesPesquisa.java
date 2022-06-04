package tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import metodos.Metodos;
import pages.OlxHomePage;

public class TestesPesquisa{

	Metodos metodos = new Metodos();
	OlxHomePage homePage = new OlxHomePage();
	
	//Pode colocar "chrome" se quiser rodar no chrome
	String navegador = "edge";
	
	@Before
	public void setUp() throws Exception {
		metodos.abrirNavegador( navegador,"https://www.olx.com.br");
	}

	@After
	public void tearDown() throws Exception {
		metodos.fecharNavegador();
	}

	@Test
	public void testePesquisaValida() throws IOException {
		metodos.escrever(homePage.campoPesquisa, "Bicicleta");
		metodos.clicar(homePage.btnPesquisa);
		metodos.tirarPrint("pesquisaValida");
	}
	
	@Test
	public void testePesquisaInvalida() throws IOException {
		metodos.escrever(homePage.campoPesquisa, "@");
		metodos.clicar(homePage.btnPesquisa);
		metodos.tirarPrint("pesquisaInvalida");
	}

}
