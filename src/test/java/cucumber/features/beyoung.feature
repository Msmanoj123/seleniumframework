Feature: beyoung cart module
Scenario: Adding the men printed t shirt  to cart and validate 
Given User is open browser and launch the URL "https://www.beyoung.in/"
Then validate user is on home page 
When mouse over on men and click on printed t shirts
Then validate user land on correct page
When select camo balidan badge half sleeve and select size and color and add to cart
Then validate the item present in the cart
