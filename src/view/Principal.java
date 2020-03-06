package view;

import controller.OperacoesController;

public class Principal {

	public static void main(String[] args) {

		OperacoesController oc = new OperacoesController();
//		oc.os();
		
		String path = "notepad.exe";
//		oc.callProcess(path);
		oc.killProcess(path);
	}

}
