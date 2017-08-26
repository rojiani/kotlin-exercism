enum class Allergen(val score: Int) {
    EGGS(1),            // 0b00000001
    PEANUTS(2),         // 0b00000010
    SHELLFISH(4),       // 0b00000100
    STRAWBERRIES(8),    // 0b00001000
    TOMATOES(16),       // 0b00010000
    CHOCOLATE(32),      // 0b00100000
    POLLEN(64),         // 0b01000000
    CATS(128)           // 0b10000000
}
