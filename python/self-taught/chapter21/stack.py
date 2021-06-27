# http://tinyurl.com/zk24ps6

class Stack:
    def __init__(self):
        self.items = []
    
    def is_empty(self):
        return self.items == []
    
    def push(self, item):
        self.items.append(item)
    
    def pop(self):
        return self.items.pop()
    
    def peek(self):
        last = len(self.items) - 1
        return self.items[last]
    
    def size(self):
        return len(self.items)

# http://tinyurl.com/jfybm4v

stack = Stack()
print(stack.is_empty())

# http://tinyurl.com/zsexcal

stack = Stack()
stack.push(1)
print(stack.is_empty())

# http://tinyurl.com/j72kswr

stack = Stack()
stack.push(1)
item = stack.pop()
print(item)
print(stack.is_empty())

# http://tinyurl.com/zle7sno

stack = Stack()

for i in range(0, 6):
    stack.push(i)

print(stack.peek())
print(stack.size())

# http://tinyurl.com/zoosvqg

stack = Stack()
for c in "Hello":
    stack.push(c)

reverse = ""

while stack.size():
    reverse += stack.pop()

print(reverse)
