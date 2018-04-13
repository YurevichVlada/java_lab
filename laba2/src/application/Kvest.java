package application;

import java.util.Random;



public class Kvest{
	/**a string containing the introductory text*/
	private String startText;
	/**a string containing the final text*/
	private String finishText;
	/**
	 * 
	 * @param newVariable new value of the variable StartText
	 */
	void SetStartText(String newVariable){
		startText=newVariable;
	 }
	/**
	 * @param newVariable new value of the variable FinishText
	 */
	 void SetFinishText(String newVariable){
		 finishText=newVariable;
	 }
	 /**
	  * @return value of the variable StartText
	  */
	 public  String GetStartText(){
		 return startText;
	 }
	 /**
	  * 
	  * @return value of the variable FinishText
	  */
	 public String GetFinishText(){
		 return finishText;
	 }
	 /**
	  * set the value of the variable FinishText
	  */
	 public void FinishKvest() {
		 finishText="����� �������� �������\n �� ��������� ����� ������� \n";
	 };
	 /**
	  * set the value of the variable StartText
	  * @param b characterizes the type of quest
	  */
	 public void ActivateKvest(boolean b) {
		 if(b==true) 
			 startText="�� ������ �������";
		 else 
			 startText="���� ������\n ������� � ����\n � ������� ������������ \n 2 < x < 9 � 2 < � < 9 ";
	 };
	 /**
	  * called function FinishKvest()
	  */
	 
}

 class KillKvest extends Kvest{
	 private String typeMonster="�����";
	 private int count=2;
	 void SetTypeMonster(String newVariable)	{
		 typeMonster=newVariable;
		 } 
	String GetTypeMonster() {
		 return typeMonster;
	}
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
	 int beat()
	 {
		 count--;
		 if(count<0)
		 {
			 SetCount();
			 FinishKvest();
			 return 0;
			 
		 }
		 return 1;
			 
	 }
 }
 
 class MoveKvest extends Kvest{
	 private String plase="����";
	 private String time="19.34.23";
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