package jp.co.sample.form;

public class InsertAdministratorForm {
	private String name;//名前
	private String mailAddress;//メールアドレス
	private String password;//パスワード
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
