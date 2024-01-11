package classes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCheckpoint {
	private Televisao televisao;
	private Antena antena;
	
	@Before
	public void setUp() {
		televisao = new Televisao();
		televisao.marca = "LG";
		televisao.modelo = "The frame";
		televisao.polegadas = 40;
		System.out.println(televisao.marca);
		System.out.println(televisao.polegadas);
		System.out.println(televisao.modelo);
		antena = new Antena();
	}
	
	@Test
	public void testVolume() {
		Televisao televisao = new Televisao();
		assertEquals(0, televisao.getVolume());
		televisao.aumentarVolume();
		assertEquals(0, televisao.getVolume());
		televisao.ligarOuDesligar();
		assertEquals(0, televisao.getVolume());
		televisao.aumentarVolume();
		assertEquals(1, televisao.getVolume());
		televisao.mutarOuDesmutar();
		assertEquals(0, televisao.getVolume());
		televisao.aumentarVolume();
		assertEquals(2, televisao.getVolume());
		televisao.mutarOuDesmutar();
		assertEquals(0, televisao.getVolume());
		televisao.mutarOuDesmutar();
		assertEquals(2, televisao.getVolume());
		televisao.mutarOuDesmutar();
		assertEquals(0, televisao.getVolume());
		televisao.diminuirVolume();
		assertEquals(1, televisao.getVolume());
	}
	
	@Test
	public void testCanais() {
		televisao.ligarOuDesligar();
		televisao.conectar(antena);
		televisao.sincronizarCanais();
		assertEquals(2, televisao.canalAtual);
		televisao.irParaCanalAcima();
		televisao.irParaCanalAcima();
		televisao.irParaCanalAbaixo();
		televisao.irParaCanal(12);
		assertEquals(12, televisao.canalAtual);
	}
	
	public void testTentativaDeSincronizarSemAntena() {
		Televisao televisao = new Televisao();
		televisao.ligarOuDesligar();
		assertFalse(televisao.sincronizarCanais());
	}
	
	public void testIrParaCanalForaDaFaixa() {
		televisao.ligarOuDesligar();
		televisao.conectar(antena);
		televisao.sincronizarCanais();
		assertFalse(televisao.irParaCanal(14));	
	}
	
	public void testDiminuirParaCanalForaDaFaixa() {
		televisao.ligarOuDesligar();
		televisao.conectar(antena);
		televisao.sincronizarCanais();
		assertFalse(televisao.irParaCanalAbaixo());
	}
}
