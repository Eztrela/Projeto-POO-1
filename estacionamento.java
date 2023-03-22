import java.util.ArrayList;



public class Estacionamento {
	private String[] placas;
	
	public Estacionamento(int n) throws Exception {
		if (n < 0) {
			throw new Exception("Valor de N inválido");
		}
		placas = new String[n];
	}
	
	public void entrar(String placa, int vaga) throws Exception{
		if( vaga - 1 > placas.length || vaga - 1 < 0 ) {
			throw new Exception("Vaga não Existe");
		}else if(!(placas[vaga - 1].equals(null))){
			throw new Exception("Vaga já ocupada");
		}
		placas[vaga - 1] = placa;
	}
	
	public void sair(int vaga) throws Exception{
		if( vaga - 1 > placas.length || vaga - 1 < 0 ) {
			throw new Exception("Vaga não Existe");
		}else if(placas[vaga - 1].equals(null)){
			throw new Exception("Vaga já desocupada");
		}
		placas[vaga - 1] = null;
	}
	
	public int consultarPlaca(String placa) {
		for(int i = 0; i < placa.length() ; i++) {
			if(  placas[i].equals(placa))
				return i + 1;
		}
		return -1;
	}
	
	public void transferir(int vaga1,int vaga2) throws Exception {
		if (((vaga1-1 < 0) || (vaga2-1 < 0)) || ((vaga1 - 1 > placas.length) || (vaga2 - 1 > placas.length))) {
			throw new Exception("Vaga não Existe");
		}else if(!(placas[vaga2 - 1].equals(null))){
			throw new Exception("Vaga de destino já ocupada");
		}else if(placas[vaga1 - 1].equals(null)) {
			throw new Exception("Vaga de origem já desocupada");
		}
		
		placas[vaga2 - 1] = placas[vaga1 - 1];
		placas[vaga1 - 1] = null;
	}
	
	public String[] listarGeral() {
		String[] listaGeral = new String[placas.length];
		for(int i = 0; i < placas.length ; i++) {
			if(  placas[i].equals(null))
				listaGeral[i] = "livre";
			else
				listaGeral[i] = placas[i];
		}
		return listaGeral;
	
	}
	
	public ArrayList<Integer> listarLivres(){
		ArrayList<Integer> vagasLivres = new ArrayList<>();
		for(int i = 0; i < placas.length ; i++) {
			if (!(placas[i].equals(null))) {
				vagasLivres.add(i+1);
			}
		}
		return vagasLivres;
	}
	
	public void gravarDados() {
			
	}
	
}	
