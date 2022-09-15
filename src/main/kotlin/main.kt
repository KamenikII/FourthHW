import kotlin.random.Random

fun main() {
    //Ex 1
    println("Задание 2")
    val amount: Int = 10_000
    val monthlyAmount: Int = 23_000
    val typeOfAccount: String = "Mastercard"
//    val typeOfAccount: String = "Maestro"
//    val typeOfAccount: String = "Visa"
//    val typeOfAccount: String = "Мир"
//    val typeOfAccount: String = "Vk Pay"
        val point: String = commissionChecker(typeOfAccount, monthlyAmount, amount)
        if (point != "") println(point)
        else {
            val com: Int = commission(typeOfAccount, monthlyAmount, amount)
            println("""Ваша сумма: $amount рублей
                |Комиссия: $com ${pennyReader(com)} 
            """.trimMargin())

        }
}

//TODO ДЛЯ ЗАДАНИЯ 1
fun commissionChecker (typeOfAccount: String = "Vk Pay", monthlyAmount: Int = 0, amount: Int): String {
    when {
        (typeOfAccount != "Vk Pay" && monthlyAmount+amount > 600_000) -> return "Ваш лимит переводов исчерпан!"
        (typeOfAccount == "Vk Pay" && monthlyAmount+amount > 40_000) -> return "Ваш лимит переводов исчерпан!"
        (typeOfAccount != "Vk Pay" && amount > 150_000) -> return "Ваш перевод слишком велик!"
        (typeOfAccount == "Vk Pay" && amount > 15_000) -> return "Ваш перевод слишком велик!"
        ((typeOfAccount == "Visa" || typeOfAccount == "Мир") && (amount < 35)) -> return "Минимальный перевод 35 рублей!"
        else -> return "" //триггер
    }
}

fun commission(typeOfAccount: String = "Vk Pay", monthlyAmount: Int = 0, amount: Int): Int {
    when {
        ((typeOfAccount == "Mastercard" || typeOfAccount == "Maestro") && (amount > 75_000)) -> return (amount*100*0.006+20).toInt()
        ((typeOfAccount == "Visa" || typeOfAccount == "Мир")) -> return (amount*100*0.0075).toInt()
        else -> return 0
    }
}

fun pennyReader(penny: Int): String {
    if (penny % 10 == 1 && penny != 11) return "копейка"
    else if (penny % 10 < 5 && penny % 10 > 1) return "копейки"
    else return "копеек"
}