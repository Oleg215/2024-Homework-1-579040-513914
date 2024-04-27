package diadia_base.tar.gz_expanded;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {

//	limitarsi alla sola verifica del corretto riconoscimento dei comandi
	private FabbricaDiComandiFisarmonica factory;
	private Comando comando;
	
	@Before
	public void setUp() {
		this.factory = new FabbricaDiComandiFisarmonica();
	}
	
	@Test
	public void ComandoNonValidoTest() {
		this.comando = new ComandoNonValido();
		assertEquals(comando.getNome(), factory.costruisciComando("sudest").getNome());
	}
	
	@Test
	public void ComandoConParametroTest() {
		this.comando = new ComandoPrendi();
		this.comando.setParametro("osso");
		assertEquals(comando.getNome(), factory.costruisciComando("prendi osso").getNome());
		assertEquals(comando.getParametro(), factory.costruisciComando("prendi osso").getParametro());
	}
	
	@Test
	public void ComandoFineTest() {
		this.comando = new ComandoFine();
		assertEquals(comando.getNome(), factory.costruisciComando("fine").getNome());
	}
	
}

/*
@Test
	public void testComandoNonValido() {
		expected = new ComandoNonValido();
		assertEquals( expected.getNome(), fabbrica.costruisciComando("pippo").getNome());
	}
	
	@Test
	public void testComandoConParametro() {
		expected = new ComandoVai();
		expected.setParametro("nord");
		Comando current = fabbrica.costruisciComando("vai nord");
		assertEquals( expected.getNome(), current.getNome());
		assertEquals( expected.getParametro(), current.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro() {
		expected = new ComandoFine();
		assertEquals( expected.getNome(), fabbrica.costruisciComando("fine").getNome());
	}
*/