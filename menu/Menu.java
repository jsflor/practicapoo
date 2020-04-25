package menu;


import db.Database;

/**
 * Write a description of class Menu here.
 * 
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class Menu {

    private Database db;

    public Menu(){}

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }
}