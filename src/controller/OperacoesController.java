package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OperacoesController {

	public OperacoesController() {
		super();
	}

	public void os() {
		String os = System.getProperty("os.name");
		String ver = System.getProperty("os.version");
		String arch = System.getProperty("os.arch");

		System.out.println(os + " versão: " + ver + " arquitetura: " + arch);

	}

	public void callProcess(String path) {
		try {
			Runtime.getRuntime().exec(path);
		} catch (IOException e) {
			if (e.getMessage().contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(path);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					System.err.println(e1.getMessage());
				}

			} else {
				System.err.println("File not found");
			}

		}

	}

	public void readProcess(String command) {

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			InputStream stream = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			while (line != null) {
				System.out.println(line);
				line = buffer.readLine();
			}
		} catch (IOException e) {
			System.err.println("Comando não encontrado");
		}

	}

	public void killProcess(String param) {

		String cmdPid = "TASKKILL /PID";
		String cmdNome = "TASKKILL /IM";

		StringBuffer buffer = new StringBuffer();
		int pid = 0;
		try {
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);

		} catch (NumberFormatException e) {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);

		}

	}

}
