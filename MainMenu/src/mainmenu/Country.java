/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainmenu;

/**
 *
 * @author Equipo
 */
public class Country {
    
    private String nameCountry, capital, idiom, population, continent, description, flag;
    private int search;
    //private Bandera bandera;

    public Country() {
    }

    public Country(String nameCountry, String capital, String idiom, String population, String continent, String description, String flag, int search) {
        this.nameCountry = nameCountry;
        this.capital = capital;
        this.idiom = idiom;
        this.continent = continent;
        this.description = description;
        this.population = population;
        this.flag = flag;
        this.search = search;
    }

    public int getSearch() {
        return search;
    }

    public void setSearch(int search) {
        this.search = search;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getIdiom() {
        return idiom;
    }

    public void setIdiom(String idiom) {
        this.idiom = idiom;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    
    
    
    
    
}
