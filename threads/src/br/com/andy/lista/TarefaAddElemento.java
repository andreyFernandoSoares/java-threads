package br.com.andy.lista;

public class TarefaAddElemento implements Runnable {

	private Lista lista;
	private int numeroDoThread;

	public TarefaAddElemento(Lista lista, int numeroDoThread) {
		this.lista = lista;
		this.numeroDoThread = numeroDoThread;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			lista.adicionaElementos("Thread "+this.numeroDoThread+" "+i);
		}
	}

}
