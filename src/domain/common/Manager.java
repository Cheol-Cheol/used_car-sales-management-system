package domain.common;

import java.util.NoSuchElementException;

import domain.employee.Employee;

public interface Manager<T> {

	public void addItem(T item);

	public void getList();

	public void getItem(int id);

	public void deleteItem(int id);

}
