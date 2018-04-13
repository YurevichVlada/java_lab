package monsters;

import java.util.Random;


public class Monster {
	/**type descripe type of the monster */
	protected  String type;
	/**monstreLevel descripe level of the monster */
	private  int monsterLevel=1;
	/**health descripe health of the monster */
	private int health=100;
	/**reduces monster's health */
	public void GetDamage() {
		health-=20;
		if (health==0) {
			Die();	
		}

	}
	/**
	 * @param val new value of the variable health
	 */
	public void SetHealth(int val) {
		health=val;
	}
	/**
	 * 
	 * @return value of the variable health
	 */
	public int GetHealth() {
		return health;
	}
	private int Die() { 
		return 0;
	}
	/**
	 * checks the condition of the monster
	 * @return true if monster is died
	 */
	public boolean IsDie() {
		if (health==0) return true;
		else return false;
	}	
	/**
	 * 
	 * @return type of the monster
	 */
	public String GetType() {
		return type;
	}
	/**
	 * 
	 * @param s new value of the variable type
	 */
	void SetType(String s) {
		type=s;
	}
	/**
	 * creates a random monster type kaban or verwolf
	 * @return random monster
	 */

	public Monster Generate(){
		int m;
		Random random = new Random();
		m=random.nextInt(2);
		if(m==1) {
			Kaban kaban = new Kaban();
			return (Monster)kaban;
		}
		else {
			Verwolf verwolf = new Verwolf();
			return (Monster)verwolf;
		}

	}
}




