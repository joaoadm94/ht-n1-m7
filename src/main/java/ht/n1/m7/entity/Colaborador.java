package ht.n1.m7.entity;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Colaborador implements Serializable {

    private Integer id;

    @NotNull(message = "Informe o nome do colaborador.")
    @NotEmpty(message = "Informe o nome do colaborador.")
    @Size(max = 50, message = "Nome muito extenso.")
    private String nome;

    @NotNull(message = "Informe o cpf do colaborador.")
    @NotEmpty(message = "Informe o nome do colaborador.")
    @Pattern(regexp = "\\d{11}", message = "CPF inválido.")
    private String cpf;

    @NotNull(message = "Informe o cargo do colaborador.")
    private Integer cargo;

    @NotNull(message = "Informe o salário do colaborador.")
    private BigDecimal salario;

    @NotNull(message = "Informe o nascimento do colaborador.")
    private LocalDate nascimento;

    public Colaborador() {}

    public Colaborador(Integer id, String nome, String cpf, Integer cargo, BigDecimal salario, LocalDate nascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salario = salario;
        this.nascimento = nascimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getCargo() {
        return cargo;
    }

    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
