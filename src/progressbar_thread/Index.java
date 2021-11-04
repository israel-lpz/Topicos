package progressbar_thread;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JButton;

public class Index extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -398869432976051533L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Progreso de la barra");
	private final JProgressBar progressBar = new JProgressBar();
	private final JButton btnIniciar = new JButton("Iniciar");
	private final JButton btnSalir = new JButton("Salir");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		this.getRootPane().setDefaultButton(btnIniciar);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel.setBounds(70, 20, 284, 39);

		contentPane.add(lblNewLabel);
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setForeground(new Color(0, 204, 51));
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setBounds(39, 69, 367, 46);

		contentPane.add(progressBar);
		btnIniciar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnIniciar.setBounds(39, 186, 85, 21);
		btnIniciar.addActionListener(ev -> {
			Hilo hilo = new Hilo(progressBar, "Hilo 1");
			hilo.start();
			try {
				hilo.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			progressBar.setValue(0);
		});

		contentPane.add(btnIniciar);
		btnSalir.addActionListener(ev -> System.exit(0));
		btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnSalir.setBounds(321, 186, 85, 21);

		contentPane.add(btnSalir);
	}
}
