/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.io.File;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Esteban M
 */
public class interfaceMenu {
    
    interfaceAboutCredits iA = new interfaceAboutCredits();
    interfaceCountry iC = new interfaceCountry();
    interfaceReports iR = new interfaceReports();
    interfaceModifity iM = new interfaceModifity();
    interfaceDelete iD = new interfaceDelete();
    interfaceSearch iS = new interfaceSearch();
    File FileCountries = new File("paises.txt");
    
    public VBox getVBox(){
    
    VBox vB_Main = new VBox();
    vB_Main.setStyle("-fx-background-image: url(world.png);"
                    +"-fx-background-position: left top, center;"
//                    +"-fx-background-repeat: no repeat;");
                    +"-fx-background-size: cover, auto;");
    
    VBox vB_Windows = new VBox();
    
    //Barra Menu
    MenuBar mB_Menu = new MenuBar();
    
    //Menu Sistema
    
    Menu m_System = new Menu("Sistema");
    
    //Agregar las opciones de submenus
    
    MenuItem mI_About = new MenuItem("Acerca de"); 
    mI_About.setAccelerator(KeyCombination.keyCombination("Alt+A"));
    mI_About.setOnAction((event)->{
//        JOptionPane.showMessageDialog(null, "Acerca de");
          vB_Windows.getChildren().clear();
          vB_Windows.getChildren().addAll(iA.getInterfaceAbout());

    });
    
    MenuItem mI_Credits = new MenuItem("Creditos");
    mI_Credits.setAccelerator(KeyCombination.keyCombination("Ctrl+c"));
    mI_Credits.setOnAction((event)->{
 
          vB_Windows.getChildren().clear();
          vB_Windows.getChildren().addAll(iA.getInterfaceCredits());

    });
    
    MenuItem mI_Exit = new MenuItem("Salir");
    mI_Exit.setOnAction((event)->Platform.exit());
    
    m_System.getItems().addAll(mI_About, mI_Credits, mI_Exit);
    
    //PAISES
    Menu m_Countries = new Menu("Paises");
    
    MenuItem mI_InsertCountry = new MenuItem("Agregar", new ImageView(new Image("insert.png")));
    mI_InsertCountry.setAccelerator(KeyCombination.keyCombination("Ctrl+a"));
    mI_InsertCountry.setOnAction((event)->{
        vB_Windows.getChildren().clear();
        vB_Windows.getChildren().addAll(iC.setInterfaceCountry());
        
    });
    
    MenuItem mI_Remove = new MenuItem("Eliminar", new ImageView(new Image("delete.png"))); 
    mI_Remove.setAccelerator(KeyCombination.keyCombination("Ctrl+e"));
    mI_Remove.setOnAction((event)->{
        vB_Windows.getChildren().clear();
        vB_Windows.getChildren().addAll(iD.setInterfaceDelete());
        });
    
    MenuItem mI_Modify = new MenuItem("Modificar", new ImageView(new Image("edit.png"))); 
    mI_Modify.setAccelerator(KeyCombination.keyCombination("Ctrl+m"));
    mI_Modify.setOnAction((event)->{
        vB_Windows.getChildren().clear();
        vB_Windows.getChildren().addAll(iM.setInterfaceModify());
        });
    
    MenuItem mI_Search = new MenuItem("Buscar", new ImageView(new Image("search.png"))); 
    mI_Search.setAccelerator(KeyCombination.keyCombination("Ctrl+s"));
    mI_Search.setOnAction((event)->{
        vB_Windows.getChildren().clear();
        vB_Windows.getChildren().addAll(iS.setInterfaceSearch());
        });
    
    m_Countries.getItems().addAll(mI_InsertCountry, mI_Remove, mI_Modify, mI_Search);
    
    //Mantenimiento
    Menu m_Maintenance = new Menu("Mantenimiento");
    
    MenuItem mI_Empty = new MenuItem("Vaciar aplicacion", new ImageView(new Image("empty.png"))); 
    mI_Empty.setOnAction((event)->{
    vB_Windows.getChildren().clear();
     
    String confirm = JOptionPane.showInputDialog("Ingrese Si para confirmar");
     if (confirm.equalsIgnoreCase("Si")|| confirm.equalsIgnoreCase("Sí")){
        FileCountries.delete();
     }
    });
    
    m_Maintenance.getItems().addAll(mI_Empty);
    
    //Reportes
    Menu m_ReportCountries = new Menu("Reportes");
    
    Menu m_report = new Menu("", new ImageView(new Image("report.png")));
    
    m_ReportCountries.getItems().addAll(m_report);
    
    MenuItem mI_ReportCountry = new MenuItem("Ver país");
    mI_ReportCountry.setOnAction((event)->{
        
        vB_Windows.getChildren().clear();
        vB_Windows.getChildren().addAll(iR.getInterfaceReports());
        
    });
    
    MenuItem mI_ContriesPerContinent = new MenuItem("Países por continente");
    mI_ContriesPerContinent.setOnAction((event)->{
        
        vB_Windows.getChildren().clear();
        vB_Windows.getChildren().addAll(iR.getInterfaceByContinent());
        
    });
    
    MenuItem mI_Popular = new MenuItem("País más buscado");
    mI_Popular.setOnAction((event)->{
        
        vB_Windows.getChildren().clear();
        vB_Windows.getChildren().addAll(iR.getInterfaceMostPopular());
        
    });
    
    m_report.getItems().addAll(mI_ReportCountry, mI_ContriesPerContinent, mI_Popular);
     
    // FIN
    mB_Menu.getMenus().addAll(m_System, m_Countries, m_ReportCountries, m_Maintenance);
    
    vB_Main.getChildren().addAll(mB_Menu, vB_Windows);
    
    return vB_Main;
    
    }//end getVBox
    
}
