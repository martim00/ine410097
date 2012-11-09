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
	
	public boolean temAulaNesteHorario(Horario horario) {
		return grade.temAulaNesteHorario(horario);
				
	}

	public GradeHorario getGradeHorario() {
		
		return grade;
	}

	public void alocaHorarioParaDisciplina(Horario horarioDisponivel,
			Disciplina disciplina, Professor professor) {
		grade.alocaHorarioParaDisciplina(horarioDisponivel, disciplina, professor);
		
	}

}
