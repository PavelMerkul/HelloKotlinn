import kotlin.math.abs

fun formatMinutes(minutes: Int): String {
    return when (minutes) {
        1 -> "1 минуту назад"
        2 -> "2 минуты назад"
        5 -> "5 минут назад"
        11 -> "11 минут назад"
        21 -> "21 минуту назад"
        25 -> "25 минут назад"
        else -> "$minutes минут назад"
    }
}

fun formatHours(hours: Int): String {
    return when (hours) {
        1 -> "1 час назад"
        else -> {
            val lastDigit = hours % 10
            when {
                lastDigit == 1 && hours != 11 -> "$hours час назад"
                lastDigit in 2..4 && (hours < 10 || hours > 20) -> "$hours часа назад"
                else -> "$hours часов назад"
            }
        }
    }
}

fun agoToText(seconds: Int): String {
    val absSeconds = abs(seconds)

    return when {
        absSeconds <= 60 -> "был(а) только что"
        absSeconds <= 60 * 60 -> formatMinutes(absSeconds / 60)
        absSeconds <= 24 * 60 * 60 -> formatHours(absSeconds / 60 / 60)
        absSeconds <= 2 * 24 * 60 * 60 -> "вчера"
        absSeconds <= 3 * 24 * 60 * 60 -> "позавчера"
        else -> "давно"
    }
}

fun main() {
    val seconds1 = 30
    val seconds2 = 3600
    val seconds3 = 86400
    val seconds4 = 172800
    val seconds5 = 259200
    val seconds6 = 360000

    println(agoToText(seconds1))
    println(agoToText(seconds2))
    println(agoToText(seconds3))
    println(agoToText(seconds4))
    println(agoToText(seconds5))
    println(agoToText(seconds6))

    val cardType = "MasterCard" // Здесь укажите тип карты ("MasterCard", "Maestro", или "VK Pay")
    val totalTransfersThisMonth = 50000.0 // Здесь укажите сумму предыдущих переводов в этом месяце
    val transferAmount = 80000.0 // Здесь укажите сумму совершаемого перевода

    val commission = PaymentCalculator.calculateCommission(cardType, totalTransfersThisMonth, transferAmount)
    println("Комиссия: $commission рублей")


}


//    val likes = 46 // Замените на ваше число лайков
//
//    val likesAnalyzer = LikesAnalyzer()
//    val result = likesAnalyzer.analyzeLikes(likes)
//
//    println(result)
//
//    val amount = 1000.0 // Сумма перевода в рублях
//    val fee = TransferFeeCalculator.calculateFee(amount)
//    println("Комиссия: $fee рублей")
//
//    val purchaseAmount = 12000.0 // Сумма покупки в рублях
//    val isRegularCustomer = true // Постоянный клиент
//
//    val discount = DiscountCalculator.calculateDiscount(purchaseAmount, isRegularCustomer)
//
//    val finalAmount = purchaseAmount - discount
//    println("Сумма покупки: $purchaseAmount рублей")
//    println("Скидка: $discount рублей")
//    println("Итоговая сумма: $finalAmount рублей")
//
//    fun agoToText() {

