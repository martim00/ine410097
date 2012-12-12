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
	
	
	/**
	 * Tenta alocar um professor para a disciplina passada. Leva em consideracao a area de atuacao do professor fecha com a area da disciplina 
	 * e se o mesmo tem horario disponivel.
	 * 
	 * @param disciplina 
	 * @throws ProfessorNaoEncontradoParaDisciplinaException caso nao encontre nenhum professor que possa ministrar a disciplina
	 */
	private void aloqueProfessorParaDisciplina(Disciplina disciplina, Fase fase) throws ProfessorNaoEncontradoParaDisciplinaException {
		
		for (Professor professor : professores) {
			
			boolean atuaNaArea = professor.atuaNaArea(disciplina.getArea());
			boolean professorTemHorarioDisponivel = professor.temHorarioDisponivel();
			
			if (atuaNaArea && professorTemHorarioDisponivel) {
				
				List<Horario> horariosDisponiveis = professor.getHorariosDisponiveis();
				
				for (Horario horarioDisponivel : horariosDisponiveis) {
					
					if (!fase.temAulaNesteHorario(horarioDisponivel)) {
						
						professor.alocaHorario(horarioDisponivel);
						disciplina.addHorario(horarioDisponivel);
						fase.alocaHorarioParaDisciplina(horarioDisponivel, disciplina, professor);
						break;
					}
				}
				
				return;
			}
		}
		
//		throw new ProfessorNaoEncontradoParaDisciplinaException();
		
	}

	/**
	 *  Retorna uma lista de Fase aonde cada elemento da lista e a uma fase do curso com uma grade horaria alocada.
	 *	Para pegar a grade horaria use o metodo <code>getGradeHorario()</code> da classe <code>Fase</code>
	 * @return List<Fase> - a lista ordenada das fases (primeiro elemento - primeira fase, segundo elemento - segunda fase, etc)
	 * @throws ProfessorNaoEncontradoParaDisciplinaException 
	 */
	public List<Fase> executeAlocacao() throws ProfessorNaoEncontradoParaDisciplinaException {
		
		for (Fase fase : fases) {
			
			for (Disciplina disciplina : fase.getDisciplinas()) {
				
				try {					
					this.aloqueProfessorParaDisciplina(disciplina, fase);
					
				} catch (ProfessorNaoEncontradoParaDisciplinaException exception) {
					
					// TODO: ver o que fazer caso nao exista nenhum professor disponivel para essa disciplina
					throw exception;
					
				}
			}
		}
		return fases;
	}

	public void addProfessores(List<Professor> professores) {
		this.professores.addAll(professores);
	}

	public void addFases(List<Fase> fases) {		
		this.fases.addAll(fases);		
	}

}
