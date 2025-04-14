package br.ulbra.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Usuario {

    private int pkidusu;
    private String nomeusu;
    private String emailusu;
    private String senhausu;
    private String foneusu;
    private String cpfusu;
    private String cepusu;
    private String logradourousu;
    private String numerousu;
    private String bairrousu;
    private String cidadeusu;
    private String estadousu;

    public Usuario() {
    }

    public Usuario(int pkidusu, String nomeusu, String emailusu, String senhausu, String foneusu, String cpfusu,
            String cepusu, String logradourousu, String numerousu, String bairrousu, String cidadeusu,
            String estadousu) {

        this.pkidusu = pkidusu;
        this.nomeusu = nomeusu;
        this.emailusu = emailusu;
        this.senhausu = senhausu;
        this.foneusu = foneusu;
        this.cpfusu = cpfusu;
        this.cepusu = cepusu;
        this.logradourousu = logradourousu;
        this.numerousu = numerousu;
        this.bairrousu = bairrousu;
        this.cidadeusu = cidadeusu;
        this.estadousu = estadousu;
    }

    public int getPkidusu() {
        return 0;
    }

    public boolean validarLogin(String emailusu, String senhausu) {
        return false;

    }

    private static final String REGEX = "[A-Z][a-z].* [A-Z][a-z].*";

    public boolean validarNome(String nome) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(nome);
        return matcher.matches();
    }

    private static final String SenhaREGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{1,8}$";

    public boolean validarSenha(String senha) {
        Pattern pattern = Pattern.compile(SenhaREGEX);
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }

    private static final String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public boolean validarEmail(String email) {

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static final String foneRegex = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";

    public boolean validarFone(String fone) {

        Pattern pattern = Pattern.compile(foneRegex);
        Matcher matcher = pattern.matcher(fone);
        return matcher.matches();
    }

    private static final String cpfREGEX = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})";

    public boolean validarCPF(String cpf) {
        Pattern pattern = Pattern.compile(cpfREGEX);
        Matcher matcher = pattern.matcher(cpf);
        return matcher.matches();
    }

    private static final String cepREGEX = "^\\d{8}$";

    public boolean validarCEP(String cep) {
        Pattern pattern = Pattern.compile(cepREGEX);
        Matcher matcher = pattern.matcher(cep);
        return matcher.matches();
    }

    private static final String logradouroREGEX = "^[A-Za-zÀ-ÿ0-9\\s\\.\\-ºª]+$";

    public boolean validarLogradouro(String logradouro) {
        Pattern pattern = Pattern.compile(logradouroREGEX);
        Matcher matcher = pattern.matcher(logradouro);
        return matcher.matches();
    }

    private static final String numREGEX = "^^\\d+$";

    public boolean validarNum(String numero) {
        Pattern pattern = Pattern.compile(numREGEX);
        Matcher matcher = pattern.matcher(numero);
        return matcher.matches();
    }

    private static final String bairroREGEX = "^[A-Za-zÀ-ÿ0-9\\s\\.'\\-]+$";

    public boolean validarBairro(String bairro) {
        Pattern pattern = Pattern.compile(bairroREGEX);
        Matcher matcher = pattern.matcher(bairro);
        return matcher.matches();
    }
    private static final String cidadeREGEX = "^[A-Za-zÀ-ÿ0-9\\s\\.'\\-]+$";

    public boolean validarCidade(String cidade) {
        Pattern pattern = Pattern.compile(cidadeREGEX);
        Matcher matcher = pattern.matcher(cidade);
        return matcher.matches();
    }

    private static final String estadoREGEX = "^(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)$";

    public boolean validarEstado(String estado) {
        Pattern pattern = Pattern.compile(estadoREGEX);
        Matcher matcher = pattern.matcher(estado);
        return matcher.matches();
    }

    public void setPkidusu(int pkidusu) {
        this.pkidusu = pkidusu;
    }

    public String getNomeusu() {
        return nomeusu;
    }

    public void setNomeusu(String nomeusu) {
        this.nomeusu = nomeusu;
    }

    public String getEmailusu() {
        return emailusu;
    }

    public void setEmailusu(String emailusu) {
        this.emailusu = emailusu;
    }

    public String getSenhausu() {
        return senhausu;
    }

    public void setSenhausu(String senhausu) {
        this.senhausu = senhausu;
    }

    public String getFoneusu() {
        return foneusu;
    }

    public void setFoneusu(String foneusu) {
        this.foneusu = foneusu;
    }

    public String getCpfusu() {
        return cpfusu;
    }

    public void setCpfusu(String cpfusu) {
        this.cpfusu = cpfusu;
    }

    public String getCepusu() {
        return cepusu;
    }

    public void setCepusu(String cepusu) {
        this.cepusu = cepusu;
    }

    public String getLogradourousu() {
        return logradourousu;
    }

    public void setLogradourousu(String logradourousu) {
        this.logradourousu = logradourousu;
    }

    public String getNumerousu() {
        return numerousu;
    }

    public void setNumerousu(String numerousu) {
        this.numerousu = numerousu;
    }

    public String getBairrousu() {
        return bairrousu;
    }

    public void setBairrousu(String bairrousu) {
        this.bairrousu = bairrousu;
    }

    public String getCidadeusu() {
        return cidadeusu;
    }

    public void setCidadeusu(String cidadeusu) {
        this.cidadeusu = cidadeusu;
    }

    public String getEstadousu() {
        return estadousu;
    }

    public void setEstadousu(String estadousu) {
        this.estadousu = estadousu;
    }

}
