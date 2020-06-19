package ioc;

import java.io.File;
import java.io.InputStream;

public interface IIocContainer {

	/**
	 * @param xml
	 * @param node
	 * @throws Exception
	 */
	public void register(File xml, String node) throws Exception;
	
	/**
	 * @param xml
	 * @param node
	 * @throws Exception
	 */
	public void register(InputStream xml, String node) throws Exception;
	
	/**
	 * @param <T>
	 * @param item
	 * @param name
	 */
	public <T> void register(Class<T> item, String name);
	
	/**
	 * @param <T>
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public <T> T resolve(String name) throws Exception;
}
