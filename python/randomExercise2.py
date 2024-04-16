from random import shuffle, randint


def randomExercises(filename):
    try:
        with open(filename, "r") as file:
            exercises = file.readlines()

        print("...Shuffling & reordering...\n")
        arm_ex = []
        other_ex = []

        for item in exercises:
            if item[:3] == "arm":
                arm_ex.append(item)
            else:
                other_ex.append(item)

        shuffle(arm_ex)
        shuffle(other_ex)

        new_exercise_list = []
        list_length = len(arm_ex) + len(other_ex)
        for i in range(list_length):
            if i % 2 == 0 and i / 2 < len(arm_ex):
                new_exercise_list.append(arm_ex[i // 2])
            else:
                new_exercise_list.append(other_ex.pop(0))

        with open(filename, "w") as file:
            for exercise in new_exercise_list:
                file.write(exercise)

        print(
            f"{filename} has been successfully shuffled with no neighbor repeats. \nCheck file to confirm."
        )

    except Exception as e:
        print(f"An error occurred: {str(e)}")


randomExercises("exercises.txt")
