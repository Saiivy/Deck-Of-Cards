package gursimar_hehar_additionalassignment;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Gursimar Singh Hehar
 * This application displays 5 decks of cards on gui, allows user to hide a deck and shuffle the cards
 */
public class Gursimar_Hehar_AdditionalAssignment extends Application {
    //All Fields
    Image cardImages = null;
    ArrayList<Image>cards;
    ImageView view=null;

    @Override
    public void start(Stage stage) {
        //Creating  a hbox with 15 padding between its elements
        HBox hbox = new HBox(15);
        
        //set padding using insets       
        hbox.setPadding(new Insets(15,15,15,15));
        
        //Creating a button to shuffle cards
        Button btnShuffle = new Button("Shuffle");
            
        //Creating arraylist to store cards
        cards = new ArrayList<>();
              
        //Looping through and adding all images to arraylist
        for (int i = 1; i < 52; i++) {
            cardImages = new Image("gursimar_hehar_additionalassignment/Cards/" + i + ".png");
             //Now lets put all the images in an arraylist
             cards.add(cardImages);
        }
      
      //Creating imageView which at First Has backside of the cards
      ImageView deck1 = new ImageView(new Image("gursimar_hehar_additionalassignment/Cards/b1fv.png"));
      ImageView deck2 = new ImageView(new Image("gursimar_hehar_additionalassignment/Cards/b1fv.png"));
      ImageView deck3 = new ImageView(new Image("gursimar_hehar_additionalassignment/Cards/b1fv.png"));
      ImageView deck4 = new ImageView(new Image("gursimar_hehar_additionalassignment/Cards/b1fv.png"));
      ImageView deck5 = new ImageView(new Image("gursimar_hehar_additionalassignment/Cards/b1fv.png"));

                 //Calling method to handle button event
                buttonEventHandler(btnShuffle, deck1, deck2, deck3, deck4, deck5);
                //We call this method to handle click on decks
                mouseClick(deck1, deck2, deck3, deck4, deck5);
      
                 //Adding all imageviews to hbox
                 hbox.getChildren().addAll(deck1,deck2,deck3,deck4,deck5);
   
                 //adding button to vbox
                 VBox vbox = new VBox();
                 vbox.getChildren().add(btnShuffle);
                 
                 //adding all nodes to vbox
                 VBox root = new VBox();
                 root.getChildren().addAll(hbox, vbox);
         
        
                 //Creating a scene
                 Scene scene = new Scene(root, 500, 500);
        
                 //Setting title of the app
                 stage.setTitle("Shuffle Cards!");
        
                 //Setting scene on stage and showin it.
                 stage.setScene(scene);
                 stage.show();
    }

    
    /**
     * 
     * @param btnShuffle
     * @param deck1
     * @param deck2
     * @param deck3
     * @param deck4
     * @param deck5 
     * This method handles events for Shuffle Button
     */
    private void buttonEventHandler(Button btnShuffle, ImageView deck1, ImageView deck2, ImageView deck3, ImageView deck4, ImageView deck5) {
        //Adding action to button
        btnShuffle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Here we set the loop to the size of arraylist
                for(int i =0; i<cards.size();i++){
                    //Shuffling the cards
                    Collections.shuffle(cards);
                    //Finally setting it to imageviews
                    deck1.setImage(cards.get(0));
                    
                    //Before adding to each deck we want to shuffle cards
                    //So that no deck shows same card as other deck
                    Collections.shuffle(cards);
                    deck2.setImage(cards.get(1));
                    
                    Collections.shuffle(cards);
                    deck3.setImage(cards.get(2));
                    
                    Collections.shuffle(cards);
                    deck4.setImage(cards.get(3));
                    
                    Collections.shuffle(cards);
                    deck5.setImage(cards.get(4));
                }
            }
        });
    }
    /**
     * 
     * @param deck1
     * @param deck2
     * @param deck3
     * @param deck4
     * @param deck5 
     * This method handles mouse click events for imageview
     */
    private void mouseClick(ImageView deck1, ImageView deck2, ImageView deck3, ImageView deck4, ImageView deck5) {
        //If the user clicked on card back of card is shown
        deck1.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (event) -> deck1.setImage(new Image("gursimar_hehar_additionalassignment/Cards/b1fv.png")));
        //Similar for all decks
        deck2.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (event) -> deck2.setImage(new Image("gursimar_hehar_additionalassignment/Cards/b1fv.png")));
        deck3.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (event) -> deck3.setImage(new Image("gursimar_hehar_additionalassignment/Cards/b1fv.png")));
        deck4.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (event) -> deck4.setImage(new Image("gursimar_hehar_additionalassignment/Cards/b1fv.png")));
        deck5.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (event) -> deck5.setImage(new Image("gursimar_hehar_additionalassignment/Cards/b1fv.png")));
    }

    /**
     * @param args the command line arguments
     * Main method to launch application
     */
    public static void main(String[] args) {
        launch(args);
    }
}
