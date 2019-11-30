/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.io.File;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo
 */
public class interfaceCountry {
    
    LogicCountries lC = new LogicCountries();
    Label lB_Error = new Label("");
    int controlaBandera = 0;
    String url = "";
//    File imgFile = null;
    
    public GridPane setInterfaceCountry(){
        
        GridPane gP_interfaceCountry = new GridPane();
        gP_interfaceCountry.setPadding(new Insets(15, 15, 15, 15));
        gP_interfaceCountry.setVgap(15);
        gP_interfaceCountry.setHgap(10);
        
        Label lB_Name = new Label("Nombre del país");
        gP_interfaceCountry.add(lB_Name, 0, 0);
        lB_Name.setFont(new Font("Broadway", 20));
        lB_Name.setTextFill(Color.YELLOW);
        lB_Name.setStyle("-fx-background-color: #7faaff");
        
//        lB_Name.setBackground(Background.EMPTY);
        
        TextField tF_Name = new TextField();
        gP_interfaceCountry.add(tF_Name, 1, 0);
        
        Label lB_Capital = new Label("Capital del país");
        gP_interfaceCountry.add(lB_Capital, 0, 1);
        lB_Capital.setFont(new Font("Broadway", 20));
        lB_Capital.setTextFill(Color.YELLOW);
        lB_Capital.setStyle("-fx-background-color: #7faaff");
        
        TextField tF_Capital = new TextField();
        gP_interfaceCountry.add(tF_Capital, 1, 1);
        
        Label lB_Idiom = new Label("Idioma más común");
        gP_interfaceCountry.add(lB_Idiom, 0, 2);
        lB_Idiom.setFont(new Font("Broadway", 20));
        lB_Idiom.setTextFill(Color.YELLOW);
        lB_Idiom.setStyle("-fx-background-color: #7faaff");
        
        TextField tF_Idiom = new TextField();
        gP_interfaceCountry.add(tF_Idiom, 1, 2);
        
        Label lB_Population = new Label("Población");
        gP_interfaceCountry.add(lB_Population, 0, 3);
        lB_Population.setFont(new Font("Broadway", 20));
        lB_Population.setTextFill(Color.YELLOW);
        lB_Population.setStyle("-fx-background-color: #7faaff");
        
        TextField tF_Population = new TextField();
        gP_interfaceCountry.add(tF_Population, 1, 3);
       
        ComboBox cB_continent = new ComboBox();
        cB_continent.setValue("Seleccione el continente");
        cB_continent.getItems().addAll("Africa", "America", "Asia", "Europa", "Oceania");
        gP_interfaceCountry.add(cB_continent, 1, 4);
        
        Label lB_Description = new Label("Descripción");
        gP_interfaceCountry.add(lB_Description, 0, 5);
        lB_Description.setFont(new Font("Broadway", 20));
        lB_Description.setTextFill(Color.YELLOW);
        lB_Description.setStyle("-fx-background-color: #7faaff");
        
        TextArea tA_Description = new TextArea();
        gP_interfaceCountry.add(tA_Description, 1, 5);
        
        Label lb_img = new Label();
        gP_interfaceCountry.add(lb_img, 1, 6);
        
        
        
        Button bTN_Bandera = new Button("Inserte la bandera");
        bTN_Bandera.setOnAction((event)->{
            FileChooser fc = new FileChooser();
           
           fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
           File imgFile = fc.showOpenDialog(null); 
           
           if (imgFile != null) {
            Image image = new Image("file:" + imgFile.getAbsolutePath());
            lb_img.setGraphic(new ImageView(image));
            controlaBandera = 1;
            url = imgFile.getAbsolutePath();
           }
        });
       gP_interfaceCountry.add(bTN_Bandera, 0, 6);
       
       lB_Error.setVisible(false);
        gP_interfaceCountry.add(lB_Error, 0,7);
        gP_interfaceCountry.setColumnSpan(lB_Error, 2);
       
        Button bTN_InsertCountry = new Button("Insertar país");
//        bTN_InsertCountry.setDisable(true);
        
            bTN_InsertCountry.setOnAction((event)->{
            
            String name = tF_Name.getText();
            String cap = tF_Capital.getText();
            String idiom = tF_Idiom.getText();
            String population = tF_Population.getText();
            String continent = cB_continent.getValue().toString();
            String description = tA_Description.getText();
            String flag = lb_img.getText();
            
               if(name.equals("")||continent.equals("Seleccione el continente")||controlaBandera==0){
                lB_Error.setText("Debe ingresar al menos el país, el continente y su bandera.");
                lB_Error.setVisible(true);
                lB_Error.setTextFill(Color.RED);
                
                lB_Error.setStyle("-fx-background-color: #7faaff");
              
              }//End if
               else{
                   if(cap.equals("")||idiom.equals("")||population.equals("")||description.equals("")){
                cap="-";
                idiom="-";
                population="-";
                description="-";
            }//end if
                   controlaBandera=0;
                   Country c = new Country (name, cap, idiom, population, continent, description, url, 0);
            
                   ArrayList paises = new ArrayList();
        
        Country tempCountries[] = lC.readRegistersFile();
        
        for (int i = 0; i < tempCountries.length; i++) {
            paises.add(tempCountries[i]);
        }
                
        boolean insert = lC.repetidos(paises, name);
        
        if (!insert){
            lC.insertCountry(c);
            lC.paisesAlfabetico();
        }else{
//            lB_Error.setText("No se pudo anadir porque ya esta en el archivo.");
            JOptionPane.showMessageDialog(null, "No se pudo anadir porque ya esta en el archivo.");
        }
            
            lB_Error.setText("");
            
            
            
               
               }
            
            
            
            lb_img.setGraphic(null);
            tF_Name.clear();
            tF_Capital.clear();
            tF_Idiom.clear();
            tF_Population.clear();
            tA_Description.clear();
            
        });
        
        gP_interfaceCountry.add(bTN_InsertCountry, 0, 8);
//        gP_interfaceCountry.add(lB_Error, 0,7);
        
        Button bTN_Exit = new Button("Salir");
        bTN_Exit.setOnAction((event)->{
            gP_interfaceCountry.getChildren().clear();
        });
        gP_interfaceCountry.add(bTN_Exit, 6, 8);
        
    return gP_interfaceCountry;    
    }
    
}
