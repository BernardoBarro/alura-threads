package br.com.alura.banheiro;

public class Banheiro {
	
	private boolean ehSujo = true;

	public void fazNumero1() {

		String nome = Thread.currentThread().getName();
		synchronized (this) {
			System.out.println(nome + " - entrando");
			
			while(ehSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " - mijando");
			ehSujo=true;

			dormeUmPouco(5000);

			System.out.println(nome + " - dando descarga");
			System.out.println(nome + " - levando a mão");
			System.out.println(nome + " - saída do banheiro");
		}
	}

	public void fazNumero2() {

		String nome = Thread.currentThread().getName();
		synchronized (this) {
			System.out.println(nome + " - entrando");
			
			while(ehSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " - cagando");
			
			ehSujo=true;

			dormeUmPouco(10000);

			System.out.println(nome + " - dando descarga");
			System.out.println(nome + " - levando a mão");
			System.out.println(nome + " - saída do banheiro");
		}
	}

	private void dormeUmPouco(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void limpa() {
		
		String nome = Thread.currentThread().getName();
		synchronized (this) {
			System.out.println(nome + " - entrando");
			
			if(!ehSujo) {
				System.out.println(nome + ", não está sujo, vou sair");
				return;
			}
			
			System.out.println(nome + " - limpando");
			this.ehSujo = false;

			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.notifyAll();

			System.out.println(nome + " - dando descarga");
			System.out.println(nome + " - levando a mão");
			System.out.println(nome + " - saída do banheiro");
		}
		
	}
	
	private void esperaLaFora(String nome) {
		System.out.println(nome + ", eca, ta sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
