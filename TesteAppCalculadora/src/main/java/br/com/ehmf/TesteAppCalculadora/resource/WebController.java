package br.com.ehmf.TesteAppCalculadora.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	
	@GetMapping("/")
	public String showForm(Model model) {
		return "index";
	}
	
	@PostMapping("/")
	public String handleFormSubmission(
			@RequestParam String modelOperacoes,
			@RequestParam String valor01,
			@RequestParam String valor02,
			Model model) {
		
		System.out.println("modelOperacoes: " + modelOperacoes + ", " +
						   "valor01: " + valor01 + ", " +
				           "valor02: " + valor02);
		return "index";
	}
	
}
