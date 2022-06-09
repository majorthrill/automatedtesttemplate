Feature: Sample Tests. 
@TechExercise 
Scenario: Verify existence of all expected elements. 
Given launch a browser.
Then navigate to the address: 'https://the-internet.herokuapp.com/challenging_dom'
Then verify that the 'Blue Button' is visible and is active.
Then verify that the 'Red Button' is visible and is active.
Then verify that the 'Green Button' is visible and is active.
Then verify that the 'Canvas' is visible and is active.
Then verify that the 'Canvas' is visible and is active with a width of '599' and height of '200'.
# Interestingly, this fails because the canvas dimensions in chromedriver are 601/202

@TechExercise
Scenario: Verify button functionality.
Given launch a browser.
Then navigate to the address: 'https://the-internet.herokuapp.com/challenging_dom'
And verify that the 'Blue Button' contains one of the expected values.
And verify that the 'Red Button' contains one of the expected values.
And verify that the 'Green Button' contains one of the expected values.
Then click on the 'Blue Button'.
And verify that the 'Blue Button' contains one of the expected values.
And verify that the 'Red Button' contains one of the expected values.
And verify that the 'Green Button' contains one of the expected values.
Then click on the 'Green Button'.
And verify that the 'Blue Button' contains one of the expected values.
And verify that the 'Red Button' contains one of the expected values.
And verify that the 'Green Button' contains one of the expected values.
Then click on the 'Red Button'.
And verify that the 'Blue Button' contains one of the expected values.
And verify that the 'Red Button' contains one of the expected values.
And verify that the 'Green Button' contains one of the expected values.
#And verify that the 'Green Button' contains leading whitespace.
# Thus far unable to wrangle the selector to find pseudo-tags.


@TechExercise
Scenario: Verify table contents.
Given launch a browser.
Then navigate to the address: 'https://the-internet.herokuapp.com/challenging_dom'
Then verify the table contents:
| Lorem 	 |  Ipsum 	  | Dolor 	  | Sit 	      | Amet 	        | Diceret   | Action      |
| Iuvaret0 |	Apeirian0 |	Adipisci0 |	Definiebas0 |	Consequuntur0 |	Phaedrum0 | edit delete |
| Iuvaret1 |	Apeirian1 |	Adipisci1 |	Definiebas1 |	Consequuntur1 |	Phaedrum1 | edit delete |
| Iuvaret2 |	Apeirian2 |	Adipisci2 |	Definiebas2 |	Consequuntur2 |	Phaedrum2 | edit delete |
| Iuvaret3 |	Apeirian3 |	Adipisci3 |	Definiebas3 |	Consequuntur3 |	Phaedrum3 | edit delete |
| Iuvaret4 |	Apeirian4 |	Adipisci4 |	Definiebas4 |	Consequuntur4 |	Phaedrum4 | edit delete |
| Iuvaret5 |	Apeirian5 |	Adipisci5 |	Definiebas5 |	Consequuntur5 |	Phaedrum5 | edit delete |
| Iuvaret6 |	Apeirian6 |	Adipisci6 |	Definiebas6 |	Consequuntur6 |	Phaedrum6 | edit delete |
| Iuvaret7 |	Apeirian7 |	Adipisci7 |	Definiebas7 |	Consequuntur7 |	Phaedrum7 | edit delete |
| Iuvaret8 |	Apeirian8 |	Adipisci8 |	Definiebas8 |	Consequuntur8 |	Phaedrum8 | edit delete |
| Iuvaret9 |	Apeirian9 |	Adipisci9 |	Definiebas9 |	Consequuntur9 |	Phaedrum9 | edit delete |


@TechExercise
Scenario: Verify edit and delete functionality.
Given launch a browser.
Then navigate to the address: 'https://the-internet.herokuapp.com/challenging_dom'
And click the edit and delete buttons on the table.

