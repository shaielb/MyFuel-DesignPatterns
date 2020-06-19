package cor.organizer;

import cor.link.node.Node;

class Link<TMessage> {

	/**
	 * 
	 */
	private  Node<TMessage> _node;
	
	/**
	 * 
	 */
	private Link<TMessage> _next;
	
	/**
	 * @param node
	 */
	public Link(Node<TMessage> node) {
		_node = node;
	}
	
	/**
	 * @param message
	 */
	public void execute(TMessage message) {
		if (_node.execute(message) && _next != null) {
			_next.execute(message);
		}
	}
	
	/**
	 * @param next
	 */
	public void setNext(Link<TMessage> next) {
		_next = next;
	}
}
