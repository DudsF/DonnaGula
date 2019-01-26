package DonnaGulaControllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DonnaGulaDAOS.CarrinhoDAO;
import DonnaGulaDAOS.DocesDAO;
import DonnaGulaDAOS.SalgadosDAO;
import DonnaGulaModels.Carrinho;
import DonnaGulaModels.Doces;
import DonnaGulaModels.Salgados;



@Controller
public class CarrinhoController {
	@RequestMapping("/Carrinho/form")
	public ModelAndView form() {
		System.out.println("Chamou o meu m�todo");
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
			System.out.println("Chamou o m�todo de adicionar");
			CarrinhoDAO carrinDAO = new CarrinhoDAO();
			carrinDAO.inserir(carrinho);
			return "redirect:/Carrinho";
		}
		
		@GetMapping("/Carrinho")
		public ModelAndView listar() {
			System.out.println("Chamou m�todo de listagem");
			CarrinhoDAO carrinDAO = new CarrinhoDAO();
			List<Carrinho> lista = carrinDAO.getLista1();
			ModelAndView model = new ModelAndView("Carrinho/TudoCar");
			model.addObject("carrinho", lista);
			return model;
		}
}
