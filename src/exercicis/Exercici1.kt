package exercicis

import java.io.File

fun main(args: Array<String>) {

    var f = File.listRoots()[0]
    var listaFicheros = f.listFiles().sorted()

    println(listaFicheros.get(10))
    do {
        val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
        val validez = false
        var num = 1

        println(s)
        println("-".repeat(s.length))
        println("0.- Directori pare")

        num = 1
        for (e in f.listFiles().sorted()) {
            if (e.isFile()) {
                println("$num .- " + e.getName() + "\t " + e.length())
                num++
            }
            if (e.isDirectory()) {
                println("$num.- " + e.getName() + "\t <Directori>")
                num++
            }
        }
        println("\nIntrodueix un numero (-1 per acabar): ")
        val entrada = readLine()!!.toInt()

        if (f.exists()){
            if (f.isDirectory){
                val aux = f.listFiles().sorted().get(entrada - 1)
                for (e in f.listFiles().sorted()) {
                    if (e.isFile()) {
                        println("$num .- " + e.getName() + "\t " + e.length())
                        num++
                    }
                    if (e.isDirectory()) {
                        println("$num.- " + e.getName() + "\t <Directori>")
                        num++
                    }
                }
            }
        }
    } while (entrada != -1)
}