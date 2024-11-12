package zombie;

public class Zombie extends Unit implements Attackable {

	protected Zombie(int hp, int pos, int attack) {
		super(hp, pos, attack);
	}

	public void attack(Unit hero) {
		attack = ran.nextInt(attack) + 3;

		hero.setHp(hero.getHp() - attack);
		if (hero.getHp() <= 0) {
			hero.setHp(0);
		}

		this.setHp(this.getHp() + attack / 2);

		String info = String.format("좀비가 %d 데미지를 입혔습니다. 현재 Hero hp : %d 좀비 체력 회복: %d", attack, hero.getHp(),
				this.getHp());
		System.out.println(info);
	}

}
