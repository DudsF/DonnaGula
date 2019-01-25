package DonnaGulaControllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DonnaGulaDAOS.CarrinhoDAO;
import DonnaGulaModels.Carrinho;


@Controller
public class CarrinhoController {

		@RequestMapping("/Carrinho/form")
		public String form() {
			System.out.println("Chamou meu método de formulário");
			return "Carrinho/form";
		}
		
		@PostMapping("/Carrinho")
		public String adicionar(Carrinho carrinho) {
			System.out.println("Chamou o método de adicionar");
			CarrinhoDAO carrinDAO = new CarrinhoDAO();
			carrinDAO.inserir(carrinho);
			return "redirect:Carrinho/";
		}
		
		@GetMapping("/Carrinho")
		public ModelAndView listar() {
			System.out.println("Chamou método de listagem");
			CarrinhoDAO carrinDAO = new CarrinhoDAO();
			List<Carrinho> lista = carrinDAO.getLista();
			ModelAndView model = new ModelAndView("Carrinho/TudoCar");
			model.addObject("carrinho", lista);
			return model;
		}
}
