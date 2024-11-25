import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppNotas {
    private JPanel mainPanel;
    private JTextField txtDisplay;
    private JButton btnAdd;
    private JTextArea txtExibir;
    private JButton btnCalc;
    private JLabel lblResultado;

    private final ArrayList<Double> notas = new ArrayList<>();

    public AppNotas() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double nota = Double.parseDouble(txtDisplay.getText());
                    if (nota < 0 || nota > 10) {
                        JOptionPane.showMessageDialog(null, "Digite uma nota entre 0 e 10");
                        return;
                    }
                    notas.add(nota);
                    atualizarListaNotas();
                    txtDisplay.setText(""); // Limpa o campo de entrada
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido!");
                }
            }
        });

        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notas.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Adicione pelo menos uma nota antes de calcular!");
                    return;
                }

                double soma = 0;
                for (double nota : notas) {
                    soma += nota;
                }

                double media = soma / notas.size();
                String status = media >= 7.0 ? "Aprovado" : "Reprovado";
                lblResultado.setText(String.format("Média: %.2f - %s", media, status));
            }
        });
    }

    private void atualizarListaNotas() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < notas.size(); i++) {
            sb.append("Nota ").append(i + 1).append(": ").append(notas.get(i)).append("\n");
        }
        txtExibir.setText(sb.toString());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicativo de Notas");
        frame.setContentPane(new AppNotas().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
