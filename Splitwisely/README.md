# Splitwisely
The goal of this project is to create a simple expense tracker in which a group of people or particular two person can manage their expenses and get a summary of their balance.

Live API- https://splitwisely-sachin.herokuapp.com/api/v1
## Features - 
1. Ability To register new user with Name,PhoneNumber and password
2. Verify whether a user is registered in database or not
3. Settle Up expense between two person given that percentage share
   - Input Format:: 
     {
        "name": "canteen chaii",
        "description": "here i am adding a expense with vishnu when we were on trip",
        "createdBy": "4",
        "participants": [1],
        "totalAmount": "1005",
        "percentage":{
            "1":"45",
            "4":"55"
          }
      }
4. Ability to create a group
	- Each group should have a name and list of members
	- Whenever an expense is added within a group, the members of the expense who are not part of the group should automatically be added as a member.
	  For example - A user creates a group "Home" with members ["A", "B"] and later adds an expense which has user "C", the group members will be - ["A" "B", "C"]
5. Ability to add an expense within a group
	 Structure of an expense - 
  
       {
        "name": "canteen chaii",
        "description": "here i am adding a expense with vishnu when we were on trip",
        "createdBy": "4",
        "participants": [1,2,3,4],
        "totalAmount": "1005",
        "percentage":{
            "1":"45",
            "4":"55"
          }
      }
    In case of groups the participants and thier percentage(if any) will get added and the structure of input remains same
6. Ability to update an expense within a group
    - Structure same as add expense.
7. Ability to delete an expense within a group
8. Ability to get the balance of a group such that the balances are simplified. which means -
    - If A,B,C are in a group such that A owes B Rs 100, B owes C Rs 100, the balance summary should show that A owes C Rs 100
    - The structure should be -

    	    {
            "name": "Home",
            "balances": {
              "A": {
                "total_balance": -100.0
                "owes_to": [{"C": 100}],
                "owed_by": []
              },
              "B": {
                "total_balance": 0.0
                "owes_to": [],
                "owed_by": []
              },
              "C": {
                "total_balance": 100.0
                "owes_by": [{"A": 100}],
                "owed_to": []
              }
            }
        	}







