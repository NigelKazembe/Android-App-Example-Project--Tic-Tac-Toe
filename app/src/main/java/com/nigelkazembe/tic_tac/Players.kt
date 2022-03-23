package com.nigelkazembe.tic_tac

class Players() {
    private var symbol: String = ""

    constructor(symbol: String): this() {
        this.symbol = symbol
    }

    fun getSymbol(): String {
        return symbol
    }

    fun setSymbol(symb: String) {
        symbol = symb
    }
}