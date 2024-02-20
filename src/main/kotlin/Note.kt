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