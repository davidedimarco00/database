package controller;

import javax.swing.JFrame;

import model.Model;
import model.ModelImpl;
import model.SQLUtilities;
import model.SQLUtilitiesImpl;

public class MainControllerImpl implements MainController {
	Model model = new ModelImpl();
	
	@Override
	public void showForm(JFrame jframe) {
		this.model.showForm(jframe);
	}

}
