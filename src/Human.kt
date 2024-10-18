abstract class Human(
    var health:Int,
    val power:Int,
    val name: String
) {
    abstract var mana: Int
    abstract var battery: Int
    abstract var shield: Int
    var hp: Int = 0
    //var randomattack: Int = 0

    open fun heal() {
        println()
        hp = (0..10).random()
        health += hp
        println("$name восстановил себе $hp здоровья")
        println()
    }

    open fun attack(target: Human){
        //randomattack = (power-5..power+10).random()
        target.health -= power//randomattack

    }

    override fun toString(): String {
        return "$name health = $health\n"
    }
}
