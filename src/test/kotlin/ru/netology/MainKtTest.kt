package ru.netology

import commission
import commissionChecker
import org.junit.Test

import org.junit.Assert.*
import pennyReader

class MainKtTest {
    //TODO проверка работы комиссии
    @Test
    fun shouldHaveCommissionVisa() {
        val typeOfAccount = "Visa"
        val amount = 10_000

        val result: Int = commission(typeOfAccount, amount = amount)

        assertEquals(7500, result)
    }

    @Test
    fun shouldHaveCommissionMir() {
        val typeOfAccount = "Мир"
        val amount = 10_000

        val result: Int = commission(typeOfAccount, amount = amount)

        assertEquals(7500, result)
    }

    @Test
    fun shouldHaveCommissionMastercard() {
        val typeOfAccount = "Mastercard"
        val amount = 80_000

        val result: Int = commission(typeOfAccount, amount = amount)

        assertEquals(48020, result)
    }

    @Test
    fun shouldHaveCommissionMaestro() {
        val typeOfAccount = "Maestro"
        val amount = 80_000

        val result: Int = commission(typeOfAccount, amount = amount)

        assertEquals(48020, result)
    }

    @Test
    fun shouldNotHaveCommissionVk() {
        val typeOfAccount = "Vk Pay"
        val amount = 10_000

        val result: Int = commission(typeOfAccount, amount = amount)

        assertEquals(0, result)
    }

    @Test
    fun shouldNotHaveCommissionMastercard() {
        val typeOfAccount = "Mastercard"
        val amount = 10_000

        val result: Int = commission(typeOfAccount, amount = amount)

        assertEquals(0, result)
    }

    @Test
    fun shouldNotHaveCommissionMaestro() {
        val typeOfAccount = "Maestro"
        val amount = 10_000

        val result: Int = commission(typeOfAccount, amount = amount)

        assertEquals(0, result)
    }

    //TODO Проверка лимитов
    @Test
    fun commissionCheckerVkDay() {
        val amount = 16_000
        val typeOfAccount = "Vk Pay"

        val result = commissionChecker(typeOfAccount, amount = amount)

        assertEquals("Ваш перевод слишком велик!", result)
    }

    @Test
    fun commissionCheckerVkDayTrigger() {
        val amount = 14_000
        val typeOfAccount = "Vk Pay"

        val result = commissionChecker(typeOfAccount, amount = amount)

        assertEquals("", result)
    }

    @Test
    fun commissionCheckerVkMonth() {
        val amount = 13_000
        val typeOfAccount = "Vk Pay"
        val monthlyAmount = 28_000

        val result = commissionChecker(typeOfAccount, monthlyAmount, amount)

        assertEquals("Ваш лимит переводов исчерпан!", result)
    }

    @Test
    fun commissionCheckerCardDay() {
        val amount = 160_000
        val typeOfAccount = "Visa"

        val result = commissionChecker(typeOfAccount, amount = amount)

        assertEquals("Ваш перевод слишком велик!", result)
    }

    @Test
    fun commissionCheckerCardMonth() {
        val amount = 130_000
        val typeOfAccount = "Mastercard"
        val monthlyAmount = 480_000

        val result = commissionChecker(typeOfAccount, monthlyAmount, amount)

        assertEquals("Ваш лимит переводов исчерпан!", result)
    }

    @Test
    fun commissionCheckerMinimumVisa() {
        val amount = 20
        val typeOfAccount = "Visa"

        val result = commissionChecker(typeOfAccount, amount = amount)

        assertEquals("Минимальный перевод 35 рублей!", result)
    }

    @Test
    fun commissionCheckerMinimumMir() {
        val amount = 20
        val typeOfAccount = "Мир"

        val result = commissionChecker(typeOfAccount, amount = amount)

        assertEquals("Минимальный перевод 35 рублей!", result)
    }

    @Test
    fun commissionCheckerTrigger() {
        val amount = 80_000
        val typeOfAccount = "Mastercard"
        val monthlyAmount = 450_000

        val result = commissionChecker(typeOfAccount, monthlyAmount, amount)

        assertEquals("", result)
    }

    //TODO Проверка копеек
    @Test
    fun pennyReaderOne(){
        val penny = 1

        val result = pennyReader(penny)

        assertEquals("копейка", result)
    }

    @Test
    fun pennyReaderLikeOne(){
        val penny = 21

        val result = pennyReader(penny)

        assertEquals("копейка", result)
    }

    @Test
    fun pennyReaderLessFive(){
        val penny = 32

        val result = pennyReader(penny)

        assertEquals("копейки", result)
    }

    @Test
    fun pennyReaderMoreFive(){
        val penny = 45

        val result = pennyReader(penny)

        assertEquals("копеек", result)
    }
}