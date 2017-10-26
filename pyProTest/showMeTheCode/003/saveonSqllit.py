import uuid
import sqlite3

conn = sqlite3.connect('db.sqlite3')
cur = conn.cursor()
query = 'insert into t_test(id) values(?)'
# vals = [uuid.uuid4() for _ in range(200)]
for _ in range(200):
	cur.execute(query, [str(uuid.uuid4())]  )
	
conn.commit()
conn.close()
