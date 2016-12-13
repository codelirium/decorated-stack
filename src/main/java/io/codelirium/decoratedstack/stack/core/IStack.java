package io.codelirium.decoratedstack.stack.core;

import java.util.Optional;


public interface IStack<T> {

	void push(final T element);

	Optional<T> pop();

	int size();

	void printContent();

}
