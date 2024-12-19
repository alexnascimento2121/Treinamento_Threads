package treino_threads;

import javax.swing.JOptionPane;

public class Thread_runable {
	public static void main(String[]args) throws InterruptedException {
	
	Thread threadEmail = new Thread(thread1);
	threadEmail.start();
	
	Thread threadNF = new Thread(thread2);
	threadNF.start();
	
	/*continua fluxo de trabalho*/
	System.out.println("chegou ao fim");
	
	/*fluxo do sistema...cadastro de venda,emissao de nota*/
	JOptionPane.showMessageDialog(null, "sistema continua executando para o usuario");
	
	}
	
	
	private static Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
			/*codigo executado em paralelo*/
			for(int p=0;p<5;p++) {
				/*quero executar esse envio com um tempo de parada ou tempo determinado*/
				System.out.println("executando envio de email");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}
	};
	
	private static Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			/*codigo executado em paralelo*/
			for(int p=0;p<5;p++) {
				/*quero executar esse envio com um tempo de parada ou tempo determinado*/
				System.out.println("executando nota fiscal");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}
	};
	
	
}

