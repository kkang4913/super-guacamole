package exam07;
//사원
public class Staff extends Employee {
	//(4)
	public Staff(String name, int age) {
		super(name, age);
	//정해진 연봉을 입력	(6)
	setSalary(2800);
	}
	@Override
	public void bonus(int month) {
		switch (month) {
		case 6: case 12:
			super.bonus(month);
			break;

		}
	}
	
}
