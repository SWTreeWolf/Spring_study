package example;

public class SingletonBean {
	private PrototypeBean prototypeBean;

	public SingletonBean() {
		// TODO Auto-generated constructor stub
		System.out.println("Singleton Bean Injection!!");
	}

	public PrototypeBean getPrototypeBean() {
		return prototypeBean;
	}

	public void setPrototypeBean(PrototypeBean prototypeBean) {
		this.prototypeBean = prototypeBean;
	}

}//end class
