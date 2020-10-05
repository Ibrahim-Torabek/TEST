import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        char userInput = 'n';

        do {
            int guess = 0;

            HangMan hangMan = new HangMan();

            do{
                System.out.print("(Guess) Enter a letter in word " + String.valueOf(hangMan.getUserWord()) + " > ");
                userInput = s.nextLine().toCharArray()[0];

                guess = hangMan.checkWord(userInput);

                if (guess == -1) {
                    System.out.println(userInput + " is already in the word");
                    continue;

                } else if (guess == 0) {
                    System.out.println(userInput + " is not in the word.");
                }
            } while (hangMan.getStatus());

            System.out.println();
            System.out.println("The word is " + String.valueOf(hangMan.getSelectedWord()) + ". You missed " + hangMan.getMissed() + " times.");


            System.out.print("Do you want to guess another word? Enter y to play again > ");
            userInput = s.nextLine().toCharArray()[0];

        } while (userInput == 'y');

        s.close();

        //Application.launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
