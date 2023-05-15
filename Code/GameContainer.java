package Code;

import Code.Gui.Visuals;
import Code.Story.ChoiceHandeler;
import Code.Story.StoryHandeler;

public class GameContainer {
    private static Visuals visuals;
    private static StoryHandeler storyHandeler;
    //upper is true, lower is false
    private static boolean playerChoice;
    
    public static void main(String[] args) throws InterruptedException {
        visuals = new Visuals();
        storyHandeler = new StoryHandeler(visuals, playerChoice);
        playerChoice = true;

        visuals.initialize();

        tutorial();
        openingNarration();
        actOneSceneOne();
        actOneSceneTwo();
        actOneSceneThree();
        actTwoSceneOne();
        actTwoSceneTwo();
        actThreeHelmSceneOne();
    }

    public static void waitForButton() throws InterruptedException {
        visuals.resetInputs();
        while(visuals.hasButtonBeenPressed()) {
            Thread.sleep(100);
        }
        if(visuals.getUpperPressed()) {
            playerChoice = true;
        } else {
            playerChoice = false;
        }
    }

    public static void tutorial() throws InterruptedException {
        storyHandeler.tutorialOne();
        waitForButton();
        storyHandeler.tutorialTwo();
        waitForButton();
        while(!playerChoice) {
            storyHandeler.tutorialTwoRetry();
            waitForButton();
        }
        storyHandeler.tutorialThree();
        waitForButton();
    }

    public static void openingNarration() throws InterruptedException {
        storyHandeler.openingNarrationOne();
        waitForButton();
        storyHandeler.openingNarrationTwo();
        waitForButton();
    }

    public static void actOneSceneOne() throws InterruptedException {
        storyHandeler.actOneSceneOneEntryOne();
        waitForButton();
        ChoiceHandeler.ACT_ONE_BEVERAGE = playerChoice;
        storyHandeler.actOneSceneOneEntryTwo();
        waitForButton();
    }

    public static void actOneSceneTwo() throws InterruptedException {
        storyHandeler.actOneSceneTwo();
        waitForButton();
    }

    public static void actOneSceneThree() throws InterruptedException {
        storyHandeler.actOneSceneThreeEntryOne();
        waitForButton();
        ChoiceHandeler.ACT_ONE_PACKED_ITEM_CHOICE = playerChoice;
        System.out.println(playerChoice);
        storyHandeler.actOneSceneThreeEntryTwo();
        waitForButton();
    }

    public static void actTwoSceneOne() throws InterruptedException {
        storyHandeler.actTwoSceneOneEntryOne();
        waitForButton();
        ChoiceHandeler.ACT_TWO_DOCKING_CHOICE = playerChoice;
        storyHandeler.actTwoSceneOneEntryTwo();
        waitForButton();
    }

    public static void actTwoSceneTwo() throws InterruptedException {
        storyHandeler.actTwoSceneTwoEntryOne();
        waitForButton();
        if(!ChoiceHandeler.ACT_ONE_PACKED_ITEM_CHOICE) {
            ChoiceHandeler.ACT_TWO_LIGHTS = playerChoice;
            ChoiceHandeler.ACT_TWO_CAMERAS = !playerChoice;
            storyHandeler.actTwoSceneTwoEntryTwo();
            waitForButton();
            if(!ChoiceHandeler.ACT_TWO_LIGHTS && playerChoice) {
                ChoiceHandeler.ACT_TWO_LIGHTS = playerChoice;
                storyHandeler.actTwoSceneTwoEntryTwo();
                waitForButton();
            } 
            System.out.println("done");
        }
        storyHandeler.actTwoSceneTwoEntryThree();
        waitForButton();
    }

    public static void actThreeHelmSceneOne() throws InterruptedException {
        storyHandeler.actThreeHelmSceneOneEntryOne();
        waitForButton();
        if(ChoiceHandeler.ACT_TWO_CAMERAS && playerChoice && !ChoiceHandeler.ACT_ONE_PACKED_ITEM_CHOICE) {
            storyHandeler.survivorPartOne();
            waitForButton();
            storyHandeler.survivorPartTwo();
            waitForButton();
            storyHandeler.survivorPartThree();
            waitForButton();
            storyHandeler.survivorEnding();
            waitForButton();
            Thread.sleep(1000);
            System.exit(2);
        } else {
            storyHandeler.actThreeHelmSceneOneEntryTwoBlackBox();
            waitForButton();
            if(!playerChoice) {
                storyHandeler.actThreeHelmFight();
                waitForButton();
                if(ChoiceHandeler.ACT_ONE_PACKED_ITEM_CHOICE) {
                    storyHandeler.actThreeHelmFirstAidFight();
                    waitForButton();
                    storyHandeler.actThreeBlackBoxEnd();
                    waitForButton();
                    Thread.sleep(1000);
                    System.exit(2);
                } else {
                    storyHandeler.actThreeHelmRepairsFight();
                    waitForButton();
                    Thread.sleep(1000);
                    System.exit(2);
                }
            } else {
                runEnding();
            }
        }
    }

    public static void runEnding() throws InterruptedException {
        storyHandeler.runEnding();
        waitForButton();
        Thread.sleep(1000);
        System.exit(2);
    }
}