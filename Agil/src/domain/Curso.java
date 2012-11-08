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
	 * Tenta alocar um professor para a disciplina passada. Leva em considera��o a area de atua��o do professor fecha com a area da disciplina 
	 * e se o mesmo tem hor�rio dispon�vel.
	 * 
	 * @param disciplina 
	 * @throws ProfessorNaoEncontradoParaDisciplinaException caso n�o encontre nenhum professor que possa ministrar a disciplina
	 */
	private void aloqueProfessorParaDisciplina(Disciplina disciplina) throws ProfessorNaoEncontradoParaDisciplinaException {
		
		for (Professor professor : professores) {
			
			if (professor.atuaNaArea(disciplina.getArea()) && professor.temHorarioDisponivel()) {
				
				Horario horario = professor.aloqueHorario();
				disciplina.addHorario(horario);
			}
		}
		
		throw new ProfessorNaoEncontradoParaDisciplinaException();
		
	}

	/**
	 *  Retorna uma lista de Fase aonde cada elemento da lista � a uma fase do curso com uma grade hor�ria alocada.
	 *	Para pegar a grade hor�ria use o m�todo <code>getGradeHorario()</code> da classe <code>Fase</code>
	 * @return List<Fase> - a lista ordenada das fases (primeiro elemento - primeira fase, segundo elemento - segunda fase, etc)
	 * @throws ProfessorNaoEncontradoParaDisciplinaException 
	 */
	public List<Fase> executeAlocacao() throws ProfessorNaoEncontradoParaDisciplinaException {
		for (Fase fase : fases) {
			
			for (Disciplina disciplina : fase.getDisciplinas()) {
				
				try {					
					this.aloqueProfessorParaDisciplina(disciplina);
					
				} catch (ProfessorNaoEncontradoParaDisciplinaException exception) {
					
					// TODO: ver o que fazer caso n�o exista nenhum professor dispon�vel para essa disciplina
					throw exception;
					
				}
			}
		}
		return fases;
	}

}
