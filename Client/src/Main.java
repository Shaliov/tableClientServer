import by.bsuir.Shaliov.ppvis.laba3.table.client.controller.ToServerController;
import by.bsuir.Shaliov.ppvis.laba3.table.client.view.frame.MainFrame;


/**
 * Created by Andrey on 6/16/2016.
 */
public class Main {
    public static void main(String[] argc) {
        ToServerController.getInstance().startRunningClient();
        MainFrame mainFrame = new MainFrame();
    }
}

