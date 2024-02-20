//ЗАМЕНЕНО ТИПОВЫМИ ИНСТРУМЕНТАМИ

//fun String.hasCharTrash(): Boolean {
//    val chars = this.trim().toCharArray()
//    for (i in chars) {
//        if ( !i.isDigit() ) {
//            return true
//        }
//    }
//    return false
//}

fun String.getDigitsToInt(): Int {
    var resultString: String = ""
    val chars = this.trim().toCharArray()
    for (i in chars) {
        if ( i.isDigit() ) {
            resultString += i
        }
    }
    return resultString.toInt()
}


