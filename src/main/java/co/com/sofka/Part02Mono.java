package co.com.sofka;

import reactor.core.publisher.Mono;

/**
 *
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 */
public class Part02Mono {


	public Mono<String> emptyMono() {
		return Mono.empty();
	}

	public Mono<String> monoWithNoSignal() {
		return Mono.never();
	}

	public Mono<String> fooMono() {
		return Mono.just("foo");
	}

	public Mono<String> errorMono() {
		return Mono.error(new IllegalStateException("Error Mono state Exception"));
	}
}
