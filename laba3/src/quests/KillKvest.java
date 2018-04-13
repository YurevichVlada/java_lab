package quests;

import java.util.Random;

public class KillKvest extends Kvest{
	/**count of the monster in this quest*/
	 private int count=2;
	 /**
	  * Set the value of the variable count in random way
	  */
	 public void SetCount(){
		 Random random = new Random();
		 count=random.nextInt(8);
	 }
	 /**
	  * 
	  * @param c new value of the variable count
	  */
	 public  void SetCount(int c) {
		 count=c;
	 }
	 /**
	  * 
	  * @return value of the variable count
	  */
	 public int GetCount() {
		 return count;
	 }
	 /**
	  * @return true , if quest must be finished as all monsters are killed
	  */
	 public boolean IsFinished(){
		 if (count<=0) {
			 End();
			 return true;
		 }	 
		 else return false;
	 }
}
