from random import shuffle

<<<<<<< HEAD

=======
>>>>>>> 7bab7cde5d96e910afab5c9addd7ad4f0db781d5
def randomExercises(filename):
    try:
        with open(filename, "r") as file:
            exercises = file.readlines()
        arm_ex = []
        other_ex = []
        for item in exercises:
<<<<<<< HEAD
            arm_ex.append(item) if item[:3] == "arm" else other_ex.append(item)
=======
            arm_ex.append(item) if item[:3] != "arm" else other_ex.append(item)
>>>>>>> 7bab7cde5d96e910afab5c9addd7ad4f0db781d5
        print("\n\n")
        print("...Shuffling & reordering...\n")
        shuffle(other_ex)
        new_exercise_list = []
        list_length = len(arm_ex) + len(other_ex)

        for i in range(list_length):
            if i % 2 == 0 and i / 2 < len(arm_ex):
                new_exercise_list.append(arm_ex[i / 2])
            else:
                new_exercise_list.append(other_ex.pop(0))

        with open(filename, "w") as file:
            for exercise in new_exercise_list:
                file.write(exercise)

        print(f"{filename} has been shuffled. \nCheck file")

    except Exception as e:
        print(f"An error occurred: {str(e)}")


randomExercises("exercises.txt")
