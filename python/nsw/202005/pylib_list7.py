import sqlite3

conn = sqlite3.connect('sample.db')
c = conn.cursor()

for row in c.execute('SELECT * FROM items'):
    print(row)

conn.close()
