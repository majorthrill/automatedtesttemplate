#Test #1-3  Verify existence of all expected elements. (Feature Scenario 1)
Verify that the red, green and blue buttons are all present and active.
Verify that the HTML Table is present and contains data (not currently automated, see note below)
Verify that the 'Canvas' is visible and is active with a width of '599' and height of '200'.

#Test #4-7 Verify button functionality. (Feature Scenario 2)
Verify that the blue, red and green buttons all contain one of the expected values.
Click on the blue button and verify that the blue, red and green buttons all contain one of the expected values.
Click on the green button and verify that the blue, red and green buttons all contain one of the expected values.
Click on the red button and verify that the blue, red and green buttons all contain one of the expected values.

#Test #8 Verify table contents. (Feature Scenario 3)
Verify that the contents of the HTML table visible on the page match those in the table of the feature file.

#Test #9-10 Verify edit and delete functionality. (Feature Scenario 4)
This comprises two tests. For each row in the table:
Click on the edit link and verify the URL is redirected to #edit.
Click on the delete link and verify the URL is redirected to #delete.


##Note: 
Due to the lack of locators I employed a secondary location method for most elements on the page. i.e. the buttons with compound class names could be located using "By.className" method and formatting them as .button.success but this meant that searching for the className of the blue button ("button") returned the three elements containing the button classname (button, button alert and button success). To get around this, my finder method then compared the full class name of each element found against what I had stored in my page model.

Unfortunately, this method does not work for the two tables in the page. I could have simply allowed webdriver to pick the first one and assume it was the table containing the data table but that results in brittle tests and given the choice my thinking is that I would rather not implement a test than implement a brittle one when a little more time could provide a solution.