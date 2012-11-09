package domain;

public class HorarioAula {

	private Disciplina disciplina;
	private Professor professor;
	private Horario horario;
	
	public HorarioAula(Disciplina disciplina, Professor professor, Horario horario) {
		this.disciplina = disciplina;
		this.professor = professor;
		this.horario = horario;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public Horario getHorario() {
		return horario;
	}
	
	public Professor getProfessor() {
		return professor;
	}

}
