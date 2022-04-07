# Phonebook Application

This program is console application. You can do such actions as:
1) to create a new user
2) to find all information about user by his id
3) to update user by his id
4) to delete user by his id

Run is through .main() in Main class. 
All information will save in a file. 

## Create user
You need enter fist name, last name, email, role, telephones (optional),
when you create a new user. User can have such roles as USER, CUSTOMER, 
ADMIN, PROVIDER, SUPER_ADMIN. By the way USER and CUSTOMER are roles the first level.
the first leve, ADMIN and PROVIDER are roles the second level and SUPER_ADMIN
is role the third level. User can't have roles from one level. And SUPER_ADMIN
can't have other roles at all. Max number of user telephones is three. User
can have zero telephones. 

## Find user by id
You need enter user id if you want to know all information about him.

## Update user by id
You need enter user id if you want to update user information. You can update 
all information. And here you can add, update or delete his telephones.

## Delete user by id
You need enter user id if you want to delete him.