/** Programa para calcular o valor de Delta e verificar se existem raízes reais para uma equação de segundo grau em JAVA utilizando interface gráfica com Swing.
 * @RaniMendes
 */
package telaequacao;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEquacao {
    private JSpinner txtA;
    private JSpinner txtB;
    private JSpinner txtC;
    private JLabel lblB;
    private JLabel lblA;
    private JLabel lblC;
    private JPanel painelMenu;
    private JButton btnCalc;
    private JLabel lblDelta;
    private JLabel lblRaiz;
    private JPanel painelResultado;

    public TelaEquacao() {
        // Inicialmente, o painel de resultado está oculto
        painelResultado.setVisible(false);

        // Adiciona os listeners para os spinners e o botão
        txtA.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblA.setText(txtA.getValue().toString());
            }
        });

        // Atualiza o valor de B no rótulo quando o spinner for alterado
        txtB.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblB.setText(txtB.getValue().toString());
            }
        });

        // Atualiza o valor de C no rótulo quando o spinner for alterado
        txtC.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblC.setText(txtC.getValue().toString());
            }
        });

        // Adiciona o listener para o botão de calcular
        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painelResultado.setVisible(true);
                int a = Integer.parseInt(txtA.getValue().toString()); // Converte o valor do spinner A para inteiro
                int b = Integer.parseInt(txtB.getValue().toString()); // Converte o valor do spinner B para inteiro
                int c = Integer.parseInt(txtC.getValue().toString()); // Converte o valor do spinner C para inteiro
                double delta = Math.pow(b, 2) - 4 * a * c; // Calcula o valor de Delta usando a fórmula
                lblDelta.setText(String.format("%.2f", delta)); // Exibe o valor de Delta formatado com duas casas decimais

                // Verifica se existem raízes reais com base no valor de Delta e atualiza o rótulo correspondente
                if (delta < 0){
                    lblRaiz.setText("Não existem raízes reais.");
                }else {
                    lblRaiz.setText("Existem raízes reais");
                }

            }
        });
    }

    public static void main(String[] args) {
        // Cria a interface gráfica em uma thread separada para evitar bloqueios na interface do usuário
        SwingUtilities.invokeLater(new Runnable() {
            @Override

            // Configura e exibe a janela principal da aplicação
            public void run() {
                JFrame frame = new JFrame("Equação do Segundo Grau");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new TelaEquacao().painelMenu);
                frame.setSize(600, 500);
                frame.revalidate();
                frame.repaint();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
