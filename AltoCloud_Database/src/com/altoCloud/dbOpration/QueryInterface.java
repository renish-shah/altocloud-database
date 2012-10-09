package com.altoCloud.dbOpration;

import java.util.List;

public interface QueryInterface<T> {
	
	
	    void add(T item);

	    void remove(T item);

	    List<T> getAll();

	    T findById(long id);

}
