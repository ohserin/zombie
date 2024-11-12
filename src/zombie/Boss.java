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
		int attackType = ran.nextInt(attack) + 1;
		if (attackType == LETHALl) {
			System.out.println("보스의 필살기 발동 2배의 공격력");
			attack = 2 * (ran.nextInt(attack) + 1);
			hero.setHp(hero.getHp() - attack);
			if (hero.getHp() <= 0) {
				hero.setHp(0);
			}
			String info = String.format("보스가 %d의 공격력으로 공격! 현재 Hero HP %d :", attack, hero.getHp());
			System.out.println(info);
		} else {
			System.out.println("보스의 일반공격 ");
			attack = ran.nextInt(attack) + 1;
			hero.setHp(hero.getHp() - attack);
			if (hero.getHp() <= 0) {
				hero.setHp(0);
			}
			String info = String.format("보스가 %d의 공격으로 공격 >>> 현재 Hero hp : %d", attack, hero.getHp());
			System.out.println(info);
		}
	}

}
