package com.shynieke.mundaneredstone.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RedstoneOreBlock.class)
public class RedstoneOreBlockMixin extends Block {
	public RedstoneOreBlockMixin(Properties properties) {
		super(properties);
	}

	@Inject(at = @At("HEAD"), method = "interact", cancellable=true)
	private static void interact(BlockState state, World world, BlockPos pos, CallbackInfo info) {
		info.cancel();
	}

	@Inject(at = @At("HEAD"), method = "use", cancellable=true)
	public void use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult, CallbackInfoReturnable<ActionResultType> info) {
		info.setReturnValue(ActionResultType.PASS);
	}

	@Inject(at = @At("HEAD"), method = "spawnParticles", cancellable=true)
	private static void spawnParticles(World world, BlockPos pos, CallbackInfo info) {
		info.cancel();
	}
}
