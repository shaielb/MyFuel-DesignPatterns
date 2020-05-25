package cor.organizer;

import cor.link.node.Node;

class Link<TMessage> {

	private  Node<TMessage> _node;
	
	private Link<TMessage> _next;
	
	public Link(Node<TMessage> node) {
		_node = node;
	}
	
	public void execute(TMessage message) {
		if (_node.execute(message) && _next != null) {
			_next.execute(message);
		}
	}
	
	public void setNext(Link<TMessage> next) {
		_next = next;
	}
}
