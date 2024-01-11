package classes;

public class Televisao {
	String marca;
	int polegadas;
	String modelo;
	boolean ligada;
	int volume;
	Antena antena;
	boolean sincronizada;
	int canalAtual;
	boolean mudo;
	
	Televisao(String marca, int polegadas, String modelo) {
		this.marca = marca;
		this.polegadas = polegadas;
		this.modelo = modelo;
	}
	
	Televisao() {
		
	}
	
	
	
	public int getVolume() {
		if (this.mudo) {
			return 0;
		}
		
		return this.volume;
	}
	
	public void ligarOuDesligar() {
		this.ligada = !ligada;
	}


	public boolean sincronizarCanais() {
		if (!this.ligada) {
			return false;
		}
		
		if (!this.isAntenaConectada()) {
			return false;
		}
		
		System.out.println("Sincronizando canais");
		this.canalAtual = this.antena.canalMinimo;
		this.sincronizada = true;		
		return true;
	}
	
	public boolean irParaCanal(int numeroCanal) {
		
		if (this.ligada) {
			if (!this.sincronizada) {
				return false;
			}
			
			if (this.antena.isCanalDisponivel(numeroCanal)) {
				this.canalAtual = numeroCanal;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean irParaCanalAcima() {
		return this.irParaCanal(this.canalAtual + 1);
	}
	
	public boolean irParaCanalAbaixo() {
		return this.irParaCanal(this.canalAtual - 1);
	}
	
	public void aumentarVolume() {

		if (this.ligada && volume < 100) {
			this.mudo = false;
			this.volume++;
		}
	}
	
	public void diminuirVolume() {

		if (this.ligada && volume > 0) {
			this.mudo = false;
			this.volume--;
		}
	}

	public void mutarOuDesmutar() {
		if (!this.ligada) {
			return;
		}
		
		this.mudo = !this.mudo;
	}

	
	
	
	public void conectar(Antena antena) {
		this.antena = antena;
	}
	
	private boolean isAntenaConectada() {
		return this.antena != null;
	}
}
