
public class TesteEstacionamento {

	public static void main(String[] args) {
		try {
			Estacionamento est = new Estacionamento(5);
			est.entrar("MMY9325", 1);
			est.entrar("MMY9324", 2);
			est.sair(2);
			est.sair(1);
			est.entrar("MMY9324", 2);
			est.gravarDados();
			System.out.println(est.listarGeral());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
