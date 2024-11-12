package zombie;

abstract public class Zombie extends Unit implements Attackable {

	protected Zombie(int hp, int pos, int attack) {
		super(hp, pos, attack);
	}

	public void attack(Unit hero) {
		attack = ran.nextInt(4) + 1;

		hero.setHp(hero.getHp() - attack);
		if (hero.getHp() <= 0) {
			hero.setHp(0);
		}

		this.setHp(this.getHp() + attack / 2);

		System.out.println(
				"좀비가 " + attack + "의 공격력으로 공격 :" + " 현재 Hero hp : " + hero.getHp() + ",좀비 체력 회복 " + this.getHp());

	}

}
