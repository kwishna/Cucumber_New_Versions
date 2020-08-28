@Baba
Feature: feature description
	In order to do something
	As someone
	I want something else to happen

@Baba1
Scenario: This Is The First Scenario.
Given User Browser Opens
  | hello | h |
  | world | w |
  | again | a |
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
Then User Enters Search Keyword '<keyword>' and "this"
And Hits Search Bar
Then Search Results Should Appear

@dev
Examples:
| url | keyword |
| https://google.com | SCO Meet |
| https://google.com | G7 Summit |

@int
Examples:
| url | keyword |
| https://google.co.in | SCO Meet |
| https://google.co.in | G7 Summit |

@Baba3
Scenario Outline: This Is The Third Scenario.
  Given My Name Is '<rowNum>' And Email Is email
  |email|
  |gfhgf1@dfdg.cpm |
  |gfhgf2@dfdg.cpm |
  |gfhgf3@dfdg.cpm |


Examples:
	|rowNum|
	|  0   |
	|  1   |
	|  2   |
