import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroContatos {
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JButton btnAdd;
    private JList listContatos;
    private JPanel mainPanel;
    private JButton btnRemover;
    private JLabel lblNome;
    private JLabel lblTelefone;
    private JLabel lblEmail;

    private DefaultListModel<String> listModel;

    public CadastroContatos() {
        listModel = new DefaultListModel<>();
        listContatos.setModel(listModel);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText().trim();
                String telefone = txtTelefone.getText().trim();
                String email = txtEmail.getText().trim();

                if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Por favor, preencha todos os campos!");
                    return;
                }

                String contato = String.format("Nome: %s  Telefone: %s  E-mail: %s ", nome, telefone, email);
                listModel.addElement(contato);

                txtNome.setText("");
                txtTelefone.setText("");
                txtEmail.setText("");

            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int SelectedIndex = listContatos.getSelectedIndex();
                if (SelectedIndex != -1) {
                    listModel.remove(SelectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null,"Selecione um contato!");
                }
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de contatos");
        frame.setContentPane(new CadastroContatos().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
