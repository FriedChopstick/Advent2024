with open("AdventDay3Input.txt") as Advent_Input:
    Advent_Input_Value =  Advent_Input.read()
    print(Advent_Input_Value)

Advent_Input_Value = Advent_Input_Value.replace("mul", "#")
print(Advent_Input_Value)

