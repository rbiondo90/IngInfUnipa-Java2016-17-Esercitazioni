/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unipa.community.robertobiondo.prg.n10.es02;

import java.util.Properties;

/**
 *
 * @author Roberto Biondo
 */
public class PropertyTest {
    public static void main(String args[]){
        System.setProperty("database", "localhost");
        System.setProperty("dbUser", "Roberto");
        System.setProperty("dbPassword", "***********");
        Properties properties = System.getProperties();
        properties.list(System.out);
        System.out.println("\nControllo manuale delle proprietà: ");
        System.out.println("database = " + System.getProperty("database"));
        System.out.println("dbUser = " + System.getProperty("dbUser"));
        System.out.println("dbPassword = " + System.getProperty("dbPassword"));
    }
}
