class Wizard(health: Int, power: Int, name: String,  override var mana: Int): Human(health,power, name) {
    override var battery: Int
        get() = TODO()
        set(value) {}
    override var shield: Int
        get() = TODO()
        set(value) {}
    var last: Int = 0
    var hpwizard: Int = 0
    var randompower: Int = 0

    override fun attack(target: Human) {
        mana -= 10
        last = target.health
        randompower = (power-5..power+10).random()
        if (mana > 0){
            target.health -= randompower*2
            println("${target.name} получил ${randompower*2} урона ($last -> ${target.health})")
        }
        else{
            target.health -= power
            println("${target.name} получил ${randompower} урона ($last -> ${target.health})")
        }
    }

    override fun heal() {
        println()
        hpwizard = (5..20).random()
        health += hpwizard
        println("$name восстановил себе $hpwizard здоровья")
        println()
    }
}