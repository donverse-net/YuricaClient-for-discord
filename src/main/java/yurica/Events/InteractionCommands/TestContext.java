package yurica.Events.InteractionCommands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import yurica.Main;

public class TestContext extends ListenerAdapter {

    public void response(UserContextInteractionEvent event){
        event.reply("Test context menu response.")
                .setEphemeral(true)
                .queue();
    }

    public void registerGuild(String guildId){
        try {
            Guild guild = Main.jda.getGuildById(guildId);

            guild.updateCommands().addCommands(
                Commands.context(Command.Type.USER, "test-context"),
                Commands.message("test-context")
            ).queue();

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public void unregisterGuild(String guildId) {
        try {
            Guild guild = Main.jda.getGuildById(guildId);
            // Delete context menu.
            guild.deleteCommandById("test-context").queue();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
