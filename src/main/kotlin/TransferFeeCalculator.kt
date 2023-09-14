class TransferFeeCalculator {
    companion object {
        // Константы для комиссии
        private const val COMMISSION_RATE = 0.0075 // 0.75%
        private const val MINIMUM_FEE = 35.0      // Минимальная комиссия 35 рублей

        // Метод для вычисления комиссии
        fun calculateFee(amount: Double): Double {
            // Вычисляем комиссию, учитывая минимальное значение
            var fee = amount * COMMISSION_RATE
            if (fee < MINIMUM_FEE) {
                fee = MINIMUM_FEE
            }
            return fee
        }
    }
}

fun main() {
    // Пример использования
    val amount = 1000.0 // Сумма перевода в рублях
    val fee = TransferFeeCalculator.calculateFee(amount)
    println("Комиссия: $fee рублей")
}
