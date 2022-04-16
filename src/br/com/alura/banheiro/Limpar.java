package br.com.alura.banheiro;

public class Limpar implements Runnable {

	private Banheiro banheiro;

	public Limpar(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		
		while(true) {
			banheiro.limpa();
			
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
