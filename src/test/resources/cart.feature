Feature: Cart
Scenario Outline: A user can navigate to product cart from any page
 Given user is on <page> page
 When user clicks on cart button
 Then user navigates to cart page

Examples:
|page|
|Main|
|Catalogue|
|Product|

Scenario: A user can see product details in the cart
 Given user has added products to cart
 When user navigates to Cart
 Then user can see product details

Scenario: A user can delete product from the cart
 Given user has added products to cart
 When user navigates to Cart
 And user clicks on delete button
 Then user can see empty cart label
 And user sees no product details