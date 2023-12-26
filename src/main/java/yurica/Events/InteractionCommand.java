package yurica.Events;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import yurica.Main;
import yurica.Events.InteractionCommands.PingCommand;

public class InteractionCommand extends ListenerAdapter {

    private PingCommand ping = new PingCommand();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();

        switch (command) {
            case "ping":
                ping.response(event);
                break;
            default:
                break;
        }
    }

    // Command register.
    public void registerCommand(){
        // Load all commands to all guilds.
        for (int i = 0; i < Main.jda.getGuilds().size(); i++) {
            String guildId = Main.jda.getGuilds().get(i).getId();
            ping.registerGuild(guildId);
        }
    }
}
