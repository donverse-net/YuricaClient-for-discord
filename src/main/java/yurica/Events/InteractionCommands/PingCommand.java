package yurica.Events.InteractionCommands;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class PingCommand {

    public void response(SlashCommandInteractionEvent event, JDA jda){
        // Reply with client ws ping.
        long ping = jda.getGatewayPing();
        event.reply("Pong! " + ping + "ms").setEphemeral(true).queue();
    }
}
