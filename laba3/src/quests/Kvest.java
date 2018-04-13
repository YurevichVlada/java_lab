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
		 finishText="Квест выполнен успешно\n Вы получаете новый уровень \n";
	 };
	 /**
	  * set the value of the variable StartText
	  * @param b characterizes the type of quest
	  */
	 public void ActivateKvest(boolean b) {
		 if(b==true) 
			 startText="Вы будете убивать";
		 else 
			 startText="Ваша задача\n попасть в зону\n с данными координатами \n 2 < x < 9 и 2 < у < 9 ";
	 };
	 /**
	  * called function FinishKvest()
	  */
	 protected void End()	{
		 FinishKvest();
	 }
	 
}



 