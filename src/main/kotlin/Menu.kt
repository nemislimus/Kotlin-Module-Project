import java.util.Scanner


open class Menu<T>(var list: MutableList<T>) {

    var menuIsActive = true
    private var typeMarker = list[0]
    private var menuLinesNumbers: MutableList<Int> = mutableListOf(0, 1)
    private var menuLineStrings: MutableList<String> = mutableListOf()


    fun printMenu() {

        if ( list[0].toString().uppercase() == STUB ) {
            list.clear()
        }

        if ( list.isNotEmpty() ) {
            for (i in list.indices) {
                val newIndex: Int = i + 2
                menuLinesNumbers.add(newIndex)
            }
            makeMenuStrings()
        } else {
            makeDefaultMenuStrings()
        }
        menuLineStrings.forEach { println(it) }
    }

    fun userInput(): Int {
        val resultInput: Int
        while (true) {
            val userCommand = Scanner(System.`in`).nextLine()
            if ( userCommand.trim().isEmpty() || userCommand.trim().any { !it.isDigit() } ) {
                println("$ANSI_RED\nWARNING: Следует ввести только цифру из меню!$ANSI_RESET\nПовторите ввод команды:")
                menuLineStrings.forEach { println(it) }
                continue
            } else if ( userCommand.getDigitsToInt() > (menuLineStrings.size -1) ) {
                println("$ANSI_RED\nWARNING: введённая цифра отсутствует в меню!$ANSI_RESET\nПовторите ввод команды:")
                menuLineStrings.forEach { println(it) }
                continue
            } else {
                resultInput = userCommand.getDigitsToInt()
                break
            }
        }
        return resultInput
    }

    fun userInputTitles(): String {
        val resultInput: String
        while (true) {
            val userCommand = Scanner(System.`in`).nextLine()
            if ( userCommand.trim().isEmpty() ) {
                println("$ANSI_RED\nWARNING: Отсутствует текс!$ANSI_RESET\nПопробуйте снова:")
                continue
            } else {
                resultInput = userCommand
                break
            }
        }
        return resultInput.trim()
    }

    fun doOnMenuInput(input: Int, action: () -> Unit ): Int {
        when (typeMarker) {
            is Archive -> {
                return when (input) {
                    1 -> {
                        menuIsActive = false
                        1
                    }

                    in 2 until menuLinesNumbers.size -> {
                        resetAllLines()
                        input
                    }

                    else -> {
                        action()
                        0
                    }
                }
            }

            is Note -> {
                when (input) {
                    1 -> {
                        menuIsActive = false
                        if (list.isEmpty()){
                            return -2
                        }
                        return 1
                    }

                    in 2 until menuLinesNumbers.size -> {
                        resetAllLines()
                        return input
                    }

                    else -> {
                        action()
                        return 0
                    }
                }
            }

            is String -> {
                return when (input) {
                    1 -> {
                        menuIsActive = false
                        1
                    }

                    else -> {
                        action()
                        0
                    }
                }
            }
        }
        return -1
    }


    private fun makeMenuStrings() {
        when (typeMarker) {
            is Archive -> {
                for (i in menuLinesNumbers.indices) {
                    when (i) {
                        0 -> menuLineStrings.add("$i. СОЗДАТЬ АРХИВ")
                        1 -> menuLineStrings.add("$i. ВЫХОД")
                        else -> menuLineStrings.add("$i. ОТКРЫТЬ АРХИВ: ${list[i-2].toString()}")
                    }
                }
            }

            is Note -> {
                for (i in menuLinesNumbers.indices) {
                    when (i) {
                        0 -> menuLineStrings.add("$i. СОЗДАТЬ ЗАМЕТКУ")
                        1 -> menuLineStrings.add("$i. ВЫХОД")
                        else -> menuLineStrings.add("$i. ОТКРЫТЬ ЗАМЕТКУ: ${list[i-2].toString()}")
                    }
                }
            }

            is String -> {
                for (i in menuLinesNumbers.indices) {
                    when (i) {
                        0 -> menuLineStrings.add("$i. ПРОЧИТАТЬ ЗАМЕТКУ")
                        1 -> menuLineStrings.add("$i. ВЫХОД")
                    }
                }
            }
        }
    }

    private fun makeDefaultMenuStrings() {
        when (typeMarker) {
            is Archive -> {
                menuLineStrings.add("0. СОЗДАТЬ АРХИВ")
                menuLineStrings.add("1. ВЫХОД")
            }

            is Note -> {
                menuLineStrings.add("0. СОЗДАТЬ ЗАМЕТКУ")
                menuLineStrings.add("1. ВЫХОД")
            }
        }
    }

    fun resetAllLines() {
        menuLineStrings.clear()
        menuLinesNumbers = mutableListOf(0, 1)
    }
}



