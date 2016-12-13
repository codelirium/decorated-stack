package io.codelirium.decoratedstack;

import io.codelirium.decoratedstack.stack.core.BasicStack;
import io.codelirium.decoratedstack.stack.core.IStack;
import io.codelirium.decoratedstack.stack.echo.EchoStack;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DecoratedStackApplication implements CommandLineRunner {

	public static void main(final String[] args) {

		SpringApplication.run(DecoratedStackApplication.class, args);

	}


	@Override
	public void run(final String... strings) throws Exception {

		final IStack<String> basicStack = new BasicStack<>();

		basicStack.push("FOO");
		basicStack.push("BAR");

		basicStack.printContent();

		basicStack.pop();
		basicStack.pop();

		basicStack.printContent();


		final EchoStack<String> echoStack = new EchoStack<>(basicStack);

		echoStack.push("FOO");

		echoStack.printContent();


		echoStack.pop();

		echoStack.printContent();

	}
}
