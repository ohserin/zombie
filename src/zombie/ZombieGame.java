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

	private final int ATTACK = 1;
	private final int HILL = 2;
	private final int RUNNING = 3;

	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();
	private boolean isRun = true;
	private int pos = 1;

	Hero hero = new Hero(220, 1, 10);
	Boss boss = new Boss(300, 9, 10);
	Zombie zombie = new Zombie(100, 4, 5);

	public void run() {
		while (isRun) {
			System.out.printf("현재 위치는 %d 입니다\n", pos);
			selectRun();
		}
	}

	private void selectRun() {
		int run = ran.nextInt(2);
		int move = input("1)앞으로 이동, 2) 종료");

		if (move == MOVE) {
			pos = pos + 1;
			hero.setPos(pos);

			if (hero.getPos() == zombie.getPos()) {
				System.out.println("좀비를 만났습니다. 공격모드로 바뀝니다.");

				while (true) {
					int action = input("1)공격하기, 2) 포션마시기, 3) 도망가기");

					if (action == ATTACK) {
						zombie.attack(hero);
						hero.attack(zombie);

					} else if (action == HILL) {
						hero.recovery();
					} else if (action == RUNNING) {

						if (run == 1) {
							System.out.println("50%의 확률로 도망에 성공하였습니다!");
							break;
						} else if (run == 0) {
							System.out.println("50%의 확률로 도망에 실패하였습니다...");
							continue;
						}
					}

					if (hero.getHp() <= 0) {
						System.out.println("Hero는 죽었습니다.");
						break;
					}
					if (zombie.getHp() <= 0) {
						System.out.println("좀비를 해치웠습니다!");
						break;
					}
				}

			}

			if (hero.getPos() == boss.getPos()) {
				System.out.println("보스를 만났습니다. 공격모드로 바뀝니다.");

				while (true) {
					int action = input("1)공격하기, 2) 포션마시기, 3) 도망가기");

					if (action == ATTACK) {
						boss.attack(hero);
						hero.attack(boss);
					} else if (action == HILL) {
						hero.recovery();
					} else if (action == RUNNING) {

						if (run == 1) {
							System.out.println("50%의 확률로 도망에 성공하였습니다!");
							break;
						} else if (run == 0) {
							System.out.println("50%의 확률로 도망에 실패하였습니다...");
							continue;
						}
					}

					if (hero.getHp() <= 0) {
						System.out.println("죽었습니다.");
						break;
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
