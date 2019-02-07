package br.com.caelum.estoque.cliente;

public class TesteServicoWeb {
 public static void main(String[] args) {

		EstoqueWS cliente = new EstoqueWS_Service().getEstoqueWSPort();

		TokenUsuario tokenUsuario = new TokenUsuario();
		
		
		//cliente.cadastrarItem(parameters, tokenUsuario);
		
		Filtros filtros = new Filtros();
		Filtro filtro = new Filtro();
		filtro.setNome("IPhone");
		filtro.setTipo(TipoItem.CELULAR);
		filtros.getFiltro().add(filtro);

		ListaItens lista = cliente.todosOsItens(filtros);

	 System.out.println("Lista: " +  lista.toString());
} 
	
	
}
