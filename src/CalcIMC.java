import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcIMC {
    private JTextField txtPeso;
    private JPanel mainPanel;
    private JLabel lblPeso;
    private JLabel lblAltura;
    private JTextField txtAltura;
    private JButton btnCalc;
    private JLabel lblResultado;

    public CalcIMC() {
        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String pesoStr = txtPeso.getText().trim();
                    String alturaStr = txtAltura.getText().trim();

                    if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Por favor, preencha os campos de peso e altura!");
                        return;
                    }

                    double peso = Double.parseDouble(pesoStr);
                    double altura = Double.parseDouble(alturaStr);

                    if (peso <= 0 || altura <= 0) {
                        JOptionPane.showMessageDialog(null,"Peso e altura devem ser valores positivos");
                        return;
                    }

                    double imc = peso / (altura * altura);
                    String categoria;
                    if (imc < 18.5){
                        categoria = "Peso baixo";
                    } else if (imc >= 18.5 && imc < 25 ){
                        categoria = "Peso normal";
                    } else if (imc >= 25 && imc < 30) {
                        categoria = "Excesso de peso";
                    } else {
                        categoria = "Obeso";
                    }
                    lblResultado.setText(String.format("IMC: %.2f - %s",imc, categoria));
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Por favor, insira valores numéricos válidos!");
                }

            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de IMC");
        frame.setContentPane(new CalcIMC().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
