fun main() {
    val likes = 46 // Замените на ваше число лайков

    val likesAnalyzer = LikesAnalyzer()
    val result = likesAnalyzer.analyzeLikes(likes)

    println(result)

    val amount = 1000.0 // Сумма перевода в рублях
    val fee = TransferFeeCalculator.calculateFee(amount)
    println("Комиссия: $fee рублей")

    val purchaseAmount = 12000.0 // Сумма покупки в рублях
    val isRegularCustomer = true // Постоянный клиент

    val discount = DiscountCalculator.calculateDiscount(purchaseAmount, isRegularCustomer)

    val finalAmount = purchaseAmount - discount
    println("Сумма покупки: $purchaseAmount рублей")
    println("Скидка: $discount рублей")
    println("Итоговая сумма: $finalAmount рублей")


}
