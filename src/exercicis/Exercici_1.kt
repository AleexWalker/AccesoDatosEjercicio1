package exercicis

import Ejemplos.llistaDirectori
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun main(args: Array<String>) {

    var f = File.listRoots()[0]
    var listaFicheros = f.listFiles().sorted()

    println(listaFicheros.get(10))

    if (f.exists()) {
        val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
        val validez = false
        var num = 1
        println(s)
        println("-".repeat(s.length))

        println("0.- Directori pare")

        while (!validez){
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

            for (e in listaFicheros){
                if (entrada == listaFicheros.indexOf(e)){
                    var fichero = e.path
                    val aux = File(e.canonicalPath)
                    for (e in aux.listFiles().sorted()){
                        println(aux.list())
                    }
                    validez
                }
            }
        }
    }
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

