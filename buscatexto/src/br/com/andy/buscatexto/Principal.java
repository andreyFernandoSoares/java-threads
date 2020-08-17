package br.com.andy.buscatexto;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String[] args) {
		
		String nome = "da";
		
		List<Thread> listaThread = new ArrayList<>();
		
		listaThread.add(new Thread(new TarefaBuscaTextual("assinaturas1.txt", nome), "ThreadAss1"));
		listaThread.add(new Thread(new TarefaBuscaTextual("assinaturas2.txt", nome), "ThreadAss2"));
	    listaThread.add(new Thread(new TarefaBuscaTextual("autores.txt", nome), "ThreadAutores"));
	    
	    listaThread.forEach(t -> t.start());
	}
}
