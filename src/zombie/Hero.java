package zombie;

public class Hero extends Unit implements Attackable, Recoverable {
	protected Hero(int hp, int pos, int attack) {
		super(hp, pos, attack);
	}

	private int count;

	@Override
	public void attack(Unit unit) {
		if (unit instanceof Unit) {
			Unit target = (Unit) unit;
		}

	}

	public void recovery() {
		if (count > 0) {
			setHp(getHp() + 200);
			System.out.println("체력 회복해서 " + getHp() + "가 되었습니다."); // 회복된 체력 출력
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
