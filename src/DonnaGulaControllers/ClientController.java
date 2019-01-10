package DonnaGulaControllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DonnaGulaDAOS.ClientDAO;
import DonnaGulaModels.Cliente;


@Controller
public class ClientController {

	@RequestMapping("/cliente/form")
	public String form() {
		System.out.println("Chamou meu m�todo de formul�rio");
		return "cliente/form";
	}
	
	@PostMapping("/cliente")
	public String adicionar(Cliente cliente) {
		System.out.println("Chamou o m�todo de adicionar");
		ClientDAO clientDAO = new ClientDAO();
		clientDAO.inserir(cliente);
		return "redirect:cliente/";
	}
	
	@GetMapping("/cliente")
	public ModelAndView listar() {
		System.out.println("Chamou m�todo de listagem");
		ClientDAO ClientDAO = new ClientDAO();
		List<Cliente> lista = ClientDAO.getCliente();
		ModelAndView model = new ModelAndView("cliente/lista");
		model.addObject("cliente", lista);
		return model;
	}
	
	@RequestMapping ("/cliente/remover")
	public String remover(Cliente cliente) {
		System.out.println("Chamou o metodo remover");
		ClientDAO clientDAO = new ClientDAO();
		clientDAO.remover(cliente);
		
		return "redirect:../cliente";
}
	@RequestMapping ("/cliente/alterar")
	public String alterar(Cliente cliente) {
		System.out.println("Chamou o metodo alterar");
		ClientDAO clientDAO = new ClientDAO();
		clientDAO.alterar(cliente);
		
		return "redirect:../cliente";
}
	@RequestMapping("/cliente/login")
	public String login() {
		System.out.println("Chamou meu m�todo entrar");
		return "cliente/login";
}
}
