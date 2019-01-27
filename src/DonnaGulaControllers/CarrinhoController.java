package DonnaGulaControllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DonnaGulaDAOS.CarrinhoDAO;
import DonnaGulaDAOS.ClientDAO;
import DonnaGulaDAOS.DocesDAO;
import DonnaGulaDAOS.SalgadosDAO;
import DonnaGulaModels.Carrinho;
import DonnaGulaModels.Cliente;
import DonnaGulaModels.Doces;
import DonnaGulaModels.Salgados;



@Controller
public class CarrinhoController {
	@RequestMapping("/Carrinho/form")
	public ModelAndView form() {
		System.out.println("Chamou o meu método");
		DocesDAO doceDAO = new DocesDAO();
		List<Doces> listaA = doceDAO.getDoces();

		SalgadosDAO salgadoDAO = new SalgadosDAO();
		List<Salgados> listaL = salgadoDAO.getSalgados();

		ModelAndView model = new ModelAndView("Carrinho/form");

		model.addObject("doce", listaA);
		model.addObject("salgado", listaL);

		return model;

	}
		@PostMapping("/Carrinho/")
		public String inserir(Carrinho carrinho) {
			System.out.println("Chamou o método de adicionar");
			CarrinhoDAO carrinDAO = new CarrinhoDAO();
			carrinDAO.inserir(carrinho);
			return "redirect:/Carrinho";
		}
		
		@GetMapping("/Carrinho")
		public ModelAndView listar() {
			System.out.println("Chamou método de listagem");
			CarrinhoDAO carrinDAO = new CarrinhoDAO();
			List<Carrinho> lista = carrinDAO.getLista1();
			ModelAndView model = new ModelAndView("Carrinho/TudoCar");
			model.addObject("carrinho", lista);
			return model;
		}
		@RequestMapping("Carrinho/selecionar")
		public ModelAndView selecionar(Carrinho carrinho) {
			CarrinhoDAO carrinDAO = new CarrinhoDAO();
			carrinho = carrinDAO.getCarrinhoByID(carrinho.getId());
			
			ModelAndView model = new ModelAndView("Carrinho/carrinho-alterar");
			model.addObject("carrinho", carrinho);
			return model;
		}
		@RequestMapping ("Carrinho/alterar")
		public String alterar(Carrinho carrinho) {
			System.out.println("Chamou o metodo alterar");
			CarrinhoDAO carrinDAO = new CarrinhoDAO();
			carrinDAO.alterar(carrinho);
			
			return "redirect:../Carrinho";
}
}
