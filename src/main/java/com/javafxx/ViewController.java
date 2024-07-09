package com.javafxx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ViewController {

    @FXML
    private Button A0; // Botão para o dígito 0
    @FXML
    private Button A1; // Botão para o dígito 1
    @FXML
    private Button A2; // Botão para o dígito 2
    @FXML
    private Button A3; // Botão para o dígito 3
    @FXML
    private Button A4; // Botão para o dígito 4
    @FXML
    private Button A5; // Botão para o dígito 5
    @FXML
    private Button A6; // Botão para o dígito 6
    @FXML
    private Button A7; // Botão para o dígito 7
    @FXML
    private Button A8; // Botão para o dígito 8
    @FXML
    private Button A9; // Botão para o dígito 9
    @FXML
    private Button DELETA; // Botão para limpar o visor
    @FXML
    private Button DIVIDIR; // Botão para adicionar o operador de divisão
    @FXML
    private Button IGUAL; // Botão para calcular o resultado
    @FXML
    private Button MAIS; // Botão para adicionar o operador de adição
    @FXML
    private Button MENOS; // Botão para adicionar o operador de subtração
    @FXML
    private Button PONTO; // Botão para adicionar o ponto decimal
    @FXML
    private TextField TELA; // Campo de texto para exibir e inserir números
    @FXML
    private Button VEZES; // Botão para adicionar o operador de multiplicação

    @FXML
    public void initialize() {
        // Configuração dos eventos de clique para cada botão
        A0.setOnAction(e -> appendText("0"));
        A1.setOnAction(e -> appendText("1"));
        A2.setOnAction(e -> appendText("2"));
        A3.setOnAction(e -> appendText("3"));
        A4.setOnAction(e -> appendText("4"));
        A5.setOnAction(e -> appendText("5"));
        A6.setOnAction(e -> appendText("6"));
        A7.setOnAction(e -> appendText("7"));
        A8.setOnAction(e -> appendText("8"));
        A9.setOnAction(e -> appendText("9"));
        DELETA.setOnAction(e -> clearText());
        DIVIDIR.setOnAction(e -> appendText("/"));
        VEZES.setOnAction(e -> appendText("*"));
        MAIS.setOnAction(e -> appendText("+"));
        MENOS.setOnAction(e -> appendText("-"));
        PONTO.setOnAction(e -> appendText("."));
        IGUAL.setOnAction(e -> calculateResult());
    }

    private void appendText(String text) {
        // Método para adicionar texto ao campo de texto (TELA)
        TELA.appendText(text);
    }

    private void clearText() {
        // Método para limpar o campo de texto (TELA)
        TELA.clear();
    }

    private void calculateResult() {
        try {
            String expression = TELA.getText(); // Obtém a expressão do campo de texto
            double result = eval(expression); // Calcula o resultado da expressão
            TELA.setText(String.valueOf(result)); // Exibe o resultado no campo de texto
        } catch (Exception e) {
            TELA.setText("Erro"); // Exibe "Erro" se ocorrer algum problema no cálculo
        }
    }

    private double eval(String expression) {
        char[] arr = expression.toCharArray();
        String operand1 = "";
        String operand2 = "";
        char operator = ' ';
        boolean foundOperator = false;

        // Percorre a expressão para separar os operandos e o operador
        for (char c : arr) {
            if (c >= '0' && c <= '9' || c == '.') {
                if (!foundOperator) {
                    operand1 += c; // Concatena dígitos ao primeiro operando
                } else {
                    operand2 += c; // Concatena dígitos ao segundo operando
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                operator = c; // Encontra o operador na expressão
                foundOperator = true;
            }
        }

        double op1 = Double.parseDouble(operand1); // Converte o primeiro operando para double
        double op2 = Double.parseDouble(operand2); // Converte o segundo operando para double

        // Realiza a operação matemática com base no operador encontrado
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                if (op2 == 0) {
                    throw new ArithmeticException("Divisão por zero"); // Lança exceção se houver divisão por zero
                }
                return op1 / op2;
            default:
                throw new UnsupportedOperationException("Operador desconhecido: " + operator); // Lança exceção se o
                                                                                               // operador for
                                                                                               // desconhecido
        }
    }

}