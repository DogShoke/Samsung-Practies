import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    var a: Int = 0
    while (a != 3){
        println("1 - Правила\n" +
                "2 - Играть\n" +
                "3 - Выход")
        a = input.nextInt()
        if (a == 1){
            println("____________________________________________________________________")
            println("Правила:")
            println()
            println(
                "Wizard: Атака - рандомное значение в пределах от (сила атаки - 5) до (сила атаки + 10)\n" +
                        "Мана удваивает атаку \n" +
                        "1 усиленный удар = 10 маны "
            )
            println("Волшебник может вылечить себя на рандомное число от 5 до 20")
            println()
            println(
                "Robot: Благодаря батарейке атака работа равна рандомному числу от (сила атаки +5) до (сила атаки + 35)\n" +
                        "1 атака затрачивает 10 зарядов батарейки"
            )
            println("Робот может вылечить себя на рандомное число от 0 до 10")
            println()
            println("Knight: Атака - рандомное значение в пределах от (сила атаки - 5) до (сила атаки + 10)\n" +
                    "Щит увеличивает здоровье рыцаря на свое значение умноженное на 2")
            println("Рыцарь может вылечить себя на рандомное число от 0 до 10")
            println("____________________________________________________________________")
        }
        if (a == 2) {
            var flag = 0
            println("Wizard: ")
            println("Введите здровье ")
            val healthW = input.nextInt()
            println("Введите силу атаки ")
            val powerW = input.nextInt()
            var name = "Wizard"
            println("Введите количество Маны ")
            var mana = input.nextInt()
            Wizard(healthW, powerW, name, mana)
            var wizard = Wizard(healthW, powerW, name, mana)

            println("Robot: ")
            println("Введите здровье ")
            val healthR = input.nextInt()
            println("Введите силу атаки ")
            val powerR = input.nextInt()
            name = "Robot"
            println("Введите заряд батареи: ")
            var battery = input.nextInt()
            Robot(healthR, powerR, name, battery)
            var robot = Robot(healthR, powerR, name, battery)

            println("Knight: ")
            println("Введите здровье ")
            val healthK = input.nextInt()
            println("Введите силу атаки ")
            val powerK = input.nextInt()
            name = "Knight"
            println("Введите здоровье щита ")
            var shield = input.nextInt()
            Knight(healthK, powerK, name, shield)
            var knight = Knight(healthK + shield * 2, powerK, name, shield)

            var count: Int = 0
            println("Количество ходов: ")
            val j = input.nextInt()
            println(
                "Wizard: 1 \n " +
                        "Robot: 2 \n" +
                        "Knight: 3 \n"
            )

            var arrayPlayers = arrayOf(wizard, robot, knight)
            while (count < j) {
                println("player = ")
                var a = input.nextInt()
                println("enemy = ")
                var b = input.nextInt()
                when (a) {
                    1 -> {
                        var player = wizard
                        when (b) {
                            1 -> {
                                wizard.attack(wizard)
                                wizard.heal()
                            }

                            2 -> {
                                wizard.attack(robot)
                                wizard.heal()
                            }

                            3 -> {
                                wizard.attack(knight)
                                wizard.heal()
                            }
                        }

                    }

                    2 -> {
                        var player = robot
                        when (b) {
                            1 -> {
                                robot.attack(wizard)
                                robot.heal()
                            }

                            2 -> {
                                robot.attack(robot)
                                robot.heal()
                            }

                            3 -> {
                                robot.attack(knight)
                                robot.heal()
                            }
                        }
                    }

                    3 -> {
                        var player = knight
                        when (b) {
                            1 -> {
                                knight.attack(wizard)
                                knight.heal()
                            }

                            2 -> {
                                knight.attack(robot)
                                knight.heal()
                            }

                            3 -> {
                                knight.attack(knight)
                                knight.heal()
                            }
                        }
                    }
                }

                if (wizard.health <= 0 || robot.health <= 0 || knight.health <= 0) {
                    Arrays.sort(arrayPlayers, CustomComparator())
                    println(arrayPlayers.contentToString())
                    flag = 1
                    break
                }
                Arrays.sort(arrayPlayers, CustomComparator())
                println(arrayPlayers.contentToString())
                println()
                count++
            }
        }
    }
}