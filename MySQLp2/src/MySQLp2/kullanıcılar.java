package MySQLp2;

public class kullanıcılar {
	String name;
	String pass;
	public kullanıcılar(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected String getPass() {
		return pass;
	}
	protected void setPass(String pass) {
		this.pass = pass;
	}

}
