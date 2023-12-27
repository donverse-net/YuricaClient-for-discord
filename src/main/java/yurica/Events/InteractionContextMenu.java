package yurica.Events;

import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import yurica.Main;
import yurica.Events.InteractionCommands.TestContext;

public class InteractionContextMenu extends ListenerAdapter {
    // Context menu class.
    private TestContext testContext = new TestContext();

    // Event handler.
    @Override
    public void onUserContextInteraction(UserContextInteractionEvent event){
        // Actions
        if (event.getName().equals("test-context")) {
            testContext.response(event);
        }
    }

    // Command register.
    public void registerCommand(){
        // Load all commands to all guilds.
        for (int i = 0; i < Main.jda.getGuilds().size(); i++) {
            String guildId = Main.jda.getGuilds().get(i).getId();

            testContext.registerGuild(guildId);
        }
    }

    // Unregister guild.
    public void unregisterGuild(String guildId, String cmdName){

        switch (cmdName) {
            case "test-context":
                testContext.unregisterGuild(guildId);
                break;
            default:
                break;
        }
    }
}
