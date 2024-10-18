class Knight(health: Int, power: Int, name: String, override var shield: Int): Human(health,power, name) {
    override var mana: Int
        get() = TODO()
        set(value) {}
    override var battery: Int
        get() = TODO()
        set(value) {}
    var last: Int = 0
    var randompower: Int = 0

    override fun attack(target: Human) {
            randompower = (power-5..power+10).random()
            last = target.health
            target.health -= power
            println("${target.name} получил ${randompower} урона ($last -> ${target.health})")
        }
}