# http://tinyurl.com/zrg24hj

class Queue:
    def __init__(self):
        self.items = []
    
    def is_empty(self):
        return self.items == []
    
    def enqueue(self, item):
        self.items.insert(0, item)
    
    def dequeue(self):
        return self.items.pop()
    
    def size(self):
        return len(self.items)

# http://tinyurl.com/j3ck9jl

a_queue = Queue()
print(a_queue.is_empty())

# http://tinyurl.com/jzjrg8s

a_queue = Queue()

for i in range(5):
    a_queue.enqueue(i)

print(a_queue.size())

# http://tinyurl.com.jazkh8b

a_queue = Queue()

for i in range(5):
    a_queue.enqueue(i)

while a_queue.size():
    print(a_queue.dequeue())

print()
print(a_queue.size())
