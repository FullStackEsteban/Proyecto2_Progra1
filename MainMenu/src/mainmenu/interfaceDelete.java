/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author Esteban
 */
public class interfaceDelete {
    
    LogicCountries lC = new LogicCountries();
    
    public GridPane setInterfaceDelete(){
        
        GridPane gP_interfaceDelete = new GridPane();
        gP_interfaceDelete.setPadding(new Insets(15, 15, 15, 15));
        gP_interfaceDelete.setVgap(15);
        gP_interfaceDelete.setHgap(10);
        
        Label lB_Title = new Label("Eliminar país");
        lB_Title.setFont(new Font("Broadway", 20));
        lB_Title.setTextFill(Color.BLUE);
        gP_interfaceDelete.add(lB_Title, 0, 0);
        
        ComboBox cB_Pais = new ComboBox();
        for(int i=0; i<lC.readRegistersFile().length; i++){
            String carneAsada = lC.readRegistersFile()[i].getNameCountry();
            cB_Pais.getItems().addAll(carneAsada);
        }
        cB_Pais.setValue("Seleccione el pais");
        gP_interfaceDelete.add(cB_Pais, 0, 1);
        
        Button bTN_Search = new Button("BORRAR");
        bTN_Search.setOnAction((event)->{
            
            String nameIs = cB_Pais.getValue().toString();
            JOptionPane.showMessageDialog(null, nameIs);
            ArrayList<Country> paises = new ArrayList();
        
        Country tempCountries[] = lC.readRegistersFile();
        
        for (int i = 0; i < tempCountries.length; i++) {
            paises.add(tempCountries[i]);
        }
        
        for (int i = 0; i<paises.size();i++){
            if (paises.get(i).getNameCountry().equals(nameIs)) {
               // paises.remove(paises.get(i));
                paises.remove(i);
            }
        }
            
//            for(Country c : paises){
//                if(c.getNameCountry().equals(nameIs)){
//                     JOptionPane.showMessageDialog(null, "entre");
//                    paises.remove(c);
//                }
//            }
              System.out.println(" antes de YA LO ELIMINE");
            lC.removeFile();
            System.out.println("YA LO ELIMINE");
            
            cB_Pais.getItems().clear();
            
            for(Country c : paises){
                 JOptionPane.showMessageDialog(null, "Insertando");
                lC.insertCountry(c);
                String carneAsada = c.getNameCountry();
            cB_Pais.getItems().addAll(carneAsada);
            }
        
            
        });
        gP_interfaceDelete.add(bTN_Search, 1, 1);
        
        Button bTN_Exit = new Button("Salir");
        bTN_Exit.setOnAction((event)->{
            gP_interfaceDelete.getChildren().clear();
        });
        gP_interfaceDelete.add(bTN_Exit, 1, 3);
        
        return gP_interfaceDelete;
        
    }
    
}
