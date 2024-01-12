class SolarSystem:
    def __init__(self, name):
        self.name = "Sun"

    def show_ss_name(self):
        return f"The only star in our solar system is the {self.name}"


class Planet(SolarSystem):
    def __init__(self, name):
        self.name = name
        self.orbits_a_star = True
        self.mass_enough_to_form_a_sphere = True
        self.cleared_neighborhood_around_orbit = True

    def show_name(self):
        return f"I am planet {self.name}"


class Atm_Moon(Planet):
    def __init__(self, name, atm_type, num_Moons):
        super().__init__(name)
        self.moons = num_Moons
        self.atmosphere = atm_type

    def show_moons(self):
        return f"I have {self.moons} moons"

    def show_atmosphere(self):
        return f"My atmosphere is mostly {self.atmosphere}"


P4wAM = Atm_Moon("Mars", "carbon dioxide", 2)

print(Atm_Moon.__dict__)
