package model;

public class VoceLista {
	private int id;
	private String voce;
	public VoceLista() {
		this(-1, "");
	}
	public VoceLista(int id, String voce) {
		this.id = id >= 0 ? id : -1;
		this.voce = !voce.isBlank() ? voce.trim() : "";
	}
	public int getId() {
		return id;
	}
	public String getVoce() {
		return voce;
	}
	public void setId(int id) {
		if (id >= 0)
			this.id = id;
	}
	public void setVoce(String voce) {
		if (!voce.isBlank())
			this.voce = voce.trim();
	}
	@Override
	public String toString() {
		return "(%s'%s')".formatted(id >= 0 ? id + ", " : "", voce);
	}
}