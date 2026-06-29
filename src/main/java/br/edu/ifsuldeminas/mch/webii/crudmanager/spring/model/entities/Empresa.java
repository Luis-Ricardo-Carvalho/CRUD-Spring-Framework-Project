package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "O nome da empresa não pode ser vazio.")
    private String name;

    @NotBlank(message = "O CNPJ não pode ser vazio.")
    @Length(min = 14, max = 18, message = "CNPJ inválido.")
    private String cnpj;

    @NotBlank(message = "O setor não pode ser vazio.")
    private String industry;

    @NotBlank(message = "O telefone não pode ser vazio.")
    private String phone;

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}