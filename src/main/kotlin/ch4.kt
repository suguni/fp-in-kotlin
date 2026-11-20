import arrow.core.Either
import arrow.core.raise.either

fun insuranceRateQuote(age: Int, speedTickets: Int): Double =
    age * speedTickets * 0.63

fun String.parseInt(): Either<Throwable, Int> =
    Either.catch { this.toInt() }

fun parseInsuranceRateQuote(age: String, speedTickets: String): Either<Throwable, Double> =
    either {
        val a = age.parseInt().bind()
        val t = speedTickets.parseInt().bind()
        insuranceRateQuote(a, t)
    }

fun main() {
    println(parseInsuranceRateQuote("32", "2").getOrNull())
}