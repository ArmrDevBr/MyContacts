/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mycontacts.utils;

/**
 *
 * @author aurem
 */
public class ValidadorEmail {

    public boolean validadorEmail(String email) {
        boolean isValid = email.contains("@");
        return isValid;
    }
}
