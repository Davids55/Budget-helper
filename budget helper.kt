fun main() {
    println(
        "This is a budget helper program that will help organise your money ")


    var budgetLimit = 0

    var expenseItems = mutableSetOf<String>()


    var makeChoice = true


    //Creates the menu at the start of the program every time an action is completed
    while(makeChoice) {
        println()
        println("Select the task you would like to complete:")
        println("1: Enter budget Limit")
        println("2: view current Limit")
        println("3: Enter expense list")
        println("4: View current expense list")
        print(">")


        val choice = readLine()

        if (choice == "1") {

            print("\nEnter your new budget limit: \$")

            budgetLimit = Integer.valueOf(readLine())

            println("your new budget limit is \$$budgetLimit")
        }

        if (choice == "2") println("Your budget limit is \$$budgetLimit")


        if (choice == "3") {
            expenseItems.clear()
            var expenseList = addExpense()
            for (i in expenseList) expenseItems.add(i)
        }


        if (choice == "4") for (i in expenseItems) println(i)

    }

}

//  the code for choice 3
fun addExpense(): Set<String> {

    var addList = true

    // this class is to format the expense entries
    data class Expense(val name: String,
                       val amount: Int,
                       val Date: String
    )

    // empty lsit that will be returned
    val expenses = mutableSetOf<String>()


    // This will loop as many times as they choose and retrieves new expense items from their input
    while (addList) {
        print("Enter expense name: ")
        val budgetItem = readLine()

        print("Enter expense cost: ")
        val budgetExpense = Integer.valueOf(readLine())

        print("Enter the date of the expense: ")
        val expenseDate = readLine()

        val item = Expense("$budgetItem", budgetExpense, "$expenseDate" )

        expenses.add(item.toString())

        print("add another item? y/n:  \n")

        var endLoop = readLine()

        if (endLoop == "n"){
            addList = false
        }

    }
    return expenses

}
