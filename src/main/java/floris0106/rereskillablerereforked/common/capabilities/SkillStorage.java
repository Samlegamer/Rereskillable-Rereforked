package floris0106.rereskillablerereforked.common.capabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class SkillStorage implements ICapabilitySerializable<Tag>
{
	public SkillModel mdl;
	
	/*
	@Nullable
    public Tag serializeNBT(Capability<SkillModel> capability, , Direction side)
    {
        return instance.serializeNBT();
    }
    
    public void deserializeNBT(Capability<SkillModel> capability, SkillModel instance, Direction side, Tag nbt)
    {
        instance.deserializeNBT((CompoundTag) nbt);
    }*/

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side)
	{
		return null;
	}

	@Override
	public Tag serializeNBT()
	{
		return mdl.serializeNBT();
	}

	@Override
	public void deserializeNBT(Tag nbt)
	{
		mdl.deserializeNBT((CompoundTag) nbt);
	}
}