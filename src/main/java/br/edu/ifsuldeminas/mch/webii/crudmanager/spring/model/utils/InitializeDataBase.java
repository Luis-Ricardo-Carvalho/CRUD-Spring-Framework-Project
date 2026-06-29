package br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities.Address;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities.Empresa;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.entities.Projeto;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories.AdrressRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories.UserRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories.EmpresaRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.spring.model.repositories.ProjetoRepository;

@Component
public class InitializeDataBase implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdrressRepository adrressRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Address aEmerson = new Address();
		aEmerson.setPlace("Rua emerson");
		aEmerson.setNumber("10");
		aEmerson.setZipCode("130000");
		adrressRepository.save(aEmerson);
		
		Address aLuiza = new Address();
		aLuiza.setPlace("Rua luiza");
		aLuiza.setNumber("11");
		aLuiza.setZipCode("131000");
		adrressRepository.save(aLuiza);
		
		Address aAna = new Address();
		aAna.setPlace("Rua ana");
		aAna.setNumber("12");
		aAna.setZipCode("132000");
		adrressRepository.save(aAna);
		
		adrressRepository.flush();
				
		User emerson = new User();
		emerson.setName("Emerson Carvalho");
		emerson.setGender("M");
		emerson.setEmail("emerson@mail.com");
		emerson.setAddress(aEmerson);
		
		User luiza = new User();
		luiza.setName("Luiza Carvalho");
		luiza.setGender("F");
		luiza.setEmail("lu@mail.com");
		luiza.setAddress(aLuiza);
		
		User ana = new User();
		ana.setName("Ana Carvalho");
		ana.setGender("F");
		ana.setEmail("ana@mail.com");
		ana.setAddress(aAna);
		
		userRepository.save(emerson);
		userRepository.save(luiza);
		userRepository.save(ana);
		
		Empresa empTech = new Empresa();
		empTech.setName("Tech Solutions Ltda");
		empTech.setCnpj("12.345.678/0001-99");
		empTech.setIndustry("Tecnologia da Informação");
		empTech.setPhone("(35) 3295-0000");
		empresaRepository.save(empTech);
		
		Empresa empInova = new Empresa();
		empInova.setName("Inova Agropecuária");
		empInova.setCnpj("98.765.432/0001-11");
		empInova.setIndustry("Agronegócio");
		empInova.setPhone("(35) 3295-1111");
		empresaRepository.save(empInova);
		
		empresaRepository.flush();
		
		Projeto projEcommerce = new Projeto();
		projEcommerce.setName("Desenvolvimento de E-commerce");
		projEcommerce.setDescription("Criação de plataforma integrada de vendas online com suporte a PIX.");
		projEcommerce.setBudget(4000.00);
		projEcommerce.setEmpresa(empTech);
		
		Projeto projCloud = new Projeto();
		projCloud.setName("Migração para Nuvem");
		projCloud.setDescription("Migrar os servidores locais e o banco de dados da empresa para a infraestrutura AWS.");
		projCloud.setBudget(5000.0);
		projCloud.setEmpresa(empTech);
		
		Projeto projAutomacao = new Projeto();
		projAutomacao.setName("Automação de Irrigação");
		projAutomacao.setDescription("Implementação de sensores IoT para controle inteligente de umidade do solo.");
		projAutomacao.setBudget(8000.00);
		projAutomacao.setEmpresa(empInova);
		
		projetoRepository.save(projEcommerce);
		projetoRepository.save(projCloud);
		projetoRepository.save(projAutomacao);
	}
}