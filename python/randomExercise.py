from random import shuffle


def randomExercises(filename):
    try:
        with open(filename, "r") as file:
            exercises = file.readlines()
            print("...Shuffling...\n")
            shuffle(exercises)
            check_repeated_exercises(exercises)

        with open(filename, "w") as file:
            for exercise in exercises:
                file.write(exercise)

        print(
            f"Exercises from {filename} have been successfully shuffled. Check file to confirm."
        )

    except Exception as e:
        print(f"An error occurred: {str(e)}")


def check_repeated_exercises(list_exercises):
    list_fully_checked = False
    while not list_fully_checked:
        if move_repeated_exercises(list_exercises):
            list_fully_checked = True


def move_repeated_exercises(exercise_list):
    def move_element(element, to_start=False):
        exercise_list.remove(element)
        if to_start:
            exercise_list.insert(0, element)
        else:
            exercise_list.append(element)

    i = 0
    while i < len(exercise_list) - len(exercise_list) % 3:
        chunk = exercise_list[i : i + 3]
        for element in chunk:
            if chunk.count(element) > 1:
                move_element(element, to_start=(i + 3 >= len(exercise_list)))
                print("Found a repeat exercise in a set... successfully moved it\n")
                return False
        i += 3
    return True


randomExercises("exercises.txt")
