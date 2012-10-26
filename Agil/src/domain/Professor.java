package domain;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	
	private List<StatusHorario> horarios = new ArrayList<StatusHorario>();

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

}
