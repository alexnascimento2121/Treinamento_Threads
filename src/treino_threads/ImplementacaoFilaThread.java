package treino_threads;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread{
	
	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();
	
	// metodo que adiciona objetos na fila
	public static void add(ObjetoFilaThread objetofila) {
		pilha_fila.add(objetofila);
	}
	
	@Override
	public void run() {
		System.out.println("fila funcionando");
		
		while(true) {
			Iterator iteracao=pilha_fila.iterator();
		
		synchronized (iteracao) {/*Bloquear o acesso a esta lista por outro processo*/
			
			while(iteracao.hasNext()) {// enquanto conter dados na lista ira processar
				
				ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();/*pega o obejto atual*/
				/*processar 10 mil notas fiscais*/
				/*gerar 100 pdf*/
				/*enviar email em massa*/
				System.out.println("------------------------------------------------------");
				
				System.out.println(processar.getNome());
				System.out.println(processar.getEmail());

				iteracao.remove();
				
					try {
						Thread.sleep(100);/*tempo de descarga de memoria*/
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}		
			try {
				Thread.sleep(1000); /*Processou toda a lista de tarefas tempo de descarga de memoria*/
			} catch (InterruptedException e) {			
				e.printStackTrace();
				}	
			}
		}	
}
