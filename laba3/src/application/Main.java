/**
 * @author Vlada Yurevich
 */
package application;
import monsters.Monster;
import classes.Person;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setResizable(false);
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 300);



			GridPane gridpane = new GridPane();
			GridPane gridpaneKvest = new GridPane();
			gridpane.setPadding(new Insets(5));
			gridpane.setHgap(5);
			gridpane.setVgap(5);
			
			gridpaneKvest.setPadding(new Insets(5));
			gridpaneKvest.setHgap(5);
			gridpaneKvest.setVgap(5);
			
			Person myPers = new Person();

			Monster m = new Monster();
			
			Label label = new Label("Раса:");
			gridpane.add(label, 0, 1);
			label = new Label("Класс:");
			gridpane.add(label, 0, 2);
			label = new Label("Уровень:");
			gridpane.add(label, 0, 3);
			label = new Label("Координаты:");
			gridpane.add(label, 0, 4);
			
			Button buttonMove = new Button("Переместиться");
			gridpane.add(buttonMove, 0, 5);
			
			
			
			Label labelRasa = new Label(myPers.GetRasa());
			Label labelClas = new Label(myPers.GetClas());
			Label labelLevel = new Label(String.valueOf(myPers.GetLevel()));
			Label labelCoordinat = new Label(String.valueOf(myPers.GetCoordinatX())+","+String.valueOf(myPers.GetCoordinatY()));
			
			gridpane.add(labelRasa, 1, 1);
			gridpane.add(labelClas, 1, 2);
			gridpane.add(labelLevel, 1, 3);
			gridpane.add(labelCoordinat, 1, 4);

			
			label = new Label("Ваше задание:");
			Label labelStartText = new Label();
			Label labelFinishText = new Label();
			Label labelInfKvest1 = new Label();
			Label labelInfKvest2 = new Label();
			Label labelInfKvest1_1 = new Label();
			Label labelInfKvest2_2 = new Label();
			Label labelHealth1 = new Label("Здоровье");
			Label labelHealth2 = new Label();
			Button buttonDoKvest = new Button();
			Button buttonFinish = new Button("Завершить");
			
			
			gridpaneKvest.add(label, 0, 0);
			gridpaneKvest.add(labelStartText, 0, 1);
			gridpaneKvest.setAlignment(Pos.TOP_CENTER);
			gridpaneKvest.add(labelInfKvest1, 0, 2);
			gridpaneKvest.add(labelInfKvest1_1, 1, 2);
			gridpaneKvest.add(labelInfKvest2, 0, 3);
			gridpaneKvest.add(labelInfKvest2_2, 1, 3);
			gridpaneKvest.add(labelHealth1, 0, 4);
			gridpaneKvest.add(labelHealth2, 1, 4);
			gridpaneKvest.add(buttonDoKvest, 0,5);
			gridpaneKvest.add(labelFinishText, 0, 6);
			gridpaneKvest.add(buttonFinish, 0, 7);
			
			gridpaneKvest.setVisible(false);
			labelHealth1.setVisible(false);
			labelHealth2.setVisible(false);
	
			buttonMove.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
				myPers.Move();
				labelCoordinat.setText(String.valueOf(myPers.GetCoordinatX())+",  "+String.valueOf(myPers.GetCoordinatY()));	
				}
			});
			
			 ComboBox<String> comboBox = new ComboBox<>();
			 comboBox.getItems().addAll("Убийство", "Перемещение");
			 comboBox.setMaxWidth(100);
			 comboBox.setPromptText("Квест");
			 gridpane.add(comboBox, 0, 6);

				comboBox.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
					boolean chouse;
					gridpaneKvest.setVisible(true);
					gridpane.setMaxSize(200, 200);
					Monster  monster = m.Generate();
					buttonMove.setDisable(true);
					comboBox.setDisable(true);
					buttonFinish.setVisible(false);
					labelFinishText.setVisible(false);
					String s=comboBox.getValue();
					if (s.equals("Убийство"))
					{
						chouse=true;
						myPers.TakeKvest(chouse);
						labelStartText.setText(myPers.myKill.GetStartText());
						buttonDoKvest.setText("бить");
						labelInfKvest1.setText("Тип:");
						labelInfKvest2.setText("Количество:");
						labelInfKvest1_1.setText(monster.GetType());
						labelInfKvest2_2.setText(String.valueOf(myPers.myKill.GetCount()));
						labelHealth1.setVisible(true);
						labelHealth2.setVisible(true);						
						labelHealth2.setText(String.valueOf(monster.GetHealth()));
					}
					else 
					{
						chouse=false;
						myPers.TakeKvest(chouse);
						labelStartText.setText(myPers.myMove.GetStartText());
						buttonDoKvest.setText("Переместиться");
						labelInfKvest1.setText("Место:");
						labelInfKvest2.setText("Время:");
						labelInfKvest1_1.setText(myPers.myMove.GetPlace());
						labelInfKvest2_2.setText(String.valueOf(myPers.myMove.GetTime()));
					}	
					
					buttonDoKvest.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
						if(chouse==true){	
							int count;
							count=myPers.myKill.GetCount();
							myPers.BeatMonster(monster);
							labelHealth2.setText(String.valueOf(monster.GetHealth()));
							if(monster.IsDie()) {
								monster.SetHealth(100);
								labelHealth2.setText(String.valueOf(monster.GetHealth()));
								myPers.myKill.SetCount(--count);
								labelInfKvest2_2.setText(String.valueOf(myPers.myKill.GetCount()));
								System.out.print(myPers.myKill.IsFinished());
								if(myPers.myKill.IsFinished()) 	{
									labelFinishText.setText(myPers.myKill.GetFinishText());
									myPers.myKill.SetCount();
								}
								else return;
							}
							else return;
						}
						if(chouse == false) {
							myPers.Move();
							labelCoordinat.setText(String.valueOf(myPers.GetCoordinatX())+",  "+String.valueOf(myPers.GetCoordinatY()));
							if(myPers.myMove.LearnCoordinat(myPers.GetCoordinatX(), myPers.GetCoordinatY())==0 )
								return;
							myPers.myMove.FinishKvest();
							labelFinishText.setText(myPers.myMove.GetFinishText());

						}
						buttonDoKvest.setDisable(true);
						labelFinishText.setVisible(true);
						buttonFinish.setVisible(true);
						
						buttonFinish.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent e) {
								labelHealth1.setVisible(false);
								labelHealth2.setVisible(false);
								gridpaneKvest.setVisible(false);
								buttonDoKvest.setDisable(false);
								buttonMove.setDisable(false);
								comboBox.setDisable(false);
								myPers.SetLevel(myPers.GetLevel()+1);
								labelLevel.setText(String.valueOf(myPers.GetLevel()));
							}
						});
					}
				});
			}
		});	 
			root.setLeft(gridpane);
			root.setRight(gridpaneKvest);
			primaryStage.setScene(scene);
			primaryStage.show();
	}catch(Exception e) {
		e.printStackTrace();
	  }
}
	
	public static void main(String[] args) {
		launch(args);
	}
}


