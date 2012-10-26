package domain;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	
	private List<Horario> horarios = new ArrayList<Horario>(); 

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void addHorario(Horario horario) {
		horarios.add(horario);
	}

}
