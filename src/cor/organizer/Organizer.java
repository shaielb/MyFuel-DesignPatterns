package cor.organizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cor.link.node.Node;
import ioc.IIocContainer;

class Organizer<TKey, TMessage> implements IOrganizer<TKey, TMessage> {

	/**
	 * 
	 */
	private IIocContainer _iocContainer;

	/**
	 * 
	 */
	private Map<TKey, Link<TMessage>> _selector = new HashMap<TKey, Link<TMessage>>();

	/**
	 * @param iocContainer
	 */
	public Organizer(IIocContainer iocContainer) {
		_iocContainer = iocContainer;
	}

	/**
	 *
	 */
	public void initialize(Map<TKey, List<String>> chainDescription) throws Exception {
		for (Entry<TKey, List<String>> entry : chainDescription.entrySet()) {
			List<String> list = entry.getValue();
			Link<TMessage> prev = null;
			for (String item : list) {
				Node<TMessage> node = _iocContainer.resolve(item);
				node.setIocContainer(_iocContainer);
				node.initialize();
				Link<TMessage> link = new Link<TMessage>(node);
				if (prev == null) {
					prev = link;
					_selector.put(entry.getKey(), prev);
				}
				else {
					prev.setNext(link);
					prev = link;
				}
			}
		}
	}

	/**
	 *
	 */
	public void execute(TKey key, TMessage message) {
		_selector.get(key).execute(message);
	}

	/**
	 *
	 */
	public IIocContainer getIocContainer() {
		return _iocContainer;
	}
}
