package co.com.sofka;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
public class Part01Flux {


	public Flux<String> emptyFlux() {
		return Flux.empty();
	}

	public Flux<String> fooBarFluxFromValues() {
		String foo = "foo";
		String bar = "bar";
		return Flux.just(foo, bar);
	}

	public Flux<String> fooBarFluxFromList() {
		List<String> list = new ArrayList<>();
		list.add("foo");
		list.add("bar");
		return Flux.fromIterable(list) ;
	}

	public Flux<String> errorFlux() {

		return Flux.error(new IllegalStateException("Error state exception"));
	}

	public Flux<Long> counter() {
		return Flux.interval(Duration.ofMillis(100)).take(10);
	}
}
