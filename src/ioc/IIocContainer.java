package ioc;

import java.io.File;
import java.io.InputStream;

public interface IIocContainer {

	public void register(File xml, String node) throws Exception;
	
	public void register(InputStream xml, String node) throws Exception;
	
	public <T> void register(Class<T> item, String name);
	
	public <T> T resolve(String name) throws Exception;
}
