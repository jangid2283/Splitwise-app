# Entities
 - User : Name, Phone number, password 

 - Group : Name, description, date
 - Expense : Name, description, date

## Relationships
- User 1 ---creates---- m Expense
- User m --- participate in ----- m Expense
- User 1 ----- admins ------- m Group
- User m --- participate in -- m Group
- Expense m --------belongs to ------- 0/1 Group


## Code flow
- There has to be a Main class from where we take inputs.
- Have a service(black box) which takes the input string and calls the appropiate function on our code.
-  Controller: All the APIs(methods/commands)
- All APIs in one controller
- Different controllers for different entities/purposes 
- Service and Service Implemention for all apis
- UserController, GroupController, ExpenseController
- Repository to store all the objects being created in the system

### Repositories
- User Repository for all user data
- Group Repository for all Group data
- Expense Repository for storing all the expense depending upon the admin who added the expense
### Expenses
- Add an expense with a user => userIds
- Add an expense in group => groupID

Live API- https://splitwisely-sachin.herokuapp.com/api/v1