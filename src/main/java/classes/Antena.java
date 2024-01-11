package classes;

public class Antena {
	int canalMinimo = 2;
	int canalMaximo = 13;
	
	public boolean isCanalDisponivel(int canal) {
		return canal >= this.canalMinimo 
			&& canal <= this.canalMaximo;
	}
}
