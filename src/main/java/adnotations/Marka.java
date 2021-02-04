/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adnotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author Kamil
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Marka {
    String name() default "Name";
}
