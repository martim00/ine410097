package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "disciplina")
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

	@OneToOne
	@JoinColumn(name="id_area")
	public AreaConhecimento getArea() {
		return area;
	}
	
	public void setArea(AreaConhecimento area) {
		this.area = area;		
	}

	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

}