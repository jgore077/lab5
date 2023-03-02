# lab5
Initially I figured we would have a passenger & airline class. Airline would have a single member which is a arraylist implementation of a queue of passengers which simulates the line before the check in gate and the passenger would have a name, seatt number, and class(E for Economy,B for Business, F for First). The airline class would also have  3 integers that represent the number of available seats in first class which has a maximum of 10 seats, 10 for business class and 20 for economy class. These numbers would be decremented respectively when a passenger is added. We will also need a checkin function that takes a name and returns a passenger. It appears we will also need some kind of graphical interface which shouldnt be too hard. Filer reading will be done with a scanner using a space as a delimiter in order to quickly instantiate passengers from the txt files. Another thing that needs to be added is that when the program starts we will need to select one of three options using 1,2 & 3git

Jimmy:
Write airline and passenger classes to completion


William:
Testing the program/Simulation


Anusha:
Reading the passenger files, check in


Ahmad:
Boarding and random chances

Orders
Search
O(N) because it must look at every passenger

Check In:
O(N) because it loops through the entire team.

Boarding:
This is O(N) because it loops through the entire array

**Who Did What?**
Will wrote the entire testing method which is contained in main.
Anusha wrote the read from passengers method and check in.
Ahmad wrote the boarding method and random chance method.
Jimmy wrote the Passenger class and Airline class, this means the constructor mainly but he also wrote the addPassenger method.

**Important to note**
Anusha first commited the readPassengersFromFile method but Jimmy edited it because it had bugs.
Ahmad made the board method and it worked but it could be simplified so it was.
