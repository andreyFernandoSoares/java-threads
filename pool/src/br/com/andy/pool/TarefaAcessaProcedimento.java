package br.com.andy.pool;

public class TarefaAcessaProcedimento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		synchronized (pool) {
			System.out.println("Peguei a conexão");
			pool.getConnection();
			
			synchronized (tx) {
				System.out.println("Comecando a tx");
				tx.begin();
				
			}
		}
	}

}
