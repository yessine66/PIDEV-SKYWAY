package Esprit.gui;

import Esprit.services.promotionCRUD;
import static Esprit.tests.mail2.sendBulkEmail2;
import java.awt.Frame;
import java.awt.PopupMenu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class LotteryWheel extends Application {
    
	// Scene Size
	private static final int HEIGHT = 800;
	private static final int WIDHT = 1200;

	private static final int CENTER_X = WIDHT / 2;
	private static final int CENTER_Y = HEIGHT / 2;
	private static final double ORBIT = 350;
	private static final int FONT_SIZE = 10;

	private static final List<Text> names = new ArrayList<>();
private static Text winnerName;
private static String testnamehiou;
private static Text brassomekaaa=new Text("vide");
      // Text text = new Text("foo");
        
       // String winnerName;
	private static Text arrowText;
  Text ok;
	private List<Point> points;
/*
                        String converterToString(Text winnerName) {
    final StringConverter<Text> converter=null ;
    
        return converter.toString(winnerName);
    }*/
	@Override
	public void start(Stage primaryStage) throws IOException {
		final Pane root = new Pane();
	 BackgroundFill background_fill = new BackgroundFill(Color.BLACK, 
                                          CornerRadii.EMPTY, Insets.EMPTY);
  
            // create Background
            Background background = new Background(background_fill);
             root.setBackground(background);
		// Load all name from the file
                 promotionCRUD aa = new promotionCRUD();
                 //aa.writeFile();
               
                String ok=aa.writeFile();
                System.out.println("\n\n\naffichili ooooook"+ok);
              //  FrontTest2 front =new FrontTest2();
              
       //  brassomekaaa.setText(ok);
                
         /*     Text text = new Text("foo");
// convert Text to String
String s = text.getText(); // value = "foo"
// convert String to Text
text.setText(s); // or text = new Text(s) // value = "foo"*/
         

                System.out.println(ok);
                System.out.println("\n\n jdida "+ brassomekaaa);
		names.addAll(loadNames(new File("names.txt")));
	
		shuffleNames();
	
		// Calculate all points where the names should be positioned.
		points = calculatePoints(names.size(), CENTER_X, CENTER_Y, ORBIT);
	
		// Number of rotations per timeline
		int cyclesPerTimeline = 5;
	
		// Create recursive timeline to slow down the wheel
		// Timeline chaining
		Timeline nextTimeline = null;
		
		for (int numberOfTimelines = 3; numberOfTimelines > 0; numberOfTimelines--) {
			final KeyFrame duration = new KeyFrame(Duration.millis(100 * numberOfTimelines));
			nextTimeline = createTimeline(root, duration, nextTimeline);
			nextTimeline.setCycleCount(cyclesPerTimeline);
		}
	
		arrowText = new Text("Winner");
		arrowText.getStyleClass().add("arrow-text");
		arrowText.setX(250);
		arrowText.setY(CENTER_Y);
	
		Rectangle rectangle = new Rectangle();
		rectangle.getStyleClass().add("rectangle");
		rectangle.setX(240);
		rectangle.setY((HEIGHT-75)/2);
		rectangle.setWidth(450);
		rectangle.setHeight(60);
		root.getChildren().add(rectangle);
		
		paintArrow(root);
		root.getChildren().addAll(names);
		root.getChildren().add(arrowText);
	
		Scene scene = new Scene(root, WIDHT, HEIGHT);
	
		primaryStage.setTitle("Lottery Wheel");
		primaryStage.setScene(scene);
		primaryStage.getScene().getStylesheets().add("rotatingNames");
		primaryStage.show();
	
		// nextTimeline.setDelay(Duration.seconds(10));
		nextTimeline.play();
               
       
	}
         private void LoadPage (String page){
    Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource(page));
                      System.out.println("load1");
        } catch (IOException ex) {
           // Logger.getLogger(FrontTest2.class.getName()).log(Level.SEVERE, null, ex);
            
             System.out.println("load2");
        }

             System.out.println("load3");
    
    }

	/**
	 * 
	 * Shuffle the names so there is a random winner.
	 * 
	 */
	private void shuffleNames() {
		// Shuffle the name
		Collections.shuffle(names);

		// Set position for each name
		int position = 0;
		for (Text name : names) {
			name.setUserData(new Integer(position++));
                      
		}

	}

	/**
	 * 
	 *  Draw the arrow.
	 * 
	 * @param root The root pane with all nodes.
	 */
	private void paintArrow(Pane root) {
		double rightSpace = WIDHT / 2 - ORBIT - 90;
		
		Path path = PathBuilder.create()
				.styleClass("arrowStyleUp")
				.elements(
						new MoveTo(rightSpace, CENTER_Y - 22), 
						new LineTo(rightSpace + 50, CENTER_Y - 22), 
						new LineTo(rightSpace + 50, CENTER_Y - 30), 
						new LineTo(rightSpace + 70, CENTER_Y - 12), 
						new LineTo(rightSpace, CENTER_Y - 12), 
						new LineTo(rightSpace, CENTER_Y - 22)
					).build();
	
		root.getChildren().add(path);
	           
		path = PathBuilder.create()
				.styleClass("arrowStyleDown")
				.elements(
						new MoveTo(rightSpace, CENTER_Y - 12), 
						new LineTo(rightSpace + 70, CENTER_Y - 12), 
						new LineTo(rightSpace + 50, CENTER_Y + 6), 
						new LineTo(rightSpace + 50, CENTER_Y - 2), 
						new LineTo(rightSpace, CENTER_Y - 2), 
						new LineTo(rightSpace, CENTER_Y - 12)
						).build();
	
		root.getChildren().add(path);
	
	}

	/**
	 * Create a bunch of timelines.
	 * @param root The root pane which contains all names, ...
	 * @param duration Duration of the timeline.
	 * @param nextTimeline The timeline which is started when the next timeline has finished.
	 * @return The new timeline.
	 */
	private Timeline createTimeline(final Pane root, final KeyFrame duration, final Timeline nextTimeline) {
		final Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new EventHandler<ActionEvent>() {
	
			@Override
			public void handle(ActionEvent event) {
				moveNames(duration);
			}
		}), duration);
	
		// Start next timeline on finish
		timeline.setOnFinished(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
                            try {
                                handleNextTimelineAndWinner(root, nextTimeline);
                            } catch (SQLException ex) {
                                Logger.getLogger(LotteryWheel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                
                                
			};
		});
	
		return timeline;
	}

	/**
	 * Start the next timeline if there is another one.
	 * Or highlight the winner.
	 * 
	 * @param root The root pane with all nodes.
	 * @param nextTimeline The next timeline of null.
	 */
	private void handleNextTimelineAndWinner(Pane root, Timeline nextTimeline) throws SQLException {
		if (nextTimeline != null) {
			// Start the next timeline
			nextTimeline.play();
		} else {
			// Only executed if the last timeline is reached
			
			// Make the text visible again
			FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), winnerName);
                        //cibouuuuuuuuuuuuuuuuuuuuuuun
                            System.out.println("1 ");
                        System.out.println(winnerName.getText());
                        promotionCRUD aa = new promotionCRUD();
                   
                        System.out.println("\n\n\n\n\n yahbiiiiiibiiiiiiii : " +aa.loadCodeBase(winnerName.getText())+"reductionnn :  "+ aa.loadCreducBase(winnerName.getText()) );
                    
                        //FrontTest2 f =new FrontTest2();
                        //promotionCRUD aa = new promotionCRUD();
                        //aa.writeFile();
                        // String ok=aa.writeFile();
showMessageDialog(null, "code mte3ek:  " +aa.loadCodeBase(winnerName.getText())+"   reductionnn mte3ek :  "+ aa.loadCreducBase(winnerName.getText()) , "mabrouuuk", JOptionPane.PLAIN_MESSAGE);
//LoadPage("notifGagnant");

   
           

        //LoadPage("AjouterPartenaire");
                        
  /*                                          Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("You can't log in");
        alert.setContentText("The Username or password you’ve entered doesn’t match any account ");
        alert.showAndWait();*/
                        
    /*                    Stage primaryStage = new Stage();
                           primaryStage.setTitle("Popup Example");  
    final Popup popup = new Popup(); popup.setX(300); popup.setY(200);
    popup.getContent().addAll(new Circle(25, 25, 50, Color.WHITE));

    Button show = new Button("Show");
    popup.show(primaryStage);  */
    
    
    /*
      show.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        popup.show(primaryStage);
      }*/
                       
                        
                                         /*     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("mabrouk");
        alert.setHeaderText("You can't log in");
        alert.setContentText("The Username or password you’ve entered doesn’t match any account ");
        alert.showAndWait();*/
                        
			fadeTransition.setFromValue(0.9f);
			fadeTransition.setToValue(1f);
			fadeTransition.playFromStart();
                        
                        
                        
                 root.getChildren().remove(arrowText);
			
			// If it was the last timeline in the chain
			// highlight the name of the winner
                        
                        
                        
			//winnerName.setId(ok);
                      System.out.println("2 ");
                        System.out.println(winnerName);
                
                        /*******************/
                        /**************
			winnerName.setTranslateY(0);
			winnerName.setY(5);
                        
               /*
                        
                        
                        
                        */        
                       
		}
	}
        /*  Alert alert = new Alert (Alert.AlertType.WARNING);
          alert.setTitle("alert code promo vode");
          alert.setHeaderText(null);
          alert.setContentText("Veuillez remplir tous les champs ! ");
          alert.showAndWait();*/

	/**
	 * Move the names from one position to the next position.
	 * 
	 * @param duration How long does the move take.
	 */
	private void moveNames(final KeyFrame duration) {
		for (Text name : names) {
			Point nextPoint = getNextPoint((Integer) name.getUserData());
			TranslateTransition move = TranslateTransitionBuilder.create()
					.node(name)
					.fromX(name.translateXProperty().doubleValue())
					.fromY(name.translateYProperty().doubleValue())
					.toX(nextPoint.x)
					.toY(nextPoint.y)
					.duration(duration.getTime())
					.build();
	
			formatText(name, nextPoint);
	
			ParallelTransition parallelTransition = new ParallelTransition();
			if (nextPoint.position==0) {
				// Make the text invisible
				FadeTransition fadeTransition = new FadeTransition(duration.getTime(), name);
				fadeTransition.setFromValue(1.0f);
				fadeTransition.setToValue(0.3f);
				parallelTransition.getChildren().add(fadeTransition);
			} else if(nextPoint.position==1) {
				// Show the name at the arrow 
				arrowText.setText(name.getText());
				
				// Make the text visible
				FadeTransition fadeTransition = new FadeTransition(duration.getTime(), name);
				fadeTransition.setFromValue(0.3f);
				fadeTransition.setToValue(1f);
				parallelTransition.getChildren().add(fadeTransition);
			}
	
			parallelTransition.getChildren().add(move);
			parallelTransition.playFromStart();
	
			name.setUserData(((Integer) name.getUserData()) + 1);
	
			if (((Integer) name.getUserData()) > points.size() - 1) {
				name.setUserData(0);
			}
		}
	}

	/**
	 * Determine the next point. Used to prevent
	 * an ArrayOutOfBoundsException.
	 * @param positionRect Actual position
	 * @return next position
	 */
	private Point getNextPoint(int positionRect) {
		return positionRect + 1 >= points.size() ? points.get(0) : points.get(positionRect + 1);
	}

	/**
	 * Format the <code>Text</code> name depending of the
	 * angle stored in the point.
	 * 
	 * @param name The name which is formatted.
	 * @param point The point with the angle.
	 */
	private void formatText(Text name, Point point) {
		Font font;
		if (point.angle == 0) {
			font = Font.font("Verdana", FontWeight.BOLD, FONT_SIZE * 1.8);
			name.setFill(Color.RED);
			winnerName = name;
                       // winnerName=brassomekaaa;
                        
                        	//winnerName = ok;
                       // System.out.println("bravooooooooooooooooooooooo");
		} 
                else if (point.angle > 349 || point.angle < 11) {
			font = Font.font("Verdana", FontWeight.BOLD, FONT_SIZE * 1.6);
			name.setFill(Color.ORANGERED);
		} else if (point.angle > 327 || point.angle < 22) {
			font = Font.font("Verdana", FontWeight.BOLD, FONT_SIZE * 1.5);
			name.setFill(Color.ORANGERED);
		} else if (point.angle > 305 || point.angle < 45) {
			font = Font.font("Verdana", FontWeight.BOLD, FONT_SIZE * 1.4);
			name.setFill(Color.ORANGE);
		} else if (point.angle > 292 || point.angle < 67) {
			font = Font.font("Verdana", FontWeight.BOLD, FONT_SIZE * 1.3);
			name.setFill(Color.YELLOW);
		} else if (point.angle > 270 || point.angle < 90) {
			font = Font.font("Verdana", FontWeight.BOLD, FONT_SIZE * 1.2);
			name.setFill(Color.YELLOW);
		} else if (point.angle > 247 || point.angle < 112) {
			font = Font.font("Verdana", FontWeight.BOLD, FONT_SIZE * 1.1);
			name.setFill(Color.YELLOW);
		} else if (point.angle > 225 || point.angle < 135) {
			font = Font.font("Verdana", FontWeight.BOLD, FONT_SIZE * 1);
			name.setFill(Color.YELLOWGREEN);
		} else if (point.angle > 202 || point.angle < 157) {
			font = Font.font("Verdana", FontWeight.BOLD, FONT_SIZE * 0.9);
			name.setFill(Color.YELLOWGREEN);
		} else {
			font = Font.font("Verdana", FontWeight.BOLD, FONT_SIZE * 0.8);
			name.setFill(Color.YELLOWGREEN);
		}
		name.setFont(font);
		return;
	}

	/**
	 * Load the names from a simple text file.
	 * 
	 * @param pathToFileWithNameList Path to the file.
	 * 
	 * @return An ArrayList with Text objects.
	 */
	private List<Text> loadNames(File pathToFileWithNameList) {
		TextBuilder<?> textBuilder = TextBuilder.create().x(0).y(0);

		List<Text> nameList = new ArrayList<Text>();
		try {
			@SuppressWarnings("resource")
			BufferedReader in = new BufferedReader(new FileReader(pathToFileWithNameList));
			String line = "";
			while ((line = in.readLine()) != null) {
				nameList.add(textBuilder.text(line).build());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nameList;
	}

	/**
	 * 
	 * A simple data structure to hold
	 * the coordinates of the name and its
	 * position an angle.
	 * 
	 * @author hameister
	 *
	 */
	class Point {
		double x;
		double y;
		int position;
		double angle;

		public String toString() {
			return position + " " + x + " " + y + " " + angle;
		}
	}

	/**
	 * Calculate all points around the center.
	 * 
	 * @param points Number of points
	 * @param centerX The center coordinate X.
	 * @param centerY The center coordinate Y.
	 * @param radius The radius (orbit) in pixel around the center.
	 * @return A List with Points.
	 */
	private List<Point> calculatePoints(int points, double centerX, double centerY, double radius) {
		List<Point> pointList = new ArrayList<>();

		double rotateAngleDegree = 360d / (double) names.size();

		double startAngleDegree = 270;
		for (int rotationStep = 0; rotationStep < points; rotationStep++) {
			double degreeStart = rotationStep * rotateAngleDegree;
			
			double angleAlpha = (degreeStart + startAngleDegree) * ((Math.PI) / 180);
			Point p = new Point();
			p.x = CENTER_X + ORBIT * Math.sin(angleAlpha);
			p.y = CENTER_Y - ORBIT * Math.cos(angleAlpha);
			p.position = rotationStep;
			p.angle = degreeStart;
			pointList.add(p);
		}

		return pointList;
	}

	public static void main(String[] args) {
		launch(args);
	}
}

