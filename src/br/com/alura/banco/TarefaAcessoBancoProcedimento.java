package br.com.alura.banco;

public class TarefaAcessoBancoProcedimento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessoBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		
		synchronized (pool) {
			System.out.println("peguei a conex�o");
			pool.getConnection();
			synchronized (tx) {
				System.out.println("come�ando a tx");
				tx.begin();
			}
		}
	}

}
