class PaymentCalculator {
    companion object {
        private const val VK_PAY_LIMIT = 300.0 // Лимит для VK Pay

        fun calculateCommission(
            cardType: String = "VK Pay",
            totalTransfersThisMonth: Double = 0.0,
            transferAmount: Double
        ): Double {
            // Проверяем, является ли карта MasterCard или Maestro
            val isMasterCardOrMaestro = cardType == "MasterCard" || cardType == "Maestro"

            // Проверяем, превышен ли лимит для VK Pay
            val isExceedingVkPayLimit = cardType == "VK Pay" && totalTransfersThisMonth + transferAmount > VK_PAY_LIMIT

            // Расчет комиссии в зависимости от типа карты и других условий
            return when {
                isMasterCardOrMaestro -> 0.0 // Не нужно платить комиссию для MasterCard и Maestro
                isExceedingVkPayLimit -> 0.0 // VK Pay бесплатно, если превышен лимит
                else -> calculateRegularCommission(transferAmount) // Обычная комиссия
            }
        }

        private fun calculateRegularCommission(transferAmount: Double): Double {
            return TransferFeeCalculator.calculateFee(transferAmount)
        }
    }
}
