package com.nigelkazembe.tic_tac

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var playerNum = 0
    private val player1 = Players()
    private val player2 = Players()
    private var roundCount: Int = 0
    private var winner = false
    private var endedCozOfWinnerOrBoardFull = " "
    private var boardFull = false
    var results = MutableLiveData<ArrayList<String>>()
    private var board: GridBoard = GridBoard()
    private var winningCombination = ""

    init{
        player1.setSymbol("X")
        player2.setSymbol("O")
    }

    fun startNewGame() {
        //println()
        //board = GridBoard()
        board.createGrid()
    }

    fun insertSelection(countPlayerMove: Int, gridPosition: Int ) {
        //val board = GridBoard()
        var gridPos = gridPosition - 1
        if (countPlayerMove % 2 == 1) {
            board.insertPlayerMoveSymbol(gridPos, "X")
            roundCount++
            endedCozOfWinnerOrBoardFull = "Winner"
            if (roundCount >= 3) {
                winner = checkWinner(player1, board)
                if (winner) {
                    playerNum = 1
                    //println("Player 1 wins!!")
                }
            }
        } else {
            board.insertPlayerMoveSymbol(gridPos, "O")
            roundCount++
            if (roundCount >= 3) {
                winner = checkWinner(player2, board)
                endedCozOfWinnerOrBoardFull = "Winner"
                if (winner) {
                    playerNum = 2
                    //println("Player 1 wins!!")
                }
            }
        }
    }

    private fun checkWinner(player: Players, gridBoard: GridBoard): Boolean {
        val playerSymbol = player.getSymbol()
        val board = gridBoard.getGridPositionsValues()
        var res = false
        var str = "1,2,4"
        str.split(",")

        board?.let {
            if (playerSymbol == board[0] && playerSymbol == board[1] && playerSymbol == board[2]) {
                res = true
                //winningCombination = "0"
                for(i in 0..2) {
                    winningCombination += "$i,"
                }
            } else if (playerSymbol == board[3] && playerSymbol == board[4] && playerSymbol == board[5]) {
                res = true
                //winningCombination = "3"
                for(i in 3..5) {
                    winningCombination += "$i,"
                }
            } else if (playerSymbol == board[6] && playerSymbol == board[7] && playerSymbol == board[8]) {
                res = true
                for(i in 6..8) {
                    winningCombination += "$i,"
                }
            } else if (playerSymbol == board[0] && playerSymbol == board[3] && playerSymbol == board[6]) {
               res = true
                for(i in 0..6 step 3) {
                    winningCombination += "$i,"
                }
            } else if (playerSymbol == board[1] && playerSymbol == board[4] && playerSymbol == board[7]) {
               res = true
                for(i in 1..7 step 3) {
                    winningCombination += "$i,"
                }
            } else if (playerSymbol == board[2] && playerSymbol == board[5] && playerSymbol == board[8]) {
               res = true
                for(i in 2..8 step 3) {
                    winningCombination += "$i,"
                }
            } else if (playerSymbol == board[0] && playerSymbol == board[4] && playerSymbol == board[8]) {
                res =true
                for(i in 0..8 step 4) {
                    winningCombination += "$i,"
                }
            } else if (playerSymbol == board[2] && playerSymbol == board[4] && playerSymbol == board[6]) {
                res = true
                for(i in 2..6 step 2) {
                    winningCombination += "$i,"
                }
            }else {
                res= false
            }
        }

        return res
    }

    fun getWinningCombos(): String {
        return winningCombination
    }

    fun checkWinnerOrBoardFull(): ArrayList<String> {
        var results = ArrayList<String>()
        //board = GridBoard()
        if(winner) {
            val arr: ArrayList<String> = ArrayList(3)
            arr.add(endedCozOfWinnerOrBoardFull)
            arr.add(winner.toString())
            arr.add( playerNum.toString())
            for (r in 0 until arr.size) {
                results.add(arr[r])
            }
            //results.postValue(arr)
        } else if(board.boardIsFull()) {
            endedCozOfWinnerOrBoardFull = "board_full"
            val arr: ArrayList<String> = ArrayList(2)
            arr.add(endedCozOfWinnerOrBoardFull)
            arr.add(board.boardIsFull().toString())
            for (r in 0 until arr.size) {
                results.add(arr[r])
            }
            //results.postValue(arr)
        }
        return results
    }

    fun restartGame() {
        board = GridBoard()
        board.createGrid()
        winner = false
        playerNum = 0
        endedCozOfWinnerOrBoardFull = ""
        roundCount = 0
        winningCombination = ""
    }

    fun getPositionValues(): MutableLiveData<ArrayList<String>> {
        val posValues = board.getGridPositionValuesAfterChange()
        val gridVals: MutableLiveData<ArrayList<String>> = board.getGridPositionValuesAfterChange()
        //gridVals.postValue()
        return gridVals

        //gridVals.postValue(posValues)

    }

    fun getGridPositionsValues(): ArrayList<String> {
        return board.getGridPositionsValues()!!
    }

    fun getBoard():MutableLiveData<ArrayList<String>>   {
        val posValues = board.getGridPositionValuesAfterChange()
        val gridVals: MutableLiveData<ArrayList<String>> = board.getGridPositionValuesAfterChange()
        //gridVals.postValue()
        return gridVals
    }

    fun displayPreviousResult() {
        //TODO
    }
}
