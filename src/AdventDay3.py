from collections import Counter

# If all numbers turn to blank and it matches
# Mul is valid
def check_if_valid(mul):
    test_mul = mul
    for i in range(10):
        test_mul = test_mul.replace(f"{i}", "")
    if test_mul == "mul(,)":
        return True
    return False

# Calculations
def calculate_mul(mul):
    first_term = mul[mul.find("(") + 1 : mul.find(",")]
    second_term = mul[mul.find(",") + 1 : mul.find(")")]
    return int(first_term) * int(second_term)

# Get input
with open("src/AdventDay3Input.txt") as Advent_Input:
    Advent_Input_Value = Advent_Input.read()

opener = "mul("
closer = ")"
all_muls = []
total = 0

### Part 1

# Goes through input and appends any possible mults to a list
while Advent_Input_Value.find(opener) != -1:
    new_input = Advent_Input_Value[Advent_Input_Value.find(opener) :]
    all_muls.append(new_input[new_input.find(opener) : new_input.find(closer) + 1])
    Advent_Input_Value = Advent_Input_Value[Advent_Input_Value.find(opener) + 2 :]

# Check each mul in list and add valid numbers to total
for i, mul in enumerate(all_muls):
    if check_if_valid(mul):
        total += calculate_mul(mul)

print(f"Part 1 Total: {total}")

# Part 2 
all_muls = []
total = 0
to_do = "do()"
to_not_do = "don't()"
to_do_bool = True

with open("src/AdventDay3Input.txt") as Advent_Input:
    Advent_Input_Value = Advent_Input.read()

while Advent_Input_Value.find(opener) != -1:
    to_do_bool = Advent_Input_Value.find(to_do) < Advent_Input_Value.find(to_not_do)
    if to_do_bool:
        new_input = Advent_Input_Value[Advent_Input_Value.find(opener) :]
        all_muls.append(new_input[new_input.find(opener) : new_input.find(closer) + 1])
        Advent_Input_Value = Advent_Input_Value[Advent_Input_Value.find(opener) + 2 :]
    else:
        new_input = Advent_Input_Value[Advent_Input_Value.find(opener) :]
        Advent_Input_Value = Advent_Input_Value[Advent_Input_Value.find(opener) + 2 :]

print(len(all_muls))
print(all_muls)

for i, mul in enumerate(all_muls):
    if check_if_valid(mul):
        total += calculate_mul(mul)

print(f"Part 2 Total: {total}")
# Investigate regular expressions
