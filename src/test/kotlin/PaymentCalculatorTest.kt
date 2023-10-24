import org.junit.Assert.assertEquals
import org.junit.Test

class PaymentCalculatorTest {

    @Test
    fun testVKPayWithinLimit() {
        val commission = PaymentCalculator.calculateCommission(cardType = "VK Pay", transferAmount = 200.0)
        assertEquals(0.0, commission, 0.001)
    }

    @Test
    fun testVKPayExceedingDailyLimit() {
        val commission = PaymentCalculator.calculateCommission(cardType = "VK Pay", transferAmount = 400.0)
        assertEquals(0.0, commission, 0.001)
    }

    @Test
    fun testVKPayExceedingMonthlyLimit() {
        val commission = PaymentCalculator.calculateCommission(
            cardType = "VK Pay",
            totalTransfersThisMonth = 350.0,
            transferAmount = 100.0
        )
        assertEquals(0.0, commission, 0.001)
    }

    @Test
    fun testMasterCardMaestroWithinLimit() {
        val commission = PaymentCalculator.calculateCommission(cardType = "MasterCard", transferAmount = 50000.0)
        assertEquals(0.0, commission, 0.001)
    }

    @Test
    fun testMasterCardMaestroExceedingLimit() {
        val commission = PaymentCalculator.calculateCommission(cardType = "MasterCard", transferAmount = 80000.0)
        val expectedCommission = (80000.0 * 0.006) + 20.0
        assertEquals(expectedCommission, commission, 0.001)
    }

    @Test
    fun testRegularCommission() {
        // Assuming calculateRegularCommission always returns 10.0
        val commission = PaymentCalculator.calculateCommission(transferAmount = 100.0)
        assertEquals(10.0, commission, 0.001)
    }
}
