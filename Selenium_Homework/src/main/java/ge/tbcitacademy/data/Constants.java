package ge.tbcitacademy.data;

import com.github.javafaker.Faker;

@SuppressWarnings("SpellCheckingInspection")
public class Constants {
    static Faker faker = new Faker();


    public static final String
            HEROKUAPP_URL = "http://the-internet.herokuapp.com/dynamic_controls",
            ENABLED_MSG_TXT = "It's enabled!",
            INPUT_TXT = "TBC IT Academy",
            DISABLE_BTN = "//*[@id=\"input-example\"]/button",
            TXT_INPUT = "//*[@id=\"input-example\"]/input",
            MESSAGE_ELEMENT = "message",
            HEARING_TXT_ELEMENT = "h4",
            HEADING_TXT_ELEMENT1 = "p",
            DYNAMIC_CONTROLS = "Dynamic Controls",
            HEADING_TXT = "This example demonstrates when elements (e.g., checkbox, input field, etc.) are changed asynchronously.",
            ULTIMATE_QA_URL = "https://ultimateqa.com/automation",
            SUCCESS_STORIES_ELEMENT = "menu-item-217938",
            TESTIMONIALS_URL = "https://ultimateqa.com/testimonials/",
            HU_D_D_URL = "http://the-internet.herokuapp.com/drag_and_drop",
            COLUMN_A_ELEMENT = "column-a",
            COLUMN_B_ELEMENT = "column-b",
            DRAGGABLE_LMNT = "draggable",
            TRUE_LMNT = "true",
            ELEMENTAL_SELENIUM_LMNT = "Elemental Selenium",
            HREF_LMNT = "href",
            ELEMENTAL_SELENIUM_URL = "http://elementalselenium.com/",
            JQUERYUI_URL = "https://jqueryui.com/slider/",
            ASIDE_H3_XPATH = "//aside[h3[@class='widget-title' or text()='Effects']]",
            UL_LI_XPATH = "//ul/Li",
            HEROKU_A_R_URL = "http://the-internet.herokuapp.com/add_remove_elements/",
            ADD_BTN = "//button[text()='Add Element']",
            LAST_DLT_BTN_CSS = "button.added-manually",
            HREF = "href",
            HREF_SOUT_TXT = "href link : ",
            HREF_ASSERT = "animate",
            LDB_ATTRIBUTE = "class",
            ASSERT_CONTAINS_A_M = "added-manually",
            DELETE_BTN_CSS = "button[onclick^='deleteElement']",
            ONCLICK_ATT = "onclick",
            DEL_LMNT = "deleteElement()",
            HEROKU_CHALLENGING_DOM = "http://the-internet.herokuapp.com/challenging_dom",
            APERIAN_XPATH = "//td[text()='Apeirian9']/preceding-sibling::td",
            TYMPANUS_URL = "https://tympanus.net/Tutorials/CustomDropDownListStyling/",
            LINK_TXT = "Demo 2",
            BY_ID_LMNT_DD = "dd",
            TAG_NAME_LI = "li",
            CSS_SLCTR_DDLI = "#dd > ul",
            TECHCANVAS_URL = "https://techcanvass.com/examples/register.html",
            CHECK_BOX_CSS = "input[type=radio]:nth-child(1)",
            CHOOSE_DROPDOWN_CSS = "p:nth-child(3) > select",
            NAME_INPUT_XPATH = "//form/fieldset/p[1]/input[1]",
            LASTNAME_INPUT_XPATH = "//form/fieldset/p[1]/input[2]",
            ADDRES_INPUT_XPATH = "//form/fieldset/p[3]/input[1]",
            ADDRES_INPUT_XPATH1 = "//form/fieldset/p[3]/input[2]",
            CITY_INPUT_XPATH = "//form/fieldset/p[4]/input[1]",
            NUMBER_INPUT_XPATH = "//form/fieldset/p[5]/input[1]",
            NUMBER1_INPUT_XPATH = "//form/fieldset/p[5]/input[2]",
            TECHCANVASS_CHECKBOX_CSS = "input[type=checkbox]",
            TECHCAN_SUBMIT_CSS = "input[type=submit]",
            SELECTOR_TXT_DD = "Mega 123 Medium screen",
            RANDOM_NAME = faker.name().firstName(),
            RANDOM_LAST_NAME = faker.name().lastName(),
            RANDOM_EMAIL = faker.internet().emailAddress(),
            RANDOM_NUMBER = String.valueOf(faker.phoneNumber()),
            RANDOM_ADDRESS = faker.address().streetAddress(),
            RANDOM_ADDRESS1 = faker.address().streetAddress(),
            RANDOM_CITY = faker.address().city(),
            ENABLE_BTN_CSS = "#input-example > button",
            LOADING_CSS = "#loading",
            ENABLE_DISABLE_INPUT_CSS = "input[type=text]",
            ACCESS_GRANTED = "ACCESS GRANTED",
            DEMOQA_PROG_BAR_URL = "https://demoqa.com/progress-bar",
            START_STOP_BTN = "startStopButton",
            SCROLL_DOWN = "window.scrollBy(0, 500)",
            PROGRESS_BAR_ID = "progressBar",
            WEBDRIVER_UNI_URL = "http://webdriveruniversity.com/To-Do-List/index.html",
            ENTRIES_XPATH ="//*[@id=\"zone2-entries\"]",
            POP_TUT_CSS = ".post-title a",
            TUT_LINKS_TXT = "\nTutorial links:",
            CODE_EX_TXT = "Code examples:",
            TECHLISTIC_URL = "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";










}