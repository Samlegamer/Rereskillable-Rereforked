package floris0106.rereskillablerereforked.common.capabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SkillProvider implements ICapabilitySerializable<CompoundTag>
{
    private final SkillModel skillModel;
    private final LazyOptional<SkillModel> optional;
    
    public SkillProvider(SkillModel skillModel)
    {
        this.skillModel = skillModel;
        optional = LazyOptional.of(() -> skillModel);
    }
    
    public void invalidate()
    {
        optional.invalidate();
    }
    
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side)
    {
        if (capability == SkillCapability.INSTANCE) return optional.cast();
        
        return LazyOptional.empty();
    }
    
    @Override
    public CompoundTag serializeNBT()
    {
        return skillModel.serializeNBT();
    }
    
    @Override
    public void deserializeNBT(CompoundTag nbt)
    {
        skillModel.deserializeNBT(nbt);
    }
}