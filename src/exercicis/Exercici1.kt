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

        //if (fAux) //DIRECTORIO Y LECTURA contemplar el 0 y que este el numero entreb 0 y 24
        if (f.exists()){
            if (f.isDirectory){
                num = 1
                for (e in f.listFiles().sorted()) {

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
        }//val aux = f.listFiles().sorted().get(entrada - 1)

        print("\nIntrodueix un numero (-1 per acabar): ")
        entrada = readLine()!!.toInt()

        f = File(listaFicheros[entrada-1].path)

    } while (!validez)
}