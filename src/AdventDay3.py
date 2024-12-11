from collections import Counter


with open("src/AdventDay3Input.txt") as Advent_Input:
    Advent_Input_Value = Advent_Input.read()
    print(Advent_Input_Value)


opener = "mul("
closer = ")"
all_muls = []

while Advent_Input_Value.find(opener) != -1:
    new_input = Advent_Input_Value[Advent_Input_Value.find(opener) :]
    print(new_input)
    all_muls.append(new_input[new_input.find(opener) : new_input.find(closer) + 1])
    Advent_Input_Value = Advent_Input_Value[Advent_Input_Value.find(opener) + 2 :]


print(all_muls)
print(len(all_muls))

# for i in range(1,10):
#     Advent_Input_Value = Advent_Input_Value.replace(str(i), "")


# print(Advent_Input_Value)
# print(Advent_Input_Value.count("mul(,)"))


# Investigate regular expressions
