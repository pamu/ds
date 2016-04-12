package ds;

public class Main {
	public static void main(String ... args) {
		PQ<Node<Integer>> pqueue = new PQ<>();
		Node<Integer> node1 = new Node<>(1, 1);
		Node<Integer> node2 = new Node<>(2, 2);
		Node<Integer> node3 = new Node<>(3, 3);
		Node<Integer> node4 = new Node<>(4, 4);
		pqueue.insert(node1);
		pqueue.insert(node4);
		pqueue.insert(node2);
		pqueue.insert(node3);
		for(int i = 0; i < 4; i ++) {
			Runnable r = () -> System.out.println(pqueue.delMax() + "");
			r.run();
		}
	}
}