
class ArhiveMenuScreen(list: MutableList<Archive>): Menu<Archive>(list) {

    fun createActionWhenArchive(): () -> Unit = {
        println("\nВы решили создать архив. Напишите его название:")
        val takeName = userInputTitles()
        list.add(Archive(takeName))
        println("Вы создали архив \"$takeName\"")
        resetAllLines()
    }
}