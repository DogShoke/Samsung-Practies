class Robot(health: Int, power: Int, name: String, override var battery: Int): Human(health,power, name) {
    override var mana: Int
        get() = TODO()
        set(value) {}
    override var shield: Int
        get() = TODO()
        set(value) {}
    var last: Int = 0
    var randompower: Int = 0

    override fun attack(target: Human) {
        battery -= 10
        last = target.health
        if (battery > 0){
            randompower = (power+5..power+35).random()
            target.health -= randompower
            println("${target.name} получил ${randompower} урона ($last -> ${target.health})")
        }
        else{
            target.health -= power
            println("${target.name} получил ${randompower} урона ($last -> ${target.health})")
        }

    }
}