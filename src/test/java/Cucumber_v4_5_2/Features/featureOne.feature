@Baba
Feature: feature description
	In order to do something
	As someone
	I want something else to happen

@Baba
Scenario: This Is The First Scenario.
Given User Browser Opens
When User Opens https://www.google.co.in
Then User Enters Search Keyword Hello Brother
And Hits Search Bar
Then Search Results Should Appear

@Baba	
Scenario Outline: This Is The First Scenario.
Given User Browser Opens
When User Opens <url>
Then User Enters Search Keyword <keyword>
And Hits Search Bar
Then Search Results Should Appear

Examples:
| url | keyword |
| https://google.com | G7 Summit |
| https://google.com | SCO Meet |