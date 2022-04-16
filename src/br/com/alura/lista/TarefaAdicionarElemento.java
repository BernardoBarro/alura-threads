package br.com.alura.lista;

public class TarefaAdicionarElemento implements Runnable {

	private Lista lista;
	private int numeroThread;

	public TarefaAdicionarElemento(Lista lista, int i) {
		this.lista = lista;
		this.numeroThread = i;

	}

	@Override
	public void run() {
		
		for(int i=0;i < 10; i++) {
			
			lista.adicionaElementos("Thread " + numeroThread + " - " + i);
			
		}
	}

}
