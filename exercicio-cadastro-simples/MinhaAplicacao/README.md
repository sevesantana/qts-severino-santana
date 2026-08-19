# MinhaAplicacao — Cadastro Simples (Java + MySQL)

Projeto Java gerado a partir do tutorial "Programa Cadastro Simples" (Aula DS 28/05/2025).

## Estrutura

```
MinhaAplicacao/
├── database.sql              # Passo 1: script de criação do banco/tabela
└── src/
    ├── factory/
    │   ├── ConnectionFactory.java   # Passo 3: fábrica de conexões JDBC
    │   └── TestaConexao.java        # Classe de teste de conectividade
    ├── modelo/
    │   └── Usuario.java             # Passo 4: bean/modelo
    ├── dao/
    │   └── UsuarioDAO.java          # Passo 5: persistência (INSERT)
    └── gui/
        └── UsuarioGUI.java          # Passos 6–9: formulário Swing (Cadastrar, Limpar, Sair)
```

## Como usar

1. **Banco de dados**: abra o MySQL Workbench (ou console) e execute `database.sql`.
2. **Driver JDBC**: baixe o MySQL Connector/J e adicione o `.jar` ao classpath do projeto (no NetBeans: Bibliotecas > Adicionar JAR/Pasta).
3. **Credenciais**: edite `ConnectionFactory.java` e ajuste usuário/senha (por padrão está `root` / senha em branco).
4. **Importar no NetBeans**: crie um novo "Aplicativo Java" chamado `MinhaAplicacao`, copie os pacotes `factory`, `modelo`, `dao` e `gui` para dentro de `Pacotes de código-fonte`.
5. **Testar conexão**: rode `factory.TestaConexao` (deve imprimir "Conexão aberta!").
6. **Rodar a aplicação**: execute `gui.UsuarioGUI` (método `main`). Preencha Nome, CPF, Email e Telefone e clique em **Cadastrar**.
7. **Conferir no banco**:
   ```sql
   use projetojava;
   select * from usuario;
   ```

## Observações
- O botão **Limpar** apaga os 4 campos de texto.
- O botão **SAIR** encerra a aplicação (`System.exit(0)`).
- Caso a conexão falhe, verifique a porta do MySQL (ex.: `jdbc:mysql://localhost:3307/projetojava`).
