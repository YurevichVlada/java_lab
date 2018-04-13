package classes;

import java.util.Random;
import monsters.Monster;
import quests.KillKvest;
import quests.MoveKvest;

public class Person {
	 private String rasa;
	 private String clas;
	 private int level=1;
	 private int coordinatX=0;
	 private int coordinatY=0;
	 public KillKvest myKill = new KillKvest();
	 public  MoveKvest myMove = new MoveKvest();
	 public Person(){
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
	  * @param m monster for beating
	  */
	 public void BeatMonster(Monster m) {
		 m.GetDamage();
	 }
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
	 public String GetRasa(){
		 return rasa;
	 }
	 public String GetClas(){
		 return clas;
	 }
	 public  int GetLevel(){
		 return level;
	 }
	 public int GetCoordinatX(){
		 return coordinatX;
	 }
	 public int GetCoordinatY(){
		 return coordinatY;
	 }	
 }