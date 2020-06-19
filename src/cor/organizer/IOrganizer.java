package cor.organizer;

import java.util.List;
import java.util.Map;

import ioc.IIocContainer;

public interface IOrganizer<TKey, TMessage> {

	/**
	 * @param chainDescription
	 * @throws Exception
	 */
	public void initialize(Map<TKey, List<String>> chainDescription) throws Exception;
	
	/**
	 * @param key
	 * @param message
	 */
	public void execute(TKey key, TMessage message);
	
	/**
	 * @return
	 */
	public IIocContainer getIocContainer();
}
