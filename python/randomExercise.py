from random import shuffle, randint


def randomExercises(filename):
    try:
        with open(filename, "r") as file:
            exercises = file.readlines()

        print("...Shuffling & checking for repeats...\n")
        shuffle(exercises)
        check_repeated_exercises(exercises)

        with open(filename, "w") as file:
            for exercise in exercises:
                file.write(exercise)

        print(
            f"{filename} has been successfully shuffled with no neighbor repeats. \nCheck file to confirm."
        )

    except Exception as e:
        print(f"An error occurred: {str(e)}")


def check_repeated_exercises(list_exercises):
    list_fully_checked = False
    while not list_fully_checked:
        if move_repeated_exercises(list_exercises):
            list_fully_checked = True


def move_repeated_exercises(exercise_list):
    def move_exercise_to_random_index(index):
        element = exercise_list.pop(index)
        random_index = randint(0, len(exercise_list))
        exercise_list.insert(random_index, element)

    i = 1
    while i < len(exercise_list):
        current_exercise_word = exercise_list[i].split()[0] if exercise_list[i].split() else ''
        prev_exercise_word = exercise_list[i-1].split()[0] if exercise_list[i-1].split() else ''
        if current_exercise_word == prev_exercise_word:
            move_exercise_to_random_index(i)
            print("Found a repeat exercise in a set... successfully moved it\n")
            return False
        print(f"Items through index {i}({exercise_list[i].strip()}) checked")
        i += 1
    return True



randomExercises("exercises.txt")
