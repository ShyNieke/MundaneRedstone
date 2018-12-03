package com.svennieke.MundaneRedstone.blocks;

import java.util.Random;

import com.svennieke.MundaneRedstone.config.MundaneConfigGen;
import com.svennieke.MundaneRedstone.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMundaneRedstone extends Block{
	
	public BlockMundaneRedstone(String registry, String unlocalised) 
	{
		super(Material.ROCK);
		this.setRegistryName(registry);
		this.setUnlocalizedName(unlocalised);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
		this.setHarvestLevel("pickaxe", 2);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.REDSTONE;
    }
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return this.quantityDropped(random) + random.nextInt(fortune + 1);
    }
	
	@Override
	public int quantityDropped(Random random)
    {
        return 4 + random.nextInt(2);
    }
	
	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }

    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        if (this.getItemDropped(state, RANDOM, fortune) != Item.getItemFromBlock(this))
        {
            return 1 + RANDOM.nextInt(5);
        }
        return 0;
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
    	if(MundaneConfigGen.otherconfigurations.SilkVanilla)
    	{
    		return new ItemStack(Blocks.REDSTONE_ORE);
    	}
    	else
    	return new ItemStack(ModBlocks.Mundane_Redstone_Ore);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(ModBlocks.Mundane_Redstone_Ore), 1, this.damageDropped(state));
    }
}
