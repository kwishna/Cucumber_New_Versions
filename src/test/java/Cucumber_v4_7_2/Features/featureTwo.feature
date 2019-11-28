@Baba
Feature: feature description
	In order to do something
	As someone
	I want something else to happen

@Baba1
Scenario: This Is The First Scenario.
Given User Browser Opens
  |hello|hello|
  |world|world|
  |again|again|
When User Opens 'https://www.google.co.in'
Then User Enters Search Keyword 'Hello Brother' and "this"
And Hits Search Bar
Then Search Results Should Appear

@Baba2
Scenario Outline: This Is The Second Scenario.
Given User Browser Opens
  |hello|
  |world|
  |again|
When User Opens '<url>'
Then User Enters Search Keyword <keyword> and "this"
And Hits Search Bar
Then Search Results Should Appear

Examples:
| url | keyword |
| https://google.com | SCO Meet |
| https://google.com | G7 Summit |