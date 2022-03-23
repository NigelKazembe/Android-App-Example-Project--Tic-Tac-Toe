package com.nigelkazembe.tic_tac

import androidx.lifecycle.MutableLiveData

class GridBoard {
    private var gridPositionValues: ArrayList<String>? = ArrayList()
    private var countItems = 0
    private var toBeObserved: MutableLiveData<ArrayList<String>> = MutableLiveData<ArrayList<String>>()

    //Method to be called to initialize the grid
    fun createGrid() {
        val gridValuesInitial = (1..9).map {
            "---"
        }

        for(i in 0 until 9) {
            gridPositionValues?.add("---")
        }
        //gridPositionValues = gridValuesInitial
    }

    //method to be called to insert a symbol into the selected position by the player
    fun insertPlayerMoveSymbol(positionIndex: Int, playerSymbol: String) {
        if (boardIsFull()) {
            throw ArrayIndexOutOfBoundsException("The board is full")
        } else {
            gridPositionValues?.set(positionIndex, playerSymbol)
            countItems++
        }
    }

    //method to get the grid position values
    fun getGridPositionsValues(): ArrayList<String>? {
        return gridPositionValues
    }

    fun getGridPositionValuesAfterChange(): MutableLiveData<ArrayList<String>> {
        toBeObserved.postValue(gridPositionValues!!)
        return  toBeObserved
    }

    //Method to check whether the board is full or not?
    fun boardIsFull():Boolean {
        return countItems == gridPositionValues?.size
    }

    //Method to display the grid to the users
    fun displayGrid() {
        var count = 0
        gridPositionValues?.let {
            for (i in 1..5) {//rows
                for (j in 1..5) {//columns
                    if(i % 2 == 0) {//if row is even then print the line separators
                        print("---")
                    }else {
                        if (j % 2 == 0) {//if column is even then print the line seperator
                            print(" | ")
                        } else
                            print(" ${it[count++]} ")
                    }
                }
                println("")
            }
        }
    }


}