package cor.organizer;

import ioc.IIocContainer;
import ioc.IocContainer;

public class CorFactory {

	/**
	 * 
	 */
	private static IIocContainer _iocContainer = new IocContainer();

	/**
	 * @param <TKey>
	 * @param <TMessage>
	 * @return
	 * @throws Exception
	 */
	public static <TKey, TMessage> IOrganizer<TKey, TMessage> createOrganizer() throws Exception {
		IOrganizer<TKey, TMessage> organizer = new Organizer<TKey, TMessage>(_iocContainer);
		return organizer;
	}
}
