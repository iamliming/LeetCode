__author__ = 'tony'

# int(variable) - casts variable to integer
# str(variable) - casts variable to string
# float(variable) - casts variable to float (number with decimal)

a = "1.1"
b = 2.22
c = float(a);
print(b * c)

print (3 + 4)
print (3 - 4)
print (3 * 4)
print (3 / 4)
print (3 % 2)
print (3 ** 4)  # 3 to the fourth power
print (3 // 4)  # floor division
print (4 / 3)


# Assignment Operators
a = 1
a += 2
print (a)


# if statement
a = 20
if a >= 22:
    print ("if")
elif a >= 21:
    print ("elseif")
else:
    print ("else")


# function

def testFunc(a, b):
    print (a + b)


testFunc(a, b)
testFunc('a','b')

# 全局变量,局部变量
# 定义在文件中的是全局变量,函数中或者语句中的是局部变量

# 循环 loop range 和普通的()有区别
print("=================for")
c = 100
sum = 0
for a in range(1, c):
    sum += a
print (sum)

#while
print("=================while")
a=1
sum=0
while (a<10):
    print (a)
    sum+=a
    a+=1
print (sum)
# string
print("===============String")
str="abcdef"
print (type(str))
print (str.count("a"))
print (str.find("a"))
# stringVar.count('x') - counts the number of occurrences of 'x' in stringVar
# stringVar.find('x') - returns the position of character 'x'
# stringVar.lower() - returns the stringVar in lowercase (this is temporary)
# stringVar.upper() - returns the stringVar in uppercase (this is temporary)
# stringVar.replace('a', 'b') - replaces all occurrences of a with b in the string
# stringVar.strip() - removes leading/trailing white space from string
print(" string idex ")
print (str[2:3])
print (str[2:-1])
print(" =============List ")
a=["1","2","3","4","5","6"]
sum=0
print(a[1])
print(a.append('x')) # appends element to end of the list
print(a.count('x')) # counts the number of occurrences of 'x' in the list
print(a.index('x')) # returns the index of 'x' in the list
a.insert(8,'y') # inserts 'x' at location 'y'
print (a)
print(a.pop()) # returns last element then removes it from the list
print(a.remove('x')) # finds and removes first 'x' from list
print(a.reverse()) # reverses the elements in the list
print(a.sort()) # sorts the list alphabetically in ascending order, or numerical in ascending order
print (a)
