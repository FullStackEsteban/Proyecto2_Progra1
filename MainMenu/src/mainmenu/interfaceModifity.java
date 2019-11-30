/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.io.File;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

/**
 *
 * @author Esteban
 */
public class interfaceModifity {
    
    LogicCountries lC = new LogicCountries();
    Label lB_Error = new Label("");
    int controlaBandera = 0;
    Country pais1 = null;
    TextArea tA_Description = new TextArea();
    TextField tF_Capital = new TextField();
    TextField tF_Idiom = new TextField();
    TextField tF_Population = new TextField();
    ComboBox cB_continent = new ComboBox();
    
    public GridPane setInterfaceModify(){
        
        GridPane gP_interfaceModify = new GridPane();
        gP_interfaceModify.setPadding(new Insets(15, 15, 15, 15));
        gP_interfaceModify.setVgap(15);
        gP_interfaceModify.setHgap(10);
        
        Label lB_Title = new Label("Modificar país");
        lB_Title.setFont(new Font("Broadway", 20));
        lB_Title.setTextFill(Color.BLUE);
        gP_interfaceModify.add(lB_Title, 0, 0);
        
        ComboBox cB_Pais = new ComboBox();
        for(int i=0; i<lC.readRegistersFile().length; i++){
            String carneAsada = lC.readRegistersFile()[i].getNameCountry();
            cB_Pais.getItems().addAll(carneAsada);
//            lC.deleteFile(carneAsada);
            
        }
        cB_Pais.setValue("Seleccione el pais");
        gP_interfaceModify.add(cB_Pais, 0, 1);
        
//        cB_Pais.setOnAction((event)->{
//            
////            for(int i=0; i<lC.readRegistersFile().length; i++){
////            String oneCountry = lC.readRegistersFile()[i].getNameCountry();
//            String oneCountry = cB_Pais.getValue().toString();
//            lC.deleteFile("paises.txt",oneCountry);
////            }
//        });
        
        Button bTN_Ok = new Button("Aceptar");
        bTN_Ok.setOnAction((event)->{
            
            String name = cB_Pais.getValue().toString();
            
            ArrayList<Country> paises = new ArrayList();
        
        Country tempCountries[] = lC.readRegistersFile();
        
        for (int i = 0; i < tempCountries.length; i++) {
            paises.add(tempCountries[i]);
        }
        
        
        
        for (Country pais : paises){
            
            if (pais.getNameCountry().equals(name)) {
                pais1 = pais;
            }//end if
        
        }//end for each
        
        cB_continent.setValue(pais1.getContinent());
        tA_Description.setText(pais1.getDescription());
        tF_Capital.setText(pais1.getCapital());
        tF_Idiom.setText(pais1.getIdiom());
        tF_Population.setText(pais1.getPopulation());
        
            
        });
        gP_interfaceModify.add(bTN_Ok, 1, 1);
        
        Label lB_Capital = new Label("Cambiar capital");
        gP_interfaceModify.add(lB_Capital, 0, 3);
        lB_Capital.setFont(new Font("Broadway", 20));
        lB_Capital.setTextFill(Color.YELLOW);
        lB_Capital.setStyle("-fx-background-color: #7faaff");
        
        gP_interfaceModify.add(tF_Capital, 1, 3);
        
        Label lB_Idiom = new Label("Cambiar Idioma");
        gP_interfaceModify.add(lB_Idiom, 0, 4);
        lB_Idiom.setFont(new Font("Broadway", 20));
        lB_Idiom.setTextFill(Color.YELLOW);
        lB_Idiom.setStyle("-fx-background-color: #7faaff");
        
        gP_interfaceModify.add(tF_Idiom, 1, 4);
        
        Label lB_Population = new Label("Cambiar población");
        gP_interfaceModify.add(lB_Population, 0, 5);
        lB_Population.setFont(new Font("Broadway", 20));
        lB_Population.setTextFill(Color.YELLOW);
        lB_Population.setStyle("-fx-background-color: #7faaff");
        
        gP_interfaceModify.add(tF_Population, 1, 5);
        
        cB_continent.setValue("Seleccione el continente");
        cB_continent.getItems().addAll("Africa", "America", "Asia", "Europa", "Oceania");
        gP_interfaceModify.add(cB_continent, 1, 6);
        
        Label lB_Description = new Label("Cambiar descripción");
        gP_interfaceModify.add(lB_Description, 0, 7);
        lB_Description.setFont(new Font("Broadway", 20));
        lB_Description.setTextFill(Color.YELLOW);
        lB_Description.setStyle("-fx-background-color: #7faaff");
        
        
        gP_interfaceModify.add(tA_Description, 1, 7);
        
        Button bTN_Save = new Button("Guardar cambios");
        gP_interfaceModify.add(bTN_Save, 1, 8);
        bTN_Save.setOnAction((event)->{
            
            String nameIs = cB_Pais.getValue().toString();
            
            ArrayList<Country> paises = new ArrayList();
        
        Country tempCountries[] = lC.readRegistersFile();
        
        for (int i = 0; i < tempCountries.length; i++) {
            paises.add(tempCountries[i]);
            
        }
        
        for (Country country : paises){
            if (country.getNameCountry().equals(nameIs)) {
                
                country.setCapital(tF_Capital.getText());
                country.setIdiom(tF_Idiom.getText());
                country.setPopulation(tF_Population.getText());
                country.setDescription(tA_Description.getText());
                country.setContinent(cB_continent.getValue().toString());
                
            }
        }
        
        lC.removeFile();
        
        for(Country country : paises){
            lC.insertCountry(country);
        }
            
            String cap = tF_Capital.getText();
            String idiom = tF_Idiom.getText();
            String population = tF_Population.getText();
            String continent = cB_continent.getValue().toString();
            String description = tA_Description.getText();
            
               if(continent.equals("Seleccione el continente")){
                lB_Error.setText("Debe ingresar al menos el país, el continente y su bandera.");
                lB_Error.setVisible(true);
                lB_Error.setTextFill(Color.RED);
                
                lB_Error.setStyle("-fx-background-color: #7faaff");
              
              }//End if
               else{
                   controlaBandera=0;
//                   Country c = new Country (cap, idiom, population, continent, description);
            
//            lC.insertCountry(c);
            lB_Error.setText("");
            
               
               }
            
            if(cap.equals("")||idiom.equals("")||population.equals("")||description.equals("")){
                cap="-";
                idiom="-";
                population="-";
                description="-";
            }//end if
            
//            lB_img.setGraphic(null);
//            tF_Name.clear();
            tF_Capital.clear();
            tF_Idiom.clear();
            tF_Population.clear();
            tA_Description.clear();
            
        });
        
        Button bTN_Exit = new Button("Salir");
        bTN_Exit.setOnAction((event)->{
            gP_interfaceModify.getChildren().clear();
        });
        gP_interfaceModify.add(bTN_Exit, 2, 9);
        
        
        return gP_interfaceModify;
    }
}
