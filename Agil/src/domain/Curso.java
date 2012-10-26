package domain;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	
	private List<Fase> fases = new ArrayList<Fase>();
	private List<Professor> professores = new ArrayList<Professor>();
	
	public void addFase(Fase fase) {
		this.fases.add(fase);
	}

	public void addProfessor(Professor professor) {
		this.professores.add(professor);
	}

	public List<Fase> getFases() {
		
		return fases;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public List<Fase> executeAlocacao() {
		// TODO: fazer o algoritmo
		return null;
	}

}
