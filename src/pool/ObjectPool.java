package pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ObjectPool<T> {

	public interface Instansiate<T> {
		T create();
	}

	private Instansiate<T> _instantaite;

	private BlockingQueue<T> _pool;

	public ObjectPool(Instansiate<T> instatiate) {
		_pool = new LinkedBlockingQueue<T>();
		_instantaite = instatiate;
	}
	
	public ObjectPool(int capacity, Instansiate<T> instatiate) {
		_pool = new LinkedBlockingQueue<T>(capacity);
		_instantaite = instatiate;
	}

	public void push(T item) throws InterruptedException {
		_pool.put(item);
	}

	public T pop() {
		T item = _pool.poll();
		if (item == null) {
			return _instantaite.create();
		}
		return item;
	}
}
