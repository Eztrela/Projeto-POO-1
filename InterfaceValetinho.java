import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceValetinho {
	// setting main attributes of the menu screen
	private JFrame mainFrame;
	private JPanel mainPanel;
	private JLabel menuTitleLabel;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private Estacionamento est;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceValetinho window = new InterfaceValetinho();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InterfaceValetinho() throws Exception{
		initialize();
	}

	public void initialize() throws Exception {
		// main frame
		est = new Estacionamento(10);
		est.lerDados();
		mainFrame = new JFrame("Valet");
		mainFrame.setResizable(false);

		// main panel
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(30, 30, 30));
		mainPanel.setLayout(null);

		// menu title
		menuTitleLabel = new JLabel("Valetinho IFPB");
		menuTitleLabel.setBounds(156, 25, 154, 20);
		menuTitleLabel.setFont(new Font("Nunito", Font.BOLD, 22));
		menuTitleLabel.setForeground(new Color(240, 240, 240));
		mainPanel.add(menuTitleLabel);

		// button 1
		btn1 = new JButton();
		this.setButtonStyle(btn1, "Entrar carro", 145, 100);
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				entrarCarro(est);
			}
		});
		mainPanel.add(btn1);

		// button 2
		btn2 = new JButton();
		this.setButtonStyle(btn2, "Sair carro", 245, 100);
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				sairCarro(est);
			}
		});
		mainPanel.add(btn2);

		// button 3
		btn3 = new JButton();
		this.setButtonStyle(btn3, "Consultar placa", 145, 170);
		btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				consultarPlaca(est);
			}
		});
		mainPanel.add(btn3);

		// button 4
		btn4 = new JButton();
		this.setButtonStyle(btn4, "Transferir placa", 245, 170);
		btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				transferePlaca(est);
			}
		});
		mainPanel.add(btn4);

		// button 5
		btn5 = new JButton();
		this.setButtonStyle(btn5, "Listar geral", 145, 240);
		btn5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				listaGeral(est);
			}
		});
		mainPanel.add(btn5);

		// button 6
		btn6 = new JButton();
		this.setButtonStyle(btn6, "Listar vagas livres", 245, 240);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaLivres(est);
			}
		});
		mainPanel.add(btn6);

		// button 7
		btn7 = new JButton();
		this.setButtonStyle(btn7, "Encerrar", 195, 310);
		btn7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					est.gravarDados();
					mainFrame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					mainFrame.dispose();
				}
			}
		});
		mainPanel.add(btn7);

		mainFrame.add(mainPanel);
		mainFrame.setSize(500, 500);
		mainFrame.setVisible(true);
	}

	public void setButtonStyle(JButton button, String title, int x, int y) {
		button.setText(title);
		button.setFont(new Font("Nunito", Font.BOLD, 10));
		button.setForeground(new Color(240, 240, 240));
		button.setBackground(new Color(70, 70, 70));
		button.setBounds(x, y, 90, 50);
		button.setBorder(null);
	}

	public void entrarCarro(Estacionamento est) {
		JDialog dialog1 = new JDialog(mainFrame, "Entrar carro", true);
		dialog1.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		dialog1.setResizable(false);
		dialog1.setBounds(100, 100, 230, 230);

		// dialog panel
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(30, 30, 30));
		panel1.setLayout(null);

		// label for car license plate field
		JLabel licensePlateLabel = new JLabel("Digite a placa do carro: ");
		licensePlateLabel.setFont(new Font("Nunito", Font.BOLD, 14));
		licensePlateLabel.setForeground(new Color(240, 240, 240));
		licensePlateLabel.setBounds(20, 20, 200, 20);
		panel1.add(licensePlateLabel);

		// textfield for car license plate
		JTextField licensePlateTextfield = new JTextField();
		licensePlateTextfield.setFont(new Font("Nunito Light", Font.PLAIN, 12));
		licensePlateTextfield.setForeground(new Color(240, 240, 240));
		licensePlateTextfield.setBackground(new Color(70, 70, 70));
		licensePlateTextfield.setBounds(20, 50, 180, 20);
		licensePlateTextfield.setBorder(null);
		panel1.add(licensePlateTextfield);

		// label for parking spot field
		JLabel parkingSpotLabel = new JLabel("Digite o número da vaga: ");
		parkingSpotLabel.setFont(new Font("Nunito", Font.BOLD, 14));
		parkingSpotLabel.setForeground(new Color(240, 240, 240));
		parkingSpotLabel.setBounds(20, 80, 200, 20);
		panel1.add(parkingSpotLabel);

		// textfield for parking spot
		JTextField parkingSpotTextfield = new JTextField();
		parkingSpotTextfield.setFont(new Font("Nunito Light", Font.PLAIN, 12));
		parkingSpotTextfield.setForeground(new Color(240, 240, 240));
		parkingSpotTextfield.setBackground(new Color(70, 70, 70));
		parkingSpotTextfield.setBounds(20, 110, 180, 20);
		parkingSpotTextfield.setBorder(null);
		panel1.add(parkingSpotTextfield);

		// button to confirm and call method
		JButton confirmButton = new JButton("Confirmar");
		confirmButton.setFont(new Font("Nunito", Font.BOLD, 10));
		confirmButton.setForeground(new Color(240, 240, 240));
		confirmButton.setBackground(new Color(70, 70, 70));
		confirmButton.setBounds(70, 150, 70, 30);
		confirmButton.setBorder(null);
		panel1.add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					est.entrar(licensePlateTextfield.getText(), Integer.parseInt(parkingSpotTextfield.getText()));
					dialog1.setVisible(false);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(dialog1, "Vaga inválida.");
				}
			}
		});

		dialog1.add(panel1);
		dialog1.setVisible(true);
	}

	public void sairCarro(Estacionamento est) {
		JDialog dialog2 = new JDialog(mainFrame, "Sair carro", true);
		dialog2.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		dialog2.setResizable(false);
		dialog2.setBounds(135, 135, 230, 230);

		// dialog panel
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(30, 30, 30));
		panel2.setLayout(null);

		// label for parking spot field
		JLabel parkingSpotLabel = new JLabel("Digite o número da vaga: ");
		parkingSpotLabel.setFont(new Font("Nunito", Font.BOLD, 14));
		parkingSpotLabel.setForeground(new Color(240, 240, 240));
		parkingSpotLabel.setBounds(20, 20, 200, 20);
		panel2.add(parkingSpotLabel);

		// textfield for parking spot
		JTextField parkingSpotTextfield = new JTextField();
		parkingSpotTextfield.setFont(new Font("Nunito Light", Font.PLAIN, 12));
		parkingSpotTextfield.setForeground(new Color(240, 240, 240));
		parkingSpotTextfield.setBackground(new Color(70, 70, 70));
		parkingSpotTextfield.setBounds(20, 50, 180, 20);
		parkingSpotTextfield.setBorder(null);
		panel2.add(parkingSpotTextfield);

		// button to confirm and call method
		JButton confirmButton = new JButton("Confirmar");
		confirmButton.setFont(new Font("Nunito", Font.BOLD, 10));
		confirmButton.setForeground(new Color(240, 240, 240));
		confirmButton.setBackground(new Color(70, 70, 70));
		confirmButton.setBounds(75, 120, 70, 30);
		confirmButton.setBorder(null);
		panel2.add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					est.sair(Integer.parseInt(parkingSpotTextfield.getText()));
					dialog2.setVisible(false);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(dialog2, "Vaga inválida.");
				}
			}
		});

		dialog2.add(panel2);
		dialog2.setVisible(true);
	}

	public void consultarPlaca(Estacionamento est) {
		// dialog
		JDialog dialog3 = new JDialog(mainFrame, "Consulta Placa", true);
		dialog3.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		dialog3.setResizable(false);
		dialog3.setBounds(135, 135, 230, 230);

		// dialog panel
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(30, 30, 30));
		panel3.setLayout(null);

		// label for car license plate field
		JLabel licensePlateLabel = new JLabel("Digite a placa do carro: ");
		licensePlateLabel.setFont(new Font("Nunito", Font.BOLD, 14));
		licensePlateLabel.setForeground(new Color(240, 240, 240));
		licensePlateLabel.setBounds(20, 20, 250, 20);
		panel3.add(licensePlateLabel);

		// textfield for car license plate
		JTextField licensePlateTextfield = new JTextField();
		licensePlateTextfield.setFont(new Font("Nunito Light", Font.PLAIN, 12));
		licensePlateTextfield.setForeground(new Color(240, 240, 240));
		licensePlateTextfield.setBackground(new Color(70, 70, 70));
		licensePlateTextfield.setBounds(20, 50, 180, 20);
		licensePlateTextfield.setBorder(null);
		panel3.add(licensePlateTextfield);

		// button to confirm and call method
		JButton confirmButton = new JButton("Confirmar");
		confirmButton.setFont(new Font("Nunito", Font.BOLD, 10));
		confirmButton.setForeground(new Color(240, 240, 240));
		confirmButton.setBackground(new Color(70, 70, 70));
		confirmButton.setBounds(75, 120, 70, 30);
		confirmButton.setBorder(null);
		panel3.add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					int result = est.consultarPlaca(licensePlateTextfield.getText());
					if (result == -1) {
						JOptionPane.showMessageDialog(dialog3, "Placa inexistente.");
					} else {
						JOptionPane.showMessageDialog(dialog3, Integer.toString(result));
					}
					dialog3.setVisible(false);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(dialog3, e1.getMessage());
				}
			}
		});

		dialog3.add(panel3);
		dialog3.setVisible(true);
	}

	public void transferePlaca(Estacionamento est) {
		// dialog
		JDialog dialog4 = new JDialog(mainFrame, "Entrar carro", true);
		dialog4.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		dialog4.setResizable(false);
		dialog4.setBounds(100, 100, 230, 230);

		// dialog panel
		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(30, 30, 30));
		panel4.setLayout(null);

		// label for car license plate field
		JLabel licensePlateLabel1 = new JLabel("Digite a vaga de origem:");
		licensePlateLabel1.setFont(new Font("Nunito", Font.BOLD, 14));
		licensePlateLabel1.setForeground(new Color(240, 240, 240));
		licensePlateLabel1.setBounds(20, 20, 200, 20);
		panel4.add(licensePlateLabel1);

		// textfield for car license plate
		JTextField licensePlateTextfield1 = new JTextField();
		licensePlateTextfield1.setFont(new Font("Nunito Light", Font.PLAIN, 12));
		licensePlateTextfield1.setForeground(new Color(240, 240, 240));
		licensePlateTextfield1.setBackground(new Color(70, 70, 70));
		licensePlateTextfield1.setBounds(20, 50, 180, 20);
		licensePlateTextfield1.setBorder(null);
		panel4.add(licensePlateTextfield1);

		// label for the other car license plate field
		JLabel licensePlateLabel2 = new JLabel("Digite a vaga de destino:");
		licensePlateLabel2.setFont(new Font("Nunito", Font.BOLD, 14));
		licensePlateLabel2.setForeground(new Color(240, 240, 240));
		licensePlateLabel2.setBounds(20, 80, 200, 20);
		panel4.add(licensePlateLabel2);

		// textfield for the other car license plate
		JTextField licensePlateTextfield2 = new JTextField();
		licensePlateTextfield2.setFont(new Font("Nunito Light", Font.PLAIN, 12));
		licensePlateTextfield2.setForeground(new Color(240, 240, 240));
		licensePlateTextfield2.setBackground(new Color(70, 70, 70));
		licensePlateTextfield2.setBounds(20, 110, 180, 20);
		licensePlateTextfield2.setBorder(null);
		panel4.add(licensePlateTextfield2);

		// button to confirm and call method
		JButton confirmButton = new JButton("Confirmar");
		confirmButton.setFont(new Font("Nunito", Font.BOLD, 10));
		confirmButton.setForeground(new Color(240, 240, 240));
		confirmButton.setBackground(new Color(70, 70, 70));
		confirmButton.setBounds(75, 150, 70, 30);
		confirmButton.setBorder(null);
		panel4.add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					int placa1 = Integer.parseInt(licensePlateTextfield1.getText());
					int placa2 = Integer.parseInt(licensePlateTextfield2.getText());
					est.transferir(placa1, placa2);
					dialog4.setVisible(false);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(dialog4, e1.getMessage());
				}
			}
		});

		dialog4.add(panel4);
		dialog4.setVisible(true);
	}

	public void listaGeral(Estacionamento est) {
		String[] vagas = est.listarGeral();
		JDialog dialog5 = new JDialog(mainFrame, "Listar Geral", true);
		dialog5.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		dialog5.setResizable(false);
		dialog5.setBounds(100, 100, 300, 300);

		// dialog panel
		JPanel panel5 = new JPanel();
		panel5.setBackground(new Color(30, 30, 30));
		panel5.setLayout(null);
		JLabel labelVaga1 = new JLabel();
		labelVaga1.setFont(new Font("Nunito", Font.BOLD, 14));
		labelVaga1.setForeground(new Color(240, 240, 240));
		labelVaga1.setBounds(20, 15, 250, 190);
		String textofinal = new String();
		for(int i = 0; i < vagas.length;i++) {
			textofinal += "Vaga "+ (i+1)+": " + vagas[i] + "<br/>";
		}
		labelVaga1.setText("<html>"+textofinal+"</html>");
		panel5.add(labelVaga1);
		JButton backButton = new JButton("Voltar");
		backButton.setFont(new Font("Nunito", Font.BOLD, 10));
		backButton.setForeground(new Color(240, 240, 240));
		backButton.setBackground(new Color(70, 70, 70));
		backButton.setBounds(110, 220, 70, 30);
		backButton.setBorder(null);
		panel5.add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					dialog5.setVisible(false);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(dialog5, e1.getMessage());
				}
			}
		});

		dialog5.add(panel5);
		dialog5.setVisible(true);
	}





	public void listaLivres(Estacionamento est) {
		ArrayList<Integer> vagas = est.listarLivres();
		JDialog dialog6 = new JDialog(mainFrame, "Listar Livres", true);
		dialog6.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		dialog6.setResizable(false);
		dialog6.setBounds(100, 100, 300, 320);

		// dialog panel
		JPanel panel6 = new JPanel();
		panel6.setBackground(new Color(30, 30, 30));
		panel6.setLayout(null);
		JLabel labelVagasLivres = new JLabel();
		labelVagasLivres.setFont(new Font("Nunito", Font.BOLD, 14));
		labelVagasLivres.setForeground(new Color(240, 240, 240));
		labelVagasLivres.setBounds(100, 15, 250, 210);
		panel6.add(labelVagasLivres);
		String finalText = "Vagas Livres: <br/>";
		for(int i = 0; i < vagas.size();i++) {
			finalText += "Vaga "+vagas.get(i) + "<br/>";
		}
		labelVagasLivres.setText("<html>"+finalText+"</html>");
		JButton backButton = new JButton("Voltar");
		backButton.setFont(new Font("Nunito", Font.BOLD, 10));
		backButton.setForeground(new Color(240, 240, 240));
		backButton.setBackground(new Color(70, 70, 70));
		backButton.setBounds(110, 240, 70, 30);
		backButton.setBorder(null);
		panel6.add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					dialog6.setVisible(false);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(dialog6, e1.getMessage());
				}
			}
		});

		dialog6.add(panel6);
		dialog6.setVisible(true);
	}

}
