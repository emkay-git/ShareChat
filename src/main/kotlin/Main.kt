import com.google.inject.Guice

fun main(args: Array<String>) {
    println("Hello World!")
    val injector = Guice.createInjector();
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}