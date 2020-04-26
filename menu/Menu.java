package menu;


import db.Database;

/**
 * Write a description of class Menu here.
 * 
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class Menu {

    private final Database db;

    public Menu() {
        db = new Database();
    }

    public Database getDb() {
        return db;
    }

}