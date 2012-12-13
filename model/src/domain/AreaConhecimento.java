package domain;

public class AreaConhecimento {


	private long id;
	private String nome = null;

	public AreaConhecimento() {
	}

	public AreaConhecimento(String nomeArea) {
		this.setNomeArea(nomeArea);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getNomeArea() {
		return nome;
	}

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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNomeArea();
	}

}