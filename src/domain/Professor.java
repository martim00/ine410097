package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Professor {
	
	private List<StatusHorario> horarios = new ArrayList<StatusHorario>();
	
	private Set<AreaConhecimento> areasDeAtuacao = new HashSet<AreaConhecimento>();

	public void addHorario(Horario horario) {
		StatusHorario statusHorario = new StatusHorario(horario, true);
		
		horarios.add(statusHorario);
	}

	public List<Horario> getHorarios() {
		
		List<Horario> horarios = new ArrayList<Horario>();
		for(StatusHorario status :  this.horarios)
			horarios.add(status.getHorario());
		
		return horarios;
	}

	public List<Horario> getHorariosDisponiveis() {
		List<Horario> horarios = new ArrayList<Horario>();
		for(StatusHorario status :  this.horarios){
			if(status.isDisponivel())
				horarios.add(status.getHorario());
		}		
		return horarios;

	}
	
 	public void alocaHorario(Horario horario) {
		for(StatusHorario status : horarios){
			if(status.getHorario().equals(horario)){
				status.setDisponivel(false);
				break;
			}
		}
	}

	private class StatusHorario{
 		
 		private Horario horario;
 		private boolean disponivel;
 		
 		public StatusHorario(Horario horario, boolean disponivel) {
 			this.horario = horario;
 			this.disponivel = disponivel;
 		}
 		
		/**
		 * @return the horario
		 */
		public Horario getHorario() {
			return horario;
		}
		/**
		 * @return the disponivel
		 */
		public boolean isDisponivel() {
			return disponivel;
		}
		/**
		 * @param horario the horario to set
		 */
		public void setHorario(Horario horario) {
			this.horario = horario;
		}
		/**
		 * @param disponivel the disponivel to set
		 */
		public void setDisponivel(boolean disponivel) {
			this.disponivel = disponivel;
		}
 			
 	}

	/**
	 * Aloca o primeiro horario disponível do professor e retorna o mesmo.
	 * 
	 * @pre Professor deve ter algum horário disponível => <code>assert(this.temHorarioDisponivel());</code>
	 * @return
	 */
	public Horario aloqueHorario() {
		
		assert(temHorarioDisponivel());
		
		Horario primeiroHorarioDisponivel = this.getHorariosDisponiveis().get(0);
		this.alocaHorario(primeiroHorarioDisponivel);
		return primeiroHorarioDisponivel;
	}

	public boolean atuaNaArea(AreaConhecimento area) {
		return this.areasDeAtuacao.contains(area);
	}

	public void addAreaDeAtuacao(AreaConhecimento areaAtuacao) {
		this.areasDeAtuacao.add(areaAtuacao);						
	}

	public boolean temHorarioDisponivel() {
		return !this.getHorariosDisponiveis().isEmpty();
	}

}
