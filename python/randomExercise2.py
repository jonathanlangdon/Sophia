from random import shuffle


# confirm file has no blank lines or duplicate exercises that are not synced
def validate_file_format(exercise_list):
    for i in range(0, len(exercise_list)):
        if exercise_list[i] == "" or exercise_list[i] == "\n":
            print(f"blank line on line {i}, please check")
            return False
        current_i_item = exercise_list[i][13:17]
        for j in range(0, len(exercise_list)):
            if i == j:
                continue
            repeated_items = current_i_item == exercise_list[j][13:17]
            if repeated_items and exercise_list[i] is not exercise_list[j]:
                print(
                    "There are identical exercises that are not synchronized. Check your file"
                )
                return False
    return True


# check order of arm exercises for duplicate orders
# start with end of list
def check_repeats(exercise_list, index):
    if index == 0:
        return
    moved_item = False
    print(f"Checking arm exercises at index {index}")
    if exercise_list[index] == exercise_list[index - 1]:
        print("fount repeat 1 away... moving to index 0")
        exercise_list.insert(0, exercise_list.pop(index))
        moved_item = True
    if index >= 2 and exercise_list[index] == exercise_list[index - 2]:
        if index < 3:
            print("fount repeat 2 away... moving to index + 1")
            exercise_list.insert(index + 1, exercise_list.pop(index))
        else:
            print("fount repeat 2 away... moving to index - 1")
            exercise_list.insert(index - 1, exercise_list.pop(index))
        moved_item = True
    if exercise_list[0] == exercise_list[1]:
        print("first 2 items the same, moving...")
        exercise_list.append(exercise_list.pop(0))
        moved_item = True
    if moved_item:
        check_repeats(exercise_list, len(exercise_list) - 1)
    else:
        check_repeats(exercise_list, index - 1)


def randomExercises(filename):
    try:
        with open(filename, "r") as file:
            exercises = file.readlines()
        if validate_file_format(exercises) is False:
            return
        arm_ex = []  # make lists for exercises
        other_ex = []
        for item in exercises:
            arm_ex.append(item) if item[:3] == "arm" else other_ex.append(item)
        print("\n\n")
        check_repeats(arm_ex, len(arm_ex) - 1)
        print("\n\n")
        check_repeats(other_ex, len(other_ex) - 1)
        print("...Shuffling & reordering...\n")
        shuffle(arm_ex)
        shuffle(other_ex)
        new_exercise_list = []  # compile lists alternating
        list_length = len(arm_ex) + len(other_ex)

        for i in range(list_length):
            if i % 2 == 0 and i / 2 < len(arm_ex):
                new_exercise_list.append(arm_ex[i // 2])
            else:
                new_exercise_list.append(other_ex.pop(0))

        with open(filename, "w") as file:
            for exercise in new_exercise_list:
                file.write(exercise)  # put exercises in file

        print(f"{filename} has been shuffled with no neighbor repeats. \nCheck file")

    except Exception as e:
        print(f"An error occurred: {str(e)}")


randomExercises("exercises.txt")
