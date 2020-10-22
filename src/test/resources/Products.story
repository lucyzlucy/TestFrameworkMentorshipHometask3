Scenario: When user clicks on category name, user navigates to category page
Given user navigates to Catalogue
When user chooses '<category>'
Then user sees '<category>' page
And user sees products
Examples:
|category|
|Одяг|
|Годинники|


Scenario: When user clicks on product, they navigate to Product page with correct product info
Given user navigates to Catalogue
When user clicks on Product
Then user navigates to Product page
And user sees the correct Product title
And user sees the correct Product price
And user sees available Product quantity


Scenario: A user can add product to cart
Given user navigates to Product page
When user clicks on 'Add to cart' button
Then product is added
And the product price is added to the total

Scenario: A user can add all available products to cart
Given user navigates to Product page
When user adds all available products to cart
And user clicks on 'Add to cart' button
Then start ordering button is shown
And product is added

Scenario: A user cannot add more products than are available
Given user navigates to Product page
When user adds more than available products to cart
And user clicks on 'Add to cart' button
Then an error is shown