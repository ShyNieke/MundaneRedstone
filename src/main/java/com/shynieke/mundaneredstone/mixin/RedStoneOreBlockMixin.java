package com.shynieke.mundaneredstone.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RedStoneOreBlock.class)
public class RedStoneOreBlockMixin extends Block {
	public RedStoneOreBlockMixin(Properties properties) {
		super(properties);
	}

	@Inject(at = @At("HEAD"), method = "interact", cancellable = true)
	private static void mundaneredstone$interact(BlockState state, Level level, BlockPos pos, CallbackInfo info) {
		info.cancel();
	}

	@Inject(at = @At("HEAD"), method = "useItemOn(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/phys/BlockHitResult;)Lnet/minecraft/world/ItemInteractionResult;", cancellable = true)
	public void mundaneredstone$use(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
	                BlockHitResult result, CallbackInfoReturnable<ItemInteractionResult> info) {
		info.setReturnValue(ItemInteractionResult.SUCCESS);
	}

	@Inject(at = @At("HEAD"), method = "spawnParticles", cancellable = true)
	private static void mundaneredstone$spawnParticles(Level level, BlockPos pos, CallbackInfo info) {
		info.cancel();
	}
}
