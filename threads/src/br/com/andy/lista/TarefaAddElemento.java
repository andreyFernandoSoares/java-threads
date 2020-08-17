package br.com.andy.lista;

import java.util.List;

public class TarefaAddElemento implements Runnable {

	private List<String> lista;
	private int numeroDoThread;

	public TarefaAddElemento(List<String> lista, int numeroDoThread) {
		this.lista = lista;
		this.numeroDoThread = numeroDoThread;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			lista.add("Thread "+this.numeroDoThread+" "+i);
		}
	}

}
