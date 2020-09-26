
public class Tester {

	public static void main(String[] args) {
		Graph grafo = new Graph();
		//imprimen FINE, testean add
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(3);
		grafo.addEdge(1, 2);
		grafo.addEdge(2, 3);
		//imprimen INFO, testean add de elementos que ya estaban
		grafo.addNode(2); //nodo repetido
		grafo.addEdge(1, 2); //arco repetido
		//imprimen WARNING, testean operaciones inv�lidas de remove
		grafo.removeNode(5); //nodo que no est�
		grafo.removeEdge(2, 1); //arco que no est�
		grafo.removeEdge(5, 6); //par�metros no est�n en la estructura
		grafo.removeEdge(1, 7); //uno de los par�metros no est� en la estructura
		//imprimen FINE, testean remove v�lidos
		grafo.removeEdge(2, 3);
		grafo.removeNode(3);
	}

}
