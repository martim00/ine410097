package domain;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	
	private List<Horario> horarios = new ArrayList<Horario>();
	
	private AreaConhecimento area = null;
	
	public Disciplina(AreaConhecimento area) {
		this.area = area;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void addHorario(Horario horario) {
		horarios.add(horario);
	}

	public AreaConhecimento getArea() {
		return area;
	}
	
	public void setArea(AreaConhecimento area) {
		this.area = area;		
	}

}
