package Code.Story;

import javax.swing.JScrollBar;

import Code.Gui.Visuals;

public class TextHandeler {
    private Visuals visuals;

    public TextHandeler (Visuals visuals) {
        this.visuals = visuals;
    }

    public void setText (String entry) {
        visuals.getMainTextBox().setText(entry);
    }

    public void append (String entry, int waitTime) throws InterruptedException {
        JScrollBar vertical = visuals.getMainScrollPane().getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
        for(int i = 0; i < entry.length(); i++) {
            visuals.getMainTextBox().append(entry.substring(i, i+1));
            Thread.sleep(waitTime);
        }
    }

    public void lineAppend (String entry, int waitTime) throws InterruptedException {
        visuals.getMainTextBox().append("\n\n");
        for(int i = 0; i < entry.length(); i++) {
            visuals.getMainTextBox().append(entry.substring(i, i+1));
            Thread.sleep(waitTime);
        }
    }

    public void blockAppend (String entry) {
        visuals.getMainTextBox().append("\n");
        visuals.getMainTextBox().append(entry);
    }

    public void ellipsis () throws InterruptedException {
        for(int i = 0; i < 3; i++) {
            visuals.getMainTextBox().append(".");
            Thread.sleep(500);
        }
    }
    
}
