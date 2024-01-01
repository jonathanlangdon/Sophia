import random


def randomExercises(filename):
    try:
        with open(filename, "r") as file:
            exercises = file.readlines()
            random.shuffle(exercises)
            print(split_into_groups_of_three(exercises))

    except Exception as e:
        print(f"An error occurred: {str(e)}")


def check_repeated_exercises(list_exercises):
    list_fully_checked = False
    while not list_fully_checked:
        if move_repeated_exercises(list_exercises):
            list_fully_checked = True


def split_into_groups_of_three(list_exercises):
    list_of_groups = []
    for i in range(0, len(list_exercises), 3):
        list_of_groups.append(list_exercises[i : i + 3])
    return list_of_groups
