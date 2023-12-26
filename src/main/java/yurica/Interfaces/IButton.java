package yurica.Interfaces;

import java.util.function.Function;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public interface IButton {
    public Button getButton();
    public Function<ButtonInteractionEvent, String> getFunction();
    public String response(ButtonInteractionEvent event);
}
