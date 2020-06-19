package cor.link.node;

import ioc.IIocContainer;

public abstract class Node<TMessage> {

	/**
	 * 
	 */
	protected IIocContainer _iocContainer;

	/**
	 * @throws Exception
	 */
	public abstract void initialize() throws Exception;

	/**
	 * @param message
	 * @return
	 */
	public abstract boolean execute(TMessage message);

	/**
	 * @param iocContainer
	 */
	public void setIocContainer(IIocContainer iocContainer) {
		_iocContainer = iocContainer;
	}
}
