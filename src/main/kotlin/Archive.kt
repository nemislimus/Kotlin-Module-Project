class Archive(val name: String) {
    var noteList: MutableList<Note> = mutableListOf(Note(STUB))

    override fun toString(): String {
        return name
    }
}

