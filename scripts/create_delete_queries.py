file = open("delete_mhtrwa.sql", "w")
for i in range(1, 10_001):
    file.write(f"DELETE FROM MHTRWO WHERE ONOMA='Test{i}' AND EPONYMO='Test{i}' AND PATRONYMO='Test{i}';\n")
