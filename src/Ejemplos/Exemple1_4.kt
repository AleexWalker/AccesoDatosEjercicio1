package Ejemplos

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun main(args: Array<String>) {
    println("Introdueix un directori:")
    val ent = BufferedReader(InputStreamReader(System.`in`)).readLine()
    val f = File(ent)
    if (f.exists()) {
        if (f.isDirectory()) {
            llistaDirectori(f)
        } else
            println("No és un directori")
    } else
        println("No existeix el directori")
}

fun llistaDirectori(f: File) {
    val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
    println(s)
    println("-".repeat(s.length))
    for (e in f.listFiles().sorted()) {
        if (e.isFile())
            println(e.getName() + "\t " + e.length())
        if (e.isDirectory())
            println(e.getName() + "\t <Directori>")
    }
}

