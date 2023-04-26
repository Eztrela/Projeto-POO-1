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
    private JDialog dialog1;
    private JDialog dialog2;
    private JDialog dialog3;
    private JDialog dialog4;
    private JDialog dialog5;
    private JDialog dialog6;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JLabel entrarLicensePlateLabel;
    private JLabel entrarParkingSpotLabel;
    private JLabel sairParkingSpotLabel;
    private JLabel consultarLicensePlateLabel;
    private JLabel transfereLicensePlateLabel1;
    private JLabel transfereLicensePlateLabel2;
    private JLabel listaGeralSpot1Label1;
    private JLabel listaLivresFreeSpacesLabel;
    private JTextField entrarParkingSpotTextfield;
    private JTextField sairParkingSpotTextfield;
    private JTextField consultarLicensePlateTextfield;
    private JTextField transfereLicensePlateTextfield1;
    private JTextField transfereLicensePlateTextfield2;
    private JButton entrarConfirmButton;
    private JButton sairConfirmButton;
    private JButton consultarConfirmButton;
    private JButton transfereConfirmButton;
    private JButton listaGeralBackButton;
    private JButton listaLivresBackButton;
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
    	dialog1 = new JDialog(mainFrame, "Entrar carro", true);
        dialog1.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog1.setResizable(false);
        dialog1.setBounds(100, 100, 230, 230);

        // dialog panel
        panel1 = new JPanel();
        panel1.setBackground(new Color(30, 30, 30));
        panel1.setLayout(null);

        // label for car license plate field
        entrarLicensePlateLabel = new JLabel("Digite a placa do carro: ");
        entrarLicensePlateLabel.setFont(new Font("Nunito", Font.BOLD, 14));
        entrarLicensePlateLabel.setForeground(new Color(240, 240, 240));
        entrarLicensePlateLabel.setBounds(20, 20, 200, 20);
        panel1.add(entrarLicensePlateLabel);

        // textfield for car license plate
        JTextField entrarLicensePlateTextfield = new JTextField();
        entrarLicensePlateTextfield.setFont(new Font("Nunito Light", Font.PLAIN, 12));
        entrarLicensePlateTextfield.setForeground(new Color(240, 240, 240));
        entrarLicensePlateTextfield.setBackground(new Color(70, 70, 70));
        entrarLicensePlateTextfield.setBounds(20, 50, 180, 20);
        entrarLicensePlateTextfield.setBorder(null);
        panel1.add(entrarLicensePlateTextfield);

        // label for parking spot field
        entrarParkingSpotLabel = new JLabel("Digite o número da vaga: ");
        entrarParkingSpotLabel.setFont(new Font("Nunito", Font.BOLD, 14));
        entrarParkingSpotLabel.setForeground(new Color(240, 240, 240));
        entrarParkingSpotLabel.setBounds(20, 80, 200, 20);
        panel1.add(entrarParkingSpotLabel);

        // textfield for parking spot
        entrarParkingSpotTextfield = new JTextField();
        entrarParkingSpotTextfield.setFont(new Font("Nunito Light", Font.PLAIN, 12));
        entrarParkingSpotTextfield.setForeground(new Color(240, 240, 240));
        entrarParkingSpotTextfield.setBackground(new Color(70, 70, 70));
        entrarParkingSpotTextfield.setBounds(20, 110, 180, 20);
        entrarParkingSpotTextfield.setBorder(null);
        panel1.add(entrarParkingSpotTextfield);

        // button to confirm and call method
        entrarConfirmButton = new JButton("Confirmar");
        entrarConfirmButton.setFont(new Font("Nunito", Font.BOLD, 10));
        entrarConfirmButton.setForeground(new Color(240, 240, 240));
        entrarConfirmButton.setBackground(new Color(70, 70, 70));
        entrarConfirmButton.setBounds(70, 150, 70, 30);
        entrarConfirmButton.setBorder(null);
        panel1.add(entrarConfirmButton);
        entrarConfirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	try {
					est.entrar(entrarLicensePlateTextfield.getText(), Integer.parseInt(entrarParkingSpotTextfield.getText()));
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
    	dialog2 = new JDialog(mainFrame, "Sair carro", true);
        dialog2.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog2.setResizable(false);
        dialog2.setBounds(135, 135, 230, 230);

        // dialog panel
        panel2 = new JPanel();
        panel2.setBackground(new Color(30, 30, 30));
        panel2.setLayout(null);

        // label for parking spot field
        sairParkingSpotLabel = new JLabel("Digite o número da vaga: ");
        sairParkingSpotLabel.setFont(new Font("Nunito", Font.BOLD, 14));
        sairParkingSpotLabel.setForeground(new Color(240, 240, 240));
        sairParkingSpotLabel.setBounds(20, 20, 200, 20);
        panel2.add(sairParkingSpotLabel);

        // textfield for parking spot
        sairParkingSpotTextfield = new JTextField();
        sairParkingSpotTextfield.setFont(new Font("Nunito Light", Font.PLAIN, 12));
        sairParkingSpotTextfield.setForeground(new Color(240, 240, 240));
        sairParkingSpotTextfield.setBackground(new Color(70, 70, 70));
        sairParkingSpotTextfield.setBounds(20, 50, 180, 20);
        sairParkingSpotTextfield.setBorder(null);
        panel2.add(sairParkingSpotTextfield);

        // button to confirm and call method
        sairConfirmButton = new JButton("Confirmar");
        sairConfirmButton.setFont(new Font("Nunito", Font.BOLD, 10));
        sairConfirmButton.setForeground(new Color(240, 240, 240));
        sairConfirmButton.setBackground(new Color(70, 70, 70));
        sairConfirmButton.setBounds(75, 120, 70, 30);
        sairConfirmButton.setBorder(null);
        panel2.add(sairConfirmButton);
        sairConfirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	try {
					est.sair(Integer.parseInt(sairParkingSpotTextfield.getText()));
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
                dialog3 = new JDialog(mainFrame, "Consulta Placa", true);
                dialog3.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                dialog3.setResizable(false);
                dialog3.setBounds(135, 135, 230, 230);

                // dialog panel
                panel3 = new JPanel();
                panel3.setBackground(new Color(30, 30, 30));
                panel3.setLayout(null);

                // label for car license plate field
                consultarLicensePlateLabel = new JLabel("Digite a placa do carro: ");
                consultarLicensePlateLabel.setFont(new Font("Nunito", Font.BOLD, 14));
                consultarLicensePlateLabel.setForeground(new Color(240, 240, 240));
                consultarLicensePlateLabel.setBounds(20, 20, 250, 20);
                panel3.add(consultarLicensePlateLabel);

                // textfield for car license plate
                consultarLicensePlateTextfield = new JTextField();
                consultarLicensePlateTextfield.setFont(new Font("Nunito Light", Font.PLAIN, 12));
                consultarLicensePlateTextfield.setForeground(new Color(240, 240, 240));
                consultarLicensePlateTextfield.setBackground(new Color(70, 70, 70));
                consultarLicensePlateTextfield.setBounds(20, 50, 180, 20);
                consultarLicensePlateTextfield.setBorder(null);
                panel3.add(consultarLicensePlateTextfield);

                // button to confirm and call method
                consultarConfirmButton = new JButton("Confirmar");
                consultarConfirmButton.setFont(new Font("Nunito", Font.BOLD, 10));
                consultarConfirmButton.setForeground(new Color(240, 240, 240));
                consultarConfirmButton.setBackground(new Color(70, 70, 70));
                consultarConfirmButton.setBounds(75, 120, 70, 30);
                consultarConfirmButton.setBorder(null);
                panel3.add(consultarConfirmButton);
                consultarConfirmButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                    	try {
                            int result = est.consultarPlaca(consultarLicensePlateTextfield.getText());
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
        dialog4 = new JDialog(mainFrame, "Entrar carro", true);
        dialog4.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog4.setResizable(false);
        dialog4.setBounds(100, 100, 230, 230);

        // dialog panel
        panel4 = new JPanel();
        panel4.setBackground(new Color(30, 30, 30));
        panel4.setLayout(null);

        // label for car license plate field
        transfereLicensePlateLabel1 = new JLabel("Digite a vaga de origem:");
        transfereLicensePlateLabel1.setFont(new Font("Nunito", Font.BOLD, 14));
        transfereLicensePlateLabel1.setForeground(new Color(240, 240, 240));
        transfereLicensePlateLabel1.setBounds(20, 20, 200, 20);
        panel4.add(transfereLicensePlateLabel1);

        // textfield for car license plate
        transfereLicensePlateTextfield1 = new JTextField();
        transfereLicensePlateTextfield1.setFont(new Font("Nunito Light", Font.PLAIN, 12));
        transfereLicensePlateTextfield1.setForeground(new Color(240, 240, 240));
        transfereLicensePlateTextfield1.setBackground(new Color(70, 70, 70));
        transfereLicensePlateTextfield1.setBounds(20, 50, 180, 20);
        transfereLicensePlateTextfield1.setBorder(null);
        panel4.add(transfereLicensePlateTextfield1);

        // label for the other car license plate field
        transfereLicensePlateLabel2 = new JLabel("Digite a vaga de destino:");
        transfereLicensePlateLabel2.setFont(new Font("Nunito", Font.BOLD, 14));
        transfereLicensePlateLabel2.setForeground(new Color(240, 240, 240));
        transfereLicensePlateLabel2.setBounds(20, 80, 200, 20);
        panel4.add(transfereLicensePlateLabel2);

        // textfield for the other car license plate
        transfereLicensePlateTextfield2 = new JTextField();
        transfereLicensePlateTextfield2.setFont(new Font("Nunito Light", Font.PLAIN, 12));
        transfereLicensePlateTextfield2.setForeground(new Color(240, 240, 240));
        transfereLicensePlateTextfield2.setBackground(new Color(70, 70, 70));
        transfereLicensePlateTextfield2.setBounds(20, 110, 180, 20);
        transfereLicensePlateTextfield2.setBorder(null);
        panel4.add(transfereLicensePlateTextfield2);

        // button to confirm and call method
        transfereConfirmButton = new JButton("Confirmar");
        transfereConfirmButton.setFont(new Font("Nunito", Font.BOLD, 10));
        transfereConfirmButton.setForeground(new Color(240, 240, 240));
        transfereConfirmButton.setBackground(new Color(70, 70, 70));
        transfereConfirmButton.setBounds(75, 150, 70, 30);
        transfereConfirmButton.setBorder(null);
        panel4.add(transfereConfirmButton);
        transfereConfirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	try {
            		int placa1 = Integer.parseInt(transfereLicensePlateTextfield1.getText());
            		int placa2 = Integer.parseInt(transfereLicensePlateTextfield2.getText());
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
    	dialog5 = new JDialog(mainFrame, "Listar Geral", true);
        dialog5.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog5.setResizable(false);
        dialog5.setBounds(100, 100, 300, 300);

        // dialog panel
        panel5 = new JPanel();
        panel5.setBackground(new Color(30, 30, 30));
        panel5.setLayout(null);
        listaGeralSpot1Label1 = new JLabel();
        listaGeralSpot1Label1.setFont(new Font("Nunito", Font.BOLD, 14));
        listaGeralSpot1Label1.setForeground(new Color(240, 240, 240));
        listaGeralSpot1Label1.setBounds(20, 15, 250, 190);
        String textofinal = new String();
        for(int i = 0; i < vagas.length;i++) {
        	textofinal += "Vaga "+ (i+1)+": " + vagas[i] + "<br/>";
        }
        listaGeralSpot1Label1.setText("<html>"+textofinal+"</html>");
        panel5.add(listaGeralSpot1Label1);
        listaGeralBackButton = new JButton("Voltar");
        listaGeralBackButton.setFont(new Font("Nunito", Font.BOLD, 10));
        listaGeralBackButton.setForeground(new Color(240, 240, 240));
        listaGeralBackButton.setBackground(new Color(70, 70, 70));
        listaGeralBackButton.setBounds(110, 220, 70, 30);
        listaGeralBackButton.setBorder(null);
        panel5.add(listaGeralBackButton);
        listaGeralBackButton.addActionListener(new ActionListener() {
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
    	dialog6 = new JDialog(mainFrame, "Listar Livres", true);
        dialog6.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog6.setResizable(false);
        dialog6.setBounds(100, 100, 300, 320);

        // dialog panel
        panel6 = new JPanel();
        panel6.setBackground(new Color(30, 30, 30));
        panel6.setLayout(null);
        listaLivresFreeSpacesLabel = new JLabel();
        listaLivresFreeSpacesLabel.setFont(new Font("Nunito", Font.BOLD, 14));
        listaLivresFreeSpacesLabel.setForeground(new Color(240, 240, 240));
        listaLivresFreeSpacesLabel.setBounds(100, 15, 250, 210);
        panel6.add(listaLivresFreeSpacesLabel);
        String finalText = "Vagas Livres: <br/>";
        for(int i = 0; i < vagas.size();i++) {
        	finalText += "Vaga "+vagas.get(i) + "<br/>";
        }
        listaLivresFreeSpacesLabel.setText("<html>"+finalText+"</html>");
        listaLivresBackButton = new JButton("Voltar");
        listaLivresBackButton.setFont(new Font("Nunito", Font.BOLD, 10));
        listaLivresBackButton.setForeground(new Color(240, 240, 240));
        listaLivresBackButton.setBackground(new Color(70, 70, 70));
        listaLivresBackButton.setBounds(110, 240, 70, 30);
        listaLivresBackButton.setBorder(null);
        panel6.add(listaLivresBackButton);
        listaLivresBackButton.addActionListener(new ActionListener() {
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
