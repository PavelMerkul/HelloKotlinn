class LikesAnalyzer {
    fun analyzeLikes(likes: Int): String {
        val variants = arrayOf("лайк", "лайка", "лайков")
        val lastDigit = likes % 10

        return when {
            lastDigit == 1 && likes != 11 -> "$likes ${variants[0]}"
            lastDigit in 2..4 && (likes < 10 || likes > 20) -> "$likes ${variants[1]}"
            else -> "$likes ${variants[2]}"
        }
    }
}
