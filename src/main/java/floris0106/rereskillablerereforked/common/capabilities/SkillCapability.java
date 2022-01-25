package floris0106.rereskillablerereforked.common.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class SkillCapability
{
    //@CapabilityInject(SkillModel.class)
    public static final Capability<SkillModel> INSTANCE = CapabilityManager.get(new CapabilityToken<SkillModel>() {
        
    });
    
    public static void init()
    {
    	//INSTANCE = CapabilityManager.get(new CapabilityToken<SkillModel>() {});
    }
}