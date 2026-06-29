package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity(name = "projetos")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "O nome do projeto não pode ser vazio.")
    private String name;

    @NotBlank(message = "A descrição não pode ser vazia.")
    private String description;

    @NotNull(message = "O orçamento não pode ser nulo.")
    @Positive(message = "O orçamento deve ser maior que zero.")
    private Double budget;

    @ManyToOne(optional = false)
    @NotNull(message = "Selecione uma empresa responsável.")
    private Empresa empresa;

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }
    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
}