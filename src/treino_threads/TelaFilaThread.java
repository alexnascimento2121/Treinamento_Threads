package treino_threads;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaFilaThread extends  JDialog{

	private static final long serialVersionUID = -1117702631864334760L;
	
	private JPanel jPanel = new JPanel(new GridBagLayout());/*painel de componentes*/
	
	private JLabel label_1 = new JLabel("Nome");/*label que mostra o texto*/
	
	private JTextField tempo_1 = new JTextField();/*label que mostra o horaro*/
	
	private JLabel label_2 = new JLabel("Email");/*label que mostra o texto 2 */
	
	private JTextField tempo_2 = new JTextField();/*label que mostra o horaro 2*/
	
	private JButton button_1 = new JButton("Add");/*botao que inicia o relogio*/
	
	private JButton button_2 = new JButton("Stop");/*botao que para o relogio*/
	
	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();
	
	
	
	public TelaFilaThread() {
		/*executa o que tiver dentro no momento da criação do obejto da classe*/
		setTitle("Tela Fila de execucao com Thread");
		setSize(new Dimension(240,240));
		setLocationRelativeTo(null);
		setResizable(false);
		
		/*posicinamento de componentes*/
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.gridx=0;
		gridBag.gridy=0;
		gridBag.gridwidth=2;
		gridBag.insets= new Insets(5, 10, 5, 5);
		gridBag.anchor= GridBagConstraints.WEST;
		
		label_1.setPreferredSize(new Dimension(200,25));
		jPanel.add(label_1,gridBag);
		
		tempo_1.setPreferredSize(new Dimension(200,25));
		gridBag.gridy ++;
		jPanel.add(tempo_1,gridBag);
		
		label_2.setPreferredSize(new Dimension(200,25));
		gridBag.gridy ++;
		jPanel.add(label_2,gridBag);
		
		tempo_2.setPreferredSize(new Dimension(200,25));
		gridBag.gridy ++;		
		jPanel.add(tempo_2,gridBag);
		
		gridBag.gridwidth=1;/*componentes com espaco de 1*/
		
		button_1.setPreferredSize(new Dimension(92,25));
		gridBag.gridy ++;
		jPanel.add(button_1,gridBag);		
		
		button_2.setPreferredSize(new Dimension(92,25));
		gridBag.gridx ++;
		jPanel.add(button_2,gridBag);
		
		button_1.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*executa o clique no botao start*/
				
				if(fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();
				}
				
				for(int qtd =0;qtd <10; qtd++) { /*simulando 10*/
				ObjetoFilaThread filaThread = new ObjetoFilaThread();
				filaThread.setNome(tempo_1.getText());
				filaThread.setEmail(tempo_2.getText()+" - "+qtd);
				
				fila.add(filaThread);
				}
			}
		});		
		
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*executa o clique no botao stop*/
				fila.stop();
				fila=null;
				
			}
		});
		
		
		fila.start();
		add(jPanel,BorderLayout.WEST);
		setVisible(true);/*torna tela visivel ao usuario, sempre sera ultimo a ser executado*/
	}
}
