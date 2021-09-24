package exercicis

import java.io.File

fun main(args: Array<String>) {

    var f = File.listRoots()[0]
    var listaFicheros = f.listFiles().sorted()
    var entrada = 0

    do {
        val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
        val validez = false
        var num = 1

        println(s)
        println("-".repeat(s.length))
        println("0.- Directori pare")

        num = 1
        listaFicheros = f.listFiles().sorted()

        for (e in listaFicheros) {
            if (e.isFile()) {
                println("$num .- " + e.getName() + "\t " + e.length())
                num++
            }
            if (e.isDirectory()) {
                println("$num.- " + e.getName() + "\t <Directori>")
                num++
            }
        }
        print("\nIntrodueix un numero (-1 per acabar): ")
        entrada = readLine()!!.toInt()


        val fAux = File(listaFicheros[entrada-1].path)
        //if (fAux) //DIRECTORIO Y LECTURA contemplar el 0 y que este el numero entreb 0 y 24
        /*if (f.exists()){
            if (f.isDirectory){
                val aux = f.listFiles().sorted().get(entrada - 1)
                num = 1
                for (e in aux.listFiles().sorted()) {

                    if (e.isFile()) {
                        println("$num.- " + e.getName() + "\t " + e.length())
                        num++
                    }
                    if (e.isDirectory()) {
                        println("$num.- " + e.getName() + "\t <Directori>")
                        num++
                    }

                }
                println()
            }
        }*/
    } while (!validez)
}