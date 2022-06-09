$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/features/TechExercise.feature");
formatter.feature({
  "name": "Sample Tests.",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify existence of all expected elements.",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TechExercise"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "launch a browser.",
  "keyword": "Given "
});
formatter.match({
  "location": "TestMapping.launchBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "navigate to the address: \u0027https://the-internet.herokuapp.com/challenging_dom\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "TestMapping.goToUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Blue Button\u0027 is visible and is active.",
  "keyword": "Then "
});
formatter.match({
  "location": "TestMapping.verifyElement(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Red Button\u0027 is visible and is active.",
  "keyword": "Then "
});
formatter.match({
  "location": "TestMapping.verifyElement(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Green Button\u0027 is visible and is active.",
  "keyword": "Then "
});
formatter.match({
  "location": "TestMapping.verifyElement(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Canvas\u0027 is visible and is active.",
  "keyword": "Then "
});
formatter.match({
  "location": "TestMapping.verifyElement(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify button functionality.",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TechExercise"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "launch a browser.",
  "keyword": "Given "
});
formatter.match({
  "location": "TestMapping.launchBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "navigate to the address: \u0027https://the-internet.herokuapp.com/challenging_dom\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "TestMapping.goToUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Blue Button\u0027 contains one of the expected values.",
  "keyword": "And "
});
formatter.match({
  "location": "TestMapping.checkElementText(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Red Button\u0027 contains one of the expected values.",
  "keyword": "And "
});
formatter.match({
  "location": "TestMapping.checkElementText(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Green Button\u0027 contains one of the expected values.",
  "keyword": "And "
});
formatter.match({
  "location": "TestMapping.checkElementText(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the \u0027Blue Button\u0027.",
  "keyword": "Then "
});
formatter.match({
  "location": "TestMapping.clickElement(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Blue Button\u0027 contains one of the expected values.",
  "keyword": "And "
});
formatter.match({
  "location": "TestMapping.checkElementText(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Red Button\u0027 contains one of the expected values.",
  "keyword": "And "
});
formatter.match({
  "location": "TestMapping.checkElementText(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Green Button\u0027 contains one of the expected values.",
  "keyword": "And "
});
formatter.match({
  "location": "TestMapping.checkElementText(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the \u0027Green Button\u0027.",
  "keyword": "Then "
});
formatter.match({
  "location": "TestMapping.clickElement(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Blue Button\u0027 contains one of the expected values.",
  "keyword": "And "
});
formatter.match({
  "location": "TestMapping.checkElementText(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Red Button\u0027 contains one of the expected values.",
  "keyword": "And "
});
formatter.match({
  "location": "TestMapping.checkElementText(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Green Button\u0027 contains one of the expected values.",
  "keyword": "And "
});
formatter.match({
  "location": "TestMapping.checkElementText(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the \u0027Red Button\u0027.",
  "keyword": "Then "
});
formatter.match({
  "location": "TestMapping.clickElement(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Blue Button\u0027 contains one of the expected values.",
  "keyword": "And "
});
formatter.match({
  "location": "TestMapping.checkElementText(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Red Button\u0027 contains one of the expected values.",
  "keyword": "And "
});
formatter.match({
  "location": "TestMapping.checkElementText(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify that the \u0027Green Button\u0027 contains one of the expected values.",
  "keyword": "And "
});
formatter.match({
  "location": "TestMapping.checkElementText(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify table contents.",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TechExercise"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "launch a browser.",
  "keyword": "Given "
});
formatter.match({
  "location": "TestMapping.launchBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "navigate to the address: \u0027https://the-internet.herokuapp.com/challenging_dom\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "TestMapping.goToUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the table contents:",
  "rows": [
    {
      "cells": [
        "Lorem",
        "Ipsum",
        "Dolor",
        "Sit",
        "Amet",
        "Diceret",
        "Action"
      ]
    },
    {
      "cells": [
        "Iuvaret0",
        "Apeirian0",
        "Adipisci0",
        "Definiebas0",
        "Consequuntur0",
        "Phaedrum0",
        "edit delete"
      ]
    },
    {
      "cells": [
        "Iuvaret1",
        "Apeirian1",
        "Adipisci1",
        "Definiebas1",
        "Consequuntur1",
        "Phaedrum1",
        "edit delete"
      ]
    },
    {
      "cells": [
        "Iuvaret2",
        "Apeirian2",
        "Adipisci2",
        "Definiebas2",
        "Consequuntur2",
        "Phaedrum2",
        "edit delete"
      ]
    },
    {
      "cells": [
        "Iuvaret3",
        "Apeirian3",
        "Adipisci3",
        "Definiebas3",
        "Consequuntur3",
        "Phaedrum3",
        "edit delete"
      ]
    },
    {
      "cells": [
        "Iuvaret4",
        "Apeirian4",
        "Adipisci4",
        "Definiebas4",
        "Consequuntur4",
        "Phaedrum4",
        "edit delete"
      ]
    },
    {
      "cells": [
        "Iuvaret5",
        "Apeirian5",
        "Adipisci5",
        "Definiebas5",
        "Consequuntur5",
        "Phaedrum5",
        "edit delete"
      ]
    },
    {
      "cells": [
        "Iuvaret6",
        "Apeirian6",
        "Adipisci6",
        "Definiebas6",
        "Consequuntur6",
        "Phaedrum6",
        "edit delete"
      ]
    },
    {
      "cells": [
        "Iuvaret7",
        "Apeirian7",
        "Adipisci7",
        "Definiebas7",
        "Consequuntur7",
        "Phaedrum7",
        "edit delete"
      ]
    },
    {
      "cells": [
        "Iuvaret8",
        "Apeirian8",
        "Adipisci8",
        "Definiebas8",
        "Consequuntur8",
        "Phaedrum8",
        "edit delete"
      ]
    },
    {
      "cells": [
        "Iuvaret9",
        "Apeirian9",
        "Adipisci9",
        "Definiebas9",
        "Consequuntur9",
        "Phaedrum9",
        "edit delete"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "TestMapping.checkTableContents(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify table contents.",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TechExercise"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "launch a browser.",
  "keyword": "Given "
});
formatter.match({
  "location": "TestMapping.launchBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "navigate to the address: \u0027https://the-internet.herokuapp.com/challenging_dom\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "TestMapping.goToUrl(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click the edit and delete buttons on the table.",
  "keyword": "And "
});
formatter.match({
  "location": "TestMapping.clickEditDelete()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});