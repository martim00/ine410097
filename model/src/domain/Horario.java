package domain;

public class Horario {
	
	private DiaDaSemana diaDaSemana;
	private HorarioNoDia horarioNoDia;
	
	public Horario(DiaDaSemana diaDaSemana, HorarioNoDia horarioNoDia) {
		this.diaDaSemana = diaDaSemana;
		this.horarioNoDia = horarioNoDia;
	}

	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public HorarioNoDia getHorarioNoDia() {
		return horarioNoDia;
	}

	public void setHorarioNoDia(HorarioNoDia horarioNoDia) {
		this.horarioNoDia = horarioNoDia;
	}

}
