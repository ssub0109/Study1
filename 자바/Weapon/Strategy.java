
public class Strategy {
	private Weapon weapon = null;
	
	void doAttack() {
		if (weapon == null) System.out.println("�Ǽհ���");
		else weapon.attack();
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

}
