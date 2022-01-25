package floris0106.rereskillablerereforked.common.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModCommands
{
    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event)
    {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        SkillsCommand.register(dispatcher);
    }
}