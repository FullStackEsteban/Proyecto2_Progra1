/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.PrintStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo
 */
public class LogicCountries {//Anade palabras al archivo
    
    File FileCountries = new File("paises.txt");
    
    public  void insertCountry(Country c){
        
        File fileCountries = new File("paises.txt");
        
        try{
            FileOutputStream fos = new FileOutputStream(fileCountries, true);
            PrintStream ps = new PrintStream(fos);
            
                ps.println(c.getNameCountry()+"/"+c.getCapital()+"/"+c.getIdiom()+"/"+c.getPopulation()+"/"+c.getContinent()+"/"+c.getDescription()+"/"+c.getFlag()+"/"+c.getSearch());
            
           
            fos.close();
        }
        catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null, "Problemas con el archivo.");
        } catch (IOException ex) {
            Logger.getLogger(LogicCountries.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
    }
    
//    public void ordenar(){//Ordena alfabeticamente readRegistersFile()[1].getNameCountry()
//        
//        Country palabras [] = new Country[7];
////        String palabras  =   readRegistersFile()[1].getNameCountry();
//        
//            for (int i = 0; i < readRegistersFile().length; i++) {
//            for (int j = 0; j < palabras.length; j++) {
//
//                if (palabras[i].compareToIgnoreCase(palabras[j]) < 0) {
//                    String aux = palabras[i];
//                    palabras[i] = palabras[j];
//                    palabras[j] = aux;
//                    
//                }//End if
//            }//End j
//
//        }//End for i
//    
////           country[indexArray] = c;
////               indexArray++;
//               
//    }
    
    public boolean repetidos(ArrayList<Country> paises, String name){
        
        boolean repetido = false;
    
        for (Country c : paises){
            if(c.getNameCountry().equals(name))
                repetido = true;
        }
        
        return repetido;
    }
    
    public void deleteFile(String file, String lineToRemove) {
    
    try {
 
        File archivo = new File(file);
 
        if (!archivo.isFile()) {
            System.out.println("no hay file");
            return;
        }
 
        //Construct the new file that will later be renamed to the original filename.
        File tempFile = new File(archivo.getAbsolutePath() + ".tmp");
 
        BufferedReader br = new BufferedReader(new FileReader(file));
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
 
        String line = null;
 
        //Read from the original file and write to the new
        //unless content matches data to be removed.
        while ((line = br.readLine()) != null) {
 
            if (!line.trim().equals(lineToRemove)) {
 
                pw.println(line);
                pw.flush();
            }
        }
        pw.close();
        br.close();
 
        //Delete the original file
        if (!archivo.delete()) {
            System.out.println("Could not delete file");
            return;
        }
 
        //Rename the new file to the filename the original file had.
        if (!tempFile.renameTo(archivo)){
            System.out.println("Could not rename file");
 
        }
    } catch (FileNotFoundException fnfe) {
//        JOptionPane.showMessageDialog(null, "Problemas al leer el archivo");
    } catch (IOException ioe) {
//        JOptionPane.showMessageDialog(null, "Problemas al leer el archivo");
    }
}
    
    public int getFileRegisters(){
        //Metodo que resuelve cuantos paises hay registrados
        File FileCountries = new File("paises.txt");
        
        int countRegisters = 0;
        
        try{
        FileInputStream fis = new FileInputStream(FileCountries);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        
        String actualRegister = br.readLine();
        
        while(actualRegister!=null){
            
            if(actualRegister!=null)
               countRegisters ++;
            
            actualRegister = br.readLine();
            
        }//End while
        fis.close();
        }catch(FileNotFoundException fnfe){
//            JOptionPane.showMessageDialog(null, "Problemas al leer el archivo");
        }catch(IOException ioe){
//            JOptionPane.showMessageDialog(null, "Problemas al leer el archivo");
        }
        
        return countRegisters;
    }
    
    public Country[] readRegistersFile(){
        //Hace lectura de los archivos para ponerlos en un arreglo
       Country array[] = new Country[getFileRegisters()];
       
       File paises = new File("paises.txt");
       
       try{
           FileInputStream fis = new FileInputStream(paises);
           InputStreamReader isr = new InputStreamReader(fis);
           BufferedReader br = new BufferedReader(isr);
           
           String actualRegister = br.readLine();
           int indexArray = 0;
           
           while(actualRegister!=null){
               
               String country = "", capital = "", idiom = "", population = "", continent = "", description = "", flag = "";
               int controlToken = 1, search = 0;
               
               StringTokenizer sT = new StringTokenizer(actualRegister, "/");//Para separar el registro
               
               while(sT.hasMoreTokens()){
                   
                   if(controlToken==1)
                       country = sT.nextToken();
                   else if(controlToken==2)
                       capital = sT.nextToken();// Integer.parseInt(sT.nextToken()); PARA LOS INT
                   else if(controlToken==3)
                       idiom = sT.nextToken();
                   else if(controlToken==4)
                       population = sT.nextToken();
                   else if(controlToken==5)
                       continent = sT.nextToken();
                   else if(controlToken==6)
                       description = sT.nextToken();
                   else if(controlToken==7)
                       flag = sT.nextToken();
                   else if(controlToken==8)
                       search = Integer.parseInt(sT.nextToken());
                   
                   controlToken++;
               }//End while 2
               
               Country c = new Country(country, capital, idiom, population, continent, description, flag, search);
               
               
               array[indexArray] = c;
               indexArray++;
               
               actualRegister = br.readLine();
           }//end while 1
         fis.close();
       }catch(FileNotFoundException fnfe){
//           JOptionPane.showMessageDialog(null, "Problemas al leer");
       }catch(IOException ioe){
//           JOptionPane.showMessageDialog(null, "Problemas al leer");
       }
        
       return array;
    } 
    
    public String getFileContinent(Country c){
        //Metodo que resuelve paises en un continente
        File FileCountries = new File("paises.txt");
        String nombrePais = "";
         
                
        try{
        FileInputStream fis = new FileInputStream(FileCountries);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        
        String america="", europa="", asia="", africa="", oceania="";
        
        while(nombrePais!=null){
                nombrePais = br.readLine();
                
                if(nombrePais!=null)
                    if(c.getNameCountry().equalsIgnoreCase("America"));
                nombrePais += america;
                        
            
        }//End while
        fis.close();
        }catch(FileNotFoundException fnfe){
//            JOptionPane.showMessageDialog(null, "Problemas al leer el archivo");
        }catch(IOException ioe){
//            JOptionPane.showMessageDialog(null, "Problemas al leer el archivo");
        }
        
        return nombrePais;
    }
    
    public void paisesAlfabetico(){
    
        ArrayList<Country> paises = new ArrayList();
        
        Country tempCountries[] = readRegistersFile();
        
//        Arrays.sort(tempCountries);
        
        for (int i = 0; i < tempCountries.length; i++) {
            paises.add(tempCountries[i]);
        }
        
        ordenar(paises);
    }
    
    public  void ordenar(ArrayList<Country> paises){
        
       // File FileCountries = new File("paises.txt");
        
        for(Country c : paises){
            //JOptionPane.showMessageDialog(null, c.getNameCountry());
        }
        
        for (int i = 0; i < paises.size(); i++) {
            for (int j = 0; j < paises.size() && i!= j; j++) {
                if (paises.get(i).getNameCountry().compareToIgnoreCase(paises.get(j).getNameCountry())<0) {
                    Country auxiliar = paises.get(i);
                    paises.set(i,paises.get(j));
                     paises.set(j,auxiliar);
                 }
            }
        }
        
//       String confirm = JOptionPane.showInputDialog("Ingrese Si para confirmar");
//     if (confirm.equalsIgnoreCase("Si")|| confirm.equalsIgnoreCase("Sí")){
//        FileCountries.delete();
//     }
     removeFile();
        
        for(Country c : paises){
//            JOptionPane.showMessageDialog(null, c.getNameCountry());
            insertCountry(c);
        }
     
    }
    
    public void removeFile(){
        
        if (FileCountries.delete())
   System.out.println("El fichero ha sido borrado satisfactoriamente");
else
   System.out.println("El fichero no puede ser borrado");
        
    }
    
}
