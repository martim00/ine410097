package domain;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	
	private List<Horario> horarios = new ArrayList<Horario>();
	
	private AreaConhecimento area = null;
	
	private String nome = null;
	
	public Disciplina(AreaConhecimento area, String nome) {
		this.area = area;
		this.nome = nome;
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

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

}
