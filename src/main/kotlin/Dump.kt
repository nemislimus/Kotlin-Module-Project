
const val ANSI_RESET = "\u001B[0m"
const val ANSI_YELLOW = "\u001B[33m"
const val ANSI_RED = "\u001B[31m"
const val ANSI_CYAN = "\u001B[36m"
const val ANSI_GREEN = "\u001B[32m"

const val STUB = "STUB"

class Archive(val name: String) {
    var noteList: MutableList<Note> = mutableListOf(Note(STUB))

    override fun toString(): String {
        return name
    }
}

class Note(val title: String) {
    var text: String = ""
    var content: MutableList<String> = mutableListOf()

    fun setContent() {
        content= mutableListOf(title, text)
    }

    override fun toString(): String {
        return title
    }
}

fun String.hasCharTrash(): Boolean {
    val chars = this.trim().toCharArray()
    for (i in chars) {
        if ( !i.isDigit() ) {
            return true
        }
    }
    return false
}

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