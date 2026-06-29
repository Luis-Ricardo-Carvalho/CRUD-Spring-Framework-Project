package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities.Empresa;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories.EmpresaRepository;
import jakarta.validation.Valid;

@Controller
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/empresas")
    public String listEmpresas(Model model) {
        List<Empresa> empresas = empresaRepository.findAll();
        model.addAttribute("empresas", empresas);
        return "empresas";
    }

    @GetMapping("/empresas/form")
    public String empresaForm(@ModelAttribute("empresa") Empresa empresa) {
        return "empresa_form";
    }

    @PostMapping("/empresas/save")
    public String empresaSave(@Valid @ModelAttribute("empresa") Empresa empresa, BindingResult errors) {
        if (errors.hasErrors()) {
            return "empresa_form";
        }
        empresaRepository.save(empresa);
        return "redirect:/empresas";
    }

    @GetMapping("/empresas/{id}")
    public String empresaUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Empresa> empOpt = empresaRepository.findById(id);
        if (empOpt.isPresent()) {
            model.addAttribute("empresa", empOpt.get());
        }
        return "empresa_form";
    }

    @GetMapping("/empresas/delete/{id}")
    public String empresaDelete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            empresaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", 
                "Não é possível excluir esta empresa pois ela possui projetos vinculados!");
        }
        return "redirect:/empresas";
    }
}