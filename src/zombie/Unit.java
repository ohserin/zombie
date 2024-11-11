package zombie;

import java.util.Random;

public class Unit {
	protected final int MAX_HP;
	protected int hp;
	protected int pos;
	protected int attack;
	protected Random ran;

	protected Unit(int hp, int pos, int attack) {
		MAX_HP = hp;
		this.hp = hp;
		this.pos = pos;
		this.attack = attack;
		this.ran = new Random();
	}

	public int getPos() {
		return this.pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMAX_HP() {
		return this.MAX_HP;
	}
}