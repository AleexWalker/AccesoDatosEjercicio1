package Ejemplos

import java.io.File

fun main(args: Array<String>) {
    val f = File.listRoots()[0]
    println("Llista de fitxers i directoris del directori actual")
    println("---------------------------------------------------")
    for (e in f.list().sorted())
        println(e);
}



