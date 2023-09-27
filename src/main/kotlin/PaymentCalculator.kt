class PaymentCalculator {
    companion object {
        private const val VK_PAY_LIMIT = 300.0 // Лимит для VK Pay
        private const val MASTER_CARD_MAESTRO_LIMIT = 75000.0 // Лимит для Maestro и MasterCard
        private const val MASTER_CARD_MAESTRO_COMMISSION_RATE = 0.006 // 0.6%
        private const val MASTER_CARD_MAESTRO_FIXED_COMMISSION = 20.0 // Фиксированная комиссия для Maestro и MasterCard

        fun calculateCommission(
            cardType: String = "VK Pay",
            totalTransfersThisMonth: Double = 0.0,
            transferAmount: Double
        ): Double {
            // Проверяем, является ли карта MasterCard или Maestro
            val isMasterCardOrMaestro = cardType == "MasterCard" || cardType == "Maestro"

            // Проверяем, превышен ли дневной лимит
            val isExceedingDailyLimit = transferAmount > VK_PAY_LIMIT

            // Проверяем, превышен ли месячный лимит
            val isExceedingMonthlyLimit = totalTransfersThisMonth + transferAmount > VK_PAY_LIMIT

            // Расчет комиссии в зависимости от типа карты и других условий
            return when {
                isMasterCardOrMaestro -> {
                    if (transferAmount > MASTER_CARD_MAESTRO_LIMIT) {
                        // Расчет комиссии для Maestro и MasterCard при сумме больше 75000
                        transferAmount * MASTER_CARD_MAESTRO_COMMISSION_RATE + MASTER_CARD_MAESTRO_FIXED_COMMISSION
                    } else {
                        0.0 // Не нужно платить комиссию для Maestro и MasterCard до 75000
                    }
                }
                isExceedingDailyLimit -> 0.0 // VK Pay бесплатно, если превышен дневной лимит
                isExceedingMonthlyLimit -> 0.0 // VK Pay бесплатно, если превышен месячный лимит
                else -> calculateRegularCommission(transferAmount) // Обычная комиссия
            }
        }

        private fun calculateRegularCommission(transferAmount: Double): Double {
            // Ваш код для расчета обычной комиссии
            // Можете использовать TransferFeeCalculator.calculateFee(transferAmount)
            // или другие правила расчета комиссии для других типов карт
            return TransferFeeCalculator.calculateFee(transferAmount)
        }
    }
}
