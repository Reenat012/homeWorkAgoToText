fun main() {
    println(agoToText((49 * 3600))) //функция, которая принимает параметром Int (секунды)
    // возвращает String (был(а) в сети тогда-то)
}

fun agoToText(timeAgo: Int): String {
    return when (timeAgo) {
        in 0..60 -> "был(а) только что"
        in 61..60 * 60 -> "был(а) ${timeAgo / 60} ${isMinutAgo(timeAgo)} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "был(а) ${timeAgo / 3600} ${isHourAgo(timeAgo)} назад"
        in 24 * 60 * 60..2 * 24 * 60 * 60 -> "вчера"
        in 2 * 24 * 60 * 60..3 * 24 * 60 * 60 -> "позавчера"
        else -> "давно"
    }
}

//функция определяет оконание слова "минута" в зависимости от timeAgo
fun isMinutAgo(timeAgo: Int): String {
    return if (((timeAgo / 60) % 10 == 1 && (timeAgo / 60) % 100 != 11)) "минуту"
    else if (((timeAgo / 60) % 10 in 2..4) &&  ((timeAgo / 60) % 10 !in 12..14)) "минуты"
    else "минут"
}

//функция определяет оконание слова "час" в зависимости от timeAgo
fun isHourAgo(timeAgo: Int): String {
    return if (((timeAgo / 3600) % 10 == 1 && (timeAgo / 3600) % 100 != 11)) "час"
    else if (((timeAgo / 3600) % 10 == 2
        || (timeAgo / 3600) % 10 == 3
        || (timeAgo / 3600) % 10 == 4) && (timeAgo / 3600) % 100 != 12
        && (timeAgo / 3600) % 100 != 13 && (timeAgo / 3600) % 100 != 14) "часа"
    else "часов"
}