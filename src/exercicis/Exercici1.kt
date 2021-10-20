package exercicis

import java.io.File
import java.lang.NumberFormatException

fun main(args: Array<String>) {

    var f = File.listRoots()[0]
    //var listaFicheros = f.listFiles().sorted()
    var entrada = 0

    do {
        val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
        val listaFicheros = f.listFiles().sorted()
        var validez = false
        var num = 1

        println(s)
        println("-".repeat(s.length))
        println("0.- Directori pare")

        num = 1

        //if (fAux) //DIRECTORIO Y LECTURA contemplar el 0 y que este el numero entre 0 y 24
        if (f.exists() && f.canRead()){
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

                print("\nIntrodueix un numero (-1 per acabar): ")
                entrada = readLine()!!.toInt()

                try {
                    if (entrada == 0) {
                        if (f.parentFile != null)
                            f = File(f.parentFile.path)
                    }
                    if (entrada == -1){
                        validez = true
                    } else
                        f = File(listaFicheros[entrada-1].path)
                } catch (e : IndexOutOfBoundsException){
                    println("¡Valor introducido NO VALIDO!\n")
                } catch (a : NumberFormatException){
                    println("¡No se permiten caracteres, tan solo numeros!")
                }

            }
        }else //val aux = f.listFiles().sorted().get(entrada - 1)
            println("No tienes permiso de lectura/O no es un directorio")

    } while (!validez)
    println("¡GRACIAS POR UTILIZAR NUESTRO EXPLORADOR DE ARCHIVOS!")
}