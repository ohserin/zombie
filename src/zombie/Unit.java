package zombie;

public class Unit {
	protected final int MAX_HP;
	protected int hp;
	protected int pos;
	protected String name;

	protected Unit(int hp, int pos, String name) {
		MAX_HP = hp;
		this.hp = hp;
		this.pos = pos;
		this.name = name;
	}
}