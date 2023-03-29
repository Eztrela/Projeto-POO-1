import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceValetinho {
    // setting main attributes of the menu screen
    JFrame mainFrame;
    JPanel mainPanel;
    JLabel menuTitleLabel;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    JButton btn6;
    JButton btn7;
    Estacionamento est;


    public InterfaceValetinho() throws Exception{
        // main frame
    	est = new Estacionamento(10);
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
                // dialog
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
                // dialog
            }
        });
        mainPanel.add(btn2);

        // button 3
        btn3 = new JButton();
        this.setButtonStyle(btn3, "Consultar placa", 145, 170);
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            
            }
        });
        mainPanel.add(btn3);

        // button 4
        btn4 = new JButton();
        this.setButtonStyle(btn4, "Transferir placa", 245, 170);
        btn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // dialog
                JDialog dialog4 = new JDialog(mainFrame, "Entrar carro", true);
                dialog4.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                dialog4.setResizable(false);
                dialog4.setBounds(100, 100, 300, 300);

                // dialog panel
                JPanel panel4 = new JPanel();
                panel4.setBackground(new Color(30, 30, 30));
                panel4.setLayout(null);

                // label for car license plate field
                JLabel licensePlateLabel1 = new JLabel("Digite a placa do carro: ");
                licensePlateLabel1.setFont(new Font("Nunito", Font.BOLD, 14));
                licensePlateLabel1.setForeground(new Color(240, 240, 240));
                licensePlateLabel1.setBounds(20, 20, 160, 20);
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
                JLabel licensePlateLabel2 = new JLabel("Digite a nova placa do carro: ");
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
                confirmButton.setBounds(110, 180, 70, 30);
                confirmButton.setBorder(null);
                panel4.add(confirmButton);

                dialog4.add(panel4);
                dialog4.setVisible(true);
            }
        });
        mainPanel.add(btn4);

        // button 5
        btn5 = new JButton();
        this.setButtonStyle(btn5, "Listar geral", 145, 240);
        mainPanel.add(btn5);

        // button 6
        btn6 = new JButton();
        this.setButtonStyle(btn6, "Listar vagas livres", 245, 240);
        mainPanel.add(btn6);

        // button 7
        btn7 = new JButton();
        this.setButtonStyle(btn7, "Encerrar", 195, 310);
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
        dialog1.setBounds(100, 100, 300, 300);

        // dialog panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(30, 30, 30));
        panel1.setLayout(null);

        // label for car license plate field
        JLabel licensePlateLabel = new JLabel("Digite a placa do carro: ");
        licensePlateLabel.setFont(new Font("Nunito", Font.BOLD, 14));
        licensePlateLabel.setForeground(new Color(240, 240, 240));
        licensePlateLabel.setBounds(20, 20, 160, 20);
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
        parkingSpotLabel.setBounds(20, 80, 170, 20);
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
        confirmButton.setBounds(110, 180, 70, 30);
        confirmButton.setBorder(null);
        panel1.add(confirmButton);
        System.out.println(licensePlateTextfield.getText() +" "+ parkingSpotTextfield.getText());
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	try {
					est.entrar(licensePlateTextfield.getText(), Integer.parseInt(parkingSpotTextfield.getText()));
					dialog1.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
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
        parkingSpotLabel.setBounds(20, 20, 170, 20);
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
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				}
            }
        });

        dialog2.add(panel2);
        dialog2.setVisible(true);
    }
    
    public void consultarPlaca(Estacionamento est) {
    	
                // dialog
                JDialog dialog3 = new JDialog(mainFrame, "Sair carro", true);
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
                licensePlateLabel.setBounds(20, 20, 170, 20);
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
        					est.consultarPlaca(null);
        					dialog3.setVisible(false);
        				} catch (Exception e1) {
        					// TODO Auto-generated catch block
        					System.out.println(e1.getMessage());
        				}
                    }
                });

                dialog3.add(panel3);
                dialog3.setVisible(true);
            }
        
    
    

}
