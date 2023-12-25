package yurica;

import yurica.Events.InteractionCommand;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Client extends ListenerAdapter {

    public JDA LoginToCLientWithShard(JDA jda, String token, int shardId, int shardTotal){
        try {
            jda = JDABuilder.createDefault(token,
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

        return jda;
    }

    public void SetEventListener(JDA jda){
        try {
            jda.addEventListener(new InteractionCommand(jda));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public void LoadInteractionCommands(JDA jda){
        try {
            System.out.println("Loading interaction commands...");
            InteractionCommand interactionCommand = new InteractionCommand(jda);
            interactionCommand.registerCommand();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public void LogoutFromClient(JDA jda){
        try {
            jda.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
