package cor.link.node;

import ioc.IIocContainer;

public abstract class Node<TMessage> {

	protected IIocContainer _iocContainer;

	public abstract void initialize() throws Exception;

	public abstract boolean execute(TMessage message);

	public void setIocContainer(IIocContainer iocContainer) {
		_iocContainer = iocContainer;
	}
}
