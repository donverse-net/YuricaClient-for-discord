package yurica.Interfaces;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public interface ISlashCommand {
    public void response(SlashCommandInteractionEvent event);
    public void registerGuild(String guildId);
    public void unregisterGuild(Guild guild);
    public void register();
    public void unregister();
}
