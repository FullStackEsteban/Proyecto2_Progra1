/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

//import java.util.Observable;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo
 */
public class interfaceReports {
    
    LogicCountries lC = new LogicCountries();
    Country country1 = new Country();
    ImageView ivImage = new ImageView();
    ArrayList<Country> paises = new ArrayList();
    
    public VBox getInterfaceReports(){
        
        VBox vB_interfaceReports = new VBox();
        
        Label lB_report = new Label("Información del país");
        lB_report.setFont(new Font("Broadway", 20));
        lB_report.setTextFill(Color.BLUE);
        
        ivImage.setFitHeight(100);
        ivImage.setFitWidth(100);
         ivImage.setImage(null);
        
        ComboBox cB_continent = new ComboBox();
        for(int i=0; i<lC.readRegistersFile().length; i++){
            String carneAsada = lC.readRegistersFile()[i].getNameCountry();
            cB_continent.getItems().addAll(carneAsada);
        }
        cB_continent.setValue("Seleccione el pais");
        
       // Country country1 = new Country();
       TableView<Country> tV_Countries = new TableView<>();
        
        Country tempCountries[] = lC.readRegistersFile();
        
        for (int i = 0; i < tempCountries.length; i++) {
            paises.add(tempCountries[i]);
        }
        
        if (paises.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La app esta vacia boludo");
        }
       
        Button bTN_Search = new Button("Buscar");
        bTN_Search.setOnAction((event)->{
            
            tV_Countries.getItems().clear();
            String name = cB_continent.getValue().toString();
            
            
        
       
        
        for (Country c : paises){
            
            if (c.getNameCountry().equals(name)){
                country1 = c;
            }
            
        }
        tV_Countries.getItems().add(country1);
        
        Image image = new Image("file:"+ country1.getFlag());
        ivImage.setImage(image);
            
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
                
//        ObservableList<Country> oL_dataCountries = FXCollections.observableArrayList(new Country("Costa Rica","America"),
//                                                                                     new Country("España","Europa"),
//                                                                                     new Country("China","Asia"));
//        tV_Countries.getItems().add(country1);
        
        tV_Countries.getColumns().addAll(tC_NameCountry, tC_Capital, tC_Idiom, tC_Population, tC_Continent, tC_Description);
        
        
        
        
        
        Button bTN_Exit = new Button("Salir");
        bTN_Exit.setOnAction((event)->{
            vB_interfaceReports.getChildren().clear();
        });
        
        vB_interfaceReports.getChildren().addAll(lB_report, cB_continent, bTN_Search, tV_Countries, bTN_Exit, ivImage);
        
    return vB_interfaceReports;
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
    
    public VBox getInterfaceByContinent(){
        
        VBox vB_interfaceByContinent = new VBox();
        
        Label lB_report = new Label("Busqueda por continente");
        lB_report.setFont(new Font("Broadway", 20));
        lB_report.setTextFill(Color.BLUE);
        
        ComboBox cB_continent = new ComboBox();
        cB_continent.getItems().addAll("Africa", "America", "Asia", "Europa", "Oceania");
        cB_continent.setValue("Seleccione el continente");
        
        //ArrayList paises = new ArrayList();
        TableView<Country> tV_Countries = new TableView<>();
        
        //Crear la columna pais
        TableColumn tC_NameCountry = new TableColumn("Países");
        tC_NameCountry.setCellValueFactory(new PropertyValueFactory("nameCountry"));
        
        Button bTN_Search = new Button("Buscar");
        bTN_Search.setOnAction((event)->{
            paises.clear();
            tV_Countries.getItems().clear();
            
            String continent = cB_continent.getValue().toString();
//            JOptionPane.showMessageDialog(null, continent);
        Country tempCountries[] = lC.readRegistersFile();
        
        for (int i = 0; i < tempCountries.length; i++) {
            if(tempCountries[i].getContinent().equals(continent)){
             paises.add(tempCountries[i]);
//             JOptionPane.showMessageDialog(null, tempCountries[i].getNameCountry()+" "+ tempCountries[i].getContinent());
            }
           
        }
        
        
        tV_Countries.getItems().clear();
        for(Country c: paises){
        tV_Countries.getItems().add(c);
        }
        
            
        });
        
        tV_Countries.getColumns().addAll(tC_NameCountry);
        
        Button bTN_Exit = new Button("Salir");
        bTN_Exit.setOnAction((event)->{
            vB_interfaceByContinent.getChildren().clear();
        });
        
        vB_interfaceByContinent.getChildren().addAll(lB_report, cB_continent, bTN_Search, tV_Countries, bTN_Exit);
        
        return vB_interfaceByContinent;
    }
    
    public VBox getInterfaceMostPopular(){
        
        VBox vB_interfaceMostPopular = new VBox();
        int buscados = 0;
        
        Label lB_report = new Label("Más buscados");
        lB_report.setFont(new Font("Broadway", 20));
        lB_report.setTextFill(Color.BLUE);
        
        TableView tV_Countries = new TableView<>();
        
        //Crear la columna pais
        TableColumn<String, Country> tC_NameCountry = new TableColumn<>("País");
        tC_NameCountry.setCellValueFactory(new PropertyValueFactory<>("nameCountry"));
        
        TableColumn<String, Country> tC_Capital = new TableColumn<>("Capital");
        tC_Capital.setCellValueFactory(new PropertyValueFactory<>("capital"));
        
        TableColumn<String, Country> tC_Idiom = new TableColumn<>("Idioma");
        tC_Idiom.setCellValueFactory(new PropertyValueFactory<>("idiom"));
        
        TableColumn<String, Country> tC_Population = new TableColumn<>("Poblacion");
        tC_Population.setCellValueFactory(new PropertyValueFactory<>("population"));
        
        //Crear la columna continente
        TableColumn<String, Country> tC_Continent = new TableColumn<>("Continente");
        tC_Continent.setCellValueFactory(new PropertyValueFactory<>("continent"));//tiene que ser le mismo nombre que esta en el constructor
        
        TableColumn<String, Country> tC_Description = new TableColumn<>("Descripcion");
        tC_Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        TableColumn<String, Country> tC_Search = new TableColumn<>("Busquedas");
        tC_Search.setCellValueFactory(new PropertyValueFactory<>("search"));
        
        tV_Countries.getColumns().addAll(tC_NameCountry, tC_Capital, tC_Idiom, tC_Population, tC_Continent, tC_Description, tC_Search);
        
        ArrayList <Country> paises = new ArrayList();
        
        Country tempCountries[] = lC.readRegistersFile();
        
        for (int i = 0; i < tempCountries.length; i++) {
            paises.add(tempCountries[i]);
        }
        
        for (Country c : paises) {
            if (c.getSearch()>buscados) {
                buscados = c.getSearch();
            }
        }
        JOptionPane.showMessageDialog(null, buscados);
        
        ArrayList <Country> masBuscado = new ArrayList();
        
        
        
        for(Country c : paises){
        if(c.getSearch() == buscados){
        masBuscado.add(c);
        }
        }
        
        for(Country c : masBuscado){
            tV_Countries.getItems().add(c);
        }
        
        Button bTN_Exit = new Button("Salir");
        bTN_Exit.setOnAction((event)->{
            vB_interfaceMostPopular.getChildren().clear();
        });
        
        vB_interfaceMostPopular.getChildren().addAll(lB_report, tV_Countries, bTN_Exit);
        
        return vB_interfaceMostPopular;
    }
    
}
