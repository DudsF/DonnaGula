package DonnaGulaControllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import DonnaGulaDAOS.DocesDAO;

import DonnaGulaModels.Doces;

@Controller
public class DocesController {
	@RequestMapping("/doces/form")
	public String form() {
		System.out.println("Chamou meu método de formulário");
		return "doces/form";
	}
	
	@PostMapping("/doces")
	public String adicionar(Doces doces) {
		System.out.println("Chamou o método de adicionar");
		DocesDAO docesDAO = new DocesDAO();
		docesDAO.inserir(doces);
		return "redirect:doces/";
	}
	
	@GetMapping("/doces")
	public ModelAndView listar() {
		System.out.println("Chamou método de listagem");
		DocesDAO docesDAO = new DocesDAO();
		List<Doces> lista = docesDAO.getDoces();
		ModelAndView model = new ModelAndView("doces/lista");
		model.addObject("doces", lista);
		return model;
	}
	
	@RequestMapping ("/doces/remover")
	public String remover(Doces doces) {
		System.out.println("Chamou o metodo remover");
		DocesDAO docesDAO = new DocesDAO();
		docesDAO.remover(doces);
		
		return "redirect:../doces";

}
}
