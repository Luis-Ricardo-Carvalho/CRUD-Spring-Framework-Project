package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities.Projeto;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories.ProjetoRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories.EmpresaRepository;
import jakarta.validation.Valid;

@Controller
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/projetos")
    public String listProjetos(Model model) {
        List<Projeto> projetos = projetoRepository.findAll();
        model.addAttribute("projetos", projetos);
        return "projetos";
    }

    @GetMapping("/projetos/form")
    public String projetoForm(@ModelAttribute("projeto") Projeto projeto, Model model) {
        model.addAttribute("empresas", empresaRepository.findAll());
        return "projeto_form";
    }

    @PostMapping("/projetos/save")
    public String projetoSave(@Valid @ModelAttribute("projeto") Projeto projeto, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("empresas", empresaRepository.findAll());
            return "projeto_form";
        }
        projetoRepository.save(projeto);
        return "redirect:/projetos";
    }

    @GetMapping("/projetos/{id}")
    public String projetoUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Projeto> projOpt = projetoRepository.findById(id);
        if (projOpt.isPresent()) {
            model.addAttribute("projeto", projOpt.get());
        }
        model.addAttribute("empresas", empresaRepository.findAll());
        return "projeto_form";
    }

    @GetMapping("/projetos/delete/{id}")
    public String projetoDelete(@PathVariable("id") Integer id) {
        projetoRepository.deleteById(id);
        return "redirect:/projetos";
    }
}