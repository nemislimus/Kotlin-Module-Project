class ArchiveBase {
    private var archiveBase: MutableList<Archive> = mutableListOf(Archive(STUB))

    fun startBase() {

        val mainMenu = ArhiveMenuScreen(archiveBase)
        println("\n-=<  ВЫ ЗАПУСТИЛИ КОНСОЛЬНОЕ ПРИЛОЖЕНИЕ ДЛЯ СОЗДАНИЯ АРХИВОВ С ЗАМЕТКАМИ  >=-")

        while (mainMenu.menuIsActive) {
            println("\nВы находитесь в списке архивов. Выберите дальнейшее действие:")
            mainMenu.printMenu()
            val goInsideArchive = mainMenu.doOnMenuInput(mainMenu.userInput(), mainMenu.createActionWhenArchive())

            if (goInsideArchive > 1) {
                val chosenArchiveNumber = goInsideArchive-2
                val noteMenu = NoteMenuScreen(archiveBase[chosenArchiveNumber].noteList)

                while ( noteMenu.menuIsActive ) {
                    println("\nВы находитесь в архиве \"${archiveBase[chosenArchiveNumber].name}\". Выберите дальнейшее действие:")
                    noteMenu.printMenu()
                    val goInsideNote = noteMenu.doOnMenuInput(noteMenu.userInput(), noteMenu.createActionWhenNote())

                    if (goInsideNote == -2){
                        archiveBase[chosenArchiveNumber].noteList.add(Note(STUB))
                    } else if (goInsideNote > 1) {
                        val chosenNoteNumber = goInsideNote - 2
                        val noteContent = archiveBase[chosenArchiveNumber].noteList[chosenNoteNumber].content
                        val insideNoteMenu = InsideNoteMenuScreen(noteContent)

                        while ( insideNoteMenu.menuIsActive ) {
                            println("\nВы находитесь в архиве \"${ archiveBase[chosenArchiveNumber].name }\", " +
                                    "в заметке \"${ archiveBase[chosenArchiveNumber].noteList[chosenNoteNumber] }\"." +
                                    " Выберите дальнейшее действие:")
                            insideNoteMenu.printMenu()
                            insideNoteMenu.doOnMenuInput( insideNoteMenu.userInput(), insideNoteMenu.openNoteContent() )
                        }
                    }
                }
            }
        }

        println("\nПриложение завершило свою работу. Все архивы уничтожены.")



    }


}