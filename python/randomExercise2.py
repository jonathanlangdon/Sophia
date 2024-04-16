from random import shuffle


def randomExercises(filename):
    try:
        with open(filename, "r") as file:
            exercises = file.readlines()

        print("...Shuffling & reordering...\n")

        # make lists of arm exercises and a list for everything else
        arm_ex = []
        other_ex = []
        for item in exercises:
            if item[:3] == "arm":
                arm_ex.append(item)
            else:
                other_ex.append(item)

        # shuffle lists
        shuffle(arm_ex)
        shuffle(other_ex)

        # check order of arm exercises for duplicate orders
        # start with end of list
        def check_repeats(index):
            if index == 0:
                return
            moved_item = False
            print(f"Checking arm exercises at index {index}")
            if arm_ex[index] == arm_ex[index - 1]:
                print("fount repeat... moving to index 0")
                arm_ex.insert(0, arm_ex.pop(index - 1))
                print(arm_ex)
                moved_item = True
            if arm_ex[0] == arm_ex[1]:
                print("first 2 items the same, moving...")
                arm_ex.append(arm_ex.pop(0))
                print(arm_ex)
                moved_item = True
            check_repeats(len(arm_ex) - 1) if moved_item else check_repeats(index - 1)

        # compile lists alternating arms & other exercises
        new_exercise_list = []
        list_length = len(arm_ex) + len(other_ex)
        for i in range(list_length):
            if i % 2 == 0 and i / 2 < len(arm_ex):
                new_exercise_list.append(arm_ex[i // 2])
            else:
                new_exercise_list.append(other_ex.pop(0))

        # put exercises in file
        with open(filename, "w") as file:
            for exercise in new_exercise_list:
                file.write(exercise)

        print(
            f"{filename} has been successfully shuffled with no neighbor repeats. \nCheck file to confirm."
        )

    except Exception as e:
        print(f"An error occurred: {str(e)}")


randomExercises("exercises.txt")
