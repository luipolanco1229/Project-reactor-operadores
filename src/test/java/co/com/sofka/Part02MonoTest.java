package co.com.sofka;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


public class Part02MonoTest {

	Part02Mono workshop = new Part02Mono();


	@Test
	public void empty() {
		Mono<String> mono = workshop.emptyMono();
		StepVerifier.create(mono)
				.verifyComplete();
	}


	@Test
	public void noSignal() {
		Mono<String> mono = workshop.monoWithNoSignal();
		StepVerifier
				.create(mono)
				.expectSubscription()
				.expectTimeout(Duration.ofSeconds(1))
				.verify();
	}


	@Test
	public void fromValue() {
		Mono<String> mono = workshop.fooMono();
		StepVerifier.create(mono)
				.expectNext("foo")
				.verifyComplete();
	}


	@Test
	public void error() {
		Mono<String> mono = workshop.errorMono();
		StepVerifier.create(mono)
				.verifyError(IllegalStateException.class);
	}

}
