/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.saulmartinez.system.utils;

/**
 *
 * @author informatica
 */
public class Validations {

    public Validations() {
    }

    public Boolean equalsText(String OriginalText, String TextToCompare) {
        return OriginalText.equals(TextToCompare);
    }

    public Boolean isFieldEmpty(String text) {
        boolean isEmpty = false;

        if (text.isEmpty() || text.isBlank()) {
            isEmpty = true;
        }

        return isEmpty;
    }

    public Boolean validateLengthOfText(String text, int lengthMax) {
        return text.length() <= lengthMax;
    }

    public Boolean emailValidation(String email) {
        Integer dotCount = 0;
        Integer atCount = 0;

        //VALIDA LA EXISTENCIA DE PUNTOS CONSECUTIVOS
        for (Integer index = 0; index < email.length(); index++) {
            if (email.charAt(index) == '.') {
                dotCount++;
            }
            if (dotCount > 1) {
                return false;
            }

        }
        //VALIDA LA EXISTENCIA DE SOLO UN UNICO ARROBA
        for (Integer index = 0; index < email.length(); index++) {
            if (email.charAt(index) == '@') {
                atCount++;
            }
        }
        if (atCount != 1) {
            return false;
        }
        return true;

    }
}
