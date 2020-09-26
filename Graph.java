import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Graph {

	private Map<Integer,Integer> vertex;
	private Map<String, Edge> edges;
	private static Logger logger;
	
	public Graph() {
		vertex = new HashMap<Integer,Integer>();
		edges = new HashMap<String,Edge>();
		if (logger == null){
			
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING); //Cambiar este parámetro para ver distintos levels
			
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}
	}
	
	public void addNode(int node) {
		boolean esta = vertex.containsKey(node);
		if (!esta) { 
			vertex.put(node,node);
			logger.fine("Nodo "+node+" agregado");
		}
		else logger.info("El nodo "+node+" se quiso agregar pero ya estaba en la estructura");
	}
	public void removeNode(int node) {
		boolean esta = vertex.containsKey(node);
		if (esta) {
			Integer valueViejo = vertex.remove(node);
			logger.fine("Nodo "+node+" removido");
		}
		else logger.warning("Se quiso remover el nodo "+node+" pero no estaba en la estructura");
	}
	public void addEdge(int node1, int node2) {
		boolean estaN1 = vertex.containsKey(node1);
		boolean estaN2 = vertex.containsKey(node2);
		if (estaN1 && estaN2) { //ambos parámetros pertenecen a la estructura
			Edge edge = new Edge(node1, node2);
			String key = node1+","+node2;
			boolean estaArco = edges.containsKey(key);
			if (!estaArco) {
				edges.put(key, edge);
				logger.fine("Arco "+key+" agregado");
			}
			else logger.info("El arco "+key+" se quiso agregar pero ya estaba en la estructura");
		}
		else logger.warning("No se pudo agregar arco porque al menos uno de los nodos de parámetro no pertenecía a la estructura");
	}
	public void removeEdge(int node1, int node2) {
		boolean estaN1 = vertex.containsKey(node1);
		boolean estaN2 = vertex.containsKey(node2);
		if (estaN1 && estaN2) { //ambos parámetros pertenecen a la estructura
			String key = node1+","+node2;
			Edge valueViejo = edges.remove(key); 
			//valueViejo es el anterior asociado a key, si hubiera uno. Si no es null.
			if (valueViejo != null) { //había un arco
				logger.fine("Arco "+key+" removido");
			}
			else logger.warning("Se quiso remover el arco "+key+" pero no estaba en la estructura");
		}
		else logger.warning("No se pudo remover arco porque al menos uno de los nodos de parámetro no pertenecía a la estructura");
	}
}
/* fine: salio todo bien.
 * info: se quiso agregar algo repetido.
 * warning: salio mal. Faltaba lo que se quería eliminar o los parámetros 
 * para operar con edges estaban mal.
 */
