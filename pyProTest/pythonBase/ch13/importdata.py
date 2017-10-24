import sqlite3

def convert(value):
	if value.startswith('~'):
		return value.strip('~')
	if not value:
		value = '0'
	return value

conn = sqlite3.connect('foot.db')
curs = conn.cursor()

# curs.execute('''
# 	create table food(
# 	id text primary key,
# 	desc text,
# 	water float,
# 	kcal float,
# 	protein float,
# 	fat float,
# 	ash float,
# 	carbs float,
# 	fiber float,
# 	sugar float
# 	)
# 	''')
query = 'insert into food(id, desc, water, kcal, protein, fat, ash) values(?,?,?,?,?,?,?)'
field_count=7
for line in open('ABBREV.txt'):
	fields = line.split("^")
	vals = [convert(f) for f in fields[:field_count]]
	curs.execute(query, vals)

conn.commit()
conn.close()