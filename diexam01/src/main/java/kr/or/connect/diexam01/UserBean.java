package kr.or.connect.diexam01;

public class UserBean {
	/*
	 * Bean은 아래 3가지 특성을 가져야 한다
	 * 	1. 기본 생성자를 가지고 있다.
	 * 	2. 필드는 private하게 선언한다. <- 변수
	 * 	3. geter, seter 메소드를 가진다. getName(), setName() 메소드를 name 프로퍼티(property) 라고 한다.(용어 중요 함)
	 */
	private String name;
	private int age;
	private boolean maie;
	
	// 기본 생성자
	public UserBean() {
	}

	public UserBean(String name, int age, boolean maie) {
		this.name = name;
		this.age = age;
		this.maie = maie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMaie() {
		return maie;
	}

	public void setMaie(boolean maie) {
		this.maie = maie;
	}
	
}
