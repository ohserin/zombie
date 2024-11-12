package zombie;

public class Hero extends Unit implements Attackable, Recoverable {
	private int count;

	protected Hero(int hp, int pos, int attack) {
		super(hp, pos, attack);
		this.count = 4;
	}

	@Override
	public void attack(Unit enemy) {

		if (enemy instanceof Boss) {
			Boss boss = (Boss) enemy;
			attack = ran.nextInt(attack) + 1;
			if (boss.getShield() > 0) {
				int excessDamage = boss.getShield() - attack;
				if (excessDamage >= 0) {
					boss.setShield(boss.getShield() - attack);
				} else {
					boss.setShield(0);
					boss.setHp(boss.getHp() - excessDamage);
				}
			} else {
				boss.setHp(boss.getHp() - attack);
			}

			if (boss.getHp() <= 0) {
				boss.setHp(0);
			}

			String info = String.format("Hero가 %d의 공격력으로 공격!! >>> 현재 Boss hp : %d 현재 보스 방어력 : %d", attack, boss.getHp(),
					boss.getShield());
			System.out.println(info);
		} else {
			

			attack = ran.nextInt(attack) + 1;
			enemy.setHp(enemy.getHp() - attack);
			if (enemy.getHp() <= 0) {
				enemy.setHp(0);
			}
			String info = String.format("Hero가 %d의 공격력으로 공격!! >>> 현재 Zombie hp : %d", attack,enemy.getHp());
			System.out.println(info);
		}
	}

	public void recovery() {
		if (count > 0) {
			setHp(getHp() + 200);
			System.out.println(String.format("hp가 %d로 상승하였습니다.", getHp()));
			count -= 1;
		} else {
			System.out.println("모두 사용했습니다.");
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
