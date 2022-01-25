package floris0106.rereskillablerereforked.client.screen.buttons;

import com.mojang.blaze3d.vertex.PoseStack;

import floris0106.rereskillablerereforked.client.screen.SkillScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.TextComponent;

public class TabButton extends AbstractButton
{
    private final boolean selected;
    private final TabType type;
    
    public TabButton(int x, int y, TabType type, boolean selected)
    {
        super(x, y, 31, 28, TextComponent.EMPTY);
        
        this.type = type;
        this.selected = selected;
    }
    
    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float partialTicks)
    {
        Minecraft minecraft = Minecraft.getInstance();
        active = !(minecraft.screen instanceof InventoryScreen) || !((InventoryScreen) minecraft.screen).getRecipeBookComponent().isVisible();
        
        if (active)
        {
            minecraft.textureManager.bindForSetup(SkillScreen.RESOURCES);	//(SkillScreen.RESOURCES);
    
            blit(stack, x, y, selected ? 31 : 0, 166, width, height);
            blit(stack, x + (selected ? 8 : 10), y + 6, 240, 128 + type.iconIndex * 16, 16, 16);
        }
    }
    
    @Override
    public void onPress()
    {
        Minecraft minecraft = Minecraft.getInstance();
        
        switch (type)
        {
            case INVENTORY:
                minecraft.setScreen(new InventoryScreen(minecraft.player));
                break;
                
            case SKILLS:
                minecraft.setScreen(new SkillScreen());
                break;
        }
    }
    
    public enum TabType
    {
        INVENTORY (0),
        SKILLS (1);
        
        public final int iconIndex;
        
        TabType(int index)
        {
            iconIndex = index;
        }
    }

	@Override public void updateNarration(NarrationElementOutput p_169152_) {}
}