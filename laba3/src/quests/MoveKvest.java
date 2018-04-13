package quests;

public class MoveKvest extends Kvest{
	 private String plase="Зона";
	 private String time="19.34.23";
	 /**
	  * @param coordinatX coordinate of the character in the x-axis
	  * @param coordinatY coordinate of the character in the y-axis
	  * @return 1 if the character is in required zone
	  */
	 public int LearnCoordinat(int coordinatX, int coordinatY) {
		if ((coordinatX>2 && coordinatX<9) && (coordinatY>2 && coordinatY<9))
			return 1;
		else
			return 0;
	 }
	 /**
	  * 
	  * @param newVariable new value of the variable plase
	  */
	 void SetPlase(String newVariable)	{
		 plase=newVariable;
		 }
	 /**
	  * 
	  * @param newVariable new value of the variable time
	  */
	 void SetTime(String newVariable)	{
		 time=newVariable;
		 }
	 /**
	  * 
	  * @return value of the variable time
	  */
	public String GetPlace() {
		 return plase;
	 }
	/**
	 * 
	 * @return value of the variable plase
	 */
	public String GetTime() {
		 return time;
	 }
}
