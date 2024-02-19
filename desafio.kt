// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
// link pto Kotlin playground

enum class Level { BASIC, INTERMEDIATE, UPPERINTERMEDIATE, ADVANCED }
enum class AccessType { STUDENT, EMPLOYEE}

data class CourseContent(var name: String, val duration: Int = 60, val level: Level)

data class Course(val name: String, var contents: MutableSet<CourseContent>, var level: Level) {

    val subscribers = mutableListOf<String>()

    fun enroll(user: User) {
        //PT-BR: TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        // TODO("Use the parameter $user to simulate an enrollment (use the list of $subscribers).")
        // TODOJIL: verif nivel

        if (user.level == this.level) {
            subscribers.add(user.name + user.userId + user.userType)
            if (user.coursesList.isNullOrEmpty()) {
                user.coursesList = mutableSetOf(this)
                println("Student course list:")
                println(user.coursesList)
            } else {
                user.coursesList!!.add(this)
                println("Student new course list:")
                println(user.coursesList)
            }
        } else {
            println("Student is not at the sae level that the course requires")
        }


        println("Students enroll in this course:")
        println(subscribers)
        var totalSubs = subscribers.size
        println("Quantidade de pessoas inscritas: $totalSubs.")
        println("----- The end -----")
        println()
    }
}

class User(var name: String, val userId: String, val password: String, var userType: AccessType, var level: Level? = Level.BASIC, var coursesList: MutableSet<Course>? = null) {
    fun infoToPrint() {
        println("New user name: $name, user id: $userId, user Type: $userType.")
    }
}

fun main() {
    // PT-BR: TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    // PT-BR: TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    // TODO("Analyze the classes modeled for this application domain and think of ways to evolve them.")
    // TODO("Simulate some test scenarios. To do this, create some objects using the classes in question.")

    val courseContentTest1 = CourseContent("Git - GitHub", 12, Level.BASIC)
    val courseContentTest2 = CourseContent("Kotlin - Introduction", 13, Level.BASIC)
    val courseContentTest3 = CourseContent("Kotlin - Programming logic", 14, Level.INTERMEDIATE)
    val courseContentTest4 = CourseContent("Agile - Agile Introdution", 15, Level.BASIC)
    val courseKotlin = Course("Kotlin", mutableSetOf(courseContentTest1,courseContentTest2, courseContentTest3), Level.INTERMEDIATE)
    val courseAgile = Course("Agile", mutableSetOf(courseContentTest4), Level.BASIC)

    val userTest1 = User("Mia", "1", "Mia123", AccessType.STUDENT, Level.INTERMEDIATE, mutableSetOf(courseAgile))
    userTest1.infoToPrint()
    val userTest2 = User("Gatuno", "2", "Gatuno123", AccessType.STUDENT)
    userTest2.infoToPrint()
    val userTest3 = User("Bela", "2", "Bela123", AccessType.STUDENT)
    userTest3.infoToPrint()

    courseKotlin.enroll(userTest1)
    courseKotlin.enroll(userTest2)
    courseKotlin.enroll(userTest3)
}
