package domain;

import java.util.ArrayList;
import java.util.List;

public class Fase {	
	
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	private GradeHorario grade = new GradeHorario();

	public List<Disciplina> getDisciplinas() {

		return disciplinas;
	}

	public void addDisciplinas(Disciplina disc) {
		disciplinas.add(disc);
	}

	public GradeHorario getGradeHorario() {
		return grade;
	}

}
