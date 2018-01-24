
Scenario: When user filter results, default fiter changed
Given selenium
When user google epam
Then epam search page opened
When user filter results by time - Past 24 hours
Then default time filter changed to - Past 24 hours