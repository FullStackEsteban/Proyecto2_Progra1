/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.util.Arrays;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Esteban M
 */
public class MainMenu extends Application{
    
//    private Stage primaryStage = null;
//    private boolean estaFull = false;
    @Override
    public void start(Stage primaryStage) {
 
        //instacia de clase
        interfaceMenu iM = new interfaceMenu();
        
        Scene scene = new Scene(iM.getVBox(), 1363, 710);
        
        primaryStage.getIcons().add(new Image("diccionary.png"));
        primaryStage.setTitle("Diccionario de Países del Mundo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
       LogicCountries lC = new LogicCountries();
       lC.paisesAlfabetico();
        System.out.println("Lo elimino para alfabetizar mae");
//        System.out.println(Arrays.toString(lC.readRegistersFile()));
//        Country temp[] = lC.readRegistersFile();
//        System.out.println(temp[0].getNameCountry());
//        System.out.println(temp[0].getContinent());
        launch(args);
    }
    
}
