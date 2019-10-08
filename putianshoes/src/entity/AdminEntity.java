package entity;

public class AdminEntity {
	
	private int id;
	private String name;
	
	public AdminEntity() {
	}

	public AdminEntity(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("AdminEntity [id=%s, name=%s]", id, name);
	}

}
