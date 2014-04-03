package models

import scala.math.BigDecimal
import scala.math.BigDecimal.RoundingMode

object Taxes {

    def definingBigDecimal(number: Double) = new BigDecimal(new java.math.BigDecimal(number)).setScale(6, RoundingMode.HALF_DOWN)

    def emolumentOnBuying = definingBigDecimal(0.00005)

    def emolumentOnSelling = definingBigDecimal(0.00005)

    def negotiatingOnBuying = definingBigDecimal(0.000285)

    def negotiatingOnSelling = definingBigDecimal(0.000285)

    def liquidationOnSelling = definingBigDecimal(0.000275)
}
