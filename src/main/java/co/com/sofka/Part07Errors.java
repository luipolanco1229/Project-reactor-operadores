/*
 * Copyright (c) 2011-2017 Pivotal Software Inc, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package co.com.sofka;


import co.com.sofka.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Part07Errors {



	public Mono<User> betterCallSaulForBogusMono(Mono<User> error) {
		return error.onErrorReturn(User.SAUL);
	}

	public Flux<User> betterCallSaulAndJesseForBogusFlux(Flux<User> error) {
		return error.onErrorReturn(User.SAUL);
	}

	public Flux<User> capitalizeMany(Flux<User> just) {
		return just.map(this::capitalizeUser);
	}
	User capitalizeUser(User user) throws GetOutOfHereException {
		if (user.equals(User.SAUL)) {
			throw new GetOutOfHereException();
		}
		return new User(user.getUsername(), user.getFirstname(), user.getLastname());
	}

	public class GetOutOfHereException extends Exception {
	}

}
