package micronaut.session

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("micronaut.session")
		.start()
}
