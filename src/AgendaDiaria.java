import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendaDiaria {
    private JPanel mainPanel;
    private JTextField txtCompromisso;
    private JSpinner spinnerDataHora;
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JTable tableCompromissos;
    private JLabel lblCompromisso;
    private JLabel lblDataHora;

    private DefaultTableModel tableModel;

    public AgendaDiaria() {
        tableModel = new DefaultTableModel(new Object[]{"Data/Hora", "Compromisso"}, 0);
        tableCompromissos.setModel(tableModel);

        spinnerDataHora.setModel(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerDataHora, "dd/MM/yyyy HH:mm");
        spinnerDataHora.setEditor(dateEditor);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String compromisso = txtCompromisso.getText().trim();
                Date dataHora = (Date) spinnerDataHora.getValue();

                if (compromisso.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um compromisso.");
                    return;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dataHoraFormatada = sdf.format(dataHora);

                tableModel.addRow(new Object[]{dataHoraFormatada, compromisso});
                txtCompromisso.setText("");
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableCompromissos.getSelectedRow();

                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um compromisso para remover.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda Diária");
        frame.setContentPane(new AgendaDiaria().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
