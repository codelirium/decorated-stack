package io.codelirium.decoratedstack.stack.echo;

import io.codelirium.decoratedstack.stack.core.IStack;
import io.codelirium.decoratedstack.stack.decorator.StackDecorator;
import java.util.Optional;


public class EchoStack<T> extends StackDecorator<T> {

	public EchoStack(final IStack<T> stack) {

		super(stack);

	}


	@Override
	public void push(final T element) {

		super.push(element);

		super.push(element);

	}

	@Override
	public Optional<T> pop() {

		super.pop();


		return super.pop();
	}
}
