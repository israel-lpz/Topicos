package validar_expresion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.Stack;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9163774343077280047L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtExpresion;
	private JLabel lblNewLabel_1;
	private JButton btnValidar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 251);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		lblNewLabel = new JLabel("Validar expresion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 10, 396, 37);
		contentPane.add(lblNewLabel);

		txtExpresion = new JTextField();
		txtExpresion.setBounds(98, 61, 268, 30);
		contentPane.add(txtExpresion);
		txtExpresion.setColumns(10);

		lblNewLabel_1 = new JLabel("Expresion:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 57, 72, 32);
		contentPane.add(lblNewLabel_1);

		btnValidar = new JButton("Validar");
		btnValidar.addActionListener((ev) -> {
			try {
				Stack<Character> stack = new Stack<Character>();
				txtExpresion.getText().chars().forEach(ascii -> {
					char caracter = (char) ascii;
					if (caracter == '(') {
						stack.push('(');
					} else if (caracter == ')') {
						stack.pop();
					}
				});
				if (!stack.isEmpty()) {
					throw new Exception();
				}
				JOptionPane.showMessageDialog(this, "Expresion valida");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Expresion invalida");
			}
		});
		btnValidar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnValidar.setBounds(20, 160, 94, 33);
		contentPane.add(btnValidar);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(e -> System.exit(0));

		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(312, 160, 94, 33);
		contentPane.add(btnSalir);
	}
}
