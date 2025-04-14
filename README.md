# Nome do Projeto

> Projeto final em Java desenvolvido durante a última semana de aula do curso técnico sobre o conteúdo de Programação orientada a objetos (POO) "

## 📌 Sobre o Projeto

Este repositório contém um projeto em Java, focando em conceitos essenciais da linguagem, como:

- Programação orientada a objetos (POO)
- Manipulação de Banco de dados
- Tratamento de exceções
- Desenvolvimento de um CRUD completo.

O projeto visa consolidar o aprendizado e podem ser utilizados como portfólio profissional.

---
## 🛠️ Tecnologias Utilizadas

- Java (JDK 17+ recomendado)
- IDE: [NetBeans  8.2]
- Git/GitHub para versionamento

---

## 🚀 Como Executar

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   ```
2. **Abra o projeto em sua IDE favorita**.
3. **Compile e execute** os arquivos `.java` conforme necessário.
   ```bash
   javac SistemaCadUsuariosProdutos.java
   java SistemaCadUsuariosProdutos   ```
   ```
---
## 📂 Estrutura do Repositório

```bash
📂 SistemaCadUsuariosProdutos 
├── 📁 src/br/ulbra
│   ├── 📁 com.exemplo.exercicios
│   │   ├── DAO.java
│   │   ├── Config.java
│   │   ├── entity.java
│   │   ├── img.java
│   │   ├── view.java
│   │
├── 📄 README.md
└── 📄 .gitignore
```
---
## 📖 Exemplos de Código
```package br.ulbra.DAO;

import br.ulbra.config.ConnectionFactory;
import br.ulbra.entity.Usuario;
import br.ulbra.view.FrmDashBoard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection con;

    public UsuarioDAO() throws SQLException {
        con = ConnectionFactory.getConnectionBanco1();
    }

    public boolean checkLogin(String email, String senha) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM bdprojeto WHERE emailUsu = ? and senhaUsu = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }

    public void save(Usuario u) {

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO bdprojeto(nomeusu, emailusu,"
                    + " senhausu, foneusu,cpfusu,cepusu,logradourousu, numerousu,"
                    + "bairrousu,cidadeusu,estadousu ) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, u.getNomeusu());
            stmt.setString(2, u.getEmailusu());
            stmt.setString(3, u.getSenhausu());
            stmt.setString(4, u.getFoneusu());
            stmt.setString(5, u.getCpfusu());
            stmt.setString(6, u.getCepusu());
            stmt.setString(7, u.getLogradourousu());
            stmt.setString(8, u.getNumerousu());
            stmt.setString(9, u.getBairrousu());
            stmt.setString(10, u.getCidadeusu());
            stmt.setString(11, u.getEstadousu());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<Usuario> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuario = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM bdprojeto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario us = new Usuario();
                us.setPkidusu(rs.getInt("pkidusu"));
                us.setNomeusu(rs.getString("nomeusu"));
                us.setEmailusu(rs.getString("emailusu"));
                us.setFoneusu(rs.getString("foneusu"));
                us.setCepusu(rs.getString("cepusu"));
                usuario.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Usuario>) usuario;
    }

}
```


---
## 🏆 Autor(es)

👤 **Isadora Mendes**  
📧 Email: coisasserias45@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/isadora-mendes-083606322/)  
🔗 [GitHub](https://github.com/M3ndezs/Isador)


👤 **Bernardo Da Fonseca Ribeiro**  
📧 Email: lobilho1976u8@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/seu-perfil/)  
🔗 [GitHub]([https://github.com/seu-usuario/](https://github.com/BernardoFonsecaRibeiro))

👤 **Leonardo Schmitt de Souza**  
📧 Email: leo.schmitt2708@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/seu-perfil/)  
🔗 [GitHub](https://github.com/Ghost-souza006)



---

## 🎯 Objetivo do Repositório

Este repositório serve como um portfólio para demonstrar habilidades em Programação Orientada a Objetos, ajudando na busca de oportunidades de emprego na área de desenvolvimento em um futuro próximo.
---
## ⚖️ Licença

Este projeto está sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
