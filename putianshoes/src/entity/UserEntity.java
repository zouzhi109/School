package entity;

public class UserEntity {
	private int id;
	private int idCard;
	private String name;
	private String sex;
	private int tel;
	private double price;
	private int aId;
	
	private AdminEntity admin;
	
	public AdminEntity getAdmin() {
		return admin;
	}

	public void setAdmin(AdminEntity admin) {
		this.admin = admin;
	}

	public UserEntity() {
	}

	public UserEntity(int id, int idCard, String name, String sex, int tel, double price, int aId) {
		this.id = id;
		this.idCard = idCard;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.price = price;
		this.aId = aId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	@Override
	public String toString() {
		return String.format("UserEntity [id=%s, idCard=%s, name=%s, sex=%s, tel=%s, price=%s, aId=%s]", id, idCard,
				name, sex, tel, price, aId);
	}
	
}
