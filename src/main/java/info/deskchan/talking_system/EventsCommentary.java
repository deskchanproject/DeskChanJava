package info.deskchan.talking_system;

import info.deskchan.core.TextOperations;

public class EventsCommentary {
    private static int drag=0;
    public static void initialize(){
        Main.getPluginProxy().addMessageListener("gui-events:character-left-click", (sender, tag, data) -> {
            Main.getPluginProxy().sendMessage("talk:request", TextOperations.toMap("purpose: CLICK, priority: 2000"));
        });
        Main.getPluginProxy().addMessageListener("gui-events:character-right-click", (sender, tag, data) -> {
            Main.getPluginProxy().sendMessage("talk:request", TextOperations.toMap("purpose: CLICK, priority: 2000"));
        });
        Main.getPluginProxy().addMessageListener("gui-events:character-start-drag", (sender, tag, data) -> {
            if(drag>0) return;
            drag=1;
            Main.getPluginProxy().sendMessage("core-utils:notify-after-delay", TextOperations.toMap("delay: 600"),(s,d) -> handleDrag(s,d));
        });
        Main.getPluginProxy().addMessageListener("gui-events:character-stop-drag", (sender, tag, data) -> {
            if(drag>1) Main.getPluginProxy().sendMessage("talk:request", TextOperations.toMap("purpose: DROP, priority: 3000"));
            drag=0;
        });
    }
    private static void handleDrag(String sender, Object data) {
        if(drag==0) return;
        Main.getPluginProxy().sendMessage("core-utils:notify-after-delay", TextOperations.toMap("delay: 6000"),(s,d) -> handleDrag(s,d));
        if(drag>0){
            if(drag==1) drag++;
            Main.getPluginProxy().sendMessage("talk:request", TextOperations.toMap("purpose: DRAG, priority: 2000"));
        }
    }
}