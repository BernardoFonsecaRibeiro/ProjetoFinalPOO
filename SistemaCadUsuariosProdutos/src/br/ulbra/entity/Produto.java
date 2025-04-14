package br.ulbra.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Produto {

    private int pkidprod;
    private String nomeProd;
    private String dataCadProd;
    private String categoriaProd;
    private Double valorUnitProd;
    private int quantEstoqueProd;

    public Produto() {

    }

    public Produto(int idProd, String nomeProd, String dataCadProd, String categoriaProd, Double valorUnitProd, int quantEstoqueProd) {
        this.pkidprod = pkidprod;
        this.nomeProd = nomeProd;
        this.dataCadProd = dataCadProd;
        this.categoriaProd = categoriaProd;
        this.valorUnitProd = valorUnitProd;
        this.quantEstoqueProd = quantEstoqueProd;
    }

    public int getpkidprod() {
        return 0;
    }

    public void setpkidprod(int pkidprod) {
        this.pkidprod = pkidprod;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getDataCadProd() {
        return dataCadProd;
    }

    public void setDataCadProd(String dataCadProd) {
        this.dataCadProd = dataCadProd;
    }

    public String getCategoriaProd() {
        return categoriaProd;
    }

    public void setCategoriaProd(String categoriaProd) {
        this.categoriaProd = categoriaProd;
    }

    public Double getValorUnitProd() {
        return valorUnitProd;
    }

    public void setValorUnitProd(Double valorUnitProd) {
        this.valorUnitProd = valorUnitProd;
    }

    public int getQuantEstoqueProd() {
        return quantEstoqueProd;
    }

    public void setQuantEstoqueProd(int quantEstoqueProd) {
        this.quantEstoqueProd = quantEstoqueProd;
    }

    private static final String REGEX = "[A-Z][a-z].* [A-Z][a-z].*";

    public boolean validarNome(String nome) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(nome);
        return matcher.matches();
    }
    private static final String codREGEX = "^\\\\d{5}$";

    public boolean validarCategoria(String cod) {
        Pattern pattern = Pattern.compile(codREGEX);
        Matcher matcher = pattern.matcher(cod);
        return matcher.matches();
    }
    private static final String dataREGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\\\d{4}$";

    public boolean validarData(String data) {
        Pattern pattern = Pattern.compile(codREGEX);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public LocalDate converterParaData(String data) {
        if (validarData(data)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(data, formatter);
        } else {
            throw new IllegalArgumentException("Data inválida: " + data);
        }
    }

    private static final String valorREGEX = "^\\d+(\\.\\d+)?$";

    public boolean validarValor(String valor) {
        Pattern pattern = Pattern.compile(valorREGEX);
        Matcher matcher = pattern.matcher(valor);
        return matcher.matches();
    }

    public double converterParaDouble(String valor) {
        if (validarValor(valor)) {
            return Double.parseDouble(valor);
        } else {
            throw new IllegalArgumentException("Valor inválido: " + valor);
        }
    }
    private static final String quantidadeREGEX = "^\\d+$";

    public boolean validarQuantidade(String quantidade) {
        Pattern pattern = Pattern.compile(quantidadeREGEX);
        Matcher matcher = pattern.matcher(quantidade);
        return matcher.matches();
    }

    public int converterParaInt(String quantidade) {
        if (validarQuantidade(quantidade)) {
            return Integer.parseInt(quantidade);
        } else {
            throw new IllegalArgumentException("Quantidade inválida: " + quantidade);
        }
    }
    
}
