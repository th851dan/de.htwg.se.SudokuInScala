package de.htwg.se.sudoku.model

import scala.util.Random

class GridCreateRandomStrategy extends GridCreateStrategyTemplate {

  def fill(_grid: Grid): Grid = {
    val num = Math.sqrt(_grid.size).toInt
    var grid = new Grid(_grid.size)
    for { index <- 1 to num } {
      grid = setRandomCell(grid)
    }
    grid
  }

  private def setRandomCell(grid: Grid): Grid = {
    val row = Random.nextInt(grid.size)
    val column = Random.nextInt(grid.size)
    val availableValueSet = grid.available(row, column).toIndexedSeq
    val numAvailableValues = availableValueSet.size
    if (numAvailableValues > 0) {
      val value = availableValueSet(Random.nextInt(numAvailableValues))
      grid.set(row, column, value)
    } else grid
  }
}
