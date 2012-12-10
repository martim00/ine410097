package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "areaconhecimento")
public class AreaConhecimento {

	private long id;
	private String nome = null;

	public AreaConhecimento() {
	}

	public AreaConhecimento(String nomeArea) {
		this.setNomeArea(nomeArea);
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNomeArea(String nomeArea) {
		this.nome = nomeArea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaConhecimento other = (AreaConhecimento) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public static void main(String[] args) {
		String teste = "|natan|teste|bola|";
		List<String> teste2 = (List<String>) Arrays.asList(teste
				.split("|"));
		teste2.get(0);
		System.out.println(teste2);
	}

}