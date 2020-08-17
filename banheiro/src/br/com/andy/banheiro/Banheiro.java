package br.com.andy.banheiro;

public class Banheiro {
	
	private boolean ehSujo = true;
	
	public void fazNumero1() {
		
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " Batendo na porta");
		
		synchronized(this) {
			System.out.println(nome+" Entrando no banheiro");
			
			while (ehSujo) 
				eperarFora(nome);
			
			System.out.println(nome+" Fazendo coisa rapida");
			
			dormeUmPoco(5000);
			
			this.ehSujo = true;
			
			System.out.println(nome+" Dando descarga");
			System.out.println(nome+" Lavando a mao");
			System.out.println(nome+" Saindo do banheiro\n");
		}
	}
	
	public void fazNumero2() {
		
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " Batendo na porta");
		
		synchronized(this) {
			System.out.println(nome+" Entrando no banheiro");
			
			while (ehSujo) 
				eperarFora(nome);
				
			System.out.println(nome+" Fazendo coisa demorada");
			
			dormeUmPoco(10000);
			
			this.ehSujo = true;
			
			System.out.println(nome+" Dando descarga");
			System.out.println(nome+" Lavando a mao");
			System.out.println(nome+" Saindo do banheiro\n");
		}
	}
	
	public void limpa() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " Batendo na porta");
		
		synchronized(this) {
			System.out.println(nome+" Entrando no banheiro");
			
			if (!ehSujo) {
				System.out.println(nome+" Não esta sujo vou sair!\n");
				return;
			}
			
			System.out.println(nome+" Limpando banheiro");
			
			dormeUmPoco(13000);
			
			System.out.println(nome+" Limpeza finalizada\n");
			
			this.ehSujo = false;
			
			this.notifyAll();
			
		}
	}
	
	public void eperarFora(String nome) {
		System.out.println(nome+" vish, banheiro ta sujo\n");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void dormeUmPoco(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
