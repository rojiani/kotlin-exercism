import Orientation.*

/**
 * Robot
 *
 * http://exercism.io/exercises/kotlin/robot-simulator/readme
 *
 * @author nrojiani
 * @date 9/22/17
 */
class Robot(var gridPosition: GridPosition, var orientation: Orientation) {

    companion object {
        val origin = GridPosition(0, 0)
    }

    constructor() : this(origin, NORTH)

    fun advance() {
        gridPosition = when (orientation) {
            NORTH -> GridPosition(gridPosition.x,     gridPosition.y + 1)
            EAST  -> GridPosition(gridPosition.x + 1, gridPosition.y)
            WEST  -> GridPosition(gridPosition.x - 1, gridPosition.y)
            SOUTH -> GridPosition(gridPosition.x,     gridPosition.y - 1)
        }
    }

    fun turnRight() {
        orientation = when (orientation) {
            NORTH -> EAST
            EAST  -> SOUTH
            WEST  -> NORTH
            SOUTH -> WEST
        }
    }

    fun turnLeft() {
        orientation = when (orientation) {
            NORTH -> WEST
            EAST  -> NORTH
            WEST  -> SOUTH
            SOUTH -> EAST
        }
    }

    fun simulate(instructions: String) {
        instructions.forEach {
            when (it) {
                'R' -> turnRight()
                'L' -> turnLeft()
                'A' -> advance()
            }
        }
    }
}
