package gui;

import modelo.Usuario;
import dao.UsuarioDAO;
import javax.swing.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UsuarioGUI extends JFrame {

    private JTextField jTextField1; // Nome
    private JTextField jTextField2; // CPF
    private JTextField jTextField3; // Email
    private JTextField jTextField4; // Telefone

    private JButton jButton1; // Cadastrar
    private JButton jButton2; // Limpar
    private JButton jButton3; // Sair

    public UsuarioGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Cadastro de Usuário");
        titulo.setFont(titulo.getFont().deriveFont(18f));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Cadastrar novo usuário"));
        painel.setLayout(new GridLayout(4, 2, 5, 5));

        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();

        painel.add(new JLabel("Nome"));
        painel.add(jTextField1);
        painel.add(new JLabel("CPF"));
        painel.add(jTextField2);
        painel.add(new JLabel("Email"));
        painel.add(jTextField3);
        painel.add(new JLabel("Telefone"));
        painel.add(jTextField4);

        JPanel painelCentro = new JPanel(new BorderLayout());
        painelCentro.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelCentro.add(painel, BorderLayout.CENTER);

        JPanel painelBotoesCrud = new JPanel();
        jButton1 = new JButton("Cadastrar");
        jButton2 = new JButton("Limpar");
        painelBotoesCrud.add(jButton1);
        painelBotoesCrud.add(jButton2);
        painelCentro.add(painelBotoesCrud, BorderLayout.SOUTH);

        add(painelCentro, BorderLayout.CENTER);

        jButton3 = new JButton("SAIR");
        JPanel painelSair = new JPanel();
        painelSair.add(jButton3);
        add(painelSair, BorderLayout.SOUTH);

        // Passo 9: Evento CADASTRAR
        jButton1.addActionListener(this::jButton1ActionPerformed);
        // Passo 8: Evento LIMPAR
        jButton2.addActionListener(this::jButton2ActionPerformed);
        // Passo 7: Evento SAIR
        jButton3.addActionListener(this::jButton3ActionPerformed);

        pack();
        setSize(420, 320);
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        // instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
        Usuario usuarios = new Usuario();
        usuarios.setNome(jTextField1.getText());
        usuarios.setCpf(jTextField2.getText());
        usuarios.setEmail(jTextField3.getText());
        usuarios.setTelefone(jTextField4.getText());

        // fazendo a validação dos dados
        if ((jTextField1.getText().isEmpty()) || (jTextField2.getText().isEmpty())
                || (jTextField3.getText().isEmpty()) || (jTextField4.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
        } else {
            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            UsuarioDAO dao = new UsuarioDAO();
            dao.adiciona(usuarios);
            JOptionPane.showMessageDialog(null,
                    "Usuário " + jTextField1.getText() + " inserido com sucesso! ");
        }
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        // apaga os dados preenchidos nos campos de texto
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UsuarioGUI().setVisible(true));
    }
}
