package com.shynieke.mundaneredstone.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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

	@Inject(at = @At("HEAD"), method = "interact", cancellable=true)
	private static void interact(BlockState state, Level world, BlockPos pos, CallbackInfo info) {
		info.cancel();
	}

	@Inject(at = @At("HEAD"), method = "use", cancellable=true)
	public void use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult rayTraceResult, CallbackInfoReturnable<InteractionResult> info) {
		info.setReturnValue(InteractionResult.PASS);
	}

	@Inject(at = @At("HEAD"), method = "spawnParticles", cancellable=true)
	private static void spawnParticles(Level world, BlockPos pos, CallbackInfo info) {
		info.cancel();
	}
}
