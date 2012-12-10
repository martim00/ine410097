package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "fase")
public class Fase {	
	
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	private GradeHorario grade = new GradeHorario();

	public List<Disciplina> getDisciplinas() {

		return disciplinas;
	}

	public void addDisciplina(Disciplina disc) {
		disciplinas.add(disc);
	}
	
	public void addDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas.addAll(disciplinas);
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
