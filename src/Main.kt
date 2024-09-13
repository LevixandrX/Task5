fun main() {
    while (true) {
        println("Введите целое число n и основание степени x через пробел (формат: n x):")

        val input = readlnOrNull()?.trim()
        val parts = input?.split(" ")

        if (parts == null || parts.size != 2) {
            println("Ошибка: Введите данные в формате: n x")
            continue
        }

        val n = parts[0].toIntOrNull()
        val x = parts[1].toIntOrNull()

        if (n == null || x == null || x <= 0 || n < 0) {
            println("Ошибка: Введите корректные значения. n должно быть неотрицательным числом, а x положительным.")
            continue
        }

        val y = findIntegerExponent(n, x)

        if (y != null) {
            println("Целочисленный показатель степени: $y")
        } else {
            println("Целочисленный показатель не существует")
        }

        break
    }
}

fun findIntegerExponent(n: Int, x: Int): Int? {
    if (n == 0) return if (x == 0) 0 else null
    if (x == 1) return if (n == 1) 0 else null

    var power = 1
    var y = 0
    while (power <= n) {
        if (power == n) return y
        power *= x
        y++
    }
    return null
}