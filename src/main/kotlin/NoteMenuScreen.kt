
class NoteMenuScreen(list: MutableList<Note>): Menu<Note>(list) {

    fun createActionWhenNote(): () -> Unit = {

        println("\nВы решили создать заметку. Напишите её заголовок:")
        val takeTitle = userInputTitles()
        list.add(Note(takeTitle))
        println("Напишите текст заметки:")
        val takeNoteText = userInputTitles()
        list.last().text = takeNoteText
        list.last().setContent()
        println("Вы создали заметку \"$takeTitle\"")
        resetAllLines()
    }
}