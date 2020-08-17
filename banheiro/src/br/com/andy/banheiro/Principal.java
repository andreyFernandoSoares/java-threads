package br.com.andy.banheiro;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String[] args) {
		
		Banheiro banheiro = new Banheiro();
		
		List<Thread> convidados = new ArrayList<>();
		convidados.add(new Thread(new TarefaNumero1(banheiro), "Maicon"));
		convidados.add(new Thread(new TarefaNumero2(banheiro), "Cleisson"));
		Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");
		limpeza.setDaemon(true);
		convidados.add(limpeza);
		convidados.forEach(t -> t.start());
	}
}
