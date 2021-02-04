/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shareable;

/**
 *
 * @author Kamil
 */
public class Shareable {
    static String text;

    public Shareable() {
    }

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        Shareable.text = text;
    }
    
}
