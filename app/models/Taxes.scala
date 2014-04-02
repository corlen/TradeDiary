package models

import java.math.BigDecimal

object Taxes {

    def definingBigDecimal(number: Double) = new BigDecimal(number).setScale(6, BigDecimal.ROUND_DOWN)

    def emolumentOnBuying = definingBigDecimal(0.00005)

    def emolumentOnSelling = definingBigDecimal(0.00005)

    def negotiatingOnBuying = definingBigDecimal(0.000285)

    def negotiatingOnSelling = definingBigDecimal(0.000285)

    def liquidationOnSelling = definingBigDecimal(0.000275)
}
