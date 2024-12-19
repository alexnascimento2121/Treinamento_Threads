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

public class TelaTimeThread extends  JDialog{

	private static final long serialVersionUID = -1117702631864334760L;
	
	private JPanel jPanel = new JPanel(new GridBagLayout());/*painel de componentes*/
	
	private JLabel label_1 = new JLabel("Time Thread 1");/*label que mostra o texto*/
	
	private JTextField tempo_1 = new JTextField();/*label que mostra o horaro*/
	
	private JLabel label_2 = new JLabel("Time Thread 2");/*label que mostra o texto 2 */
	
	private JTextField tempo_2 = new JTextField();/*label que mostra o horaro 2*/
	
	private JButton button_1 = new JButton("Start");/*botao que inicia o relogio*/
	
	private JButton button_2 = new JButton("Stop");/*botao que para o relogio*/
	
	private Runnable thread = new Runnable() {		
		@Override
		public void run() {
			while(true) {/*roda infinitamente enquanto for true*/
				tempo_1.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Calendar.getInstance().getTime()));
			//	tempo_2.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Calendar.getInstance().getTime())); forma simples
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	};
	
	private Runnable thread2 = new Runnable() {		
		@Override
		public void run() {
			while(true) {/*roda infinitamente enquanto for true*/			
				tempo_2.setText(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(Calendar.getInstance().getTime())); 
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	};
	
	private Thread threadTempo1;
	private Thread threadTempo2;
	
	public TelaTimeThread() {
		/*executa o que tiver dentro no momento da criação do obejto da classe*/
		setTitle("Tela de Time com Thread");
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
		tempo_1.setEditable(false);
		jPanel.add(tempo_1,gridBag);
		
		label_2.setPreferredSize(new Dimension(200,25));
		gridBag.gridy ++;
		jPanel.add(label_2,gridBag);
		
		tempo_2.setPreferredSize(new Dimension(200,25));
		gridBag.gridy ++;
		tempo_2.setEditable(false);
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
				threadTempo1 = new Thread(thread);
				threadTempo1.start();	
				
				threadTempo2 = new Thread(thread2);
				threadTempo2.start();
				
				button_1.setEnabled(false);
				button_2.setEnabled(true);
			}
		});		
		
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*executa o clique no botao stop*/
				threadTempo1.stop();	
				threadTempo2.stop();
				
				button_1.setEnabled(true);
				button_2.setEnabled(false);
			}
		});
		
		button_2.setEnabled(false);
		
		add(jPanel,BorderLayout.WEST);
		setVisible(true);/*torna tela visivel ao usuario, sempre sera ultimo a ser executado*/
	}
}
