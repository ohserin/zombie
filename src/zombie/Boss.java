package zombie;

public class Boss extends Unit {
	private int shield;
	private final int LETHALl = 1;

	public int getShield() {
		return shield;
	}

	public void setShield(int value) {
		shield = value;
	}

	protected Boss(int hp, int pos, int attack) {
		super(hp, pos, attack);
	}

	public void attack(Unit hero) {
		int attackType = ran.nextInt(4) + 1;
		if (attackType == LETHALl) {
			System.out.println("보스의 필살기 발동 2배의 공격력");
			attack = 2 * (ran.nextInt(4) + 1);
			hero.setHp(hero.getHp() - attack);
			if (hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.println("보스가 " + attack + "의 공격력으로 공격 :" + " 현재 Hero hp : " + hero.getHp());
		} else {
			System.out.println("보스의 일반공격 ");
			int power = ran.nextInt(4) + 1;
			hero.setHp(hero.getHp() - power);
			if (hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.println("보스가 " + power + "의 공격력으로 공격 :" + " 현재 Hero hp : " + hero.getHp());
		}
	}

}
