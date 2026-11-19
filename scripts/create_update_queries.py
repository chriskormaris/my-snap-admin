import random
from lytrax_afm import generate_valid_afm

file = open("update_mhtrwa.sql", "w")
for i in range(1, 11):
    afm = generate_valid_afm()
    salary = random.randint(700, 2_500)
    file.write(f"UPDATE MHTRWO SET AFM={afm}, SALARY={salary} WHERE ONOMA='Test{i}' AND EPONYMO='Test{i}' AND PATRONYMO='Test{i}';\n")
