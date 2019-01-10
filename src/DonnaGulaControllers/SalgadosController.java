package DonnaGulaControllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import DonnaGulaDAOS.DocesDAO;
import DonnaGulaDAOS.SalgadosDAO;
import DonnaGulaModels.Doces;
import DonnaGulaModels.Salgados;

@Controller
public class SalgadosController {
	@RequestMapping("/salgados/form")
	public String form() {
		System.out.println("Chamou meu método de formulário");
		return "salgados/form";
	}
	
	@PostMapping("/salgados")
	public String adicionar(Salgados salgados) {
		System.out.println("Chamou o método de adicionar");
		SalgadosDAO salgadosDAO = new SalgadosDAO();
		salgadosDAO.inserir(salgados);
		return "redirect:salgados/";
	}
	
	@GetMapping("/salgados")
	public ModelAndView listar() {
		System.out.println("Chamou método de listagem");
		SalgadosDAO salgadosDAO = new SalgadosDAO();
		List<Salgados> lista = salgadosDAO.getSalgados();
		ModelAndView model = new ModelAndView("salgados/lista");
		model.addObject("salgados", lista);
		return model;
	}
	
	@RequestMapping ("/salgados/remover")
	public String remover(Salgados salgados) {
		System.out.println("Chamou o metodo remover");
		SalgadosDAO salgadosDAO = new SalgadosDAO();
		salgadosDAO.remover(salgados);
		
		return "redirect:../salgados";

}
}

