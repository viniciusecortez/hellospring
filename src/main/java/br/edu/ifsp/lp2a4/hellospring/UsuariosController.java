package br.edu.ifsp.lp2a4.hellospring;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsp.lp2a4.hellospring.entidades.Usuario;
import br.edu.ifsp.lp2a4.hellospring.entidades.UsuariosRepository;

@Controller
public class UsuariosController {
	
	private UsuariosRepository repository;

	public UsuariosController(UsuariosRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/usuarios")
	public String index(Model model) {

		model.addAttribute("usuarios", repository.findAll()); 
		
		return "usuarios/list";
	}
	
	@GetMapping("/usuarios/create")
	public String create(Usuario usuario) {
		return "usuarios/create";
	}
	
	@PostMapping("/usuarios")
	public String create(@Valid Usuario usuario, BindingResult result, Model model) {
		
		if(result.hasErrors())
			return "usuarios/create";
		
		repository.save(usuario);
		
		model.addAttribute("usuarios", repository.findAll()); 
		
		return "usuarios/list";
	}
}
