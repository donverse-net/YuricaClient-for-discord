package yurica;

import yurica.Events.InteractionButton;
import yurica.Events.InteractionCommand;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Client extends ListenerAdapter {

    InteractionCommand interactionCommand = new InteractionCommand();
    InteractionButton interactionButton = new InteractionButton();

    public void loginToCLientWithShard(String token, int shardId, int shardTotal){
        try {
            Main.jda = JDABuilder.createDefault(token,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT
            )
            .setRawEventsEnabled(true)
            .useSharding(shardId, shardTotal)
            .setActivity(Activity.playing("in shard " + (shardId + 1) + "/" + shardTotal + ""))
            .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setEventListener();
        loadInteractionCommands();
        loadInteractionComponents(); // Add to map
    }

    private void setEventListener(){
        try {
            Main.jda.addEventListener(interactionCommand);
            Main.jda.addEventListener(interactionButton);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private void loadInteractionCommands(){
        try {
            System.out.println("Loading interaction commands...");
            interactionCommand.registerCommand();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private void loadInteractionComponents(){
        try {
            System.out.println("Loading interaction components...");
            interactionButton.loadButtons();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public void logoutFromClient(){
        try {
            Main.jda.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
