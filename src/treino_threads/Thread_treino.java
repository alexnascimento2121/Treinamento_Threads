package treino_threads;

import javax.swing.JOptionPane;

public class Thread_treino {
	public static void main(String[]args) throws InterruptedException {
		/*Thread 1-exemplo envio de email*/
		new Thread() {
			public void run() {/*executa o codigo parelalo*/
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
			
		}.start();/*Start liga a thread que executa paralelamente por trás*/	
		
		/*Thread 2-executar nota fiscal*/
		new Thread() {
			public void run() {/*executa o codigo parelalo*/
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
			
		}.start();/*Start liga a thread que executa paralelamente por trás*/
		
		/*continua fluxo de trabalho*/
		System.out.println("chegou ao fim");
		
		/*fluxo do sistema...cadastro de venda,emissao de nota*/
		JOptionPane.showMessageDialog(null, "sistema continua executando para o usuario");
	}

}
