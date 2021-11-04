package quiz;

import java.util.ArrayList;

public class Quiz {

	private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();

	private int current = 0;

	public Quiz() {
		preguntas.add(new Pregunta("¿Cuál es la flor nacional de Japón?", "Sakura", "Momo", "Kiku", "Sakura"));
		preguntas.add(new Pregunta("¿Cuántas franjas tiene la bandera de Estados Unidos?", "12", "13", "15", "13"));
		preguntas.add(new Pregunta("¿Cuál es el símbolo químico de la plata?", "Ag", "Ar", "Pl", "Ag"));
		preguntas.add(new Pregunta("¿Cuántos corazones tiene un pulpo?", "3", "5", "4", "3"));
		preguntas.add(new Pregunta("¿Qué cantidad de huesos en el cuerpo humano adulto?", "200", "210", "206", "206"));
	}

	public void Siguiente() {
		current++;
	}

	public void Anterior() {
		current--;
	}

	public boolean HasNext() {
		return current < preguntas.size() - 1;
	}

	public boolean HasPrev() {
		return current > 0;
	}

	public Pregunta ObtenerPreguntaActual() {
		return preguntas.get(current);
	}

	public int getTotalPreguntas() {
		return preguntas.size();
	}

	public int Calificar() {
		int numRespuestasCorrectas = 0;
		for (Pregunta pregunta : preguntas) {
			if(pregunta.getRespuestaCorrecta().equals(pregunta.getRespuestaSeleccionada())) {
				numRespuestasCorrectas++;
			}
		}
		return numRespuestasCorrectas;
	}
	
	public void ModificarOpcionActualSeleccionada(String respuesta) {
		preguntas.get(current).setRespuestaSeleccionada(respuesta);
	}
}
