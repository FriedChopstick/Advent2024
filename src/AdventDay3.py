from collections import Counter

def check_if_valid(mul):
   test_mul = mul
   for i in range(1,10):
      test_mul = test_mul.replace(f"{i}", "")
   if test_mul == "mul(,)":
      return True
   return False

def calculate_mul(mul):
    first_term = mul[mul.find("(") + 1: mul.find(",")]
    second_term = mul[mul.find(",") + 1: mul.find(")")]
    return int(first_term) * int(second_term)

with open("src/AdventDay3Input.txt") as Advent_Input:
    Advent_Input_Value = Advent_Input.read()
    print(Advent_Input_Value)


opener = "mul("
closer = ")"
all_muls = []
total = 0

while Advent_Input_Value.find(opener) != -1:
    new_input = Advent_Input_Value[Advent_Input_Value.find(opener) :]
    print(new_input)
    all_muls.append(new_input[new_input.find(opener) : new_input.find(closer) + 1])
    Advent_Input_Value = Advent_Input_Value[Advent_Input_Value.find(opener) + 2 :]

for i, mul in enumerate(all_muls):
    if check_if_valid(mul) == True:
        total += calculate_mul(mul)
        

print(all_muls)
print(len(all_muls))
print(total)

   #  for i in range(1,10):
   #    mul.replace(i, "")


# for i in range(1,10):
#     Advent_Input_Value = Advent_Input_Value.replace(str(i), "")


# print(Advent_Input_Value)
# print(Advent_Input_Value.count("mul(,)"))


# Investigate regular expressions
