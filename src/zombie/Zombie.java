package zombie;

abstract public class Zombie extends Unit implements Attackable {

	protected Zombie(int hp, int pos, int attack) {
		super(hp, pos, attack);
	}

	public void attack(Unit hero) {
		attack = ran.nextInt(attack) + 1;

		hero.setHp(hero.getHp() - attack);
		if (hero.getHp() <= 0) {
			hero.setHp(0);
		}
	}

}
