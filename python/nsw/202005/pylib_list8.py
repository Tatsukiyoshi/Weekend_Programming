import sqlite3

conn = sqlite3.connect('sample.db')
c = conn.cursor()

prams = (2, 'USBメモリ32GB', 1200)
c.execute('INSERT INTO items VALUES (?, ?, ?)', prams)
conn.commit()

for row in c.execute('SELECT * FROM items'):
    print(row)

conn.close()

