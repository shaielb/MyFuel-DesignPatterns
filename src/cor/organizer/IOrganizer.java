package cor.organizer;

import java.util.List;
import java.util.Map;

import ioc.IIocContainer;

public interface IOrganizer<TKey, TMessage> {

	public void initialize(Map<TKey, List<String>> chainDescription) throws Exception;
	
	public void execute(TKey key, TMessage message);
	
	public IIocContainer getIocContainer();
}
