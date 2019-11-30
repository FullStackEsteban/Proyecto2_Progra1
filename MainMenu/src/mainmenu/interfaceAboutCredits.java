/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import javafx.scene.control.TextArea;
import javafx.scene.layout.*;

/**
 *
 * @author Esteban M
 */
public class interfaceAboutCredits {
    
    public VBox getInterfaceAbout(){
        
        VBox vB_About = new VBox();
        
        TextArea tA_About = new TextArea();
        tA_About.setEditable(false);
        tA_About.setText("App Países del mundo \nDesarrollado en Netbeans 9.0 \nLeguaje de programación Java");
        
        vB_About.getChildren().addAll(tA_About);
        
        return vB_About;
    }
    
    public VBox getInterfaceCredits(){
        
        VBox vB_Credits = new VBox();
        
        TextArea tA_Credits = new TextArea();
        tA_Credits.setEditable(false);
        tA_Credits.setText("Esteban Madriz Astorga B84545\nSaúl Machado Álvarez B94434");
        
        vB_Credits.getChildren().addAll(tA_Credits);
        
        return vB_Credits;
    }
    
}
