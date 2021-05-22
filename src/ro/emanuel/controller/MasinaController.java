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

import ro.emanuel.dao.MasinaDAO;
import ro.emanuel.pojo.Masina;

@Controller
public class MasinaController {

	@RequestMapping(value = "listMasina.htm", method = RequestMethod.GET)
	public ModelAndView listMasini() throws SQLException {
		ModelMap model = new ModelMap();

		ArrayList<Masina> cars = MasinaDAO.getMasini();
		model.put("cars", cars);

		return new ModelAndView("listMasina.jsp", model);
	}

//	Read details

	@RequestMapping(value = "detaliiMasina.htm", method = RequestMethod.GET)
	public ModelAndView detailsMasina(@RequestParam Integer id) throws SQLException {
		ModelMap model = new ModelMap();

		Masina st =MasinaDAO.getMasinaById(id);
		model.put("masina", st);

		return new ModelAndView("detaliiMasina.jsp", model);

	}

//	Create

	@RequestMapping(value = "adaugare-masina.htm", method = RequestMethod.GET)
	public ModelAndView showAdMasina(Model model) {

		Masina st = new Masina();
		model.addAttribute("masinaForm", st);

		return new ModelAndView("addMasina.jsp", "model", model);
	}
	
	@RequestMapping(value="adaugare-masina-save.htm", method=RequestMethod.POST)
	public ModelAndView addMasina(@ModelAttribute("masinaForm") Masina st, 
			ModelMap model, BindingResult result) {
		
		try {
			MasinaDAO.createMasina(st);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/listMasina.htm");
	}

	//delete
	@RequestMapping(value = "deleteMasina.htm", method = RequestMethod.GET)
	public ModelAndView deleteMasina(@RequestParam Integer id) throws SQLException {

		MasinaDAO.deleteMasina(id);

		return new ModelAndView("redirect:/listMasina.htm");

	}
	
	//update/ edit
	@RequestMapping(value = "editare-masina.htm", method = RequestMethod.GET)
	public ModelAndView showEditAdMasina(@RequestParam Integer id, Model model) throws SQLException{

		Masina st =MasinaDAO.getMasinaById(id);
		model.addAttribute("masinaForm", st);

		return new ModelAndView("editMasina.jsp", "model", model);
	}
	
	@RequestMapping(value="editare-masina-save.htm", method=RequestMethod.POST)
	public ModelAndView editMasina(@ModelAttribute("masinaForm") Masina st, 
			ModelMap model, BindingResult result) {
		
		try {
			MasinaDAO.updateMasina(st);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/listMasina.htm");
	}
}
