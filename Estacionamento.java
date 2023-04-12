
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Estacionamento {
	private String[] placas;

	public Estacionamento(int n) throws Exception {
		if (n < 0) {
			throw new Exception("Valor de N inválido");
		}
		placas = new String[n];
	}

	public void entrar(String placa, int vaga) throws Exception {
		if (vaga > placas.length || vaga <= 0) {
			throw new Exception("Vaga não Existe");
		} else if (placas[vaga - 1] != null) {
			throw new Exception("Vaga já ocupada");
		}
		try (FileWriter fileWriter = new FileWriter(new File("./historico.csv"),
				true)) {
			LocalDateTime localDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			fileWriter.write(localDateTime.format(formatter) + ";" + vaga + ";" + placa
					+ ";" + " Entrada" + "\n");
			fileWriter.close();
		}
		placas[vaga - 1] = placa;
	}

	public void sair(int vaga) throws Exception {
		if (vaga > placas.length || vaga <= 0) {
			throw new Exception("Vaga não Existe");
		} else if (placas[vaga - 1] == (null)) {
			throw new Exception("Vaga já desocupada");
		}
		try (FileWriter fileWriter = new FileWriter(new File("./historico.csv"),
				true)) {
			LocalDateTime localDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			fileWriter.write(localDateTime.format(formatter) + ";" + vaga + ";"
					+ placas[vaga - 1] + ";" + " Saida" + "\n");
			fileWriter.close();
		}
		placas[vaga - 1] = null;
	}

	public int consultarPlaca(String placa) {
		for (int i = 0; i < placas.length; i++) {
			if (Objects.equals(placas[i], placa))
				return i + 1;
		}
		return -1;
	}

	public void transferir(int vaga1, int vaga2) throws Exception {
		if (((vaga1 <= 0) || (vaga2 <= 0)) || ((vaga1 > placas.length) || (vaga2 > placas.length))) {
			throw new Exception("Vaga não Existe");
		} else if (!(placas[vaga2 - 1] == (null))) {
			throw new Exception("Vaga de destino já ocupada");
		} else if (placas[vaga1 - 1] == (null)) {
			throw new Exception("Vaga de origem já desocupada");
		}

		placas[vaga2 - 1] = placas[vaga1 - 1];
		placas[vaga1 - 1] = null;
	}

	public String[] listarGeral() {
		String[] listaGeral = new String[placas.length];
		for (int i = 0; i < placas.length; i++) {
			if (placas[i] == (null))
				listaGeral[i] = "livre";
			else
				listaGeral[i] = placas[i];
		}
		return listaGeral;

	}

	public ArrayList<Integer> listarLivres() {
		ArrayList<Integer> vagasLivres = new ArrayList<>();
		for (int i = 0; i < placas.length; i++) {
			if ((placas[i] == (null))) {
				vagasLivres.add(i + 1);
			}
		}
		return vagasLivres;
	}

	public void gravarDados() throws Exception {
			
		FileWriter fileWriter = new FileWriter(new File("./placas.csv"));
		for (int i = 0; i < placas.length - 2; i++) {
			if (!(placas[i] == null)) {
				fileWriter.write((i + 1) + ";" + placas[i] + "\n");
			}else if(i == placas.length -1) {
				
				fileWriter.write((placas.length) + ";" + placas[placas.length - 1]);
			}
		}
		fileWriter.flush();
		fileWriter.close();
		

	}
	
	public void lerDados() throws Exception{
		File salvos = new File("./placas.csv");
		if(salvos.exists()) {
			
			Scanner arquivo = new Scanner(new File("./placas.csv"));
			while (arquivo.hasNextLine()) {
				String[] salvo = arquivo.nextLine().split(";");
				placas[Integer.parseInt(salvo[0]) - 1] = salvo[1]; 
				
				
			}
			arquivo.close();
		}
	}
}
