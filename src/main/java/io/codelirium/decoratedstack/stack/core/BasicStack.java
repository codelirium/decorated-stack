package io.codelirium.decoratedstack.stack.core;

import com.google.common.collect.Lists;
import org.springframework.util.Assert;
import java.util.List;
import java.util.Optional;


public final class BasicStack<T> implements IStack<T> {

	private final List<T> content;


	public BasicStack() {

		content = Lists.newLinkedList();

	}


	@Override
	public synchronized void push(final T element) {

		Assert.notNull(element, "The element cannot be null.");


		content.add(element);

	}

	@Override
	public synchronized Optional<T> pop() {

		if (content.isEmpty()) {

			return Optional.empty();

		}


		return Optional.of(content.remove(content.size() - 1));
	}

	@Override
	public int size() {

		return content.size();

	}

	@Override
	public void printContent() {

		if (content.isEmpty()) {

			System.out.println("EMPTY");

		} else {

			content.forEach(element -> System.out.println(element.toString()));

		}
	}
}
