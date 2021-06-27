import sqlite3

conn = sqlite3.connect('sample.db')
c = conn.cursor()

c.execute('CREATE TABLE items (id int, name varchar(64), price int)')
c.execute('INSERT INTO items VALUES (1, "SDカード128GB", 1800)')
conn.commit()

conn.close()
