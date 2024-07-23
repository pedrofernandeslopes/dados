fun imprimirDeFimParaInicio(): String {
    var resultado = "["
    var ponteiroAuxiliar = ponteiroFim
    for (i in 0 until quantidade) {
        if (i == quantidade - 1) {
            resultado += ponteiroAuxiliar?.dado
        } else {
            resultado += ponteiroAuxiliar?.dado.toString() + ","
        }
        ponteiroAuxiliar = ponteiroAuxiliar?.anterior
    }
    return "$resultado]"
}
