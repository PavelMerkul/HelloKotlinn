class DiscountCalculator {
    companion object {
        private const val REGULAR_CUSTOMER_DISCOUNT_PERCENTAGE = 1 // 1% скидка для постоянных клиентов
        private const val STANDARD_DISCOUNT = 100.0 // Стандартная скидка 100 рублей
        private const val PERCENTAGE_DISCOUNT_THRESHOLD = 10000.0 // Порог для скидки в процентах

        fun calculateDiscount(purchaseAmount: Double, isRegularCustomer: Boolean): Double {
            var discount = 0.0

            if (purchaseAmount in 1.0..1000.0) {
                // Сумма покупки от 0 до 1,000 рублей
                discount = 0.0
            } else if (purchaseAmount in 1001.0..10000.0) {
                // Сумма покупки от 1,001 до 10,000 рублей
                discount = STANDARD_DISCOUNT
            } else if (purchaseAmount > PERCENTAGE_DISCOUNT_THRESHOLD) {
                // Сумма покупки от 10,001 рубля и выше
                discount = purchaseAmount * 0.05 // 5% скидка
            }

            if (isRegularCustomer) {
                discount += purchaseAmount * (REGULAR_CUSTOMER_DISCOUNT_PERCENTAGE / 100.0)
            }

            return discount
        }
    }
}
