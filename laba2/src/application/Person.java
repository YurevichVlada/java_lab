package application;

import java.util.Random;

public class Person {
	 private String rasa;
	 private String clas;
	 private int level=1;
	 private int coordinatX=0;
	 private int coordinatY=0;
	 KillKvest myKill = new KillKvest();
	 MoveKvest myMove = new MoveKvest();
	 Person(){
		 rasa="Ёльф";
		 clas="Ћучник";
	 }
	 /**
	  *  activate new quest
	  * @param b characterizes the type of quest
	  */
	 public void TakeKvest(boolean b) {
		if(b==true) 
			myKill.ActivateKvest(b);
		else 
			myMove.ActivateKvest(b);
	 };
	 /**
	  * changes the coordinates of the character in a random way
	  */
	 public void Move() {
		 Random random = new Random();
		 coordinatX=random.nextInt(11);
		 coordinatY=random.nextInt(11);
	 };
	 /**
	  * @param newVariable new value of the variable rasa
	  */
	 public void SetRasa(String newVariable){
		 rasa=newVariable;
	 }
	 /**
	  * @param newVariable new value of the variable clas
	  */
	 public void SetClas(String newVariable){
		 clas=newVariable;
	 }
	 /**
	  * @param new value of the variable level
	  */
	 public void SetLevel(int newVariable){
		 level=newVariable;
	 }
	 /**
	  * 
	  * @param newVariable new value of the variable coordinatX
	  */
	 public void SetCoordinatX(int newVariable){
		 coordinatX=newVariable;
	 }
	 /**
	  * 
	  * @param newVariable new value of the variable coordinatY
	  */
	 public void SetCoordinatY(int newVariable){
		 coordinatY=newVariable;
	 }
	 String GetRasa(){
		 return rasa;
	 }
	 String GetClas(){
		 return clas;
	 }
	 int GetLevel(){
		 return level;
	 }
	 int GetCoordinatX(){
		 return coordinatX;
	 }
	 int GetCoordinatY(){
		 return coordinatY;
	 }
}


