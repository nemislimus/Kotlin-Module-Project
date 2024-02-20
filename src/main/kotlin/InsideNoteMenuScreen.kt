class InsideNoteMenuScreen(list: MutableList<String>): Menu<String>(list) {

    fun openNoteContent(): () -> Unit = {

        println( ANSI_YELLOW + "\nВ заметке \"${ list[0] }\" содержится следующий текст:")
        println(ANSI_GREEN + list[1] + ANSI_RESET)
        resetAllLines()
    }
}