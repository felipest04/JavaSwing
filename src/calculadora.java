import javax.swing.*;
import java.awt.event.ActionListener;

public class calculadora {
    private JButton btnZero;
    private JButton btnUm;
    private JButton btnDois;
    private JButton btnTres;
    private JButton btnQuatro;
    private JButton btnCinco;
    private JButton btnSeis;
    private JButton btnSete;
    private JButton btnOito;
    private JButton btnNove;
    private JButton btnSubtrair;
    private JButton btnSoma;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    private JButton btnLimpar;
    private JTextField txtDisplay;
    private JPanel mainPanel;
    private JButton btnIgual;

    private double num1 = 0;
    private String operador = "";
    private  boolean novoNumero = true;

    public calculadora() {
        btnLimpar.addActionListener(e -> {
            txtDisplay.setText("");
            num1 = 0;
            operador = "";
            novoNumero = true;
        });

        ActionListener numerosListener = e -> {
            String comando = e.getActionCommand();
            if (novoNumero) {
                txtDisplay.setText(comando);
                novoNumero = false;
            } else {
                txtDisplay.setText(txtDisplay.getText() + comando);
            }
        };

        btnZero.addActionListener(numerosListener);
        btnUm.addActionListener(numerosListener);
        btnDois.addActionListener(numerosListener);
        btnTres.addActionListener(numerosListener);
        btnQuatro.addActionListener(numerosListener);
        btnCinco.addActionListener(numerosListener);
        btnSeis.addActionListener(numerosListener);
        btnSete.addActionListener(numerosListener);
        btnOito.addActionListener(numerosListener);
        btnNove.addActionListener(numerosListener);

        ActionListener operacoesListener = e -> {
            operador = e.getActionCommand();
            num1 = Double.parseDouble(txtDisplay.getText());
            novoNumero = true;
        };

        btnSoma.addActionListener(operacoesListener);
        btnSubtrair.addActionListener(operacoesListener);
        btnMultiplicar.addActionListener(operacoesListener);
        btnDividir.addActionListener(operacoesListener);

        btnIgual.addActionListener(e -> {
            double num2 = Double.parseDouble(txtDisplay.getText());
            double resultado = calcular(num1, num2, operador);
            txtDisplay.setText(String.valueOf(resultado));
            novoNumero = true;
        });
    }

    private double calcular(double n1, double n2, String operador) {
        switch (operador) {
            case "+": return n1 + n2;
            case "-": return n1 - n2;
            case "*": return n1 * n2;
            case "/": return n2 != 0 ? n1 / n2 : 0;
            default: return 0;
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new calculadora().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
