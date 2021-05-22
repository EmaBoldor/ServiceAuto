package ro.emanuel.controller;

import java.sql.SQLException;
import java.util.ArrayList;

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
import ro.emanuel.pojo.Angajat;


@Controller
public class AngajatController {

	@RequestMapping(value = "listAngajat.htm", method = RequestMethod.GET)
	public ModelAndView listAngajati() throws SQLException {
		ModelMap model = new ModelMap();

		ArrayList<Angajat> employees = AngajatDAO.getAngajati();
		model.put("employees", employees);

		return new ModelAndView("listAngajat.jsp", model);
	}

//	Read details

	@RequestMapping(value = "detaliiAngajat.htm", method = RequestMethod.GET)
	public ModelAndView detailsAngajat(@RequestParam Integer id) throws SQLException {
		ModelMap model = new ModelMap();

		Angajat st = AngajatDAO.getAngajatById(id);
		model.put("angajat", st);

		return new ModelAndView("detaliiAngajat.jsp", model);

	}

//	Create

	@RequestMapping(value = "adaugare-angajat.htm", method = RequestMethod.GET)
	public ModelAndView showAdAngajat(Model model) {

		Angajat st = new Angajat();
		model.addAttribute("angajatForm", st);

		return new ModelAndView("addAngajat.jsp", "model", model);
	}
	
	@RequestMapping(value="adaugare-angajat-save.htm", method=RequestMethod.POST)
	public ModelAndView addAngajat(@ModelAttribute("angajatForm") Angajat st, 
			ModelMap model, BindingResult result) {
		
		try {
			AngajatDAO.createAngajat(st);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/listAngajat.htm");
	}

	//delete
	@RequestMapping(value = "deleteAngajat.htm", method = RequestMethod.GET)
	public ModelAndView deleteAngajat(@RequestParam Integer id) throws SQLException {

		AngajatDAO.deleteAngajat(id);

		return new ModelAndView("redirect:/listAngajat.htm");

	}
	
	//update/ edit
	@RequestMapping(value = "editare-angajat.htm", method = RequestMethod.GET)
	public ModelAndView showEditAdAngajat(@RequestParam Integer id, Model model) throws SQLException{

		Angajat st =AngajatDAO.getAngajatById(id);
		model.addAttribute("angajatForm", st);

		return new ModelAndView("editAngajat.jsp", "model", model);
	}
	
	@RequestMapping(value="editare-angajat-save.htm", method=RequestMethod.POST)
	public ModelAndView editAngajat(@ModelAttribute("angajatForm") Angajat st, 
			ModelMap model, BindingResult result) {
		
		try {
			AngajatDAO.updateAngajat(st);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/listAngajat.htm");
	}
}
