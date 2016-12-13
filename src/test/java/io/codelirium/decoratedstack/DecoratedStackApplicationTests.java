package io.codelirium.decoratedstack;

import io.codelirium.decoratedstack.stack.core.BasicStack;
import io.codelirium.decoratedstack.stack.echo.EchoStack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest
@RunWith(SpringRunner.class)
public class DecoratedStackApplicationTests {

	private BasicStack<String> basicStack;
	private EchoStack<String>  echoStack;


	public void setupBasicStack() {

		basicStack = new BasicStack<>();

	}

	public void setupEchoStack() {

		echoStack = new EchoStack<>(new BasicStack<>());

	}


	@Test
	public void testThatStringElementIsPushedInBasicStack() {

		setupBasicStack();


		basicStack.push("FOO");

		assertThat(basicStack.size(), is(1));
	}

	@Test
	public void testThatStringElementIsPoppedFromBasicStack() {

		setupBasicStack();


		basicStack.push("FOO");

		final Optional<String> element = basicStack.pop();

		assertThat(basicStack.size(), is(0));
		assertThat(element.isPresent(), is(Boolean.TRUE));
		assertThat(element.get(), is("FOO"));
	}

	@Test
	public void testThatStringElementIsPushedInEchoStack() {

		setupEchoStack();


		echoStack.push("FOO");

		assertThat(echoStack.size(), is(2));
	}

	@Test
	public void testThatStringElementIsPoppedFromEchoStack() {

		setupEchoStack();


		echoStack.push("FOO");

		final Optional<String> element = echoStack.pop();

		assertThat(echoStack.size(), is(0));
		assertThat(element.isPresent(), is(Boolean.TRUE));
		assertThat(element.get(), is("FOO"));
	}
}
