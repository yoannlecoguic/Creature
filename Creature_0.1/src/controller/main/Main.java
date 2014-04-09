package controller.main;

import java.awt.Dimension;

import model.main.Model;
import view.main.View;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		//CHECK .INI FILE
		View view = new View();
		Controller controller = new Controller(model, view);
	}

}
