package domain;

import java.io.Serializable;

public class AreaConhecimento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String nomeArea = null;

	public AreaConhecimento() {}
	
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
		return nomeArea;
	}

	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeArea == null) ? 0 : nomeArea.hashCode());
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
		if (nomeArea == null) {
			if (other.nomeArea != null)
				return false;
		} else if (!nomeArea.equals(other.nomeArea))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNomeArea();
	}
	
}