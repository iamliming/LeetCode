__author__ = 'tony'
#
# Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
#
# push(x) -- Push element x onto stack.
# pop() -- Removes the element on top of the stack.
# top() -- Get the top element.
# getMin() -- Retrieve the minimum element in the stack.
#*min:
# ----------------------------------------------
#  100-->80-->80-->70
#  ----------------------------------------------
#  stack
#  ---------------------------------------------
#  0|-20|10|-10

class MinStack:
    def __init__(self):
        self.A = []
        self.min = 0;
    # @param x, an integer
    # @return an integer
    def push(self, x):
        if len(self.A) == 0:
            self.A.append(0)
            self.min=x
        else:
            self.A.append(x-self.min)
            if x < self.min:
                self.min = x
    #Removes the element on top of the stack.
    def pop(self):
        tmp=self.A.pop()
        if tmp < 0:
            self.min = self.min -tmp
    # @return an integer
    def top(self):
        tmp = self.A[len(self.A) - 1]
        if tmp<0:
            return self.min
        return self.min + tmp
    # @return an integer
    def getMin(self):
        return self.min
    def size(self):
        return len(self.A)

mystack = MinStack()
mystack.push(50)
mystack.push(100)
mystack.push(80)
mystack.push(20)
mystack.push(10)
mystack.push(40)
mystack.push(80)

print(mystack.A)
while mystack.size()>0:
    print("===========")
    print('min' + str(mystack.getMin()))
    print('top' + str(mystack.top()))
    mystack.pop()
