package Code.Story;

import Code.Constants;
import Code.Gui.Visuals;

public class StoryHandeler {
    private TextHandeler textHandeler;
    private Visuals visuals;

    public StoryHandeler (Visuals visuals, boolean playerChoice) {
        this.visuals = visuals;
        textHandeler = new TextHandeler(visuals);
    }

    public void tutorialOne() {
        textHandeler.setText(TextBlocks.TUTORIAL_ENTRY_ONE);
    }

    public void tutorialTwoRetry() {
        textHandeler.blockAppend(TextBlocks.TUTORIAL_ENTRY_TWO_RETRY);
    }

    public void tutorialTwo() {
        visuals.getLowerButton().setText("");
        textHandeler.blockAppend(TextBlocks.TUTORIAL_ENTRY_TWO);
    }

    public void tutorialThree() {
        visuals.getUpperButton().setText("I'm ready");
        visuals.getLowerButton().setText("I'm ready");
        textHandeler.blockAppend(TextBlocks.TUTORIAL_ENTRY_THREE);
    }

    public void openingNarrationOne() throws InterruptedException {
        textHandeler.setText("");
        setToContinue();
        textHandeler.append(TextBlocks.OPENING_NARRATION_ENTRY_ONE, Constants.FAST_APPEND_WAIT_TIME);
    }

    public void openingNarrationTwo() throws InterruptedException {
        textHandeler.lineAppend(TextBlocks.OPENING_NARRATION_ENTRY_TWO, Constants.FAST_APPEND_WAIT_TIME);
    }


    public void actOneSceneOneEntryOne() throws InterruptedException {
        textHandeler.setText("");
        visuals.getUpperButton().setText("Make Some Refreshing Tea");
        visuals.getLowerButton().setText("Make Some Energizing Coffee");
        textHandeler.append(TextBlocks.ACT_ONE_SCENE_ONE_ENTRY_ONE, Constants.FAST_APPEND_WAIT_TIME);
    }

    public void actOneSceneOneEntryTwo() throws InterruptedException {
        setToContinue();
        if (ChoiceHandeler.ACT_ONE_BEVERAGE) {
            textHandeler.lineAppend(TextBlocks.ACT_ONE_SCENE_ONE_ENTRY_TWO_TEA, Constants.FAST_APPEND_WAIT_TIME);
        } else {
            textHandeler.lineAppend(TextBlocks.ACT_ONE_SCENE_ONE_ENTRY_TWO_COFFEE, Constants.FAST_APPEND_WAIT_TIME);
        }
        visuals.getUpperButton().setText("Read the Distress Call Information");
        visuals.getLowerButton().setText("Read the Distress Call Information");
    }

    public void actOneSceneTwo() throws InterruptedException {
        setToContinue();
        textHandeler.setText("");
        visuals.getUpperButton().setText("Run to Your Ship");
        visuals.getLowerButton().setText("Run to Your Ship");
        textHandeler.append(TextBlocks.ACT_ONE_SCENE_TWO, Constants.SLOW_APPEND_WAIT_TIME);
    }

    public void actOneSceneThreeEntryOne() throws InterruptedException {
        textHandeler.setText("");
        visuals.getUpperButton().setText("Find First Aid Supplies");
        visuals.getLowerButton().setText("Search for Supplies for Repairs");
        textHandeler.append(TextBlocks.ACT_ONE_SCENE_THREE_ENTRY_ONE, Constants.FAST_APPEND_WAIT_TIME);
    }

    public void actOneSceneThreeEntryTwo() throws InterruptedException {
        setToContinue();
        if(ChoiceHandeler.ACT_ONE_PACKED_ITEM_CHOICE) {
            textHandeler.lineAppend(TextBlocks.ACT_ONE_SCENE_THREE_ENTRY_TWO_FIRST_AID, Constants.FAST_APPEND_WAIT_TIME);
        } else {
            textHandeler.lineAppend(TextBlocks.ACT_ONE_SCENE_THREE_ENTRY_TWO_REPAIR, Constants.FAST_APPEND_WAIT_TIME);
        }
    }

    public void actTwoSceneOneEntryOne() throws InterruptedException{
        textHandeler.setText("");
        visuals.getUpperButton().setText("Approve Automated Boarding");
        visuals.getLowerButton().setText("Deny Automated Boarding");
        textHandeler.append(TextBlocks.ACT_TWO_SCENE_ONE_ENTRY_ONE, Constants.FAST_APPEND_WAIT_TIME);
    }

    public void actTwoSceneOneEntryTwo() throws InterruptedException{
        setToContinue();
        if (ChoiceHandeler.ACT_TWO_DOCKING_CHOICE) {
            textHandeler.lineAppend(TextBlocks.ACT_TWO_SCENE_ONE_ENTRY_TWO_APPROVED, Constants.FAST_APPEND_WAIT_TIME);
        } else {
            textHandeler.lineAppend(TextBlocks.ACT_TWO_SCENE_ONE_ENTRY_TWO_DENIED, Constants.FAST_APPEND_WAIT_TIME);
        }
    }

    public void actTwoSceneTwoEntryOne() throws InterruptedException {
        textHandeler.setText("");
        if(ChoiceHandeler.ACT_ONE_PACKED_ITEM_CHOICE) {
            textHandeler.append(TextBlocks.ACT_TWO_SCENE_TWO_ENTRY_ONE_FIRST_AID, Constants.FAST_APPEND_WAIT_TIME);
        } else {
            visuals.getUpperButton().setText("Route Power to Lights");
            visuals.getLowerButton().setText("Route Power to Cameras");
            textHandeler.append(TextBlocks.ACT_TWO_SCENE_TWO_ENTRY_ONE_REPAIRS, Constants.FAST_APPEND_WAIT_TIME);
        }
    }

    public void actTwoSceneTwoEntryTwo() throws InterruptedException {
        if (ChoiceHandeler.ACT_TWO_LIGHTS) {
            visuals.getUpperButton().setText("Unplug and Continue");
            visuals.getLowerButton().setText("Unplug and Continue");
            textHandeler.lineAppend(TextBlocks.ACT_TWO_SCENE_TWO_ENTRY_TWO_LIGHTS, Constants.FAST_APPEND_WAIT_TIME);
        } else {
            visuals.getUpperButton().setText("Route Power to Lights");
            visuals.getLowerButton().setText("Unplug and Continue");
            textHandeler.lineAppend(TextBlocks.ACT_TWO_SCENE_TWO_ENTRY_TWO_CAMERA, Constants.FAST_APPEND_WAIT_TIME);
        }
    }

    public void actTwoSceneTwoEntryThree() throws InterruptedException {
        visuals.getUpperButton().setText("Take the Path to the Helm");
        visuals.getLowerButton().setText("Take the Path to the Helm");
        textHandeler.lineAppend(TextBlocks.ACT_TWO_SCENE_TWO_ENTRY_THREE, Constants.FAST_APPEND_WAIT_TIME);
    }

    public void actThreeHelmSceneOneEntryOne() throws InterruptedException {
        textHandeler.setText("");
        visuals.getUpperButton().setText("Find the Black Box");
        visuals.getLowerButton().setText("Find the Black Box");
        if(ChoiceHandeler.ACT_TWO_CAMERAS && !ChoiceHandeler.ACT_ONE_PACKED_ITEM_CHOICE) {
            visuals.getUpperButton().setText("Search for the Survivors");
            textHandeler.append(TextBlocks.ACT_THREE_HELM_SCENE_ONE_ENTRY_ONE_CAMERA, Constants.FAST_APPEND_WAIT_TIME);
        } else {
            textHandeler.append(TextBlocks.ACT_THREE_HELM_SCENE_ONE_ENTRY_ONE, Constants.FAST_APPEND_WAIT_TIME);
        }
    }

    public void actThreeHelmSceneOneEntryTwoBlackBox() throws InterruptedException {
        setToContinue();
        textHandeler.lineAppend(TextBlocks.ACT_THREE_HELM_SCENE_ONE_ENTRY_TWO_BLACK_BOX_PART_ONE, Constants.FAST_APPEND_WAIT_TIME);
        textHandeler.append(TextBlocks.ACT_THREE_HELM_SCENE_ONE_ENTRY_TWO_BLACK_BOX_PART_TWO, Constants.MEDIUM_APPEND_WAIT_TIME);
        visuals.getUpperButton().setText("Run");
        visuals.getLowerButton().setText("Fight");
        textHandeler.lineAppend(TextBlocks.ACT_THREE_HELM_SCENE_ONE_ENTRY_THREE, Constants.FAST_APPEND_WAIT_TIME);
    }

    public void actThreeHelmFight() throws InterruptedException {
        setToContinue();
        textHandeler.setText("");
        textHandeler.append(TextBlocks.ACT_THREE_HELM_FIGHT, Constants.FAST_APPEND_WAIT_TIME);
    }

    public void actThreeHelmRepairsFight() throws InterruptedException {
        textHandeler.lineAppend(TextBlocks.ACT_THREE_HELM_FIGHT_REPAIRS, Constants.SLOW_APPEND_WAIT_TIME);
        visuals.getUpperButton().setText("End");
        visuals.getLowerButton().setText("End");
    }

    public void actThreeHelmFirstAidFight() throws InterruptedException {
        textHandeler.lineAppend(TextBlocks.ACT_THREE_HELM_FIGHT_FIRST_AID, Constants.SLOW_APPEND_WAIT_TIME);
    }

    public void actThreeBlackBoxEnd() throws InterruptedException {
        textHandeler.lineAppend(TextBlocks.ACT_THREE_BLACK_BOX_ENDING, Constants.FAST_APPEND_WAIT_TIME);
        visuals.getUpperButton().setText("End");
        visuals.getLowerButton().setText("End");
    }

    public void runEnding() throws InterruptedException {
        textHandeler.setText("");
        visuals.getUpperButton().setText("Look Around");
        visuals.getLowerButton().setText("Try to Go Back to Sleep");
        textHandeler.append(TextBlocks.ACT_THREE_RUN_ENDING, Constants.MEDIUM_APPEND_WAIT_TIME);
    }

    public void survivorPartOne() throws InterruptedException {
        textHandeler.setText("");
        setToContinue();
        textHandeler.append(TextBlocks.ACT_THREE_SURVIVOR_ENTRY_ONE, Constants.FAST_APPEND_WAIT_TIME);
        visuals.getUpperButton().setText("Ask the Survivor What Happened");
        visuals.getLowerButton().setText("Ask the Survivor What Happened");
    }

    public void survivorPartTwo() throws InterruptedException {
        setToContinue();
        textHandeler.lineAppend(TextBlocks.ACT_THREE_SURVIVOR_ENTRY_TWO, Constants.FAST_APPEND_WAIT_TIME);
        visuals.getUpperButton().setText("Search for the Self Destruct Terminal");
        visuals.getLowerButton().setText("Search for the Self Destruct Terminal");
    }
    
    public void survivorPartThree() throws InterruptedException {
        textHandeler.setText("");
        setToContinue();
        textHandeler.append(TextBlocks.ACT_THREE_SURVIVOR_ENTRY_THREE, Constants.FAST_APPEND_WAIT_TIME);
        visuals.getUpperButton().setText("Start the Self Destruct Sequence");
        visuals.getLowerButton().setText("Start the Self Destruct Sequence");
    }

    public void survivorEnding() throws InterruptedException {
        visuals.getUpperButton().setText("End");
        visuals.getLowerButton().setText("End");
        textHandeler.lineAppend(TextBlocks.ACT_THREE_SURVIVOR_ENDING, Constants.FAST_APPEND_WAIT_TIME);
    }

    private void setToContinue() {
        visuals.getUpperButton().setText("Continue");
        visuals.getLowerButton().setText("Continue");
    }


}
