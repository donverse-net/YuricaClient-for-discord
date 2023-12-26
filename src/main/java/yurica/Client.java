package yurica;

import yurica.Events.InteractionCommand;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Client extends ListenerAdapter {

    InteractionCommand interactionCommand = new InteractionCommand();

    public void LoginToCLientWithShard(String token, int shardId, int shardTotal){
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

        SetEventListener();
        LoadInteractionCommands();
    }

    public void SetEventListener(){
        try {
            Main.jda.addEventListener(new InteractionCommand());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public void LoadInteractionCommands(){
        try {
            System.out.println("Loading interaction commands...");
            interactionCommand.registerCommand();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public void LogoutFromClient(){
        try {
            Main.jda.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
