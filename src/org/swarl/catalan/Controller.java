package org.swarl.catalan;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigInteger;

public class Controller {
    @FXML
    private TextField input;

    @FXML
    private TextArea output;

    @FXML
    private void calculate() {
        BigInteger inBig = catalan(Integer.parseInt(input.getText()));
        output.setText(String.format("%,d", inBig));
    }

    private BigInteger catalan(int n) {
        if (n <= 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(4)
                .multiply(BigInteger.valueOf(n))
                .subtract(BigInteger.valueOf(2))
                .multiply(catalan(n - 1))
                .divide(BigInteger.valueOf(n).add(BigInteger.ONE));
    }
}
