def randomExercises(filename):
    try:
        with open(filename, "r") as file:
            exercises = file.readlines()
            random.shuffle(exercises)

    except Exception as e:
        print(f"An error occurred: {str(e)}")
