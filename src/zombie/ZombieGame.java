package zombie;

import java.util.Random;
import java.util.Scanner;

public class ZombieGame {

	private ZombieGame() {
	}

	private static ZombieGame instance = new ZombieGame();

	public static ZombieGame getInstance() {
		return instance;
	}

	private final int MOVE = 1;
	private final int EXIT = 2;

	private final int ATTACK = 2;
	private final int HILL = 2;
	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();
	private boolean isRun = true;
	private int pos = 1;

	Hero hero = new Hero(1, 100, 2);

	public void run() {
		while (isRun) {
			System.out.printf("현재 위치는 %d 입니다\n", pos);
			selectRun();
		}
	}

	private void selectRun() {
		int move = input("1)앞으로 이동, 2) 종료");

		if (move == MOVE) {
			pos = pos + 1;
			hero.setPos(pos);

			int appeared = ran.nextInt(10) + 1;
			if (hero.getPos() == appeared) {
				System.out.println("좀비를 만났습니다. 공격모드로 바뀝니다.");

				while (true) {
					int action = input("1)공격하기, 2) 포션마시기");

					if (action == ATTACK) {
//						hero.attack()
					} else if (action == HILL) {
						System.out.println("마셨다???");
						hero.recovery();
					}
				}

			}

		} else if (move == EXIT) {
			System.out.println("게임종료");
			isRun = false;
		}

	}

	private int input(String msg) {
		System.out.println(msg + " : ");
		String input = scan.nextLine();

		int num = -1;
		try {
			num = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자로 입력하세요.");
		}
		return num;
	}

}
