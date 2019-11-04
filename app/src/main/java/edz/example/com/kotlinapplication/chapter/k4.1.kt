package edz.example.com.kotlinapplication.chapter

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable! Clickable")
}
interface Focusable {
    fun setFocus(b: Boolean) =
            println("I ${if (b) "got" else "lost"} focus. Focusable")

    fun showOff() = println("I'm focusable! Focusable")
}


class Button1 : Clickable, Focusable {
    override fun click() = println("I was clicked Button1")

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}




fun main(args: Array<String>) {

    val button = Button1()
    button.showOff()
    button.setFocus(true)
    button.click()

}