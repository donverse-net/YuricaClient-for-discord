package yurica.Events.InteractionComponents.Buttons;

import java.util.function.Function;

import org.jetbrains.annotations.Nullable;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;

public class Test extends ListenerAdapter {
    public Button button = Button.of(ButtonStyle.PRIMARY, "test", "Test Button");

    public Button getButton() {
        return button;
    }

    public Function<ButtonInteractionEvent, String> getFunction() {
        return this::response;
    }

    @Nullable
    public String response(ButtonInteractionEvent event) {
        try {
            event.reply("Test button is clicked!").setEphemeral(true).queue();
            return "Test button is clicked!";
        } catch (Exception e) {
            return "Error!";
        }
    }
}
