package com.kyrosb01.request;

import com.kyrosb01.validation.Date;
import com.kyrosb01.validation.Phone;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "CPF é obrigatório")
    @CPF
    private String cpf;

    @NotNull(message = "Data de nascimento é obrigatória")
    @Date
    private String dataNascimento;

    @NotNull(message = "Email é obrigatório")
    @Email
    private String email;

    @NotNull(message = "Número de telefone é obrigatório!")
    @Phone
    private String telefone;

    public ClienteRequest() {
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
