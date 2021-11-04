package quiz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class QuizForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1199639618228495915L;
	private JPanel contentPane;
	private final Quiz quiz = new Quiz();
	private final JButton btnAnterior;
	private final JButton btnSiguiente;
	private final JLabel lblPregunta;
	private final JRadioButton radOpcion1;
	private final JRadioButton radOpcion2;
	private final JRadioButton radOpcion3;
	private final ButtonGroup grpOpciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizForm frame = new QuizForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void ActualizarRespuestaSeleccionada() {
		if (radOpcion1.isSelected())
			quiz.ModificarOpcionActualSeleccionada(radOpcion1.getText());
		else if (radOpcion2.isSelected())
			quiz.ModificarOpcionActualSeleccionada(radOpcion2.getText());
		else if (radOpcion3.isSelected())
			quiz.ModificarOpcionActualSeleccionada(radOpcion3.getText());
	}

	private void ActualizarBotonesYPreguntas() {
		btnSiguiente.setEnabled(quiz.HasNext());
		btnAnterior.setEnabled(quiz.HasPrev());
		Pregunta pregunta = quiz.ObtenerPreguntaActual();
		lblPregunta.setText(pregunta.getNombre());
		radOpcion1.setText(pregunta.getRespuesta1());
		radOpcion2.setText(pregunta.getRespuesta2());
		radOpcion3.setText(pregunta.getRespuesta3());
		grpOpciones.clearSelection();
		if (radOpcion1.getText().equals(pregunta.getRespuestaSeleccionada()))
			radOpcion1.setSelected(true);
		else if (radOpcion2.getText().equals(pregunta.getRespuestaSeleccionada()))
			radOpcion2.setSelected(true);
		else if (radOpcion3.getText().equals(pregunta.getRespuestaSeleccionada()))
			radOpcion3.setSelected(true);
	}

	/**
	 * Create the frame.
	 */
	public QuizForm() {
		setTitle("Quiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 272);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPregunta = new JLabel("Pregunta 1");
		lblPregunta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPregunta.setBounds(10, 10, 478, 25);
		contentPane.add(lblPregunta);

		radOpcion1 = new JRadioButton("New radio button");
		radOpcion1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ActualizarRespuestaSeleccionada();
			}
		});
		radOpcion1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radOpcion1.setBounds(6, 41, 384, 21);
		contentPane.add(radOpcion1);

		radOpcion2 = new JRadioButton("New radio button");
		radOpcion2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ActualizarRespuestaSeleccionada();
			}
		});
		radOpcion2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radOpcion2.setBounds(6, 75, 384, 21);
		contentPane.add(radOpcion2);

		radOpcion3 = new JRadioButton("New radio button");
		radOpcion3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ActualizarRespuestaSeleccionada();
			}
		});
		radOpcion3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radOpcion3.setBounds(6, 109, 384, 21);
		contentPane.add(radOpcion3);

		btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quiz.Anterior();
				ActualizarBotonesYPreguntas();
			}
		});
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAnterior.setBounds(10, 171, 85, 32);
		contentPane.add(btnAnterior);

		grpOpciones = new ButtonGroup();
		grpOpciones.add(radOpcion1);
		grpOpciones.add(radOpcion2);
		grpOpciones.add(radOpcion3);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quiz.Siguiente();
				ActualizarBotonesYPreguntas();
			}
		});
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSiguiente.setBounds(105, 171, 112, 32);
		contentPane.add(btnSiguiente);

		JButton btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						String.format("%d/%d respuestas correctas", quiz.Calificar(), quiz.getTotalPreguntas()),
						"Resultado", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnEvaluar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEvaluar.setBounds(320, 171, 85, 32);
		contentPane.add(btnEvaluar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(415, 171, 85, 32);
		contentPane.add(btnSalir);

		ActualizarBotonesYPreguntas();
	}
}
