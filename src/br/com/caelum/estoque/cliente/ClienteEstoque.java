package br.com.caelum.estoque.cliente;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ClienteEstoque{

	//wsimport -s src -p br.com.caelum.estoque.cliente    http://localhost:8080/estoque/EstoqueWS?wsdl
	//wsgen -cp bin br.com.xxx -wsdl -inlineSchemas
	
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8080/estoquews-web/EstoqueWS?wsdl");
        QName qname = new QName("http://ws.estoque.caelum.com.br/", "EstoqueWS");

        Service service = Service.create(url, qname);

        EstoqueWS cliente = service.getPort(EstoqueWS.class);


    	Filtros filtros = new Filtros();
        Filtro filtro = new Filtro();
        filtro.setNome("IPhone");
        filtro.setTipo(TipoItem.CELULAR);
		filtros.getFiltro().add(filtro);

        ListaItens lista = cliente.todosOsItens(filtros);

        for (Item item : lista.item) {
            System.out.println(item.getNome());
        }
    }
}