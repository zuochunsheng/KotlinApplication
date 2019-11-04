package edz.example.com.kotlinapplication.chapter


//fun parsePath(path: String) {
//    val directory = path.substringBeforeLast("/")
//    val fullName = path.substringAfterLast("/")
//
//    val fileName = fullName.substringBeforeLast(".")
//    val extension = fullName.substringAfterLast(".")
//
//    println("Dir: $directory, name: $fileName, ext: $extension")
//}
fun parsePath(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}

val kotlinLogo = """| //
                   .|//
                   .|/ \"""


class User(val id: Int, val name: String, val address: String)

//fun saveUser(user: User) {
//
//    fun validate(user: User,
//                 value: String,
//                 fieldName: String) {
//        if (value.isEmpty()) {
//            throw IllegalArgumentException(
//                    "Can't save user ${user.id}: empty $fieldName")
//        }
//    }
//
//    validate(user, user.name, "Name")
//    validate(user, user.address, "Address")
//
//    // Save user to the database
//}

fun saveUser(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                    "Can't save user ${user.id}: " +
                            "empty $fieldName")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")

    // Save user to the database
}

fun main(args: Array<String>) {

//    println("12.345-6.A".split("\\.|-".toRegex()))
//    println("12.345-6.A".split(".", "-"))

//    parsePath("/Users/yole/kotlin-book/chapter.adoc")
//    println(kotlinLogo.trimMargin("."))

    saveUser(User(1, "", ""))
}