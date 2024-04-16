from random import shuffle


# check order of arm exercises for duplicate orders
# start with end of list
def check_repeats(the_list, index):
    if index == 0:
        return
    moved_item = False
    print(f"Checking arm exercises at index {index}")
    if the_list[index] == the_list[index - 1]:
        print("fount repeat 1 away... moving to index 0")
        the_list.insert(0, the_list.pop(index))
        print(the_list)
        moved_item = True
    if index >= 2 and the_list[index] == the_list[index - 2]:
        print("fount repeat 2 away... moving to index 0")
        the_list.insert(0, the_list.pop(index))
        print(the_list)
        moved_item = True
    if the_list[0] == the_list[1]:
        print("first 2 items the same, moving...")
        the_list.append(the_list.pop(0))
        print(the_list)
        moved_item = True
    (
        check_repeats(the_list, len(the_list) - 1)
        if moved_item
        else check_repeats(the_list, index - 1)
    )


def randomExercises(filename):
    try:
        with open(filename, "r") as file:
            exercises = file.readlines()
        arm_ex = []  # make lists for exercises
        other_ex = []
        for item in exercises:
            arm_ex.append(item) if item[:3] == "arm" else other_ex.append(item)
        check_repeats(arm_ex, len(arm_ex) - 1)
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
