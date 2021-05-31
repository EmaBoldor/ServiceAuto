package ro.emanuel.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.dao.AngajatDAO;
import ro.emanuel.dao.ClientDAO;
import ro.emanuel.pojo.Angajat;
import ro.emanuel.pojo.Client;


@Controller
public class ClientController {

	@RequestMapping(value = "listClient.htm", method = RequestMethod.GET)
	public ModelAndView listClienti() throws SQLException {
		ModelMap model = new ModelMap();

		ArrayList<Client> customers = ClientDAO.getClienti();
		model.put("customers", customers);
		
		ArrayList<Angajat> angajati =AngajatDAO.getAngajati();
		HashMap<Integer, String> angajatiMap=new HashMap<Integer, String>();
		for(Angajat a:angajati) {
			angajatiMap.put(a.getId(), a.getCalificare());
		}
		model.put("angajati", angajatiMap);

		return new ModelAndView("listClient.jsp", model);
	}

//	Read details

	@RequestMapping(value = "detaliiClient.htm", method = RequestMethod.GET)
	public ModelAndView detailsClient(@RequestParam Integer id) throws SQLException {
		ModelMap model = new ModelMap();

		Client st = ClientDAO.getClientById(id);
		model.put("client", st);
		
		ArrayList<Angajat> angajati =AngajatDAO.getAngajati();
		for(Angajat a:angajati) {
			if(a.getId()==st.getAngajatId()) {
				model.put("calificareAngajat", a.getCalificare());
				//model.put("calificareAngajat", a.getCalificare());
			}
		}

		return new ModelAndView("detaliiClient.jsp", model);

	}

//	Create

	@RequestMapping(value = "adaugare-client.htm", method = RequestMethod.GET)
	public ModelAndView showAdClient(Model model) throws SQLException {

		Client st = new Client();
		model.addAttribute("clientForm", st);
		
		ArrayList<Angajat> angajati=AngajatDAO.getAngajati();
		model.addAttribute("angajati", angajati);

		return new ModelAndView("addClient.jsp", "model", model);
	}
	
	@RequestMapping(value="adaugare-client-save.htm", method=RequestMethod.POST)
	public ModelAndView addClient(@ModelAttribute("clientForm") Client st, 
			ModelMap model, BindingResult result) {
		
		try {
			ClientDAO.createClient(st);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/listClient.htm");
	}

	//delete
	@RequestMapping(value = "deleteClient.htm", method = RequestMethod.GET)
	public ModelAndView deleteClient(@RequestParam Integer id) throws SQLException {

		ClientDAO.deleteClient(id);

		return new ModelAndView("redirect:/listClient.htm");

	}
	
	//update/ edit
	@RequestMapping(value = "editare-client.htm", method = RequestMethod.GET)
	public ModelAndView showEditAdClient(@RequestParam Integer id, Model model) throws SQLException{

		Client st =ClientDAO.getClientById(id);
		model.addAttribute("clientForm", st);

		return new ModelAndView("editClient.jsp", "model", model);
	}
	
	@RequestMapping(value="editare-client-save.htm", method=RequestMethod.POST)
	public ModelAndView editClient(@ModelAttribute("clientForm") Client st, 
			ModelMap model, BindingResult result) {
		
		try {
			ClientDAO.updateClient(st);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/listClient.htm");
	}
}
