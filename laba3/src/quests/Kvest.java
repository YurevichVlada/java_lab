package quests;

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
	 protected void End()	{
		 FinishKvest();
	 }
	 
}



 