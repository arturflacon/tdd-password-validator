# TDD - Validador de Senhas Seguras

Módulo de validação de senhas desenvolvido com a metodologia **Test-Driven Development (TDD)** para uma fintech brasileira.

---

## Regras de Validação

| Regra | Descrição |
|---|---|
| Tamanho mínimo | Pelo menos 8 caracteres |
| Letra maiúscula | Pelo menos uma letra maiúscula (A-Z) |
| Letra minúscula | Pelo menos uma letra minúscula (a-z) |
| Número | Pelo menos um dígito (0-9) |
| Caractere especial | Pelo menos um de: `!@#$%^&*` |
| Sem espaços | Não pode conter espaços em branco |

---

## Tecnologias

- Java 8
- JUnit 5 (junit-jupiter 5.10.1)
- Maven 3

---

## Como executar os testes

Com Maven instalado:

```bash
mvn test
```

Ou abra o projeto no IntelliJ IDEA — ele reconhece o `pom.xml` e executa os testes automaticamente.

---

## Processo de Desenvolvimento (TDD)

O desenvolvimento seguiu rigorosamente o ciclo **Red → Green → Refactor**:

### Red (teste falha)
Cada teste foi escrito antes da implementação. Com o método `validate` retornando `true` por padrão (stub inicial), todos os testes que esperavam `false` falhavam imediatamente — evidenciando o estado Red.

### Green (teste passa)
Após cada teste falhar, foi implementado o **mínimo de código necessário** para fazê-lo passar, sem antecipar regras futuras.

### Refactor
Com todos os testes passando, o código foi reestruturado: o método `validate` tornou-se uma composição de métodos privados (`hasMinimumLength`, `hasUpperCase`, etc.), eliminando o loop duplicado e tornando cada regra explícita e isolada.

---

## Histórico de Commits

O histórico segue o padrão `test:` → `feat:` → `refactor:` para cada regra:

```
chore: inicializa projeto Maven com JUnit 5
test:  deve rejeitar senha com menos de 8 caracteres e senha nula
feat:  implementa validação de tamanho mínimo e rejeição de senha nula
test:  deve rejeitar senha sem letra maiúscula
feat:  adiciona validação de letra maiúscula
test:  deve rejeitar senha sem letra minúscula
feat:  adiciona validação de letra minúscula
test:  deve rejeitar senha sem número
feat:  adiciona validação de número
test:  deve rejeitar senha sem caractere especial
feat:  adiciona validação de caractere especial
test:  deve rejeitar senha com espaço em branco
feat:  adiciona validação de ausência de espaços em branco
test:  deve aceitar senha que atende todos os critérios
refactor: extrai cada validação em método privado
docs:  adiciona README com documentação do projeto
```

---

## Decisões Técnicas

**Stub inicial retornando `true`:** optou-se por iniciar o método `validate` retornando `true` em vez de `false`, garantindo que cada teste de rejeição falhasse no estado Red — tornando o ciclo TDD visível no histórico de commits.

**Verificação de `null` no primeiro ciclo:** a validação de senha nula foi incluída junto à regra de tamanho mínimo, pois ambas tratam da ausência de conteúdo válido e não justificam um ciclo separado.

**Refactor com métodos privados:** o loop único original foi substituído por métodos privados especializados. Isso torna cada regra de negócio rastreável individualmente e facilita futuras extensões (ex.: adicionar novos tipos de caracteres especiais).

---

## Desafios Encontrados

- **Definir o estado Red corretamente:** com um stub retornando `false`, testes `assertFalse(...)` passariam imediatamente — o que não evidenciaria o ciclo TDD. A solução foi iniciar com `return true`.
- **Granularidade dos commits:** manter commits pequenos e focados exigiu disciplina para não implementar múltiplas regras de uma vez.

---

## Reflexão sobre TDD

A prática do TDD obrigou a pensar em cada regra de negócio isoladamente antes de codificá-la. O resultado foi um código com responsabilidades bem definidas e 100% das regras cobertas por testes. O histórico de commits funciona como uma documentação viva do raciocínio por trás de cada decisão.
