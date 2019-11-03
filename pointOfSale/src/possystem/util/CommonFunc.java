/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem.util;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import static possystem.view.addItem.txtCost;

/**
 *
 * @author ChanukaD
 */
public class CommonFunc {

    public static String genarateCode(String code, int Status) {
        String newCode = null;
        for (int i = 0; i < code.length(); i++) {
            int j = i + 1;
            String letter = code.substring(i, j);
            try {
                int number = Integer.valueOf(letter);
                int codeNumber = Integer.valueOf(code.substring(i, code.length()));
                if (codeNumber < 9) {
                    codeNumber++;
                    newCode = code.substring(0, i--) + "0" + codeNumber;
                } else if (codeNumber > 8 && codeNumber < 99) {

                } else if (codeNumber > 99) {

                }
            } catch (Exception e) {
                System.out.println("Not a number");
            }
        }

        return newCode;
    }

    public static int acceptOnlyNumbers(JTextField txtField, KeyEvent evt) {
        String value = txtField.getText();
        int keyEvent = 0;
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {

        } else if (evt.getKeyChar() == '.') {
            if (value.contains(".")) {
                keyEvent = evt.getKeyCode();
                txtCost.setText(txtCost.getText().replace(".", ""));
            } else if(value.length()==0){
                keyEvent = evt.getKeyCode();
                txtCost.setText(txtCost.getText().replace(".", ""));
            }

        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

        } else {
            keyEvent = evt.getKeyCode();
            char charr = evt.getKeyChar();
            txtCost.setText(txtCost.getText().replace(String.valueOf(charr), ""));
        }
        return keyEvent;
    }

    public static void removeLastCharOfTextField(JTextField txtField) {
        txtField.setText("" + txtField.getText().substring(0, txtField.getText().length() - 1));
    }
}
