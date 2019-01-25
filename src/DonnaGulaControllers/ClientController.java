package DonnaGulaControllers;



import java.util.List;

import javax.servlet.http.HttpSession;

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
		System.out.println("Chamou meu método de formulário");
		return "cliente/form";
	}
	
	@PostMapping("/cliente")
	public String adicionar(Cliente cliente) {
		System.out.println("Chamou o método de adicionar");
		ClientDAO clientDAO = new ClientDAO();
		clientDAO.inserir(cliente);
		return "redirect:cliente/";
	}
	
	@GetMapping("/cliente")
	public ModelAndView listar() {
		System.out.println("Chamou método de listagem");
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
	@RequestMapping("cliente/selecionar")
	public ModelAndView selecionar(Cliente cliente) {
		ClientDAO clienteDAO = new ClientDAO();
		cliente = clienteDAO.getById(cliente.getId());
		
		ModelAndView model = new ModelAndView("cliente/cliente-alterar");
		model.addObject("cliente", cliente);
		return model;
	}
	@RequestMapping ("cliente/alterar")
	public String alterar(Cliente cliente) {
		System.out.println("Chamou o metodo alterar");
		ClientDAO clientDAO = new ClientDAO();
		clientDAO.alterar(cliente);
		
		return "redirect:../cliente";
}
	 @RequestMapping("loginForm")
     public String loginForm() {
		 System.out.println("Login Formulario");
         return "cliente/formulario-login";
     }
	 
	 @RequestMapping("/efetuaLogin")
     public String efetuaLogin(Cliente cliente, HttpSession session) {
         if(new ClientDAO().usuarioExiste() != null) {
             session.setAttribute("usuarioLogado", cliente);
             return "menu";
         }
         return "redirect:../cliente";
}
	@RequestMapping("/cliente/login")
	public String login() {
		System.out.println("Chamou meu método entrar");
		return "cliente/login";
}
}
