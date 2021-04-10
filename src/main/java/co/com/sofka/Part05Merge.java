package co.com.sofka;


import co.com.sofka.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to merge flux.
 *
 */
public class Part05Merge {

	public Flux<User> mergeFluxWithInterleave(Flux<User> all, Flux<User> all1) {
		return all.mergeWith(all1);
	}

	public Flux<User> mergeFluxWithNoInterleave(Flux<User> all, Flux<User> all1) {
		return all.concatWith(all1);
	}

	public Flux<User> createFluxFromMultipleMono(Mono<User> skylerMono, Mono<User> marieMono) {
		return Flux.from(skylerMono.concatWith(marieMono));
	}
}
