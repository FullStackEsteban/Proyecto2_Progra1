/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Esteban
 */
public class interfaceSearch {
    
    LogicCountries lC = new LogicCountries();
    Country country1 = new Country();
    ImageView ivImage = new ImageView();
    ArrayList<Country> paises = new ArrayList();
    
    public GridPane setInterfaceSearch(){
        
        GridPane gP_interfaceSearch = new GridPane();
        gP_interfaceSearch.setPadding(new Insets(15, 15, 15, 15));
        gP_interfaceSearch.setVgap(15);
        gP_interfaceSearch.setHgap(10);
        
        Label lB_Title = new Label("Buscar país");
        lB_Title.setFont(new Font("Broadway", 20));
        lB_Title.setTextFill(Color.BLUE);
        gP_interfaceSearch.add(lB_Title, 0, 0);
        
        ComboBox cB_pais = new ComboBox();
        for(int i=0; i<lC.readRegistersFile().length; i++){
            String carneAsada = lC.readRegistersFile()[i].getNameCountry();
            cB_pais.getItems().addAll(carneAsada);
        }
        gP_interfaceSearch.add(cB_pais, 0, 1);
        cB_pais.setValue("¿Qué país desea buscar?");
        
        
        Button bTN_Exit = new Button("Salir");
        bTN_Exit.setOnAction((event)->{
            gP_interfaceSearch.getChildren().clear();
        });
        
        gP_interfaceSearch.add(bTN_Exit, 1, 2);
        
        TableView<Country> tV_Countries = new TableView<>();
        
        Button bTN_Search = new Button("Buscar");
        gP_interfaceSearch.add(bTN_Search, 0, 2);
        bTN_Search.setOnAction((event)->{
            
            tV_Countries.getItems().clear();
            String name = cB_pais.getValue().toString();
            
            ArrayList<Country> paises = new ArrayList();
            Country tempCountries[] = lC.readRegistersFile();
            
            for (int i = 0; i < tempCountries.length; i++) {
            paises.add(tempCountries[i]);
        }
            
            for (int i = 0; i<paises.size();i++){
            if (paises.get(i).getNameCountry().equals(name)) {
                paises.get(i).setSearch(paises.get(i).getSearch()+1);
            }
            }
            
            lC.removeFile();
            
            for(Country c: paises){
            lC.insertCountry(c);
            }
            
        for (Country c : paises){
            
            if (c.getNameCountry().equals(name)){
                country1 = c;
            }
            
        }
        tV_Countries.getItems().add(country1);
        
        Image image = new Image("file:"+ country1.getFlag());
        ivImage.setImage(image);
        gP_interfaceSearch.add(ivImage, 0, 4);
            
        });
        
        //Crear la columna pais
        TableColumn tC_NameCountry = new TableColumn("País");
        tC_NameCountry.setCellValueFactory(new PropertyValueFactory("nameCountry"));//tiene que ser le mismo nombre que esta en el constructor       
        
        TableColumn tC_Capital = new TableColumn("Capital");
        tC_Capital.setCellValueFactory(new PropertyValueFactory("capital"));
        
        TableColumn tC_Idiom = new TableColumn("Idioma");
        tC_Idiom.setCellValueFactory(new PropertyValueFactory("idiom"));
        
        TableColumn tC_Population = new TableColumn("Poblacion");
        tC_Population.setCellValueFactory(new PropertyValueFactory("population"));
        
        //Crear la columna continente
        TableColumn tC_Continent = new TableColumn("Continente");
        tC_Continent.setCellValueFactory(new PropertyValueFactory("continent"));//tiene que ser le mismo nombre que esta en el constructor
        
        TableColumn tC_Description = new TableColumn("Descripcion");
        tC_Description.setCellValueFactory(new PropertyValueFactory("description"));
        
        tV_Countries.getColumns().addAll(tC_NameCountry, tC_Capital, tC_Idiom, tC_Population, tC_Continent, tC_Description);
        gP_interfaceSearch.add(tV_Countries, 0, 3);
        
        return gP_interfaceSearch;
        
    }
    
    
    
    public ObservableList<Country> getListCountries(){//tableview recibe un observable list
        //añadir los paises del archivo al table
        ArrayList array = new ArrayList();
        
        Country tempCountries[] = lC.readRegistersFile();
        
//        Arrays.sort(tempCountries);
        
        for (int i = 0; i < tempCountries.length; i++) {
            array.add(tempCountries[i]);
        }
    
        ObservableList<Country> oL_dataCountries = FXCollections.observableArrayList(paises);
        
        return oL_dataCountries;
    }
}
