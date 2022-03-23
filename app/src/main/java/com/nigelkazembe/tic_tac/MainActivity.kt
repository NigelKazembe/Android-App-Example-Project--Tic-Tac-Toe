package com.nigelkazembe.tic_tac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.nigelkazembe.tic_tac.databinding.ActivityMainBinding
import com.nigelkazembe.tic_tac.GridBoard

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private var gridPosition = 0
    private var countPlayerMoves = 0 //for when a player moves, used to denote which player it is that will be playing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        whenGameLaunches()
        listenerSetup()


    }

    private fun observerSetup() {
        var winningCombs = ""

        var result = viewModel.checkWinnerOrBoardFull()
            //result.let {
                if (result.isNotEmpty()) {
                    if (result[0] == "Winner") {
                        winningCombs = viewModel.getWinningCombos()
                        var strFoCombs = ""
                        for (i in 0 until winningCombs.length - 1) {
                            strFoCombs += winningCombs[i]
                        }

                        when (strFoCombs) {
                            "0,1,2" -> {
                                binding.button4.isEnabled = false
                                binding.button5.isEnabled = false
                                binding.button6.isEnabled = false
                                binding.button7.isEnabled = false
                                binding.button8.isEnabled = false
                                binding.button9.isEnabled = false
                                binding.textView.text = getString(R.string.winner) + result[2]
                            }
                            "3,4,5" -> {
                                binding.button1.isEnabled = false
                                binding.button2.isEnabled = false
                                binding.button3.isEnabled = false
                                binding.button7.isEnabled = false
                                binding.button8.isEnabled = false
                                binding.button9.isEnabled = false
                                binding.textView.text = getString(R.string.winner) + result[2]
                            }
                            "6,7,8" -> {
                                binding.button4.isEnabled = false
                                binding.button5.isEnabled = false
                                binding.button6.isEnabled = false
                                binding.button1.isEnabled = false
                                binding.button2.isEnabled = false
                                binding.button3.isEnabled = false
                                binding.textView.text = getString(R.string.winner) + result[2]
                            }
                            "0,3,6" -> {
                                binding.button2.isEnabled = false
                                binding.button5.isEnabled = false
                                binding.button6.isEnabled = false
                                binding.button3.isEnabled = false
                                binding.button8.isEnabled = false
                                binding.button9.isEnabled = false
                                binding.textView.text = getString(R.string.winner) + result[2]
                            }
                            "1,4,7" -> {
                                binding.button4.isEnabled = false
                                binding.button1.isEnabled = false
                                binding.button6.isEnabled = false
                                binding.button7.isEnabled = false
                                binding.button3.isEnabled = false
                                binding.button9.isEnabled = false
                                binding.textView.text = getString(R.string.winner) + result[2]
                            }
                            "2,4,6" -> {
                                binding.button4.isEnabled = false
                                binding.button1.isEnabled = false
                                binding.button6.isEnabled = false
                                binding.button2.isEnabled = false
                                binding.button8.isEnabled = false
                                binding.button9.isEnabled = false
                                binding.textView.text = getString(R.string.winner) + result[2]
                            }
                            "0,4,8" -> {
                                binding.button4.isEnabled = false
                                binding.button2.isEnabled = false
                                binding.button6.isEnabled = false
                                binding.button7.isEnabled = false
                                binding.button8.isEnabled = false
                                binding.button3.isEnabled = false
                                binding.textView.text = getString(R.string.winner) + result[2]
                            }
                            "2,5,8" -> {
                                binding.button4.isEnabled = false
                                binding.button5.isEnabled = false
                                binding.button2.isEnabled = false
                                binding.button7.isEnabled = false
                                binding.button8.isEnabled = false
                                binding.button1.isEnabled = false
                                binding.textView.text = getString(R.string.winner) + result[2]
                            }
                        }
                    } else if (result[0] == "board_full") {
                        binding.textView.text = getString(R.string.boardFull)
                    }
                }
            }


    private fun listenerSetup() {
        binding.startGame.setOnClickListener{
            viewModel.startNewGame()
            binding.button1.isEnabled = true
            binding.button2.isEnabled = true
            binding.button3.isEnabled = true
            binding.button4.isEnabled = true
            binding.button5.isEnabled = true
            binding.button6.isEnabled = true
            binding.button7.isEnabled = true
            binding.button8.isEnabled = true
            binding.button9.isEnabled = true
            binding.restartGame.isEnabled = true
            binding.startGame.isEnabled = false
            displayGrid()
        }

        binding.button1.setOnClickListener {
            gridPosition = 1
            countPlayerMoves++
            viewModel.insertSelection(countPlayerMoves, gridPosition)
            displayGrid()
            observerSetup()
            binding.button1.isEnabled = false

        }

        binding.button2.setOnClickListener {
            gridPosition = 2
            countPlayerMoves++
            viewModel.insertSelection(countPlayerMoves, gridPosition)
            displayGrid()
            observerSetup()
            binding.button2.isEnabled = false

        }

        binding.button3.setOnClickListener {
            gridPosition = 3
            countPlayerMoves++
            viewModel.insertSelection(countPlayerMoves, gridPosition)
            displayGrid()
            observerSetup()
            binding.button3.isEnabled = false
        }

        binding.button4.setOnClickListener {
            gridPosition = 4
            countPlayerMoves++
            viewModel.insertSelection(countPlayerMoves, gridPosition)
            displayGrid()
            observerSetup()
            binding.button4.isEnabled = false
        }

        binding.button5.setOnClickListener {
            gridPosition = 5
            countPlayerMoves++
            viewModel.insertSelection(countPlayerMoves, gridPosition)
            displayGrid()
            observerSetup()
            binding.button5.isEnabled = false
        }

        binding.button6.setOnClickListener {
            gridPosition = 6
            countPlayerMoves++
            viewModel.insertSelection(countPlayerMoves, gridPosition)
            displayGrid()
            observerSetup()
            binding.button6.isEnabled = false
        }

        binding.button7.setOnClickListener {
            gridPosition = 7
            countPlayerMoves++
            viewModel.insertSelection(countPlayerMoves, gridPosition)
            displayGrid()
            observerSetup()
            binding.button7.isEnabled = false
        }

        binding.button8.setOnClickListener {
            gridPosition = 8
            countPlayerMoves++
            viewModel.insertSelection(countPlayerMoves, gridPosition)
            displayGrid()
            observerSetup()
            binding.button8.isEnabled = false
        }

        binding.button9.setOnClickListener {
            gridPosition = 9
            countPlayerMoves++
            viewModel.insertSelection(countPlayerMoves, gridPosition)
            displayGrid()
            observerSetup()
            binding.button9.isEnabled = false
        }

        binding.restartGame.setOnClickListener {
            viewModel.restartGame()
            binding.restartGame.isEnabled = true
            binding.startGame.isEnabled = false
            binding.button1.isEnabled = true
            binding.button2.isEnabled = true
            binding.button3.isEnabled = true
            binding.button4.isEnabled = true
            binding.button5.isEnabled = true
            binding.button6.isEnabled = true
            binding.button7.isEnabled = true
            binding.button8.isEnabled = true
            binding.button9.isEnabled = true
            countPlayerMoves = 0
            gridPosition = 0
            displayGrid()
        }
    }

    private fun displayGrid() {
        val values = viewModel.getGridPositionsValues()
        binding.button1.text = values[0].toString()
        binding.button2.setText(values[1].toString())
        binding.button3.setText(values[2].toString())
        binding.button4.setText(values[3].toString())
        binding.button5.setText(values[4].toString())
        binding.button6.setText(values[5].toString())
        binding.button7.setText(values[6].toString())
        binding.button8.setText(values[7].toString())
        binding.button9.setText(values[8].toString())
    }

    //Only the start game button should be clickable
    private fun whenGameLaunches() {
        var but: String = "button1"
        binding.button1.isEnabled = false
        binding.button2.isEnabled = false
        binding.button3.isEnabled = false
        binding.button4.isEnabled = false
        binding.button5.isEnabled = false
        binding.button6.isEnabled = false
        binding.button7.isEnabled = false
        binding.button8.isEnabled = false
        binding.button9.isEnabled = false
        binding.restartGame.isEnabled = false
    }


}