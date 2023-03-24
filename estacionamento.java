import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
		} else if (!(placas[vaga - 1] == null)) {
			throw new Exception("Vaga já ocupada");
		}
		try (FileWriter fileWriter = new FileWriter(new File("./store/historico.csv"),
				true)) {
			LocalDateTime localDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			fileWriter.append(localDateTime.format(formatter) + ";" + vaga + ";" + placa
					+ ";" + " Entrada" + "\n");
			fileWriter.flush();
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
		try (FileWriter fileWriter = new FileWriter(new File("./store/historico.csv"),
				true)) {
			LocalDateTime localDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			fileWriter.append(localDateTime.format(formatter) + ";" + vaga + ";"
					+ placas[vaga - 1] + ";" + " Saida" + "\n");
			fileWriter.flush();
			fileWriter.close();
		}
		placas[vaga - 1] = null;
	}

	public int consultarPlaca(String placa) {
		for (int i = 0; i < placas.length; i++) {
			if (placas[i] == placa)
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
		if (placas.length == 0) {
			throw new Exception("Não existem dados para serem gravados");
		}
		FileWriter fileWriter = new FileWriter(new File("./store/placas.csv"), true);
		for (int i = 0; i < placas.length - 2; i++) {
			if (!(placas[i] == null)) {
				fileWriter.append((i + 1) + ";" + placas[i] + "\n");
			}
		}
		fileWriter.append((placas.length) + ";" + placas[placas.length - 1]);
		fileWriter.close();

	}
	
	public void lerDados() throws Exception{
		Scanner arquivo = new Scanner(new File("./store/placas.csv"));
		ArrayList<Integer> livres = this.listarLivres();
		while (arquivo.hasNextLine()) {
			String[] salvo = arquivo.nextLine().split(";");
			if(livres.contains(Integer.parseInt(salvo[0]))) {
				this.entrar(salvo[1], Integer.parseInt(salvo[0]));
			}else {
				this.sair(Integer.parseInt(salvo[0]));
				this.entrar(salvo[1], Integer.parseInt(salvo[0]));
			}
		}
		arquivo.close();
	}
}
