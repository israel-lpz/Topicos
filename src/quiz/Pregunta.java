package quiz;

public class Pregunta {	
	public Pregunta(String nombre, String respuesta1, String respuesta2, String respuesta3, String respuestaCorrecta) {
		Nombre = nombre;
		Respuesta1 = respuesta1;
		Respuesta2 = respuesta2;
		Respuesta3 = respuesta3;
		RespuestaCorrecta = respuestaCorrecta;
	}

	private String Nombre;
	
	private String Respuesta1;
	
	private String Respuesta2;
	
	private String Respuesta3;
	
	private String RespuestaCorrecta;

	private String RespuestaSeleccionada;
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getRespuesta1() {
		return Respuesta1;
	}

	public String getRespuesta2() {
		return Respuesta2;
	}

	public String getRespuesta3() {
		return Respuesta3;
	}

	public String getRespuestaCorrecta() {
		return RespuestaCorrecta;
	}

	public void setRespuestaCorrecta(String respuestaCorrecta) {
		RespuestaCorrecta = respuestaCorrecta;
	}
	
	public String getRespuestaSeleccionada() {
		return RespuestaSeleccionada;
	}

	public void setRespuestaSeleccionada(String respuestaSeleccionada) {
		RespuestaSeleccionada = respuestaSeleccionada;
	}
}
