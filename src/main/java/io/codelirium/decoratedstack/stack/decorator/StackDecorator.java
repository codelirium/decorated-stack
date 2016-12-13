package io.codelirium.decoratedstack.stack.decorator;

import io.codelirium.decoratedstack.stack.core.IStack;
import java.util.Optional;


public class StackDecorator<T> implements IStack<T> {

	private IStack<T> stack;


	public StackDecorator(final IStack<T> stack) {

		this.stack = stack;

	}


	@Override
	public void push(final T element) {

		stack.push(element);

	}


	@Override
	public Optional<T> pop() {

		return stack.pop();

	}


	@Override
	public int size() {

		return stack.size();

	}

	@Override
	public void printContent() {

		stack.printContent();

	}
}
