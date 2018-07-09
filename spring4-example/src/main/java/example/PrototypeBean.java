package example;

public class PrototypeBean {
	private String message;
	
	public PrototypeBean() {
		// TODO Auto-generated constructor stub
		System.out.println("prototype injection!!");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}//end class
